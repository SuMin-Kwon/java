package exam02;

import java.util.List;
import java.util.Scanner;

public class BookServiceFind implements BookService{


	public BookServiceFind () {}

	@Override
	public void exexute(BookList list) {
		
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		List<Book> booklist = list.findName(name);
		System.out.println(booklist);
		
		
	}

}
