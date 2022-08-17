package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.util.ElementUtil;

public class SearchResultsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1.By locators
	By productCount = By.cssSelector("div.product-thumb");
	
	// 2.Constructor
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//3.Page Actions:
	public int getProductSearchCount() {
		return eleUtil.waitForElementsToBeVisible(productCount,AppConstants.MEDIUM_DEFAULT_TIME_OUT).size();
	}
	
	public ProductInfoPage selectProduct(String SearchProductName) {
		By product = By.linkText(SearchProductName);
		eleUtil.doClick(product);
		return new ProductInfoPage(driver);
		
	}
}
