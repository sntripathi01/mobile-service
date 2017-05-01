package com.redox.mobile.service;

import org.junit.Ignore;
import org.junit.Test;

public class FeeServiceTest {
	@Ignore
	@Test
	public void testFeeSlipService() {
		FeeService feeService = new FeeService();
		feeService.feeSlipService("00003765", "INS001", "11", null);
	}

}
