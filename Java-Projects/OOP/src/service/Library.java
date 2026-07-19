package service;

import java.util.ArrayList;
import java.util.Arrays;

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
		BorrowRecord borrowRecord = new BorrowRecord(member, book, "19-07-2026", "29-07-2026");
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
	
}
