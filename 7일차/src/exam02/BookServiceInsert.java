package exam02;

import java.util.Scanner;

public class BookServiceInsert implements BookService {
	
	
	public BookServiceInsert() {}

	@Override
	public void exexute(BookList list) {
		Scanner sc = new Scanner(System.in);
		String isbn = sc.next();
		String name = sc.next();
		String content = sc.next();
		Book book = new Book(isbn,name,content);
		list.insert(book);
		
		
	}

	
}
