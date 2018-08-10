package info.sjd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MultiplicationRunnerTest {

	@Test
	void testGetMultiplyByColumn() {

		assertEquals("  1234\n   111\n  ____\n  1234\n 1234\n1234\n______\n136974",
				MultiplicationRunner.getMultiplyByColumn(1234, 111).toString());

	}

	@Test
	void testGetMultiplicationResult() {
		assertEquals(0, MultiplicationRunner.getMultiplicationResult(0, 134));
		assertEquals(4, MultiplicationRunner.getMultiplicationResult(2, 2));
	}

	@Test
	void testGetIntend() {

		assertEquals("    ", MultiplicationRunner.getIndent(11, 111111).toString());

	}

	@Test
	void testGetLine() {

		assertEquals("____", MultiplicationRunner.getLine(6666).toString());

	}
}
