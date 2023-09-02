import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AdminAddBookView extends JPanel {
	public AdminAddBookView() {
		init();
	}

	private void init() {
		setSize(1000, 750);

		Font ft = new Font("함초롬돋움", Font.BOLD, 15);

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddhhmmss");
		String formattedDate = formatter.format(date);

		JPanel idPanel = new JPanel();
		idPanel.setBounds(250, 215, 500, 30);

		JLabel idLabel = new JLabel("도서 ID");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(ft);

		JTextField idField = new JTextField();
		idField.setHorizontalAlignment(SwingConstants.CENTER);
		idField.setFont(ft);
		idField.setText("ISBN" + formattedDate);
		idField.setEditable(false);

		idPanel.setLayout(new GridLayout(0, 2, 0, 0));
		idPanel.add(idLabel);
		idPanel.add(idField);

		JPanel namePanel = new JPanel();
		namePanel.setBounds(250, 252, 500, 30);

		JLabel nameLabel = new JLabel("도서명");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(ft);

		JTextField nameField = new JTextField(20);
		nameField.setHorizontalAlignment(SwingConstants.CENTER);
		nameField.setFont(ft);
		namePanel.setLayout(new GridLayout(0, 2, 0, 0));

		namePanel.add(nameLabel);
		namePanel.add(nameField);

		JPanel pricePanel = new JPanel();
		pricePanel.setBounds(250, 289, 500, 30);

		JLabel priceLabel = new JLabel("가격");
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setFont(ft);

		JTextField priceField = new JTextField(20);
		priceField.setHorizontalAlignment(SwingConstants.CENTER);
		priceField.setFont(ft);
		pricePanel.setLayout(new GridLayout(0, 2, 0, 0));

		pricePanel.add(priceLabel);
		pricePanel.add(priceField);

		JPanel authorPanel = new JPanel();
		authorPanel.setBounds(250, 326, 500, 30);

		JLabel authorLabel = new JLabel("저자");
		authorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		authorLabel.setFont(ft);

		JTextField authorField = new JTextField(20);
		authorField.setHorizontalAlignment(SwingConstants.CENTER);
		authorField.setFont(ft);
		authorPanel.setLayout(new GridLayout(0, 2, 0, 0));

		authorPanel.add(authorLabel);
		authorPanel.add(authorField);

		JPanel descPanel = new JPanel();
		descPanel.setBounds(250, 363, 500, 30);

		JLabel descLabel = new JLabel("설명");
		descLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descLabel.setFont(ft);

		JTextField descField = new JTextField(20);
		descField.setHorizontalAlignment(SwingConstants.CENTER);
		descField.setFont(ft);
		descPanel.setLayout(new GridLayout(0, 2, 0, 0));

		descPanel.add(descLabel);
		descPanel.add(descField);

		JPanel categoryPanel = new JPanel();
		categoryPanel.setBounds(250, 400, 500, 30);

		JLabel categoryLabel = new JLabel("분야");
		categoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		categoryLabel.setFont(ft);

		JTextField categoryField = new JTextField(20);
		categoryField.setHorizontalAlignment(SwingConstants.CENTER);
		categoryField.setFont(ft);
		categoryPanel.setLayout(new GridLayout(0, 2, 0, 0));

		categoryPanel.add(categoryLabel);
		categoryPanel.add(categoryField);

		JPanel releasePanel = new JPanel();
		releasePanel.setBounds(250, 437, 500, 30);

		JLabel releaseLabel = new JLabel("출판일");
		releaseLabel.setSize(new Dimension(200, 50));
		releaseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		releaseLabel.setFont(ft);

		JTextField releaseField = new JTextField(20);
		releaseField.setHorizontalAlignment(SwingConstants.CENTER);
		releaseField.setFont(ft);
		releasePanel.setLayout(new GridLayout(0, 2, 0, 0));

		releasePanel.add(releaseLabel);
		releasePanel.add(releaseField);

		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(250, 474, 500, 40);

		JLabel okLabel = new JLabel("추가");
		okLabel.setFont(ft);

		JButton okButton = new JButton();
		okButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		okButton.add(okLabel);
		btnPanel.add(okButton);

		okButton.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] writeBook = new String[7];
				writeBook[0] = idField.getText();
				writeBook[1] = nameField.getText();
				writeBook[2] = priceField.getText();
				writeBook[3] = authorField.getText();
				writeBook[4] = descField.getText();
				writeBook[5] = categoryField.getText();
				writeBook[6] = releaseField.getText();

				try {
					FileWriter fw = new FileWriter("book.txt", true);

					for (int i = 0; i < 7; i++) {
						fw.write(writeBook[i] + "\n");
					}
					fw.close();
					JOptionPane.showMessageDialog(null, "새 도서 정보가 저장되었습니다");

					Date date = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("yyMMddhhmmss");
					String strDate = formatter.format(date);

					idField.setText("ISBN" + strDate);
					nameField.setText("");
					priceField.setText("");
					authorField.setText("");
					descField.setText("");
					categoryField.setText("");
					releaseField.setText("");

					System.out.println("새 도서 정보가 저장되었습니다");
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});

		JLabel noLabel = new JLabel("취소");
		noLabel.setFont(ft);

		JButton noButton = new JButton();
		noButton.setHorizontalTextPosition(SwingConstants.CENTER);
		noButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		noButton.add(noLabel);

		btnPanel.add(noButton);

		noButton.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				nameField.setText("");
				priceField.setText("");
				authorField.setText("");
				descField.setText("");
				categoryField.setText("");
				releaseField.setText("");
			}
		});

		setLayout(null);
		add(idPanel);
		add(namePanel);
		add(pricePanel);
		add(authorPanel);
		add(descPanel);
		add(categoryPanel);
		add(releasePanel);
		add(btnPanel);

//		setVisible(true);
	}
}
