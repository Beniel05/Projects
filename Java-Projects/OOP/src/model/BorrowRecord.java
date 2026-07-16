package model;

public class BorrowRecord {
	private int recordId;
	
	private Member member;
	private Book book;
	
	private String borrowDate;
	private String returnDate;
	
	public BorrowRecord(int recordId, Member member, Book book, String borrowDate, String returnDate) {
		this.recordId = recordId;
		this.member = member;
		this.book = book;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
}
