// Number Conversion problem: Based on a string, implement validation for binary and
// hexadecimal numbers, and their conversion to decimal.
// Case 1: "100001" -> 33
// Case 2: "AB0" -> 2736
// Case 3: "aB0" -> 2736
// Case 3: "1001n" -> Error
// Case 4: "ABBZ" -> Error

public class NumberConversion {
	public static void main(String[] args) {
		System.out.println("----Number Conversion----");
		String example = "100001";
		String hexaExample = "aB0";

		System.out.println("The string: " + example + " is " + stringToDecimal(example, 2) + " as in decimal");
		System.out.println("The string: " + hexaExample + " is " + stringToDecimal(hexaExample, 16) + " as in decimal");

	}

	public static boolean isNBase(String givenString, int base) {
		boolean isBaseN = true;

		if(givenString.isEmpty()) {
			isBaseN = false;
		} else {
			if(base == 2) {
				isBaseN = isBinaryNumber(givenString, isBaseN);
			} else if(base == 16) {
				isBaseN = isHexNumber(givenString, isBaseN);
			} else {
				throw new IllegalArgumentException("Number " + base + " is not a valid base");
			}
		} 
		
		return isBaseN; 	
	}

	public static boolean isBinaryNumber(String givenString, boolean isBinary) {
		for(int i = 0; i < givenString.length() && isBinary; i++) {
			char currentChar = givenString.charAt(i);
			isBinary = currentChar == '0' || currentChar == '1';
		}
		return isBinary;

	}

	public static boolean isHexNumber(String givenString, boolean isHex) {
		String upperCaseString = givenString.toUpperCase();

		for(int i = 0; i < upperCaseString.length() && isHex; i++) {
			char currentChar = upperCaseString.charAt(i);
			isHex = Character.isDigit(currentChar) || currentChar >= 'A' && currentChar <= 'F';
		}

		return isHex;
	}



	public static int stringToDecimal(String givenString, int base) {
		if(isNBase(givenString, base)) {
			int decimalValue = 0;

			for(int i = 0; i < givenString.length(); i++) {
				// Get current char
				char currentChar = givenString.charAt(i);
				// Get numeric value
				int value = Character.getNumericValue(currentChar);
				decimalValue = decimalValue * base + value;
			}

			return decimalValue;
		}
		return -1; // Something went wrong
	}
}
