package com.spicejet.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage {

	public WebDriver driver;
	
	public BookingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	  @FindBy(xpath="//input[contains(@name,'SeniorCitizenDiscount')]")
	  WebElement checkbox;

	//By checkbox = By.xpath("//input[contains(@name,'SeniorCitizenDiscount')]");
	By fromfield = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	By from = By.xpath("//a[@value='BLR']");
	By to = By.xpath("(//a[@value='IXJ'])[2]");
	By countofdays = By.xpath("*//table[@class='ui-datepicker-calendar'] //td[@data-handler='selectDay']");
	By selectday = By.xpath("//td[@data-handler='selectDay']");
	By selecteddate = By.xpath("//td[@data-handler='selectDay']");
	By currency = By.id("ctl00_mainContent_DropDownListCurrency");
	By go = By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']");



	public WebElement clickCheckbox() {

		return checkbox;

	}

	public WebElement clickFromField() {

		return driver.findElement(fromfield);

	}

	public WebElement selectFromCity() {

		return driver.findElement(from);

	}

	public WebElement selectDestiCity() {

		return driver.findElement(to);

	}

	public int getDaysCount() {

		return driver.findElements(countofdays).size();

	}

	public List<WebElement> getDates() {

		return driver.findElements(selectday);

	}

	public List<WebElement> selectDate() {

		return driver.findElements(selecteddate);

	}

	public WebElement selectCurrency() {

		return driver.findElement(currency);

	}
	

	public WebElement submit() {

		return driver.findElement(go);

	}
}
