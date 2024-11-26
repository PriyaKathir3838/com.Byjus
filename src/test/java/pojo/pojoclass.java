package pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.baseclass;

public class pojoclass extends baseclass {
	public pojoclass() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class = 'dropdown-toggle' and text() = 'Study Materials']")
	private WebElement study;
	
	@FindBy(xpath = "//a[text() = 'NEET']")
	private WebElement neet;
	
	@FindBy(xpath = "//a[text() = 'NEET']") 
	private WebElement link;
	

	@FindBy(xpath = "//a[text() = 'JEE']")
	private WebElement jee;
	
	@FindBy(xpath = "//a[text() = 'JEE']")
	private WebElement link1;
	
	@FindBy(xpath = "//a[text() = 'Commerce']")
	private WebElement com;
	
	@FindBy(xpath = "//a[text() = 'Commerce']")
	private WebElement link2;
	
	public WebElement getStudy() {
		return study;
	}

	public WebElement getNeet() {
		return neet;
	}

	public WebElement getLink() {
		return link;
	}

	public WebElement getJee() {
		return jee;
	}

	public WebElement getLink1() {
		return link1;
	}

	public WebElement getCom() {
		return com;
	}

	public WebElement getLink2() {
		return link2;
	}
}
