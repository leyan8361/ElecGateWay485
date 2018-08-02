package com.heshun.modbus;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	public int bytes2UnsignedShort(byte high, byte low, boolean reverse) {
		int result = 0;
		int _f = ((high << 8) | low & 0xff) & 0x0FFFF;
		boolean flag = (_f >> 15) != 0 ? true : false;
		int absValue = _f << 17 >> 17;

		if (absValue != 0) {
			result = flag ? Math.negateExact(absValue) : absValue;
		}
		return result;
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		byte[] x = { (byte) 0x80, 00 };
		System.out.println(bytes2UnsignedShort(x[0], x[1], true));
	}
}
