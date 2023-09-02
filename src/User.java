import java.util.ArrayList;

public class User {
	private String name;
	private String phone;
	private String address;
//	private ArrayList<Book> orderList = new ArrayList<Book>();
	private ArrayList<OrderItem> orderInfo = new ArrayList<OrderItem>();
	private int lastedOrderNum = 0;

	public User(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public User(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	public ArrayList<Book> getOrderList() {
//		return orderList;
//	}
//
//	public void addOrder(Book cartItem) {
//		
//	}

	public ArrayList<OrderItem> getOrderInfo() {
		return this.orderInfo;
	}

	public void order(Cart cart) {
		OrderItem newOrder = new OrderItem();

		newOrder.setOrderNumber(lastedOrderNum);
		newOrder.setOrderDate();
		newOrder.setOrderAddress(getAddress());
		newOrder.setOrderBookList(cart);

		this.orderInfo.add(newOrder);
	}
}
