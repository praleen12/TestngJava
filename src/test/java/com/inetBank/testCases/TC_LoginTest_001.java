package com.inetBank.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetBank.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {

		driver.get(baseUrl);

		logger.info("URL is opened");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(username);

		logger.info("Entered Username");

		loginPage.setPassword(password);
		logger.info("Entered password");

		loginPage.clickSubmit();
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage21234")) {
			Assert.assertTrue(true);
			logger.info("login test passed");
		} else
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);

//		Assert.assertEquals("Guru99 Bank Manager HomePage21234", driver.getTitle());

	}
}
