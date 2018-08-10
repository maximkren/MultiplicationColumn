package info.sjd;

import java.util.Formatter;

public class MultiplicationRunner {

	public static void main(String[] args) {
		System.out.print(getMultiplyByColumn(300, 555));

	}

	public static String getMultiplyByColumn(int multiplicant, int multiplier) {

		int finalResult = getMultiplicationResult(multiplicant, multiplier);
		Formatter formattedString = new Formatter();
		StringBuilder stringBuilderResult = new StringBuilder();
		String resultString = "";

		stringBuilderResult.append(getIndent(multiplicant, finalResult)).append(multiplicant);
		stringBuilderResult.append("%n").append(getIndent(multiplier, finalResult)).append(multiplier);

//ACTIONS:		
//intermediate results to array
		int lengthOfMultiplier = Integer.toString(multiplier).length();
		int[] digitsOfmultiplier = new int[lengthOfMultiplier];
		int[] intermediateResults = new int[lengthOfMultiplier];
		int modResult = multiplier;
		int actionCounter = 0;

//add intermediate results into array if multiplier > 10		
		if (multiplier > 10) {
			stringBuilderResult.append("%n").append(getIndent(multiplicant, finalResult)).append(getLine(multiplicant));

			for (int i = 0; i < intermediateResults.length; i++) {
				digitsOfmultiplier[i] = modResult % 10;
				intermediateResults[i] = getMultiplicationResult(multiplicant, digitsOfmultiplier[i]);
				modResult = modResult / 10;
			}
		}
//append intermediate results to main string
		for (int i = 0; i < intermediateResults.length; i++) {

			if (intermediateResults[i] != 0) {

				stringBuilderResult.append("%n")
						.append(getIndent(intermediateResults[i], finalResult).delete(0, actionCounter))
						.append(intermediateResults[i]);

			}
			actionCounter++;
		}
		stringBuilderResult.append("%n").append(getLine(finalResult));
		stringBuilderResult.append("%n").append(finalResult);

		resultString += formattedString.format(stringBuilderResult.toString());
		formattedString.close();

		return resultString;

	}

//return multiplication result if operands is !0

	public static int getMultiplicationResult(int arg1, int arg2) {
		int result = 0;

		if (arg1 != 0 && arg2 != 0) {

			result = arg1 * arg2;

		}

		return result;
	}

// Indent Builder
	public static StringBuilder getIndent(int comparedValue, int finalResult) {

		StringBuilder indentStringBuilder = new StringBuilder();
		String immediateResultAsString = Integer.toString(comparedValue);
		String finalResultAsString = Integer.toString(finalResult);
		int indent = finalResultAsString.length() - immediateResultAsString.length();

		for (; indent > 0; indent--) {
			indentStringBuilder.append(' ');
		}

		return indentStringBuilder;
	}

//Line Builder
	public static StringBuilder getLine(int lineForNumber) {
		int line = Integer.toString(lineForNumber).length();
		StringBuilder indentStringBuilder = new StringBuilder();

		for (; line > 0; line--) {
			indentStringBuilder.append('_');
		}

		return indentStringBuilder;
	}

}
