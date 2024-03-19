package bbl.strings.test;

import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bbl.strings.RegularExpresions;

class RegualarExpresionsTest {

	@Test
	void javaVariableTrueTest()
	{
		String regex=RegularExpresions.javaVariable();
		assertTrue("abs".matches(regex));
		assertTrue("a".matches(regex));
		assertTrue("$".matches(regex));
		assertTrue("$123".matches(regex));
		assertTrue("$1_23".matches(regex));
		assertTrue("abs_".matches(regex));
		assertTrue("__".matches(regex));
		assertTrue("aBs".matches(regex));
	}
	@Test
	void javaVariableFalseTest()
	{
		String regex=RegularExpresions.javaVariable();
		assertFalse("1abc".matches(regex));
		assertFalse("_".matches(regex));
		assertFalse("a-2".matches(regex));
		assertFalse("a 2".matches(regex));
		assertFalse("b?c".matches(regex));
		assertFalse("i*bc".matches(regex));
	}
	
	@Test
	void zero_300TrueTest()
	{
		String regex=RegularExpresions.zero_300();
		assertTrue("0".matches(regex));
		assertTrue("1".matches(regex));
		assertTrue("19".matches(regex));
		assertTrue("198".matches(regex));
		assertTrue("299".matches(regex));
		assertTrue("30".matches(regex));
		assertTrue("300".matches(regex));
	}
	
	@Test
	void zero_300FalseTest()
	{
		String regex=RegularExpresions.zero_300();
		assertFalse("00".matches(regex));
		assertFalse("01".matches(regex));
		assertFalse("19s".matches(regex));
		assertFalse("398".matches(regex));
		assertFalse("2990".matches(regex));
		assertFalse("-30".matches(regex));
		assertFalse("301".matches(regex));
		assertFalse("330".matches(regex));
	}
	
	@Test
	void ipOctetTest()
	{
		String regex=RegularExpresions.ipOctet();
		assertTrue("0".matches(regex));
		assertTrue("9".matches(regex));
		assertTrue("99".matches(regex));
		assertTrue("00".matches(regex));
		assertTrue("000".matches(regex));
		assertTrue("10".matches(regex));
		assertTrue("19".matches(regex));
		assertTrue("199".matches(regex));
		assertTrue("010".matches(regex));
		assertTrue("255".matches(regex));
		assertTrue("010".matches(regex));
		assertFalse("".matches(regex));
		assertFalse("321".matches(regex));
		assertFalse("256".matches(regex));
		assertFalse("0001".matches(regex));
	}
	
	@Test
	void mobileIsraelPhoneTest()
	{
		String regex=RegularExpresions.mobileIsraelPhone();
		assertTrue("+972-53-443-43-34".matches(regex));
		assertTrue("+972534434334".matches(regex));
		assertTrue("+972-534434334".matches(regex));
		
		assertTrue("053-443-43-34".matches(regex));
		assertTrue("0534434334".matches(regex));
		assertTrue("053-443-4334".matches(regex));
		assertTrue("053443-4334".matches(regex));
		assertTrue("053443-4334".matches(regex));
		assertTrue("05344343-34".matches(regex));

		
		assertFalse("-972534434334".matches(regex));
		assertFalse("+9725-34434334".matches(regex));
		assertFalse("+9725344-34334".matches(regex));
		assertFalse("+9725344343348".matches(regex));
		assertFalse("+97253a434334".matches(regex));

		assertFalse("1534434334".matches(regex));
		assertFalse("05-34434334".matches(regex));
		assertFalse("05344-34334".matches(regex));
		assertFalse("05344343348".matches(regex));
		assertFalse("053a434334".matches(regex));
	}
	
	@Test
	@DisplayName("test for ip v4 regular expression")
	void ipV4adressTest()
	{
		String regex=RegularExpresions.ipV4adress();
		assertTrue("1.2.3.4".matches(regex));
		assertFalse("1.2.3".matches(regex));
		assertFalse("1 2.3.4".matches(regex));
		assertFalse("1. 2.3.4".matches(regex));
		assertFalse("1.2.3.4.5".matches(regex));
		assertFalse("1.2.3&4".matches(regex));
	}
	
	@Test
	@DisplayName("test of simple arithmetic expression")
	void SimpleArithmeticExpressionTest()
	{
		String regex=RegularExpresions.SimpleArithmeticExpression();
		assertTrue("20".matches(regex));
		assertTrue(" 20+3 /2 *100".matches(regex));
		assertTrue("10000-1 ".matches(regex));
		assertFalse("-20".matches(regex));
		assertFalse("20 ** 3".matches(regex));
		assertFalse("20+3 /2 *100 +".matches(regex));
	}
	
	@Test
	@DisplayName ("test arithmetic expression with any numbers or variable names and brackets")
	
	void ArithmeticExpressionTest()
	{
		String regex=RegularExpresions.ArithmeticExpression();
		assertTrue("(20.5+abc)*2".matches(regex));
		assertTrue("(20.5+abc))*2".matches(regex));
		assertTrue("(20.5+abc / 3)*(2".matches(regex));
		assertTrue("(abc)".matches(regex));
		assertFalse("2 + _".matches(regex));
		assertFalse("2 + a12 * ".matches(regex));
		assertFalse("2 + )a12".matches(regex));
	}
	
	@Test
	@DisplayName ("test for floating and integer constants")
	void floatNumberAndIntegerExpressionTest()
	{
		String regex=RegularExpresions.floatNumberAndIntegerExpression();
		assertTrue("0".matches(regex));
		assertTrue("012".matches(regex));
		assertTrue("129".matches(regex));
		assertTrue("0.5".matches(regex));
		assertTrue("1.456".matches(regex));
		assertTrue("0.398".matches(regex));
		assertTrue("1967.".matches(regex));
		assertTrue(".0345".matches(regex));
		assertFalse("".matches(regex));
		assertFalse("123 945".matches(regex));
		assertFalse(".".matches(regex));
		assertFalse("-456.789".matches(regex));
		assertFalse("456.$789".matches(regex));
	}
	
	@Test
	void operandOfArithmeticExpressionTest()
	{
		String regex=RegularExpresions.operandOfArithmeticExpression();
		assertTrue("abc".matches(regex));
		assertTrue("123".matches(regex));
		assertTrue("12.33".matches(regex));
		assertTrue("(abc".matches(regex));
		assertTrue("abc)".matches(regex));
		assertTrue("(aBc)".matches(regex));
		assertTrue(" ( 123 ) ".matches(regex));
		assertTrue("  ( abc )) ".matches(regex));
		assertTrue("  ( abc )  ) ".matches(regex));
		assertFalse("".matches(regex));
		assertFalse(") abc".matches(regex));
		assertFalse(" abc ( ".matches(regex));
		assertFalse(") abc(".matches(regex));
		assertFalse("abc+".matches(regex));		
	}
}
