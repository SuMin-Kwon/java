package exam02;

import java.util.List;

public abstract class BookAccess {

	public BookAccess () {}
	
	public abstract void insert(Book book);
	
	public abstract List<Book> findName(String a); 
}
