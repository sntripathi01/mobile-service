package com.redox.mobile.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppServiceTest   {

	@Test
	public void test() {
		AppService appService = new AppService();
		appService.sendLinkAndOtp("11", "8802368071", "sntripathi01@gmail.com");
	}

}
