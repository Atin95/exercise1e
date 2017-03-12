package wdsr.exercise1;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;

import wdsr.exercise1.logic.Calculator;

public class CalculatorUtilModuloTest {
	private Calculator calculator;
	private CalculatorUtil calcUtil;

	@Before
	public void init() {
		calculator = Mockito.mock(Calculator.class);
		calcUtil = new CalculatorUtil(calculator);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testModuloByZero() {
		//given
		doThrow(new IllegalArgumentException()).when(calculator).modulo(anyInt(), eq(0));
		
		//when
		calcUtil.getModuloText(5, 0);
		
		//then
		//empty
	}

	@Test
	public void testModulo16By4() {
		//given
		doReturn(0).when(calculator).modulo(16, 4);
		
		//when
		String result = calcUtil.getModuloText(16, 4);
		
		//then
		assertEquals("16 % 4 = 0", result);
		verify(calculator).modulo(16, 4);
	}
}
