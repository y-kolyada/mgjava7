class Book {
	// public static int bookCount = initResult();
	public static int bookCount = 5;

	static {
		// bookCount = 5;
		if (bookCount < 10) { 
			bookCount = initResult();
		}
		
	}

	public Book() {
		++bookCount;
	}

	public static void printBookCount() {
		System.out.println(bookCount);
	}

	public static int getBookCount() {
		return bookCount;
	}

	public static void incrementBookCount() {
		++bookCount;
	}

	// public int initResult() {
	static int initResult() {
		return 20;
	}
}

public class PublisherGui {
	public static void main(String[] args) {
		System.out.println(Book.class);
		System.out.println("bookCount: " + Book.bookCount);
		Book.incrementBookCount();
		System.out.println(Book.bookCount);
		Book b1 = new Book();
		Book b2 = new Book();
		System.out.println(Book.bookCount);
		b1.bookCount = 5;
		System.out.println(Book.bookCount);
		System.out.println(b2.bookCount);
		Book.printBookCount();
		
		StaticException staticExp = new StaticException();
		System.out.println(StaticException.class);
		System.out.println("userAccount: " + staticExp.userAccount);
	}
}