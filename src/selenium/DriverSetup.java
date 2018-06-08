package selenium;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetup {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);

		String driverPath = "";
		String url = "http://amazon.com";

		if (System.getProperty("os.name").toUpperCase().contains("MAC"))
			driverPath = "./resources/webdrivers/mac/chromedriver";
		else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
			driverPath = "./resources/webdrivers/pc/chromedriver.exe";
		else
			throw new IllegalArgumentException("Unknown OS");

		System.setProperty("webdriver.chrome.driver", driverPath);
//		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions option = new ChromeOptions();
//		option.addArguments("disable-infobars");
//		option.addArguments("--disable-notifications");

		if (System.getProperty("os.name").toUpperCase().contains("MAC"))
			option.addArguments("-start-fullscreen");
		else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
			option.addArguments("--start-maximized");
		else
			throw new IllegalArgumentException("Unknown OS");

		
	}
}

/* 
public class DriverSetup {

static protected WebDriver driver;

public static void waitUntilElementDisplayed(final WebElement e, int sec, WebDriver driver) {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    WebDriverWait wait = new WebDriverWait(driver, sec);
    ExpectedCondition elementIsDisplayed = new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver arg0) {
            try {
                e.isDisplayed();
                return true;
            }
            catch (Exception e ) {
                return false;
            }
        }
    };
    wait.until(elementIsDisplayed);
    System.out.println(e.isDisplayed());
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

static String pathToDriver = Paths.get(System.getProperty("user.dir")).toAbsolutePath().toString() +
		File.separator + "src"+ File.separator + "test" + File.separator + "java"+ File.separator + "driversSetUp" + File.separator;
public enum Browser {
    Chrome,
    IE,
    Firefox
}

public static WebDriver setupDriver(Browser browser, String driverFileName) {
	WebDriver driver = null;
	String osName = (System.getProperty("os.name").toLowerCase().contains("mac") ? "mac" : "windows");
	if(browser == Browser.Chrome) {
		if (osName.equals("windows")) {
			System.setProperty("webdriver.chrome.driver", pathToDriver + driverFileName);
		} else {
			System.setProperty("webdriver.chrome.driver", pathToDriver + driverFileName);
		}
		driver = new ChromeDriver();
	}
	
	else if(browser == Browser.Firefox) {
		//Add config
	}
	
	else if(browser == Browser.IE) {
		//Add config
	}
	
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	return driver;
}*/