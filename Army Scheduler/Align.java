import java.text.NumberFormat ;

/**
 *  A class to right-align, center-align, or left-align an expression in a
 *  field of a specified width.  The expression may be a String, int or double,
 *  The expression is converted to a String (if not already a String) and 
 *  padded with the correct number of spaces to make its length equal to the 
 *  specified width. 
 *
 *  Note: If the width specified is too small to accomodate the entire 
 *  expression, then the width is ignored and the expression is neither 
 *  padded nor truncated.
 *
 *  @author Greg
 */
public final class Align
{
	private static final String SPACE = " " ;
	
	private static NumberFormat formatter = NumberFormat.getNumberInstance() ;

	/**
	 * Right-align a string in a field of a specified width
	 * @param aString the string to be aligned
	 * @param width the width (number of spaces) of the field
	 * @return the string "padded" with the correct number of leading spaces,
	 * if necessary, to right-align it in the field
	 */
	public static String right(String aString, int width)
	{
		while ( aString.length() < width)
		{
			  aString = SPACE + aString ;
		}  
		return aString ;
	}

	/**
	 * Left-align a string in a field of a specified width
	 * @param aString the string to be aligned
	 * @param width the width (number of spaces) of the field
	 * @return the string "padded" with the correct number of trailing spaces,
	 * if necessary, to left-align it in the field
	 */
	public static String left(String aString, int width)
	{
		while ( aString.length() < width)
		{
			  aString = aString + SPACE  ;
		}  
		return aString ;
	}

	/**
	 * Center-align a string in a field of a specified width
	 * @param aString the string to be aligned
	 * @param width the width (number of spaces) of the field
	 * @return the string "padded" with the correct number of leading 
	 * and trailing spaces, if necessary, to center it in the field
	 */
	public static String center(String aString, int width)
	{
		// compute total number of spaces to be added
		int spacesToBeAdded = width - aString.length() ;
		
		// put half of those to the left of the string
		for (int i = 1 ; i <= spacesToBeAdded / 2 ; i++)
		{
			  aString = SPACE + aString ;
		}
		// now put the rest to the right of the string
		while ( aString.length() < width )
		{
			aString = aString + SPACE ;
		}
		return aString ;
	}

	/**
	 * Right-align an int in a field of a specified width
	 * @param number the int to be aligned
	 * @param width the width (number of spaces) of the field
	 * @return the int converted to a string and padded with the correct number
	 * of leading spaces, if necessary, to right-align it in the field
	 */
	public static String right(int number, int width)
	{
		String out = String.valueOf(number) ;
		// to save code, call String-argument "right" method
		return right(out,width) ;
	}
	
	/**
	 * Left-align an int in a field of a specified width
	 * @param number the int to be aligned
	 * @param width the width (number of spaces) of the field
	 * @return the int converted to a string and padded with the correct number
	 * of trailing spaces, if necessary, to left-align it in the field
	 */
	public static String left(int number, int width)
	{
		String out = String.valueOf(number) ;
		// to save code, call String-argument "left" method
		return left(out,width) ;
	}
	
	/**
	 * Center-align an int in a field of a specified width
	 * @param number the int to be aligned
	 * @param width the width (number of spaces) of the field
	 * @return the int converted to a string and padded with the correct number
	 * of leading and trailing spaces, if necessary, to center it in the field
	 */
	public static String center(int number, int width)
	{
		String out = String.valueOf(number) ;
		// to save code, call String-argument "center" method
		return center(out,width) ;
	}
	
	/**
	 * Right-align a double expression in a field of a specified width
	 * @param number the double to be rounded and aligned
	 * @param width the width (number of spaces) of the field
	 * @return the double value converted to a string and padded with the 
	 * correct number of leading spaces, if necessary, to right-align it in the
	 * field
	 */
	public static String right(double number, int width)
	{
		String out = String.valueOf(number) ;
		// to save code, call String-argument "right" method
		return right(out,width) ;
	}

	/**
	 * Formats a double expression as US currency and right-aligns it in 
	 * a field of a specified width.
	 * Note: width must be one greater than for the same value formatted as
	 * "non-currency," to accomodate the "$"
	 * @param number the value to be expressed as currency
	 * @param width the width (number of spaces) of the field
	 * @return a String consisting of the correct number of leading spaces, 
	 * if necessary, for right-alignment, the dollar sign ($), and the number
	 * rounded to 2 decimal places
	 */
	public static String currency(double number, int width)
	{
		// insert leading spaces and round to 2 decimal places
		String out = right(number,width-1,2) ;
		return "$" + out ;
	}

	/**
	 * Left-align a double expression in a field of a specified width
	 * @param number the double to be rounded and aligned
	 * @param width the width (number of spaces) of the field
	 * @return the double value converted to a string and padded with the 
	 * correct number of trailing spaces, if necessary, to left-align it in 
	 * the field
	 */
	public static String left(double number, int width)
	{
		String out = String.valueOf(number) ;		
		// to save code, call String-argument "left" method
		return left(out,width) ;
	}

	/**
	 * Center-align a double expression in a field of a specified width
	 * @param number the double to be rounded and aligned
	 * @param width the width (number of spaces) of the field
	 * @return the double value converted to a string and padded with the
	 * correct number of leading and trailing spaces, if necessary, to center 
	 * it in the field
	 */
	public static String center(double number, int width)
	{
		String out = String.valueOf(number) ;
		// to save code, call String-argument "center" method
		return center(out,width) ;
	}
	
	/**
	 * Round a double to a specified number of decimal places and right-align
	 * it in a field of a specified width.
	 * @param number the double to be rounded and aligned
	 * @param width the width (number of spaces) of the field
	 * @param places the number of decimal places to which number is rounded
	 * @return the double, rounded to the correct number of decimal places, 
	 * converted to a string, and padded with the correct number of leading 
	 * spaces (if necessary) to right-align it in the field
	 */
	public static String right(double number, int width, int places)
	{
		String out = roundOrPad(number, places) ;
		// to save code, call String-argument "right" method
		return right(out,width) ;
	}
	
	/**
	 * Round a double to a specified number of decimal places and left-align
	 * it in a field of a specified width.
	 * @param number the double to be rounded and aligned
	 * @param width the width (number of spaces) of the field
	 * @param places the number of decimal places to which number is rounded
	 * @return the double, rounded to the correct number of decimal places, 
	 * converted to a string, and padded with the correct number of trailing 
	 * spaces (if necessary) to left-align it in the field
	 */
	public static String left(double number, int width, int places)
	{
		String out = roundOrPad(number, places) ;
		// to save code, call String-argument "left" method
		return left(out,width) ;
	}
	
	/**
	 * Round a double to a specified number of decimal places and center it in 
	 * a field of a specified width.
	 * @param number the double to be rounded and aligned
	 * @param width the width (number of spaces) of the field
	 * @param places the number of decimal places to which number is rounded
	 * @return the double, rounded to the correct number of decimal places, 
	 * converted to a string, and padded with the correct number of leading 
	 * and trailing spaces (if necessary) to center it in the field
	 */
	public static String center(double number, int width, int places)
	{
		String out = roundOrPad(number, places) ;
		// to save code, call String-argument "center" method
		return center(out,width) ;
	}
	
	/*
	 * This method is called by the 3 methods that round or right-pad a double 
	 * to a certain number of decimal places before aligning it in a field 
	 * (i.e., called by the 3 three-argument methods, above).  
	 * The rounding/padding is done via the NumberFormat class, and then the
	 * resulting String is returned to be aligned by the calling method.
	 */
	private static String roundOrPad(double number, int places)
	{
		places = Math.abs(places) ;		// just in case places is negative!		

		formatter.setMaximumFractionDigits(places) ;
		formatter.setMinimumFractionDigits(places) ;
		return formatter.format(number) ;
	}
}	