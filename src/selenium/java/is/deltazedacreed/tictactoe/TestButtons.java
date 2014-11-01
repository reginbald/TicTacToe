/*
 * Copyright (c) 2014 Delta Zeda Creed.
 */
package is.deltazedacreed.tictactoe;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * Class for testing if buttons are displayed.
 */
public class TestButtons {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.is/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testButtons() throws Exception {
    assertEquals(" ", driver.findElement(By.id("0 0")).getText());
    assertEquals(" ", driver.findElement(By.id("0 1")).getText());
    assertEquals(" ", driver.findElement(By.id("0 2")).getText());
    assertEquals(" ", driver.findElement(By.id("1 0")).getText());
    assertEquals(" ", driver.findElement(By.id("1 1")).getText());
    assertEquals(" ", driver.findElement(By.id("1 2")).getText());
    assertEquals(" ", driver.findElement(By.id("2 0")).getText());
    assertEquals(" ", driver.findElement(By.id("2 1")).getText());
    assertEquals(" ", driver.findElement(By.id("2 2")).getText());
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

