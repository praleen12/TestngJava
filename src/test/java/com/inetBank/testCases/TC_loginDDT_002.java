package com.inetBank.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBank.pageObjects.LoginPage;
import com.inetBank.utilities.XLUtils;

import junit.framework.Assert;

public class TC_loginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws Exception {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(user);
		loginPage.setPassword(pwd);
		loginPage.clickSubmit();
		Thread.sleep(5000);
		if(isAlert()) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(true);
			loginPage.clickLogOut();
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();

		}

	}

	public boolean isAlert() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	@DataProvider(name = "LoginData")
	public String[][] getEmpData() throws IOException {
		
		
		//Read data from Excel
		String path = System.getProperty("user.dir")+ "/src/test/java/com/intBank/testData/loginData.xlsx";
		
		int rowsnum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String empdata[][]=new String[rowsnum][colcount];
		for(int i= 1; i<=rowsnum; i++) {
			for(int j=0; j<colcount; j++) {
				empdata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		
		
		return (empdata);
	}

}
