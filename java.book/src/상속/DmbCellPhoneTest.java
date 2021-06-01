package 상속;

public class DmbCellPhoneTest {

	public static void main(String[] args) {

		DmbCellPhone Phone = new DmbCellPhone();
		DmbCellPhone dmbCellPhone = new DmbCellPhone("삼성","black",10);
		
		System.out.println(dmbCellPhone.color + ":" 
							+ dmbCellPhone.model);
		
		dmbCellPhone.powerOn();				// 상속
		dmbCellPhone.bell();				// 상속
		dmbCellPhone.trunOnDmb();
		dmbCellPhone.changeChannel(20);
		dmbCellPhone.trunOffDmb();
		dmbCellPhone.powerOff();			// 상속
		
	}

}
