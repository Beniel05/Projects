package model;

public class BorrowRecord {
	// Shared counter for all BorrowRecord objects
    private static int nextRecordId = 1001;

    // Each object's own ID
    private int recordId;
	
	private Member member;
	private Book book;
	
	private String borrowDate;
	private String returnDate;
	
	public BorrowRecord(Member member, Book book, String borrowDate, String returnDate) {
		
		this.recordId = nextRecordId++;
		
		this.member = member;
		this.book = book;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "BorrowRecord [recordId=" + recordId + ", member=" + member + 
				", book=" + book + ", borrowDate=" + borrowDate + 
				", returnDate=" + returnDate + "]";
	}

	public int getRecordId() {
		return recordId;
	}

	// We shouldn't let someone change the recordId from outside!
//	public void setRecordId(int recordId) {
//		this.recordId = recordId;
//	}

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
