package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.util.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1.By locators
	private By logoutLink = By.linkText("Logout");
	private By searchField = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	private By accPageHeaders = By.cssSelector("div#content h2");

	// 2.Constructor
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3.Page Actions:
	public String getAccountsPageTitle() {
		String title = eleUtil.waitForTitleToBe(AppConstants.ACCOUNTS_PAGE_TITLE, AppConstants.SMALL_DEFAULT_TIME_OUT);
		System.out.println("Acc page title is: " + title);
		return title;
	}

	public String getLoginPageUrl() {
		String url = eleUtil.waitForUrl(AppConstants.SMALL_DEFAULT_TIME_OUT, AppConstants.LOGIN_PAGE_URL_FRACTION);
		System.out.println("Acc page URL is: " + url);
		return url;
	}

	public boolean isLogoutLinkExist() {
		return eleUtil.waitForElementVisible(logoutLink, AppConstants.SMALL_DEFAULT_TIME_OUT).isDisplayed();
	}

	public boolean isSearchFieldExist() {
		return eleUtil.waitForElementVisible(searchField, AppConstants.MEDIUM_DEFAULT_TIME_OUT).isDisplayed();
	}

	public List<String> getAccountHeaderList() {
		return eleUtil.getAllElementsTextList(accPageHeaders, AppConstants.SMALL_DEFAULT_TIME_OUT);
	}

	// Common page actions
	public SearchResultsPage doSearch(String productName) {
		System.out.println("Searching for :" + productName);
		eleUtil.doSendKeysWithWait(searchField, AppConstants.MEDIUM_DEFAULT_TIME_OUT, productName);
		eleUtil.doClick(searchIcon);
		return new SearchResultsPage(driver); // This is TDD, Test Driven Development approach. We have to start write
												// our test cases, then we have to keep refactoring the code on the
												// basis of test
	}

}
