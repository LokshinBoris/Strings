package bbl.strings;

import static org.junit.jupiter.api.DynamicTest.stream;

public class RegularExpresions 
{
	public static String javaVariable()
	{
		
		// return regex for cheking a java variable string
		String regex="([A-Za-z$][A-Za-z0-9_$]*|_[A-Za-z0-9_$]+)";
		// String regex="[A-Za-z$][\\w$]*|_[\\w$]+";
		return regex;
	}
	public static String zero_300()
	{
		
		// string contains number from 0-300; leading zeros are disallowed
		String regex="[1-9]\\d?|[1-2]\\d\\d|300|0";
		return regex;
	}
	public static String ipOctet()
	{
		
		// string contains 1-3 symbols number from 0-255; leading zeros are allowed
		String regex="([0-1]?\\d?\\d|2[0-4]\\d|25[0-5])";
		return regex;
	}
	
	public static String mobileIsraelPhone()
	{
		// string contains possible mobile phone number
		//+972-<prefix two digits beginning from 5>-<7 digits of number>
		//<prefix 3 digits: first - 0? second 5 third -any>-<7 digits of number>
		// 0547334458
		String regex="\\+972-?5\\d-?\\d{3}-?\\d{2}-?\\d{2}|05\\d-?\\d{3}-?\\d{2}-?\\d{2}";
		return regex;
	}
	
	public static String ipV4adress()
	{
		String regex=ipOctet();
		return String.format("%1$s(\\.%1$s){3}",regex );
	}
	
	public static String SimpleArithmeticExpression()
	{
		
		// operators only binary +,-,*,/
		// operands only integer numbers
		// no brackets
		String operand=integerNumberExpression();
		String operation=operationExpression();
		return String.format("%1$s(%2$s%1$s)*", operand, operation);
	}
	public static String integerNumberExpression() 
	{
	   return "(\\s*\\d+\\s*)";
	}
	
	public static String operationExpression() 
	{
	   return "[-+*/]";
	}
	
	public static String floatNumberAndIntegerExpression()
	{
		return "(\\s*(\\d+(\\.\\d*)?)|((\\d*\\.)?\\d+)\\s*)";
	}
	
	public static String javaVariableForOperand()
	{
		String regex=String.format("(\\s*%s\\s*)",javaVariable());
		return regex;	
	}
	
	public static String operandOfArithmeticExpression()
	{
		String operand=String.format("\\s*([(]\\s*)*\\s*(%1$s|%2$s)(\\s*[)])*\\s*", floatNumberAndIntegerExpression(),javaVariableForOperand());
		return operand; 
	}
	
	public static String ArithmeticExpression() 
	{
		String operand=operandOfArithmeticExpression();
		String operation=operationExpression();
		return String.format("%1$s(%2$s%1$s)*", operand, operation);		
	}
	
	
}
