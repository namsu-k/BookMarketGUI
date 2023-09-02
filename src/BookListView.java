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

public class BookListView extends JPanel {

	private BookList booklist = new BookList();
	private int selectRow = 0;

	public BookListView(Cart cart) {
		setSize(1000, 700);
		setLayout(null);

		Font ft = new Font("함초롬돋움", Font.BOLD, 15);

		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 160, 1000, 360);
		add(tablePanel);

		ArrayList<Book> contentList = booklist.getBookList();
		Object[] tableHeader = { "도서ID", "도서명", "가격", "저자", "설명", "분야", "출판일" };
//		Object[][] content = { { "123", "123", "123", "123", "123", "123", "123" } };
		Object[][] content = new Object[contentList.size()][tableHeader.length];

		for (int i = 0; i < contentList.size(); i++) {
			Book bookItem = contentList.get(i);
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
		btnPanel.setBounds(350, 570, 300, 50);

		JLabel btnLabel = new JLabel("선택 도서 장바구니 담기");
		btnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		btnLabel.setFont(ft);

		JButton addBtn = new JButton();
		addBtn.add(btnLabel);

		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cart.add(contentList.get(selectRow));
				JOptionPane.showMessageDialog(null, "선택한 도서를 장바구니에 담았습니다");

			}
		});
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnPanel.add(addBtn);

		add(btnPanel);

		setVisible(true);
	}
}
