package org.inputhandle;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
		public void Screenshots(String url) {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.get(url);
		File Screenshot_src = d.getScreenshotAs(OutputType.FILE);
		File Screenshot_dest = new File("./snaps/img.png");
		try {
			FileHandler.copy(Screenshot_src, Screenshot_dest);
		} catch (IOException e) {
			System.err.println("Exception allowed");
			e.printStackTrace();
		}
		d.quit();
		
	}

	public void AlertCode(String url) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.get(url);
		d.findElementById("accept").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.err.println("Excepted allowed");
			e.printStackTrace();
		}
		d.switchTo().alert().accept();
		d.findElementById("confirm").click();
		Thread.sleep(1000);
		d.switchTo().alert().dismiss();
		Thread.sleep(1000);
		d.findElementById("prompt").click();
		Alert at = d.switchTo().alert();
		at.sendKeys("Alexa");
		at.accept();
		String text = d.findElementById("myName").getText();
		System.out.println(text);
		d.quit();
	}
	public static void main(String[] args) throws InterruptedException{
		
	
		/*
		 * Screenshot s = new Screenshot();
		 * 
		 * s.Screenshots("https://www.facebook.com/");
		 */
		
		Screenshot s = new Screenshot();
		
		s.AlertCode("https://letcode.in/alert");
		
		

	}

}
