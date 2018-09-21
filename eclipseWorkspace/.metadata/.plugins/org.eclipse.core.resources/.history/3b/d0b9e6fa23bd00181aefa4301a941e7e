package pkg;

import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelect {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:6666/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMultipleSelect() throws Exception {
    driver.get(baseUrl + "/SampleWebSites/Login.html");
    driver.findElement(By.id("lname")).clear();
    Thread.sleep(3000);
    driver.findElement(By.id("lname")).sendKeys("Mahesh");
    driver.findElement(By.id("lpassword")).clear();
    
    Thread.sleep(3000);
    
    driver.findElement(By.id("lpassword")).sendKeys("syntel123$");
    driver.findElement(By.id("btn")).click();
    
    Thread.sleep(3000);
    driver.findElement(By.linkText("Please Register.....")).click();
    driver.findElement(By.id("eid")).clear();
    driver.findElement(By.id("eid")).sendKeys("Test001");
    driver.findElement(By.id("ename")).clear();
    driver.findElement(By.id("ename")).sendKeys("TestName");
    Thread.sleep(3000);
    WebElement element=driver.findElement(By.id("ecty"));
    
    Select se=new Select(element);
    se.selectByVisibleText("Pune");
    se.selectByVisibleText("Delhi");
    Thread.sleep(3000);
    List<WebElement> allSelectedOptions = se.getAllSelectedOptions();
    for (WebElement webElement : allSelectedOptions)
    {
    System.out.println("You have selected ::"+ webElement.getText());
    }
    
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=ecty | label=Pune]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=ecty | label=Delhi]]
    driver.findElement(By.id("submit")).click();
    

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
