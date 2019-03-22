package com.spiceJet.test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.spicejet.pages.BookingPage;

import resources.Base;



public class HomepageTest extends Base {
	private static Logger log = LogManager.getLogger(Base.class.getName());
	

	@BeforeTest
	public void initialize() throws IOException, SQLException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("driver initialized successfully");
	}

	@Test(dataProvider="getdata")
	public void invokeHome(String date,String currency) throws IOException {

		
		BookingPage l = new BookingPage(driver);
		
		// Selecting the checkbox
		log.debug("Selecting the senior citizen");
		l.clickCheckbox().click();
		log.info("Checked on the checbox successfully");

		// Clicking on the from field
		log.debug("Clicking on the check field");
		l.clickFromField().click();
		log.info("Successfully clicked on the from field");

		// Selecting the 'from city'
		log.debug("Selecting the 'from city'");
		l.selectFromCity().click();
		log.info("Successfully selected the city");

		// Selecting the 'destination city'
		log.debug("Selecting the 'from city'");
		l.selectDestiCity().click();
		log.info("Successfully selected the destination city");

		// get the count of days for the present month
		int count = l.getDaysCount();
		log.info(l.getDaysCount());

		// iterating through all the days
		for (int i = 0; i < count; i++) {

			String dates = l.getDates().get(i).getText();
			// System.out.println(dates);
			//String datevalue = prop.getProperty("bookingdate");
			String datevalue = date;
			if (dates.equalsIgnoreCase(datevalue)) {
				l.selectDate().get(i).click();
				log.info("Successfully clicked on the desired day");
				break;
			}
			log.error("Could not find the desired date");
		}
		// using select for the dropdowns
		Select s = new Select(l.selectCurrency());
		log.debug("selecting the currency type");
		//s.selectByValue(prop.getProperty("currencytype"));
		s.selectByValue(currency);
		log.info("Successfully selected currency type");

		l.submit().click();
		log.info("Successfully clicked on the go button");
		
		
	}

	@DataProvider
	public Object[][] getdata() {
		
		//rows : number of tests to run
		//column : number of parameters to be passed for each test
		
		Object[][] data = new Object[1][2];
		
		data[0][0]="19";
		data[0][1]="AED";
		
		
		return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
		log.info("Successfully closed the browser");

	}
}
