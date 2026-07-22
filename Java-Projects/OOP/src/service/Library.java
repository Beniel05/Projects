package service;

import java.util.ArrayList;

import model.Book;
import model.BookStatus;
import model.BorrowRecord;
import model.Member;

public class Library {
	private ArrayList<Book> books;
	private ArrayList<Member> members;
	private ArrayList<BorrowRecord> records;
	
	public Library() {
		books = new ArrayList<>();
		members = new ArrayList<>();
		records = new ArrayList<>();
	}

	public boolean addBook(Book book) {
		if(book == null) {
			return false;
		}			
		books.add(book);
		return true;
	}
	
	public boolean registerMember(Member member) {
		if(member == null) {
			return false;
		}
		members.add(member);
		return true;
	}
	
	public void viewAllBooks() {
		for(Book each: books) {
			System.out.println(each);
		}
	}
	
	public void viewAllMembers() {
		for(Member each: members) {
			System.out.println(each);
		}
	}
	
	public Book findBookById(int bookId) {
		for(Book book : books) {
			if(bookId == book.getBookId()) {
				return book;
			}
		}
		return null;
	}
	
	public Member findMemberById(int memberId) {
		for(Member member : members) {
			if(memberId == member.getMemberId()) {
				return member;
			}
		}
		return null;
	}
	
	public String borrowBook(int bookId, int memberId) {
		
		// Getting both book and member objects
		Book book = findBookById(bookId);
		Member member = findMemberById(memberId);
		
		// if book is null (not exist) or book is already borrowed -> return;
		if(book == null) {
			return "Book not found";
		} else if (book.getStatus() == BookStatus.BORROWED) {
			return "Book is already Borrowed";
		}
		
		// if member is null (not exist) -> return;
		if(member == null) {
			return "Member not found";
		}
		
		// Both book and member are exist & book is available to be borrowed -> Change it to borrowed
		book.setStatus(BookStatus.BORROWED);
		
		// Add the record to the records list
		BorrowRecord borrowRecord = new BorrowRecord(member, book, "19-07-2026", null);
		records.add(borrowRecord);
		
		// Send a confirmation String.
		return "Book borrowed Successfully";
	}
	
	public void viewAllBorrowRecords() {
		for(BorrowRecord record : records) {
			System.out.println(record);
		}
	}
	
	public BorrowRecord getRecordById(int recordId) {
		for(BorrowRecord record : records) {
			if(record.getRecordId() == recordId) {
				return record;
			}
		}
		return null;
	}
	
	public String returnBook(int recordId) {
		
		// Getting the record to follow DRY principle
		BorrowRecord record = getRecordById(recordId);

		if(record == null) { 
			// If record is not exist - No borrow happened
			return "No such record";
		}
		
		// Getting book obj after the above check
		Book book = record.getBook();
		
		if(book.getStatus() == BookStatus.AVAILABLE) {
			return "Book cannot be returned.";
		}
		
		// If BookStatus is BORROWED;
		book.setStatus(BookStatus.AVAILABLE);
		record.setReturnDate("29-7-26"); // hard Coded for now (practicing)
		// After learning about date and time API - i'll update this.
		
		return "Returned Successfully";
	}
	
	public void viewBooksBorrowedByMember(int memberId) {
		// First getting the Member by ID;
		Member member = findMemberById(memberId);
		
		// If no member found return;
		if(member == null) {
			System.out.println("There is no registered Member with that ID.");
			return;
		}
		
		// Declaring a flag - to determine does the member having borrowed book right now.
		boolean hasBorrowedBooks = false;
		
		// Iterating in the records -> 
		// If record's member details == this member ->
		// And the Book Status == Borrowed ( Member having that book right now ) -> Print those records
		for(BorrowRecord record : records) {
			if(record.getMember() == member) {
				if(record.getBook().getStatus() == BookStatus.BORROWED) {
					System.out.println(record);
					hasBorrowedBooks = true;
				}
			}
		}
		
		// If no member's record == this member -> Not having any books right now
		// May be returned borrowed books / not even borrowed a book.
		if(!hasBorrowedBooks) {
			System.out.println("The user doesn't have any book with them.");
		}
	 
	}
	
	public void viewBorrowHistoryOfMember(int memberId) {
		// Getting the member by ID;
		Member member = findMemberById(memberId);
		
		if(member == null) {
			System.out.println("No such member.");
			return;
		}
		
		// Setting flag to determine -> does this member have history of borrow
		boolean recordFound = false;
		
		// Iterating the records -> if record's member detail == this member -> print -> set the flag to true.
		for(BorrowRecord record : records) {
			if(record.getMember() == member) {
				System.out.println(record);
				recordFound = true;
			}
		}
		
		// If the member doesn't borrowed any books -> the flag will be still false -> This will print and return
		if(!recordFound) {
			System.out.println("This Member haven't borrowed any books.");
		}
	}
	
	public String removeBookById(int bookId) {
		// Getting the Book by ID;
		Book book = findBookById(bookId);
		
		// If no book found -> return;
		if(book == null) {
			return "No Book has the ID: " + bookId;
		}
		
		// If book currently been borrowed -> can't be removed.
		if(book.getStatus() == BookStatus.BORROWED) {
			return "Book is currently borrowed and cannot be removed.";
		}
		
		// Else; Book will be removed
		// For this current project - each book will have a quantity of 1 only.
		// So we're directly removing the book object from the books list.
		books.remove(book);
		return "Successfully Removed Book with ID: " + bookId;
	}
	
	public String removeMemberById(int memberId) {
		Member member = findMemberById(memberId);
		
		if(member == null) {
			return "Cannot remove: No member found with ID " + memberId;
		}

		for(BorrowRecord record : records) {
			// Cannot remove Member if they currently having borrowed books
			if(record.getMember() == member && record.getBook().getStatus() == BookStatus.BORROWED) {
				return "Cannot remove: Member currently has borrowed books.";
			}
		}
		
		// Removing the current member object in the members list - if Member doesn't have any books with them.
		members.remove(member);
		return "Successfully removed member with ID: " + memberId;
	}
	
	public void searchBooksByTitle(String title) {
		String search = title.toLowerCase();
		
		boolean bookFound = false;
		
		for(Book book : books) {
			if(book.getTitle().toLowerCase().contains(search)) {
				System.out.println(book);
				bookFound = true;
			}
		}
		
		if(!bookFound) {
			System.out.println("No book found.");
		}
	}
	
	public void searchBooksByAuthor(String author) {
		String search = author.toLowerCase();
		
		boolean authorFound = false;
		
		for(Book book : books) {
			if(book.getAuthor().toLowerCase().contains(search)) {
				System.out.println(book);
				authorFound = true;
			}
		}
		
		if(!authorFound) {
			System.out.println("No books by that Author.");
		}
	}
	
	public void searchBooksByGenre(String genre) {
		String search = genre.toLowerCase();
		
		boolean genreFound = false;
		
		for(Book book : books) {
			if(book.getGenre().toLowerCase().contains(search)) {
				System.out.println(book);
				genreFound = true;
			}
		}
		
		if(!genreFound) {
			System.out.println("No Book with that genre found.");
		}
	}
	
	public String updateBookPrice(int bookId, double newPrice) {
		Book book = findBookById(bookId);
		
		if(book == null) {
			return "No Book has that ID: " + bookId;
		}
		
		if(newPrice <= 0) {			
			return "Price must be greater than 0.";
		}
		
		book.setPrice(newPrice);
		return "Successfully updated Book Price.";
	}
	
	public String updateBookPages(int bookId, int newPages) {
		Book book = findBookById(bookId);
		
		if(book == null) {
			return "No Book has that ID: " + bookId;
		}
		
		if(newPages <= 0) {
			return "Pages should be greater than 0";
		}
		
		book.setPages(newPages);
		return "Updated Book Pages Successfully.";
	}
	
	public String updateBookTitle(int bookId, String newTitle) {
		Book book = findBookById(bookId);
		
		if(book == null) {
			return "No Book has that ID: " + bookId;
		}

		if(newTitle == null || newTitle.trim().isEmpty()) {
			return "New title cannot be Null or Empty.";
		}
		
		book.setTitle(newTitle.trim());
		return "Updated Book Title Successfully.";
	}
	
	public String updateBookAuthor(int bookId, String newAuthor) {
		Book book = findBookById(bookId);
		
		if(book == null) {
			return "No Book has that ID: " + bookId;
		}
		
		if(newAuthor == null || newAuthor.trim().isEmpty()) {
			return "Author name cannot be Null or Empty";
		}
		
		book.setAuthor(newAuthor.trim());
		return "Updated Book Author Successfully.";
	}
	
	public String updateBookGenre(int bookId, String newGenre) {
		Book book = findBookById(bookId);
		
		if(book == null) {
			return "No Book has that ID: " + bookId;
		}
		
		if(newGenre == null || newGenre.trim().isEmpty()) {
			return "Genre cannot be Null or Empty";
		}
		
		book.setGenre(newGenre.trim());
		return "Updated Book Genre Successfully";
	}
	
	// Learning method:
	// In a real Library Management System, book status should normally
	// change only through borrowBook() and returnBook().
	// This method exists only to practice update operations.
	public String updateBookStatus(int bookId, BookStatus newStatus) {
		Book book = findBookById(bookId);
		
		if(book == null) {
			return "No Book has that ID: " + bookId;			
		}
		
		if(newStatus == null) {
			return "Status cannot be null";
		}
		
		book.setStatus(newStatus);
		return "Updated Book Status Successfully";
	}
	
	public String updateMemberName(int memberId, String newName) {
		Member member = findMemberById(memberId);
		
		if(member == null) {
			return "No Registered Member has that ID: " + memberId;			
		}
		
		if(newName == null || newName.trim().isEmpty()) {
			return "Name cannot be Null or Empty";
		}
		
		member.setName(newName.trim());
		return "Updated Member Name Successfully";
	}
	
	public String updateMemberContact(int memberId, String newContact) {
		Member member = findMemberById(memberId);
		
		if(member == null) {
			return "No Registered Member has that ID: " + memberId;			
		}
		
		if(newContact == null || newContact.trim().isEmpty()) {
			return "Contact cannot be Null or Empty";
		}
		
		member.setContact(newContact.trim());
		return "Updated Member Contact Successfully";
	}
	
	public String updateMemberAddress(int memberId, String newAddress) {
		Member member = findMemberById(memberId);
		
		if(member == null) {
			return "No Registered Member has that ID: " + memberId;			
		}
		
		if(newAddress == null || newAddress.trim().isEmpty()) {
			return "Address cannot be Null or Empty";
		}
		
		member.setAddress(newAddress.trim());
		return "Updated Member Address Successfully";
	}
	
	public String updateMemberAge(int memberId, int newAge) {
		Member member = findMemberById(memberId);
		
		if(member == null) {
			return "No Registered Member has that ID: " + memberId;			
		}
		
		if(newAge <= 0) {
			return "Age should be greater than 0.";
		}
		
		member.setAge(newAge);
		return "Updated Member Age Successfully";
	}
	
}
