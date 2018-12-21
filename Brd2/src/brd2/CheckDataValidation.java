package brd2;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
public class CheckDataValidation {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String value;
		System.out.println("Enter the field:");
		value=sc.nextLine();
//		System.out.println(DataValidation.DataType(value,"Byte"));
//		System.out.println(DataValidation.DataType(value,"Short"));
//		System.out.println(DataValidation.DataType(value,"Integer"));
 //    	System.out.println(DataValidation.DataType(value,"Character"));	
 //    	System.out.println(DataValidation.DataType(value,"String"));	
		System.out.println(DataValidation.DataType(value,"Double"));	


	/*
		System.out.println(DataValidation.DataLength(value,(byte)15));
		
		*/

		
		/*String sp = null;
		System.out.println("Enter the restricted special characters:");
		sp=sc.nextLine();
		System.out.println(DataValidation.ValidSpecialChar(value,sp));
		*/
		
		
		
		/*List<String> values = new ArrayList<String>();
		values.add("monday");
		values.add("tuesday");
		values.add("wednesday");
		System.out.println(DataValidation.DomainValue(value,values));
		*/
		
		/*
		System.out.println(DataValidation.EmailValidation(value));
	*/
		/*
		SimpleDateFormat sm=new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(DataValidation.FormatValidation(value,sm));
*/
	}
}
	
	