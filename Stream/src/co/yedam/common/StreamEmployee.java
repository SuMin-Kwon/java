package co.yedam.common;

import java.util.List;

import com.yedam.Employee;
import com.yedam.EmployeeDAO;

public class StreamEmployee {

	public static void main(String[] args) {
			
		List<Employee> elist = null;
		EmployeeDAO edao = new EmployeeDAO();
		elist = edao.getEmloyeeList();
		elist.stream()
			.filter( (t) -> Integer.parseInt(t.getBirthDate().substring(0,4)) > 1970)
			.forEach((t) -> System.out.println(t.getFirstName()+"_"
												+t.getLastName()+" : "
												+ t.getTitle()));
		
		
		
	}

}
