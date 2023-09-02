import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderItem {
	private int orderNumber;
	private String orderDate;
	private String orderAddress;
	private ArrayList<Book> orderBookList;

	public String getOrderNumber() {
		String stringOrderNumber = String.valueOf(this.orderNumber);
		return stringOrderNumber;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public ArrayList<Book> getOrderBookList() {
		return orderBookList;
	}

	public void setOrderNumber(int lastedOrderNum) {
		this.orderNumber = ++lastedOrderNum;
	}

	public void setOrderDate() {
		Date orderDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

		String formattingDate = formatter.format(orderDate);

		this.orderDate = formattingDate;
	}

	public void setOrderAddress(String newAddress) {
		this.orderAddress = newAddress;
	}

	public void setOrderBookList(ArrayList<Book> orderBookList) {
		this.orderBookList = new ArrayList<Book>(orderBookList);
	}
}
