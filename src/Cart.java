import java.util.ArrayList;

public class Cart extends ArrayList<Book> {
	private User user;

	public Cart(User user) {
		this.user = user;
	}
}
