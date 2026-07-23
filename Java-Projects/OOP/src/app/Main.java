package app;

import java.util.Scanner;

import model.Book;
import model.BookStatus;
import service.Library;

public class Main {
	public static void main(String[] args) {
	
		Library library = new Library();
		Scanner sc = new Scanner(System.in);
	
		while(true) {
			System.out.println("===== Library Management System =====");
			System.out.println("\n1. Add Book");
			System.out.println("2. Register Member");
			System.out.println("3. View All Books");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			
			int choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
			case 1: 
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

				Book book = new Book(bookId, title, author, genre, pages, price, BookStatus.AVAILABLE);
				
				if(library.addBook(book)) {					
					System.out.println("Book added successfully.");
				} else {
					// This else is un-reachable right now. Having this for future proof (scalability).
					System.out.println("\nFailed to Add Book");
				}
				
				break;
				
			case 2:
				// Register Member
				break;
			case 3:
				// View All Books
				break;
			case 4:
				System.out.println("===== Program Ends =====");
				sc.close();
				return;
			default:
				System.out.println("Invalid choice.");
			}
		}
		
		
	}
}
