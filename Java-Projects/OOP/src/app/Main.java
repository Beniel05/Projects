package app;

import model.Book;
import model.BookStatus;
import model.Member;
import service.Library;

public class Main {
	public static void main(String[] args) {
		
		Library library = new Library();
		
		Book book1 = new Book(101, "Clean Code", "Robert Cecil Martin", "Programming", 464, 799.0, BookStatus.AVAILABLE);
		Book book2 = new Book(102, "Designing Data-Intensive Applications", "Martin Kleppmann", "System Design", 650, 1853.0, BookStatus.AVAILABLE
);
		
		library.addBook(book1);
		library.addBook(book2);
		
		Member member1 = new Member(1, "John", 23, "123456789", "No.1, West Cross St, USA");
		
		
		library.viewAllBooks();
		library.viewAllMembers();
		
	}
}
