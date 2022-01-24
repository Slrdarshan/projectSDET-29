package module_name_purchaseOrder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class tectCase_025 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileInputStream fis=new FileInputStream("./data/testcase.property");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		String adr = p.getProperty("address");
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		WebElement more = driver.findElement(By.xpath("//a[text()='More']"));
		  Actions a=new Actions(driver);
		a.moveToElement(more).perform();
		driver.findElement(By.xpath("//a[text()='Purchase Order']")).click();
		driver.findElement(By.xpath("//img[@title='Create Purchase Order...']")).click();
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		WebElement option = driver.findElement(By.xpath("(//select[@class='small'])[5]"));
		Select s=new Select(option);
		s.selectByIndex(2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(adr);
		Thread.sleep(3000);
		
		   Actions b=new Actions(driver);
	       WebElement logout = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
	        b.moveToElement(logout).perform();
	        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
