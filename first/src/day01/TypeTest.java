package day01;
/*
 * �������� ����
 * ������ Ÿ���� �����ֱ� ���ؼ� ���ڿ� ǥ�ø� �������
 * ���� int�� double�� �⺻���̶� �ڿ� ǥ�� �����൵ ��
 * 
 * 				   200  2223L  10.3F  10. 5
 * 
 * 				   �⺻			    	�⺻
 *   1		2		4	  8		4		8
 * byte > short > int > long					���� 
 * 							> float > double	�Ǽ�
 * 		  char									����
 * boolean										��
 * 
 * 0.000001  > 0.1*10�� -5��
 * */



public class TypeTest {

	public static void main(String[] args) {
	//	System.out.println(Integer.MAX_VALUE);
	//	System.out.println(Long.MAX_VALUE);
		long a = 2200000000L;  
		// int b = 220000000;
		float f = 0.123456789f;  //��ȿ�ڸ��� 7�ڸ������� ǥ�ð����ϰ� �������� �ø���
		System.out.println(f);
		double d = 0.12345678912345678910;   //��ȿ�ڸ��� 16~17�ڸ������� ǥ�ð���
		System.out.println(d);
		
		// ����ǥ��
		int b = 0111;   // (0xa > 10 ,0xb > 15 )��������, 0���� �����ϸ� 8����
		System.out.println("8���� 111 =" + b);
		
		int b8 = 015 + 04;
		System.out.println("8���� 015 + 04 =" + 
							Integer.toOctalString(b8));
		
		int b16 = 0xff;     // 0x�� �����ϸ� 16����
		System.out.println(b16);
		
		int b2 =0b1111;     // 0b�� �����ϸ� 2����
		System.out.println(b2);
		//char
		System.out.println("--------------------------");
		char c1 = '��';
		System.out.println((int)c1);    // 10����
		System.out.println(Integer.toHexString(c1)); //16����
		char c2 = '\uac01'; 
		int c3 = 44033;
		System.out.println(c2);
		System.out.println((char)c3);
		
	}

}
