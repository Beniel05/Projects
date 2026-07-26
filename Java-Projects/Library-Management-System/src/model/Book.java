package model;

public class Book {
	private int bookId;
	private String title;
	private String author;
	private String genre;
	private int pages;
	private double price;
	private BookStatus status;
	
	public Book(int bookId, String title, String author, String genre, int pages, double price, BookStatus status) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.pages = pages;
		this.price = price;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + 
				", genre=" + genre + ", pages=" + pages + ", price=" + price +
				", status=" + status + "]";
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public BookStatus getStatus() {
		return status;
	}

	public void setStatus(BookStatus status) {
		this.status = status;
	}
	
}
