package service;

import java.util.ArrayList;
import java.util.Arrays;

import model.Book;
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
	
}
