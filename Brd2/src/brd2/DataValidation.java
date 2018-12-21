package brd2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class DataValidation {

	static boolean DataType(String value, String st) {
		switch (st) {
		case "Byte":
			try {
				int var = Integer.parseInt(value);
				System.out.println(var);
				if (var < 128 && var >= -128) {
					return true;
				}
			} catch (NumberFormatException exception) {
				return false;
			}
			break;
		case "Short":
			try {
				int var = Integer.parseInt(value);
				System.out.println(var);
				if (var <= 32767 && var >= -32768) {
					return true;
				}
			} catch (NumberFormatException exception) {
				return false;
			}
			break;
		case "Integer":
			try {
				int var = Integer.parseInt(value);
//			      if(var<=2147483647 && var>=-2147483648)
//			       {
				return true;
//			       }
			} catch (NumberFormatException exception) {
				return false;
			}
			/*
			 * break;
			 */ case "Character":
			if (value.length() == 1) {
				char ch = value.charAt(0);
				return true;
			}
			break;
		case "Long":
			try {
				long var = Long.parseLong(value);
//	      if(var<=-9,223,372,036,854,775,807  && var>=-9,223,372,036,854,775,808 )
//	       {
				return true;
//	       }
			} catch (NumberFormatException exception) {
				return false;
			}
			/* break; */
		case "String":
			if (value.getClass().getSimpleName().equals("String"))
				return true;
			break;
		case "Double":
			try {
               double var=Double.parseDouble(value);  
               return true;
			}
			catch(NumberFormatException exception)
			{
				return false;
			}
		}
		return false;
	}

	static boolean DataLength(String value, byte length) {
		boolean b = false;
		if (value.length() <= length)
			b = true;
		System.out.println(value);
		return b;

	}

	static boolean ValidSpecialChar(String value, String sp)

	{
		boolean b = true;
		byte l1, l2;
		l1 = (byte) (value).length();
		l2 = (byte) sp.length();
		for (byte i = 0; i < l1; i++)
			for (byte j = 0; j < l2; j++)
				if ((value).charAt(i) == sp.charAt(j))
					return false;
		return b;
	}

	static boolean DomainValue(String value, List<String> values) {
		boolean b = false;
		byte noOfValues = (byte) values.size();
		for (byte i = 0; i < noOfValues; i++)
			if (values.get(i).equals(value))
				return true;
		return b;
	}

	static boolean FormatValidation(String date, SimpleDateFormat sm) {
		sm.setLenient(false);
		try {
			sm.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}

	}

	static boolean EmailValidation(String email) {

		return email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}");
	}
}
