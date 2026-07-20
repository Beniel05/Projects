package app;

import model.Book;
import model.BookStatus;
import model.Member;
import service.Library;

public class Main {
	public static void main(String[] args) {
		
		Library library = new Library();
		
		Book book1 = new Book(101, "Clean Code", "Robert Cecil Martin", "Programming", 464, 799.0, BookStatus.AVAILABLE);
		Book book2 = new Book(102, "Designing Data-Intensive Applications", "Martin Kleppmann", "System Design", 650, 1853.0, BookStatus.AVAILABLE);
		
		library.addBook(book1);
		library.addBook(book2);
		
		Member member1 = new Member(1, "John", 23, "123456789", "No.1, West Cross St, USA");
		Member member2 = new Member(2, "Doe", 30, "9087654321", "No.2, North Cross St, Denmark");
		library.registerMember(member1);
		library.registerMember(member2);
		
		System.out.println("=============== viewAllBooks() ===============\n");
		library.viewAllBooks();
		
		System.out.println("\n=============== viewAllMembers() ===============\n");
		library.viewAllMembers();
		
		System.out.println("\n=============== findBookById(int bookId) ===============\n");
		// For testing purpose;
		Book book = library.findBookById(999);
		if(book != null) {
			System.out.println(book);
		} else {
			System.out.println("Book not found.");
		}
		
		System.out.println("\n=============== findMemberById(int memberId) ===============\n");
		Member member = library.findMemberById(1);
		if(member != null) {
			System.out.println(member);
		} else {
			System.out.println("Member not found.");
		}
		
		System.out.println("\n=============== borrowBook(int bookId, int memberId) ===============\n");
		// Testing borrowBook() method;
		String borrowResult1 = library.borrowBook(101,1);
		System.out.println(borrowResult1);
	
		String borrowResult2 = library.borrowBook(101, 2); // Trying to borrow the borrowed book.
		System.out.println(borrowResult2);
		
		String borrowResult3 = library.borrowBook(1000, 1); // Not a valid book id
		String borrowResult4 = library.borrowBook(102, 1000); // Not a valid member id
		System.out.println(borrowResult3);
		System.out.println(borrowResult4);
		
		System.out.println("\n=============== viewAllBorrowRecords() ===============\n");
		library.viewAllBorrowRecords();
	
		System.out.println("\n=============== returnBook() ===============\n");
		
		library.viewAllBorrowRecords();
		// BookStatus BORROWED, returnDate is null (not returned).
		
		String returnResult1 = library.returnBook(1001);
		// Trying to return the returned Book.
		
		library.viewAllBorrowRecords();
		// BookStatus changed to AVAILABLE again, returnDate has set (hard coded).
		
		String returnResult2 = library.returnBook(1001);
		// Trying to return - When no borrow happened (no records).
		String returnResult3 = library.returnBook(999);
		System.out.println(returnResult1);
		System.out.println(returnResult2);
		System.out.println(returnResult3);
		
		
		System.out.println("\n=============== viewBooksBorrowedByMember() ===============\n");
		// Getting details of what are all the books - currently the member having.
		library.viewBooksBorrowedByMember(1);
		
		library.borrowBook(101, 2); // Member2 have borrowed the book-101.
		library.viewBooksBorrowedByMember(2);
		
		// Passing Invalid MemberId;
		library.viewBooksBorrowedByMember(-1);
		
	}
}
