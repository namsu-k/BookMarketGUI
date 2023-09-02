import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AdminLoginView {
	private Admin admin;

	public AdminLoginView(Admin admin) {
		this.admin = admin;

		JFrame frame = new JFrame();
		frame.setSize(400, 300);

		JPanel idPanel = new JPanel();
		idPanel.setBounds(12, 60, 360, 50);

		JLabel idLabel = new JLabel("아이디");
		idLabel.setBounds(38, 15, 100, 21);
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JTextField idField = new JTextField(10);
		idField.setBounds(150, 15, 150, 21);
		idPanel.setLayout(null);

		idPanel.add(idLabel);
		idPanel.add(idField);

		JPanel pwPanel = new JPanel();
		pwPanel.setBounds(12, 120, 360, 50);

		JLabel pwLabel = new JLabel("비밀번호");
		pwLabel.setBounds(38, 15, 100, 21);
		pwLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pwPanel.setLayout(null);

		pwPanel.add(pwLabel);
		frame.getContentPane().setLayout(null);

		frame.getContentPane().add(idPanel);
		frame.getContentPane().add(pwPanel);

		JTextField pwField = new JTextField(10);
		pwField.setBounds(150, 15, 150, 21);
		pwPanel.add(pwField);

		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(12, 180, 360, 50);

		JButton loginBtn = new JButton("로그인");
		loginBtn.setBounds(75, 10, 100, 30);

		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (idField.getText().isEmpty() || pwField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "관리자 정보를 입력해주세요");
				} else if (idField.getText().equals(admin.getId()) && pwField.getText().equals(admin.getPw())) {
					admin.setIsLogin();
					frame.dispose();
					JOptionPane.showMessageDialog(null, "로그인 완료");
				}
			}
		});

		JButton cancelBtn = new JButton("취소");
		cancelBtn.setBounds(185, 10, 100, 30);

		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		btnPanel.setLayout(null);

		btnPanel.add(loginBtn);
		btnPanel.add(cancelBtn);

		frame.getContentPane().add(btnPanel);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
