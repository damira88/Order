package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"/Users/damira88/Documents/selenium dependencies/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(" http://secure.smartbearsoftware.com/samples/" + "TestComplete12/WebOrders/Login.aspx \n");
		String username = "Tester";
		String password = "test";
		String expected = "Web Orders Login";
		String actual = driver.getTitle();
		if (expected.equals(actual)) {
			System.out.println("Successfully landed on the main page:  " + actual);
		} else {
			System.out.println("failed landing on the main page");

		}
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys(username);
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		driver.findElement(By.linkText("Order")).click();
		int range = 100;
		Random rd = new Random();
		String quantity = rd.nextInt(100) + "";
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(quantity);

		CustomerName s1 = new CustomerName();
		String fullname = s1.randomString();
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(fullname);
		String st = "123 Any st";
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys(st);
		;
		String city = "AnyTown";
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys(city);
		String state = "Virginia";
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys(state);
		
		
driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(""+rd.nextInt(9)+rd.nextInt(9)+rd.nextInt(9)+rd.nextInt(9)+rd.nextInt(9));
		
		String se1="//*[@id=\"ctl00_MainContent_fmwOrder_cardList_1\"]";
		String s2="//*[@id=\"ctl00_MainContent_fmwOrder_cardList_2\"]";
		String s3="//*[@id=\"ctl00_MainContent_fmwOrder_cardList_0\"]";
		int a =rd.nextInt(3);
		
		if(a==1)
		driver.findElement(By.xpath(s3)).click();
		else if(a==2)
			driver.findElement(By.xpath(se1)).click();
		else
			driver.findElement(By.xpath(s2)).click();
		
		StringBuilder cardnumber = new StringBuilder();
		for(int i=0; i<15; i++) {
			cardnumber.append(""+(rd.nextInt(10)-1));
		}
		StringBuilder cardnumber2 = new StringBuilder();
		for(int i=0; i<14; i++) {
			cardnumber2.append(""+(rd.nextInt(10)-1));
		}
		if(a==1 ) {
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(""+4+cardnumber);
		}else if(a==2) {
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(""+5+cardnumber);
		}else {
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(""+3+cardnumber2);
		}
		int date=rd.nextInt(12);
		StringBuilder datee =new StringBuilder();
		if(date<10) {
			
			datee.append("0").append(date);
		}else {
			datee.append(date);
		}
		int year= rd.nextInt(99);
		while(year<19) {
			year=rd.nextInt(99);
		}
//		StringBuilder yearr = new StringBuilder();
//		yearr.append(year);
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys(datee+"/"+year);
//		driver.close();
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]")).click();


		// driver.close();
	}
}
