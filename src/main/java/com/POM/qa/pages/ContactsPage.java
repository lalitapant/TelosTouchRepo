package com.POM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.POM.qa.base.TestBase;



public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[text()='Contacts']")
	WebElement contactsLabel;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']/input")
	WebElement company;
	
	@FindBy(xpath = "//button[contains(@class,'linkedin')]")
	WebElement saveBtn;
	
	@FindBy(xpath = "//i[@class='users icon']")
	WebElement contactsLink;
	
	
	
	
	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	
	public void selectContactsByName(String name){
		
		Actions act =  new Actions(driver);
		act.moveToElement(contactsLink).click().perform();
		act.moveToElement(driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//input[@name='id']"))).click().perform();
	}
	
	
	public void createNewContact(String ftName, String ltName, String comp){
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		
	}
}
