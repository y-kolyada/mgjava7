class Book {
	static int bookCount;

	public Book() {
		++bookCount;
	}
}

public class PublisherGui {
	public static void main() {
		//System.out.println(Book);	
		System.out.println(Book.bookCount);
		Book b1 = new Book();
		Book b2 = new Book();
		System.out.println(Book.bookCount);		
	}
}