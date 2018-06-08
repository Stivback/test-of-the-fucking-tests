package tests.amazonTest;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultsPage;
import selenium.DriverSetup;


public class AmazonTest extends DriverSetup{

	@BeforeClass(alwaysRun = true)
	public void setupClass()
	{
	
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setupTest()
	{

	}

	@Parameters()
	@Test(description = "Test Description")
	public void groupSetup(ChromeDriver driver) throws Exception{
		
		driver.get("https://www.amazon.com");
		HomePage.putSearch("ipad air 2 case");
		HomePage.getSearchButton().click();
		SearchResultsPage.refinePlasticCase().click();

		SearchResultsPage.refinePutPrize(20, 100);

		// get 5 items from seasrch
		int limit = 5;

		List<SearchItem> resultList = SearchResultsPage.getResultList(limit);

		// #5
		System.out.println();
		for(int i=0;i<resultList.size();i++) {
			System.out.println(resultList.get(i).name + "|" + resultList.get(i).price + "|" + resultList.get(i).score);
		}

		// #6
		for(int i=0;i<limit;i++){
			Assert.assertTrue(resultList.get(i).price >= 20 && resultList.get(i).price <= 100);
		}

		// #6
		SearchItem.sortByPrice(resultList);

		// #7
		SearchItem.sortByScore(resultList);

		// #7
		SearchItem.sortByPrice(resultList);
		for(int i = 0; i < limit - 1; i++) {
			Assert.assertTrue(resultList.get(i).price <= resultList.get(i).price);
		}

		// #8
		System.out.println("\nRecommended by Price:");
		System.out.println(resultList.get(0).name + "|" + resultList.get(0).price + "|" + resultList.get(0).score);
		SearchItem.sortByScore(resultList);
		System.out.println("\nRecommended by Score:");
		System.out.println(resultList.get(5-1).name + "|" + resultList.get(limit - 1).price + "|" + resultList.get(limit - 1).score);
	}
		
		
		
		
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDownTest()
	{

	}
	
	@AfterClass(alwaysRun = true)
	public void tearDownClass()
	{

	}
}
