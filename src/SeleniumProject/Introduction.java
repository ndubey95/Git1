package SeleniumProject;

	import java.time.Duration;
	import java.util.Arrays;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class Introduction {

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("https://rahulshettyacademy.com/");
			driver.manage().window().maximize();
			driver.findElement(By.linkText("Practice")).click();
			driver.findElement(By.id("name")).sendKeys("Nilesh Dubey");
			driver.findElement(By.id("email")).sendKeys("neel210895@gmail.com");
			driver.findElement(By.className("btn-style-one")).click();
			Actions a=new Actions(driver);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,500)");
			a.moveToElement(driver.findElement(By.linkText("Automation Practise - 1"))).keyDown(Keys.CONTROL).click().build().perform();
		    Set<String> handles=driver.getWindowHandles();
		    Iterator<String> it=handles.iterator();
		// method"1"
	        it.next();
		    String childid=it.next();
		    driver.switchTo().window(childid);
		 /* method"2"
		    while(it.hasNext())
		    {
		 String abc=driver.switchTo().window(it.next()).getTitle();
		    if(abc.equalsIgnoreCase("greenkart"))
		    		{
		    	        driver.switchTo().window(abc);
		    	        break;
		    		}
		    }*/
		 /* method"3"
		   String[] abc=handles.toArray(new String[handles.size()]);
		   driver.switchTo().window(abc[1]);*/
			// //div[@class='products']/div[1]/h4
		    //"Carrot", "Beans", "Capsicum", "Potato"
		    String finalveggie="";
		    String[] requiredveggies= {"Brocolli"};
		    List veggieslist=Arrays.asList(requiredveggies);
		   WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(5));
		    //w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product']")));
		    List<WebElement> veggies = driver.findElements(By.xpath("//div[@class='product']"));
		    //String veggie=driver.findElement(By.xpath("//div[@class='products']/div[1]/h4")).getText();
		    //System.out.println(veggie);
		    int i=1, j=0;
		    while(i<=veggies.size())
		    {
		    	String veggie = driver.findElement(By.xpath("//div[@class='products']/div["+i+"]/h4")).getText();
		    	String[] vegg=veggie.split("-");
		    	String actualveggie=vegg[0];
		    	finalveggie=actualveggie.trim();
		    	//System.out.println(finalveggie);
		        if(veggieslist.contains(finalveggie))
		        		{
		    	driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(j).click();
		    	w.until(ExpectedConditions.invisibilityOfElementLocated(By.className("added")));
		        		}
		        
		    	i++;
		    	j++;
		    }
		    
		    driver.findElement(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']")).sendKeys("Beans");
		    ////td[text()='Price']/following-sibling::td[2]/strong
		    String totalcount=driver.findElement(By.xpath("//td[text()='Items']/following-sibling::td[2]/strong")).getText();
		    String totalprice=driver.findElement(By.xpath("//td[text()='Price']/following-sibling::td[2]/strong")).getText();
		    System.out.println("Total count of items are: "+totalcount+" which sums up to "+totalprice);
		    driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		    driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		    //w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
		    a.click(driver.findElement(By.xpath("//input[@type='text']"))).sendKeys("rahulshettyacademy");
		    //driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		    driver.findElement(By.className("promoBtn")).click();
		    
		    ////input[@placeholder='Enter promo code']
		    System.out.println(driver.findElement(By.xpath("//div[contains(@style, 'text-align')]")).getText());
		    driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		    //w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Choose Country']")));
		    Select s=new Select(driver.findElement(By.xpath("//select[@style='width: 200px;']")));
		    s.selectByValue("India");
		    driver.findElement(By.cssSelector(".chkAgree")).click();
		    driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		    System.out.println(driver.findElement(By.xpath("//span[contains(@style, 'color:green')]")).getText());
		
		}

	}



