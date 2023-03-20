package org.inputhandle;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputBox {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		ChromeDriver d = new ChromeDriver();
		
		d.get("https://letcode.in/edit");
		
		d.manage().window().maximize();
		
		d.findElementById("fullName").sendKeys("John");
		
		d.findElementByXPath("(//input[@type=\"text\"])[2]").sendKeys(" human", Keys.TAB);
		
		String val = d.findElementById("getMe").getAttribute("value");
		
		System.out.println("Inside Value is :" + val);
		
		d.findElementById("clearMe").clear();
		
		boolean check = d.findElementById("noEdit").isEnabled();
		
		System.out.println("Able to edit? : " + check);
		
		String chk1 = d.findElementById("dontwrite").getAttribute("readonly");
		
		System.out.println(chk1);
		
		d.quit();
		
	}

}
