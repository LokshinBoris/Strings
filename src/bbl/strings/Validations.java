package bbl.strings;



public class Validations
{
	public static boolean isArithmeticExpression(String expression)
	{
		// 1. checking against the regular expression
		// 2. checking brackets. For each '(' there should be ')'
		// consider introducing counter that increased for '(' and decreased for ')'
		// if during passing over the string expression counter <0 returning false
		// if after passing whole string counter !=0 returning false
		
		String regex=RegularExpresions.ArithmeticExpression();
		boolean isRegularExpressions=expression.matches(regex);
		int index=0;
		int counter=0;
		if(!isRegularExpressions) counter=-1;
		while ( index<expression.length() && counter>=0)
		{
			if(expression.charAt(index)=='(') counter++;
			if(expression.charAt(index)==')') counter--;
			index++;
		}
		return counter==0;
	}
	
	public static boolean isPasword(String expression)
	{
		//TODO
		return false;
	}
}
