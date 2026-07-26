package app;

import java.util.Scanner;

import model.Book;
import model.BookStatus;
import model.Member;
import service.Library;

public class Main {
	public static void main(String[] args) {
	
		Library library = new Library();
		Scanner sc = new Scanner(System.in);
	
		while(true) {
			System.out.println("\n===== Library Management System =====");
			System.out.println("1. Add Book");
			System.out.println("2. Register Member");
			System.out.println("3. View All Books");
			System.out.println("4. View All Members");
			System.out.println("5. Borrow Book");
			System.out.println("6. Return Book");
			System.out.println("7. View Available Books");
			System.out.println("8. View Borrowed Books");
			System.out.println("9. View All Borrow Records");
			System.out.println("10. View Books Borrowed By Member");
			System.out.println("11. View Borrow History Of Member");
			System.out.println("12. Search Books");
			System.out.println("13. Update Book");
			System.out.println("14. Update Member");
			System.out.println("15. Remove Book");
			System.out.println("16. Remove Member");
			System.out.println("17. Library Statistics");
			System.out.println("100. Exit");
			System.out.print("Enter your choice: ");
			
			int choice = Integer.parseInt(sc.nextLine());
			
			switch (choice) {

			case 1:
			    addBook(sc, library);
			    break;

			case 2:
			    registerMember(sc, library);
			    break;

			case 3:
			    library.viewAllBooks();
			    break;

			case 4:
			    library.viewAllMembers();
			    break;

			case 5:
			    borrowBook(sc, library);
			    break;

			case 6:
			    returnBook(sc, library);
			    break;

			case 7:
			    library.viewAvailableBooks();
			    break;

			case 8:
			    library.viewBorrowedBooks();
			    break;

			case 9:
			    library.viewAllBorrowRecords();
			    break;

			case 10:
			    viewBooksBorrowedByMember(sc, library);
			    break;

			case 11:
			    viewBorrowHistory(sc, library);
			    break;

			case 12:
			    searchBooksMenu(sc, library);
			    break;

			case 13:
			    updateBookMenu(sc, library);
			    break;

			case 14:
			    updateMemberMenu(sc, library);
			    break;

			case 15:
			    removeBook(sc, library);
			    break;

			case 16:
			    removeMember(sc, library);
			    break;

			case 17:
			    statisticsMenu(library);
			    break;

			case 100:
			    System.out.println("\n===== Program Ends =====");
			    sc.close();
			    return;

			default:
			    System.out.println("Invalid choice.");
			}
		}
		
		
	}
	private static void addBook(Scanner sc, Library library) {
		
		System.out.print("Enter Book ID: ");
		int bookId = Integer.parseInt(sc.nextLine());
		
		System.out.print("Enter Title: ");
		String title = sc.nextLine();
		
		System.out.print("Enter Author: ");
		String author = sc.nextLine();
		
		System.out.print("Enter Genre: ");
		String genre = sc.nextLine();
		
		System.out.print("Enter Pages: ");
		int pages = Integer.parseInt(sc.nextLine());
		
		System.out.print("Enter Price: ");
		double price = Double.parseDouble(sc.nextLine());
		
		Book book = new Book(
				bookId,
				title,
				author,
				genre,
				pages,
				price,
				BookStatus.AVAILABLE);
		
		if (library.addBook(book)) {
			System.out.println("Book added successfully.");
		} else {
			System.out.println("Failed to add book.");
		}
	}
	
	private static void registerMember(Scanner sc, Library library) {
		
		System.out.print("Enter Member ID: ");
		int memberId = Integer.parseInt(sc.nextLine());
		
		System.out.print("Enter Name: ");
		String name = sc.nextLine();
		
		System.out.print("Enter Age: ");
		int age = Integer.parseInt(sc.nextLine());
		
		System.out.print("Enter Contact: ");
		String contact = sc.nextLine();
		
		System.out.print("Enter Address: ");
		String address = sc.nextLine();
		
		Member member = new Member(
				memberId,
				name,
				age,
				contact,
				address);
		
		if (library.registerMember(member)) {
			System.out.println("Member registered successfully.");
		} else {
			System.out.println("Failed to register member.");
		}
	}
	
	private static void borrowBook(Scanner sc, Library library) {

	    System.out.print("Enter Book ID: ");
	    int bookId = Integer.parseInt(sc.nextLine());

	    System.out.print("Enter Member ID: ");
	    int memberId = Integer.parseInt(sc.nextLine());

	    System.out.println(library.borrowBook(bookId, memberId));
	}
	
	private static void returnBook(Scanner sc, Library library) {

	    System.out.print("Enter Record ID: ");
	    int recordId = Integer.parseInt(sc.nextLine());

	    System.out.println(library.returnBook(recordId));
	}
	
	private static void viewBooksBorrowedByMember(Scanner sc, Library library) {

	    System.out.print("Enter Member ID: ");
	    int memberId = Integer.parseInt(sc.nextLine());

	    library.viewBooksBorrowedByMember(memberId);
	}
	
	private static void viewBorrowHistory(Scanner sc, Library library) {

	    System.out.print("Enter Member ID: ");
	    int memberId = Integer.parseInt(sc.nextLine());

	    library.viewBorrowHistoryOfMember(memberId);
	}
	
	private static void searchBooksMenu(Scanner sc, Library library) {

	    while (true) {

	        System.out.println("\n===== Search Books =====");
	        System.out.println("1. Search By Title");
	        System.out.println("2. Search By Author");
	        System.out.println("3. Search By Genre");
	        System.out.println("4. Back");
	        System.out.print("Enter choice: ");

	        int choice = Integer.parseInt(sc.nextLine());

	        switch (choice) {

	        case 1:
	            System.out.print("Enter Title: ");
	            library.searchBooksByTitle(sc.nextLine());
	            break;

	        case 2:
	            System.out.print("Enter Author: ");
	            library.searchBooksByAuthor(sc.nextLine());
	            break;

	        case 3:
	            System.out.print("Enter Genre: ");
	            library.searchBooksByGenre(sc.nextLine());
	            break;

	        case 4:
	            return;

	        default:
	            System.out.println("Invalid choice.");
	        }
	    }
	}
	
	private static void removeBook(Scanner sc, Library library) {

	    System.out.print("Enter Book ID: ");
	    int bookId = Integer.parseInt(sc.nextLine());

	    System.out.println(library.removeBookById(bookId));
	}
	
	private static void removeMember(Scanner sc, Library library) {

	    System.out.print("Enter Member ID: ");
	    int memberId = Integer.parseInt(sc.nextLine());

	    System.out.println(library.removeMemberById(memberId));
	}
	
	private static void statisticsMenu(Library library) {

	    System.out.println("\n===== Library Statistics =====");

	    System.out.print("Total Books: ");
	    library.countBooks();

	    System.out.print("Total Members: ");
	    library.countMembers();

	    System.out.print("Total Borrow Records: ");
	    library.countBorrowRecords();

	    library.countAvailableBooks();

	    library.countBorrowedBooks();

	    System.out.println("Library Empty : " + library.isLibraryEmpty());
	}
	
	private static void updateBookMenu(Scanner sc, Library library) {

	    while (true) {

	        System.out.println("\n===== Update Book =====");
	        System.out.println("1. Update Title");
	        System.out.println("2. Update Author");
	        System.out.println("3. Update Genre");
	        System.out.println("4. Update Pages");
	        System.out.println("5. Update Price");
	        System.out.println("6. Update Status");
	        System.out.println("7. Back");
	        System.out.print("Enter choice: ");

	        int choice = Integer.parseInt(sc.nextLine());

	        if (choice == 7) {
	            return;
	        }

	        System.out.print("Enter Book ID: ");
	        int bookId = Integer.parseInt(sc.nextLine());

	        switch (choice) {

	        case 1:
	            System.out.print("Enter New Title: ");
	            System.out.println(library.updateBookTitle(bookId, sc.nextLine()));
	            break;

	        case 2:
	            System.out.print("Enter New Author: ");
	            System.out.println(library.updateBookAuthor(bookId, sc.nextLine()));
	            break;

	        case 3:
	            System.out.print("Enter New Genre: ");
	            System.out.println(library.updateBookGenre(bookId, sc.nextLine()));
	            break;

	        case 4:
	            System.out.print("Enter New Pages: ");
	            int pages = Integer.parseInt(sc.nextLine());
	            System.out.println(library.updateBookPages(bookId, pages));
	            break;

	        case 5:
	            System.out.print("Enter New Price: ");
	            double price = Double.parseDouble(sc.nextLine());
	            System.out.println(library.updateBookPrice(bookId, price));
	            break;

	        case 6:

	            System.out.println("1. AVAILABLE");
	            System.out.println("2. BORROWED");
	            System.out.print("Choose Status: ");

	            int statusChoice = Integer.parseInt(sc.nextLine());

	            BookStatus status = null;

	            switch (statusChoice) {
	            case 1:
	                status = BookStatus.AVAILABLE;
	                break;
	            case 2:
	                status = BookStatus.BORROWED;
	                break;
	            default:
	                System.out.println("Invalid Status.");
	                continue;
	            }

	            System.out.println(library.updateBookStatus(bookId, status));
	            break;

	        default:
	            System.out.println("Invalid choice.");
	        }
	    }
	}
	
	private static void updateMemberMenu(Scanner sc, Library library) {

	    while (true) {

	        System.out.println("\n===== Update Member =====");
	        System.out.println("1. Update Name");
	        System.out.println("2. Update Age");
	        System.out.println("3. Update Contact");
	        System.out.println("4. Update Address");
	        System.out.println("5. Back");
	        System.out.print("Enter choice: ");

	        int choice = Integer.parseInt(sc.nextLine());

	        if (choice == 5) {
	            return;
	        }

	        System.out.print("Enter Member ID: ");
	        int memberId = Integer.parseInt(sc.nextLine());

	        switch (choice) {

	        case 1:
	            System.out.print("Enter New Name: ");
	            System.out.println(library.updateMemberName(memberId, sc.nextLine()));
	            break;

	        case 2:
	            System.out.print("Enter New Age: ");
	            int age = Integer.parseInt(sc.nextLine());
	            System.out.println(library.updateMemberAge(memberId, age));
	            break;

	        case 3:
	            System.out.print("Enter New Contact: ");
	            System.out.println(library.updateMemberContact(memberId, sc.nextLine()));
	            break;

	        case 4:
	            System.out.print("Enter New Address: ");
	            System.out.println(library.updateMemberAddress(memberId, sc.nextLine()));
	            break;

	        default:
	            System.out.println("Invalid choice.");
	        }
	    }
	}
}
