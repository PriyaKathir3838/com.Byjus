package base;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {
	public static WebDriver driver;	
	public static Actions actions;
	public static JavascriptExecutor js;
	public static WebDriverWait wait;
	public static Alert al;
	
	
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	     actions = new Actions(driver);
		// al = driver.switchTo().alert();
		js = (JavascriptExecutor)driver;
		//WebDriverWait wait;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		}
	public void webApplicationLaunch(String url) {
		driver.get(url);
	}
	public void closeBrowser() {
		driver.quit();
		
	}
	public String currenturl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	public String webTitle() {
		String title = driver.getTitle();
		return title;
		
	}
	public String pageSource() {
		String pagesource = driver.getPageSource();
		return pagesource;
	}
	public void launch(String url) {
		driver.navigate().to(url);
	}
	public void pageForward() {
		driver.navigate().forward();
	}
	public void pageBack() {
		driver.navigate().back();
	}
	public void refresh() {
		driver.navigate().refresh();
		}
	public String windowHandle() {
		String window =driver.getWindowHandle();
		return window;
	}
	public void childWindow() {
		String window = driver.getWindowHandle();
		Set<String> mulwindows = driver.getWindowHandles();
		for(String x:mulwindows) {
			if(!x.equals(window)) {
				driver.switchTo().window(x);
				
			}
		}
		
		
	}
	public void switchWindow(String window) {
		driver.switchTo().window(window);
		
	}
	public void pageclose() {
		driver.close();
	}
	//WebElement

	public void sendText(WebElement element, String textinput) {
		element.sendKeys(textinput);
	}
	public void deleteText(WebElement element) {
	element.clear();
	}
	public void button(WebElement element) {
	element.click();
	}
	public void submitButton(WebElement element) {
	element.submit();
	}

	public String obtainText(WebElement element) {
	String gettext = element.getText();
	return gettext;
	}
	public String obtainAttribute(WebElement element, String attribute) {
	String attributeText = element.getAttribute(attribute);
	return attributeText;
	}

	public String tagname(WebElement element) {
	String tagname = element.getTagName();
	return tagname;
	}
	public boolean selected(WebElement element) {
	boolean selected = element.isSelected();
	return selected;
	}
	public boolean enable(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}
	public boolean displayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;

	}
	public String cssValue(WebElement element, String value) {
	String cssvalue = element.getCssValue(value);
	return cssvalue;
	}

	//Actions

	public void mouseOver(WebElement element) {
		actions.moveToElement(element).build().perform();

	}
	public void actionDouble(WebElement element) {
		actions.doubleClick(element).build().perform();

	}
	public void actionContext(WebElement element) {
		actions.contextClick(element).perform();

	}
	public void actionDragAndDrop(WebElement source, WebElement destination) {
		actions.dragAndDrop(source, destination).build().perform();
	}
	public void actionInputText(WebElement element, String textinput) {
	actions.sendKeys(element,textinput).build().perform();

	}
	public void actionButton(WebElement element) {
		actions.click(element).perform();

	}

	//TakeScreenshot
	public void screenshot(String screenshotlocation)  {
		
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(".//target//"+screenshotlocation+".png");
		try {
		FileUtils.copyFile(source, destination);}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	//Alerts
	public void alertAccept() {
		al.accept();
		
	}
	public void alertDismiss() {
		al.dismiss();
	}
	public String alertObtainText() {
		String text = al.getText();
		return text;
	}
	public void alertInputText(String alertinput) {
		al.sendKeys(alertinput);
	}
	//Dropdown

	public void indexSelect(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	public void valueSelect(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	public void visibleTextSelect(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	public boolean multipleOptions (WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		return multiple;
	}
	public WebElement firstOptions(WebElement element) {
		Select s= new Select(element);
		WebElement firstoption = s.getFirstSelectedOption();
		return firstoption;
	}
	public List<WebElement> options(WebElement element) {
		Select s = new Select(element);
		List<WebElement> option = s.getOptions();
		return option;
	}
	public List<WebElement> allOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> alloption = s.getAllSelectedOptions();
		return alloption;
	}
	public void indexDeselect(WebElement element, int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}
	public void valueDeselect(WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByValue(value);
	}
	public void visibleTextDeselect(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}
	public void optionsDeselect(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	//JavaScriptExecutor

	public void inputText(String attributename, String attributeval, WebElement element, int i) {
		js.executeScript("arguments[0].setAttribute('"+attributename+"','"+attributeval+"')",element );
	}
	public void button (WebElement element, int i) {
		js.executeScript("arguments[0].click())", element);
	}
	public Object obtainText(WebElement element, String attributeval) {
		Object text = js.executeScript("return arguments[0].getAttribute('"+attributeval+"')", element);
		return text;
	}
	public void scrollUp(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public void scrollDown(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	//Frames

	public void indexFrame(int index) {
		driver.switchTo().frame(index);
	}
	public void nameFrame(String name) {
		driver.switchTo().frame(name);
	}
	public void elementFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	public void nextFrame() {
		driver.switchTo().defaultContent();
	}
	public void mainFrame() {
		driver.switchTo().parentFrame();
	}

	//wait

	public void timeout(WebElement element) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void timeout() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.alertIsPresent());
	}
	public void timeoutOne(WebElement element) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(element));
	}


	

}
