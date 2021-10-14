package com.upgrade.gui.pages;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class ContactPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@id=\'root\']/div/main/div/div[1]/div[2]/div[1]/div/div/div/div/div/label[1]/div[1]")
    private ExtendedWebElement individualCheck;
    
    @FindBy(xpath = "//*[@id=\'root\']/div/main/div/div[1]/div[2]/div[1]/div/div/div/div/div/label[2]/div[1]")
    private ExtendedWebElement jointCheck;
    
    @FindBy(name = "borrowerFirstName")
    private ExtendedWebElement borrowerFirstName;
    
    @FindBy(name = "borrowerLastName")
    private ExtendedWebElement borrowerLastName;
    
    @FindBy(name = "borrowerStreet")
    private ExtendedWebElement borrowerStreet;
    
    @FindBy(name = "borrowerCity")
    private ExtendedWebElement borrowerCity;
    
    @FindBy(name = "borrowerState")
    private ExtendedWebElement borrowerState;
    
    @FindBy(name = "borrowerZipCode")
    private ExtendedWebElement borrowerZipCode;
    
    @FindBy(name = "borrowerDateOfBirth")
    private ExtendedWebElement borrowerDateOfBirth;
   
    @FindBy(xpath="//*[@id=\'root\']/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[2]/button")
    private ExtendedWebElement continueButton;
    		
    public ContactPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public void selectApplicationType(String apptype) {
    	
    	assertElementPresent(individualCheck);
    	assertElementPresent(jointCheck);
    	
    	if(apptype.equalsIgnoreCase("Joint"))
    		jointCheck.check();
    	else 
    		individualCheck.check();
    }
    

   public void enterContactFN(String firstName) {
        assertElementPresent(borrowerFirstName);
        borrowerFirstName.getElement().sendKeys(firstName);
    }
    
    public void enterContactLN(String lastName) {
        assertElementPresent(borrowerLastName);
        borrowerLastName.getElement().sendKeys(lastName);
    }
    
    public void enterContactStreet(String street) {
        assertElementPresent(borrowerStreet);
        borrowerStreet.getElement().sendKeys(street);
    }
    
    public void enterContactCity(String city) {
        assertElementPresent(borrowerCity);
        borrowerCity.getElement().sendKeys(city);
    }
    
    public void enterContactState(String state) {
        assertElementPresent(borrowerState);
        borrowerState.getElement().sendKeys(state);
    }
    
    public void enterContactZip(String zip) {
        assertElementPresent(borrowerZipCode);
        borrowerZipCode.getElement().sendKeys(zip);
    }
    
    public void enterContactDoB(String dob) {
        assertElementPresent(borrowerDateOfBirth);
        borrowerDateOfBirth.getElement().sendKeys(dob);
    }
    
    public void clickContinue() {
    	assertElementPresent(continueButton);
    	continueButton.click();
    }
    
}
