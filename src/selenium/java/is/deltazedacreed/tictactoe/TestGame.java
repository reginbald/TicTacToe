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
 * Class for testing a simple game of tic tac toe.
 */

public class TestGame {
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
  public void testGame() throws Exception {
    driver.get("http://tictactoe420.herokuapp.com/");
    driver.findElement(By.id("0 0")).click();
    for (int second = 0;; second++) {
        if (second >= 60){ 
            fail("timeout"); 
        }
        try { 
            if ("It's player 2's turn".equals(driver.findElement(By.id("results")).getText())){ 
                break; 
            } 
        } catch (Exception e) {}
        Thread.sleep(1000);
    }

    assertEquals("It's player 2's turn", driver.findElement(By.id("results")).getText());
    driver.findElement(By.id("0 1")).click();
    for (int second = 0;; second++) {
        if (second >= 60){ 
            fail("timeout");
        }
        try { 
            if ("It's player 1's turn".equals(driver.findElement(By.id("results")).getText())){ 
                break; 
            } 
        } catch (Exception e) {}
        Thread.sleep(1000);
    }

    assertEquals("It's player 1's turn", driver.findElement(By.id("results")).getText());
    driver.findElement(By.id("1 1")).click();
    for (int second = 0;; second++) {
        if (second >= 60){ 
            fail("timeout");  
        }
        try { 
            if ("It's player 2's turn".equals(driver.findElement(By.id("results")).getText())){ 
                break; 
            } 
        } catch (Exception e) {}
        Thread.sleep(1000);
    }

    assertEquals("It's player 2's turn", driver.findElement(By.id("results")).getText());
    driver.findElement(By.id("1 2")).click();
    for (int second = 0;; second++) {
        if (second >= 60){ 
            fail("timeout"); 
        }
        try { 
            if ("It's player 1's turn".equals(driver.findElement(By.id("results")).getText())){ 
                break; 
            } 
        } catch (Exception e) {}
        Thread.sleep(1000);
    }

    assertEquals("It's player 1's turn", driver.findElement(By.id("results")).getText());
    driver.findElement(By.id("2 2")).click();
    for (int second = 0;; second++) {
        if (second >= 60){ 
            fail("timeout");
        }
        try { 
            if ("Player 1 wins!".equals(driver.findElement(By.id("results")).getText())){
                 break; 
            } 
        } catch (Exception e) {}
        Thread.sleep(1000);
    }

    assertEquals("Player 1 wins!", driver.findElement(By.id("results")).getText());
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

