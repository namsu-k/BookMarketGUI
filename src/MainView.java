import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainView extends JFrame {
	private User user;
	private Cart cart;
	private Admin admin = new Admin();

	public MainView(User user) {
		this.user = user;
		this.cart = new Cart(this.user);

		init();
	}

	private void init() {
		Font ft = new Font("함초롬돋움", Font.BOLD, 15);

		setTitle("온라인 서점");
		setSize(1000, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();

		JMenu menuBookList = new JMenu("상품");
		menuBookList.setFont(ft);

		JMenuItem itemBookList = new JMenuItem("상품 목록");

		itemBookList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				BookListView bookListView = new BookListView(cart);
				getContentPane().add(bookListView);
				getContentPane().revalidate();
				getContentPane().repaint();

			}
		});

		menuBookList.add(itemBookList);
		menuBar.add(menuBookList);

		JMenu menuMyPage = new JMenu("고객");
		menuMyPage.setFont(ft);

		JMenuItem itemUserInfo = new JMenuItem("고객 정보");

		itemUserInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				UserInfoView userInfoView = new UserInfoView(user);
				getContentPane().add(userInfoView);
				getContentPane().revalidate();
				getContentPane().repaint();
			}
		});

		JMenuItem itemUserCart = new JMenuItem("장바구니");

		itemUserCart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				if (cart.size() == 0) {
					CartEmptyView cartEmptyView = new CartEmptyView();
					getContentPane().add(cartEmptyView);
				} else {
					CartView cartView = new CartView(cart, user);
					getContentPane().add(cartView);
				}
				getContentPane().revalidate();
				getContentPane().repaint();
			}
		});

		JMenuItem itemUserOrder = new JMenuItem("주문 정보");

		itemUserOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				if (user.getOrderInfo().size() == 0) {
					OrderEmptyView orderEmptyView = new OrderEmptyView();
					getContentPane().add(orderEmptyView);
				} else {
					OrderInfoView orderInfoView = new OrderInfoView(user);
					getContentPane().add(orderInfoView);
				}
				getContentPane().revalidate();
				getContentPane().repaint();

			}
		});

		menuMyPage.add(itemUserInfo);
		menuMyPage.add(itemUserCart);
		menuMyPage.add(itemUserOrder);
		menuBar.add(menuMyPage);

		JMenu menuAdmin = new JMenu("관리자");
		menuAdmin.setFont(ft);

		JMenuItem itemAdminLogin = new JMenuItem("관리자 로그인");

		itemAdminLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminLoginView adminLogin = new AdminLoginView(admin);
			}
		});

		JMenuItem itemAdminAddBook = new JMenuItem("새 도서 추가");

		itemAdminAddBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (admin.getIsLogin()) {
					getContentPane().removeAll();
					AdminAddBookView adminAddBookView = new AdminAddBookView();
					getContentPane().add(adminAddBookView);
					getContentPane().revalidate();
					getContentPane().repaint();
				} else {
					JOptionPane.showMessageDialog(null, "관리자 로그인 후 이용 가능합니다");
				}
			}
		});

		menuAdmin.add(itemAdminLogin);
		menuAdmin.add(itemAdminAddBook);
		menuBar.add(menuAdmin);

		setJMenuBar(menuBar);

		setLocationRelativeTo(null);
		setVisible(true);
	}
}
