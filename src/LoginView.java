import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginView extends JFrame {
	private User user;

	public LoginView() {
		setTitle("고객 정보 입력");
		setSize(1000, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		Font ft = new Font("함초롬돋움", Font.BOLD, 15);

		JPanel namePanel = new JPanel();
		namePanel.setBounds(0, 400, 1000, 50);
		add(namePanel);

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setFont(ft);
		namePanel.add(nameLabel);

		JTextField nameField = new JTextField(10);
		nameField.setFont(ft);
		namePanel.add(nameField);

		JPanel phonePanel = new JPanel();
		phonePanel.setBounds(0, 450, 1000, 50);
		add(phonePanel);

		JLabel phoneLabel = new JLabel("연락처");
		phoneLabel.setFont(ft);
		phonePanel.add(phoneLabel);

		JTextField phoneField = new JTextField(10);
		phoneField.setFont(ft);
		phonePanel.add(phoneField);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 500, 1000, 100);
		add(buttonPanel);

		JLabel buttonLabel = new JLabel("쇼핑하기", JLabel.LEFT);
		buttonLabel.setFont(ft);
		JButton enterButton = new JButton();
		enterButton.add(buttonLabel);
		buttonPanel.add(enterButton);

		enterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (nameField.getText().isEmpty() || phoneField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "고객 정보를 입력하세요");
				} else {
//					UserInit.init(nameField.getText(), Integer.parseInt(phoneField.getText()));
					user = new User(nameField.getText(), phoneField.getText());
					dispose();
					new MainView(user);
				}
			}
		});

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
