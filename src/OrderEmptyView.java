import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class OrderEmptyView extends JPanel {

	public OrderEmptyView() {
		setSize(1000, 750);

		Font ft = new Font("함초롬돋움", Font.BOLD, 15);
		setLayout(null);

		JPanel emptyCartPanel = new JPanel();
		emptyCartPanel.setBounds(417, 325, 165, 31);

		JLabel emptyLabel = new JLabel("주문 정보가 없습니다");
		emptyLabel.setFont(ft);

		emptyCartPanel.add(emptyLabel);

		add(emptyCartPanel);
		setVisible(true);
	}

}
