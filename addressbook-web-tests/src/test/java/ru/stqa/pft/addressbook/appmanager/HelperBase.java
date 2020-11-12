package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelperBase {
  public WebDriver wd;

  public HelperBase(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void type(String locator, String text) {
    click(By.name(locator));
    wd.findElement(By.name(locator)).clear();
    wd.findElement(By.name(locator)).sendKeys(text);
  }

  public int count(String elementName) {
    return wd.findElements(By.name(elementName)).size();
  }
  public boolean isAlertPresent(){
    try{
      wd.switchTo().alert();
      return true;
    } catch(NoAlertPresentException e) {
      return false;
    }
  }
}
