import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class BookList {
	private ArrayList<Book> booklist = new ArrayList<Book>();

	public BookList() {
		setBookList();
	}

	public ArrayList<Book> getBookList() {
		return booklist;
	}

	public void setBookList() {
		try {
			FileReader fr = new FileReader("book.txt");
			BufferedReader reader = new BufferedReader(fr);

			String isbn;
			String[] bookData = new String[7];

			while ((isbn = reader.readLine()) != null) {
				if (isbn.contains("ISBN")) {
					bookData[0] = isbn;
					bookData[1] = reader.readLine();
					bookData[2] = reader.readLine();
					bookData[3] = reader.readLine();
					bookData[4] = reader.readLine();
					bookData[5] = reader.readLine();
					bookData[6] = reader.readLine();
				}

				Book bookItem = new Book(bookData[0], bookData[1], bookData[2], bookData[3], bookData[4], bookData[5],
						bookData[6]);

				booklist.add(bookItem);
			}
			reader.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
