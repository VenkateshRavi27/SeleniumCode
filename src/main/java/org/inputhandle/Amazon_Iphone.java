package org.inputhandle;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_Iphone {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\venka\\eclipse-workspace\\WindowsHandling\\driver\\chromedriver.exe");
		
		WebDriver d = new ChromeDriver();
		
		d.get("https://www.flipkart.com/");
		
		//d.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) d;
		
		WebElement xbutton = d.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		
		xbutton.click();
		
		WebElement search_field = d.findElement(By.name("q"));
		
		search_field.sendKeys("iPhone X");
		
		WebElement clk = d.findElement(By.xpath("//button[@type='submit']"));
		
		clk.click();
		
		Thread.sleep(2000);
		
		WebElement pClick = d.findElement(By.xpath("//div[text()='APPLE iPhone 11 (White, 128 GB)']"));
		
		pClick.click();
		
		WebElement amt = d.findElement(By.xpath("(//div[text()='₹47,199'])[1]"));
		
		String display_text = amt.getText();
		
		System.out.println("iPhone Price is : " + display_text);
		
		Thread.sleep(4000);
		
		WebElement pincode = d.findElement(By.xpath("//input[@class='_36yFo0']"));
		
		js.executeScript("arguments[0].setAttribute('value', '612103')", pincode);
		
		WebElement check = d.findElement(By.xpath("//span[text()='Check']"));
		
		js.executeScript("arguments[0].click()", check);
		
		String pid = d.getWindowHandle();
		
		System.out.println("Main Page ID : " +pid);
		
		Set<String> cid = d.getWindowHandles();
		
		System.out.println("Result Page Id : " +cid);
		
		for (String st : cid) {
			
			if (st != pid) {
				
				d.switchTo().window(st);	
			}
		}
		
		WebElement buy = d.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']"));
		
		buy.click();
		
		Thread.sleep(3000);
		
		d.quit();
	}

}
