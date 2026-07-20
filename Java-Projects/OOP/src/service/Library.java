package service;

import java.util.ArrayList;

import model.Book;
import model.BookStatus;
import model.BorrowRecord;
import model.Member;

public class Library {
	private static ArrayList<Book> books;
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
	
		Member member = findMemberById(memberId);
		
		if(member == null) {
			System.out.println("There is no registered Member with that ID.");
			return;
		}
		
		boolean hasBorrowedBooks = false;
		
		for(BorrowRecord record : records) {
			if(record.getMember() == member) {
				if(record.getBook().getStatus() == BookStatus.BORROWED) {
					System.out.println(record);
					hasBorrowedBooks = true;
				}
			}
		}
		
		if(!hasBorrowedBooks) {
			System.out.println("The user doesn't have any book with them.");
		}
	 
	}
	
}
