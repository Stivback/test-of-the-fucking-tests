package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.DriverSetup;

public class HomePage extends DriverSetup {
		
	
	 private static WebElement element = null;
	    
	    public static void putSearch(String itemName) {
	        element = driver.findElement(By.id("twotabsearchtextbox"));
	        element.sendKeys(itemName);
	    }

	    public static WebElement getSearchButton() {
	        element = driver.findElement(By.xpath("//input[@class='nav-input' and @value='Go']"));
	        return element;
	    }
	
	
	
	
	}
