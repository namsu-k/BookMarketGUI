import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class OrderInfoView extends JPanel {

	private ArrayList<OrderItem> orderInfoList = new ArrayList<OrderItem>();
	private Object[] tableHeader = { "도서 ID", "도서명", "가격", "저자", "설명", "분야", "출판일" };
	private int select = 0;

	public OrderInfoView(User user) {
		setBounds(new Rectangle(0, 0, 1000, 750));
		this.orderInfoList = user.getOrderInfo();

		Font ft = new Font("함초롬돋움", Font.BOLD, 15);

		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(250, 50, 500, 50);
		titlePanel.setLayout(new BorderLayout(0, 0));
		JLabel titleLabel = new JLabel("주문 정보");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(ft);

		titlePanel.add(titleLabel, BorderLayout.NORTH);

		JPanel orderNumberPanel = new JPanel();
		orderNumberPanel.setBounds(50, 110, 450, 50);

		JLabel orderNumberLabel = new JLabel("주문 번호");
		orderNumberLabel.setFont(ft);
		orderNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JTextField orderNumberField = new JTextField(15);
		orderNumberField.setHorizontalAlignment(SwingConstants.CENTER);
		orderNumberField.setFont(ft);
		orderNumberField.setEditable(false);
		orderNumberField.setText(user.getOrderInfo().get(select).getOrderNumber());

		orderNumberPanel.setLayout(new BorderLayout(0, 0));
		orderNumberPanel.add(orderNumberLabel);
		orderNumberPanel.add(orderNumberField, BorderLayout.SOUTH);

		JPanel orderDatePanel = new JPanel();
		orderDatePanel.setBounds(500, 110, 450, 50);

		JLabel orderDateLabel = new JLabel("주문 날짜");
		orderDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderDateLabel.setFont(ft);

		JTextField orderDateField = new JTextField(15);
		orderDateField.setHorizontalAlignment(SwingConstants.CENTER);
		orderDateField.setFont(ft);
		orderDateField.setEditable(false);
		orderDateField.setText(user.getOrderInfo().get(select).getOrderDate());

		orderDatePanel.setLayout(new BorderLayout(0, 0));
		orderDatePanel.add(orderDateLabel);
		orderDatePanel.add(orderDateField, BorderLayout.SOUTH);

		JPanel addressPanel = new JPanel();
		addressPanel.setBounds(50, 170, 900, 100);

		JLabel addressLabel = new JLabel("배송 주소");
		addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addressLabel.setFont(ft);

		JTextField addressField = new JTextField(200);
		addressField.setEditable(false);
		addressField.setHorizontalAlignment(SwingConstants.CENTER);
		addressField.setFont(ft);
		addressField.setText(user.getAddress());

		addressPanel.setLayout(new BorderLayout(0, 0));
		addressPanel.add(addressLabel, BorderLayout.NORTH);
		addressPanel.add(addressField, BorderLayout.CENTER);
		setLayout(null);

		JPanel orderBookListPanel = new JPanel();
		orderBookListPanel.setBounds(50, 300, 900, 300);
		orderBookListPanel.setLayout(null);

		JLabel orderBookListLabel = new JLabel("도서 주문 목록");
		orderBookListLabel.setBounds(0, 0, 900, 21);
		orderBookListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderBookListLabel.setFont(new Font("함초롬돋움", Font.BOLD, 15));

		orderBookListPanel.add(orderBookListLabel);

		TableModel tableModel = new DefaultTableModel(
				getContent(user.getOrderInfo().get(getSelect()).getOrderBookList()), tableHeader);

		JTable orderBookListTable = new JTable();
		orderBookListTable.setBounds(new Rectangle(0, 0, 900, 279));
		JScrollPane tableScrollPane = new JScrollPane();
		tableScrollPane.setBounds(0, 21, 900, 279);

		String[] listItem = new String[orderInfoList.size()];
		if (orderInfoList.size() != 0) {
			for (int i = 0; i < orderInfoList.size(); i++) {
				listItem[i] = String.valueOf(i);
			}
		}

		JComboBox comboBox = new JComboBox(listItem);
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> comboSrc = (JComboBox<String>) e.getSource();
				int index = comboSrc.getSelectedIndex();
				setSelect(index);

				System.out.println(getSelect());
				System.out.println(user.getOrderInfo().get(getSelect()).getOrderBookList().get(0).getBookId());

				orderBookListTable.setModel(getTableModel(user));
				orderBookListTable.revalidate();
				orderBookListTable.repaint();
			}
		});

		titlePanel.add(comboBox, BorderLayout.CENTER);

		tableScrollPane.setViewportView(orderBookListTable);
		orderBookListPanel.add(tableScrollPane);

		add(titlePanel);
		add(orderNumberPanel);
		add(orderDatePanel);
		add(addressPanel);
		add(orderBookListPanel);

		setVisible(true);
	}

	private Object[][] getContent(ArrayList<Book> orderBookList) {
		ArrayList<Book> tableData = orderBookList;

		Object[][] content = new Object[tableData.size()][tableHeader.length];

		for (int i = 0; i < tableData.size(); i++) {
			Book bookItem = tableData.get(i);
			content[i][0] = bookItem.getBookId();
			content[i][1] = bookItem.getTitle();
			content[i][2] = bookItem.getPrice();
			content[i][3] = bookItem.getAuthor();
			content[i][4] = bookItem.getDesc();
			content[i][5] = bookItem.getCategory();
			content[i][6] = bookItem.getRelease();
		}

		return content;
	}

	private TableModel getTableModel(User user) {
		TableModel model = new DefaultTableModel(getContent(user.getOrderInfo().get(getSelect()).getOrderBookList()),
				tableHeader);

		return model;
	}

	public int getSelect() {
		return this.select;
	}

	public void setSelect(int index) {
		this.select = index;
	}
}
