package myTestpkg;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLogin() throws Exception {
    driver.get("http://localhost:8044/TestWebProject/Login.html");
    driver.findElement(By.id("un")).click();
    driver.findElement(By.id("un")).clear();
    driver.findElement(By.id("un")).sendKeys("mahesh");
    driver.findElement(By.id("up")).clear();
    driver.findElement(By.id("up")).sendKeys("syntel123$");
    driver.findElement(By.id("up")).sendKeys(Keys.ENTER);
    
    String title = driver.getTitle();
    assertEquals(title, "Registration Page");
    
    driver.findElement(By.id("eid")).click();
    driver.findElement(By.id("eid")).clear();
    driver.findElement(By.id("eid")).sendKeys("5203");
    driver.findElement(By.id("ename")).clear();
    driver.findElement(By.id("ename")).sendKeys("George");
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=ecity | label=N-York]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='City'])[1]/following::option[4]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Salary'])[1]/following::td[1]")).click();
    driver.findElement(By.id("esalary")).click();
    driver.findElement(By.id("esalary")).clear();
    driver.findElement(By.id("esalary")).sendKeys("41200");
    driver.findElement(By.id("submit")).click();
    //assertEquals(closeAlertAndGetItsText(), "Employee Has above 5000 salary");
    
    title = driver.getTitle();
    assertEquals(title, "Registration Success");
    driver.close();
  }

  @AfterClass(alwaysRun = true)
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
