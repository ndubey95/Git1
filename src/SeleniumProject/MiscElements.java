package SeleniumProject;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MiscElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//radio button
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Practice")).click();
		driver.findElement(By.id("name")).sendKeys("Nilesh Dubey");
		driver.findElement(By.id("email")).sendKeys("neel210895@gmail.com");
		driver.findElement(By.className("btn-style-one")).click();
		driver.findElement(By.xpath("//a[text()='Automation Practise - 2']")).click();
		List<WebElement> radiobuttons=driver.findElements(By.cssSelector("input[name=radioButton]"));
		for(int i=0;i<radiobuttons.size();i++)
		{
			radiobuttons.get(i).click();
		}
		
		//autocomplete
		
		driver.findElement(By.cssSelector("input[id='autocomplete']")).sendKeys("In");
		driver.findElement(By.xpath("//div[text()=\"British Indian Ocean Territory\"]")).click();
		
		//dropdown
		
		Select s=new Select(driver.findElement(By.xpath("//select[@name='dropdown-class-example']")));
		s.selectByVisibleText("Option2");
		
		//checkboxes
		
		List<WebElement> checkboxes=driver.findElements(By.cssSelector("input[type='checkbox']"));
		for (int j=0;j<checkboxes.size();j++)
		{
			checkboxes.get(j).click();
		}
		
		//switch window
		
	/*	driver.findElement(By.id("openwindow")).click();
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> it=windowhandles.iterator();
		WebDriverWait wdw=new WebDriverWait(driver, Duration.ofSeconds(8));
		while(it.hasNext())
		{
			String ParentID2="";
			//String parentid=it.next();
			String Windows=driver.switchTo().window(it.next()).getTitle();
			String ParentID=driver.getWindowHandle();
			System.out.println(Windows);
			
			if(Windows.contains("QAClick"))
			{
				String ID=driver.getWindowHandle();
				driver.switchTo().window(ID);
				wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p/following-sibling::span")));
				String email=driver.findElement(By.xpath("//p/following-sibling::span")).getText();
				System.out.println(email);
				driver.close();
			}
			else
			{
				ParentID2=ParentID;
			}
			driver.switchTo().window(ParentID2);
		}    */
		
		//window alerts
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).sendKeys("Nilesh");
		driver.findElement(By.xpath("//input[@value='Alert']")).click();
		driver.switchTo().alert().accept();
		
		//table[@name='courses']/tbody/tr/following-sibling::tr/td[2]
		////table[@name='courses']/tbody/tr[2]/td[3]
		List<WebElement> courselists=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/following-sibling::tr/td[2]"));
		List<WebElement> prices=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/following-sibling::tr/td[3]"));
		List<WebElement> intructornames=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/following-sibling::tr/td[1]"));
 		for(int i=0;i<courselists.size();i++)
		{
			String courselist=courselists.get(i).getText();
			if(courselist.contains("WebSecurity"))
			{
				String price=prices.get(i).getText();
				String intructorname=intructornames.get(i).getText();
				System.out.println("Coursename: "+courselist);
				System.out.println("Price: "+price);
				System.out.println("Instructor name: "+intructorname);
				break;
			}
		}
		
		//Mouse hover
 		
 		Actions a=new Actions(driver);
 		a.moveToElement(driver.findElement(By.id("mousehover"))).build().perform();
 		driver.findElement(By.xpath("//div/a[text()='Reload']")).click();
 		
       //iFrame
 		JavascriptExecutor js =(JavascriptExecutor)driver;
 		js.executeScript("window.scrollBy(0,2000)");
 		driver.switchTo().frame("courses-iframe");
 		driver.findElement(By.xpath("//a[@href='learning-path']")).click();
 		js.executeScript("window.scrollBy(0,1000)");
 		driver.findElement(By.xpath("//a[contains(@href, 'https://courses.rahulshettyacademy.com/p/java-sdet')]")).click();
 		Set handles=driver.getWindowHandles();
 		System.out.println(handles.size());
 		Iterator<String> it=handles.iterator();
 		String parentid="";
 		while(it.hasNext())
 		{
 			
 			String tabtitle=driver.switchTo().window(it.next()).getTitle();
 			String tabtitleparent=driver.getWindowHandle();
 			if(tabtitle.contains("Java"))
 			{
 				String childID=driver.getWindowHandle();
 				driver.switchTo().window(childID);
 				WebDriverWait wdw=new WebDriverWait(driver, Duration.ofSeconds(10));
 				wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='course-subtitle']")));
 				System.out.println(driver.findElement(By.xpath("//h2[@class='course-subtitle']")).getText());
 				
 			}
 			else
 			{
 				parentid=tabtitleparent;
 			}
 			
 		}
 		driver.switchTo().window(parentid);
	}

}
