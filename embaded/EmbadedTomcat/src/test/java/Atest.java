
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Atest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		//"D:\\programy\\FirefoxPortable\\App\\Firefox\\firefox.exe"
		//this.getClass().getResource("/FirefoxPortable/App/Firefox/firefox.exe").toURI()
		FirefoxBinary binary = new FirefoxBinary(new File("D:\\programy\\FirefoxPortable\\App\\Firefox\\firefox.exe"));
		FirefoxProfile profile = new FirefoxProfile();
		driver = new FirefoxDriver(binary, profile);
		baseUrl = "http://newkalkulator.appspot.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testUntitled2() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//div[@id='buttons']/label[3]/span"))
				.click();
		driver.findElement(By.id("bcalculate")).click();
		driver.findElement(By.id("submit")).click();
		// Thread.sleep(2000);
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("wynik_cena"))&&!driver.findElement(By.id("wynik_cena")).getText().isEmpty())
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		assertEquals("2756", driver.findElement(By.id("wynik_cena")).getText());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
