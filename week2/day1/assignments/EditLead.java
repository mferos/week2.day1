package week2.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver cd = new ChromeDriver();
		cd.get("http://leaftaps.com/opentaps/control/login");
		cd.manage().window().maximize();
		
		cd.findElement(By.id("username")).sendKeys("DemoCSR");
		cd.findElement(By.id("password")).sendKeys("crmsfa");
		cd.findElement(By.className("decorativeSubmit")).click();
		cd.findElement(By.linkText("CRM/SFA")).click();
		cd.findElement(By.linkText("Leads"));
		cd.findElement(By.linkText("Create Lead")).click();
		cd.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		cd.findElement(By.id("createLeadForm_firstName")).sendKeys("Mohamed");
		cd.findElement(By.id("createLeadForm_lastName")).sendKeys("Feros");
		cd.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Feros");
		cd.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT");
		cd.findElement(By.id("createLeadForm_description")).sendKeys("Selenium Assignment");
		cd.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("feroseh19@gmail.com");
		
		WebElement w = cd.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select s = new Select(w);
		s.selectByVisibleText("New York");
		
		cd.findElement(By.name("submitButton")).click();
		
		Thread.sleep(2000);
		
		cd.findElement(By.linkText("Edit")).click();
		cd.findElement(By.id("updateLeadForm_description")).clear();
		cd.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Note updated");
		
		cd.findElement(By.name("submitButton")).click();
		
		System.out.println("Title - " + cd.getTitle());
	}
}
