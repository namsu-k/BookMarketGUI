
public class Book {
	private String bookId;
	private String title;
	private String price;
	private String author;
	private String desc;
	private String category;
	private String release;

	public Book(String bookId, String title, String price, String author, String desc, String category,
			String release) {
		this.bookId = bookId;
		this.title = title;
		this.price = price;
		this.author = author;
		this.desc = desc;
		this.category = category;
		this.release = release;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}
}
