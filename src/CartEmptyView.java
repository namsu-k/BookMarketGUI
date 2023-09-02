import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CartEmptyView extends JPanel {

	public CartEmptyView() {
		setSize(1000, 750);

		Font ft = new Font("함초롬돋움", Font.BOLD, 15);
		setLayout(null);

		JPanel emptyCartPanel = new JPanel();
		emptyCartPanel.setBounds(417, 325, 165, 31);

		JLabel emptyLabel = new JLabel("장바구니가 비었습니다");
		emptyLabel.setFont(ft);

		emptyCartPanel.add(emptyLabel);

		add(emptyCartPanel);
		setVisible(true);
	}

}
