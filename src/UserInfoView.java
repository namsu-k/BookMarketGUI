import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UserInfoView extends JPanel {

	public UserInfoView(User user) {

		setSize(1000, 750);

		Font ft = new Font("함초롬돋움", Font.BOLD, 15);

		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(250, 255, 500, 50);
		titlePanel.setLayout(new BorderLayout(0, 0));
		JLabel titleLabel = new JLabel("고객 정보");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(ft);

		titlePanel.add(titleLabel);

		JPanel namePanel = new JPanel();
		namePanel.setBounds(250, 315, 500, 50);

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setFont(ft);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JTextField nameField = new JTextField(15);
		nameField.setHorizontalAlignment(SwingConstants.CENTER);
		nameField.setFont(ft);
		nameField.setEditable(false);
		nameField.setText(user.getName());

		namePanel.setLayout(new BorderLayout(0, 0));
		namePanel.add(nameLabel);
		namePanel.add(nameField, BorderLayout.SOUTH);

		JPanel phonePanel = new JPanel();
		phonePanel.setBounds(250, 375, 500, 50);

		JLabel phoneLabel = new JLabel("연락처");
		phoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phoneLabel.setFont(ft);

		JTextField phoneField = new JTextField(15);
		phoneField.setHorizontalAlignment(SwingConstants.CENTER);
		phoneField.setFont(ft);
		phoneField.setEditable(false);
		phoneField.setText(user.getPhone());

		phonePanel.setLayout(new BorderLayout(0, 0));
		phonePanel.add(phoneLabel);
		phonePanel.add(phoneField, BorderLayout.SOUTH);

		JPanel addressPanel = new JPanel();
		addressPanel.setBounds(250, 435, 500, 50);

		JLabel addressLabel = new JLabel("주소");
		addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addressLabel.setFont(ft);

		JTextField addressField = new JTextField(50);
		addressField.setHorizontalAlignment(SwingConstants.CENTER);
		addressField.setFont(ft);
		addressField.setEditable(false);
		addressField.setText(user.getAddress());

		addressPanel.setLayout(new BorderLayout(0, 0));
		addressPanel.add(addressLabel);
		addressPanel.add(addressField, BorderLayout.SOUTH);
		setLayout(null);

		add(titlePanel);
		add(namePanel);
		add(phonePanel);
		add(addressPanel);

		setVisible(true);
	}
}
