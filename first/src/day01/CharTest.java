package day01;

public class CharTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ҹ���
		char c1 = 'A';   //   '\uac00   0xac00
		int c2 = c1 + 32;
		System.out.println( c2 + " " + (char)c2 );
		
		char c3 = '\uac00';
		char c4 = 0xac00;
		char c5 = '��';
		char c6 = 44032;
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		
		//���ڿ�
		String s = "\"�ȳ�\"\n��\n��\t����\\";  // str�� "" , char ''
		System.out.println(s);
		

	}

}
