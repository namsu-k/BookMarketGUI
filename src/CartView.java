import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CartView extends JPanel {

	private User user;
	private ArrayList<Book> cartList;
	private int selectRow = 0;
	private Object[] tableHeader = { "도서ID", "도서명", "가격", "저자", "설명", "분야", "출판일" };

	private Object[][] getContent(ArrayList<Book> cart) {
		ArrayList<Book> tableData = cart;

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

	public CartView(Cart cart, User user) {
		this.user = user;

		Font ft = new Font("함초롬돋움", Font.BOLD, 15);

		setSize(1000, 750);
		setLayout(null);

		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 160, 1000, 360);

		cartList = cart;
		Object[][] content = new Object[cartList.size()][tableHeader.length];

		for (int i = 0; i < cartList.size(); i++) {
			Book bookItem = cartList.get(i);
			content[i][0] = bookItem.getBookId();
			content[i][1] = bookItem.getTitle();
			content[i][2] = bookItem.getPrice();
			content[i][3] = bookItem.getAuthor();
			content[i][4] = bookItem.getDesc();
			content[i][5] = bookItem.getCategory();
			content[i][6] = bookItem.getRelease();
		}

		JTable bookTable = new JTable(content, tableHeader);

		bookTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				selectRow = bookTable.getSelectedRow();
			}
		});

		bookTable.setRowSelectionInterval(0, 0);
		bookTable.getSelectedColumn();

		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setPreferredSize(new Dimension(850, 350));
		jScrollPane.setViewportView(bookTable);

		tablePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		tablePanel.add(jScrollPane);

		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(350, 570, 500, 50);

		JLabel deleteBtnLabel = new JLabel("선택 도서 삭제");
		deleteBtnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		deleteBtnLabel.setFont(ft);

		JButton deleteBtn = new JButton();
		deleteBtn.add(deleteBtnLabel);

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cart.remove(cartList.get(selectRow));
				JOptionPane.showMessageDialog(null, "선택한 도서를 삭제하였습니다");
				TableModel tableModel = new DefaultTableModel(getContent(cart), tableHeader);
				bookTable.setModel(tableModel);
				if (cart.isEmpty()) {
					TableModel emptyTableModel = new DefaultTableModel(new Object[0][0], tableHeader);
					bookTable.setModel(emptyTableModel);
				}
				revalidate();
				repaint();
			}
		});
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnPanel.add(deleteBtn);

		JLabel clearBtnLabel = new JLabel("장바구니 비우기");
		clearBtnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clearBtnLabel.setFont(ft);

		JButton clearBtn = new JButton();
		clearBtn.add(clearBtnLabel);

		clearBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int select = JOptionPane.showConfirmDialog(null, "장바구니를 비우시겠습니까?");

				if (select == 0) {
					cart.clear();
					TableModel emptyTableModel = new DefaultTableModel(new Object[0][0], tableHeader);
					bookTable.setModel(emptyTableModel);
					revalidate();
					repaint();
				}
			}
		});

		btnPanel.add(clearBtn);

		JLabel orderBtnLabel = new JLabel("주문하기");
		orderBtnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderBtnLabel.setFont(ft);

		JButton orderBtn = new JButton();
		orderBtn.add(orderBtnLabel);

		orderBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (user.getAddress() == null) {
					String address = JOptionPane.showInputDialog("배송지를 입력해주세요");

					user.setAddress(address);

				}

				int select = JOptionPane.showConfirmDialog(null, "주문하시겠습니까?");

				if (select == 0) {
					user.order(cart);
					cart.clear();
					TableModel emptyTableModel = new DefaultTableModel(new Object[0][0], tableHeader);
					bookTable.setModel(emptyTableModel);
					revalidate();
					repaint();
				}

			}
		});

		btnPanel.add(orderBtn);

		add(tablePanel);
		add(btnPanel);

		setVisible(true);
	}
}
