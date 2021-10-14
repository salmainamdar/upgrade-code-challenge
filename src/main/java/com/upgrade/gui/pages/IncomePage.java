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

public class IncomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(name = "borrowerIncome")
    private ExtendedWebElement borrowerIncome;
    
    @FindBy(name = "borrowerAdditionalIncome")
    private ExtendedWebElement borrowerAdditionalIncome;
    
    @FindBy(name = "confirmIncome")
    private ExtendedWebElement confirmIncome;
    				
    @FindBy(xpath="//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[2]/button")
    private ExtendedWebElement continueButton;
     		
    public IncomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public void enterBorrowerIncome(String income) {
        assertElementPresent(borrowerIncome);
        borrowerIncome.getElement().sendKeys(income);
    }

    public void enterBorrowerAdditionalIncome(String additionalIncome) {
        assertElementPresent(borrowerAdditionalIncome);
        borrowerAdditionalIncome.getElement().sendKeys(additionalIncome);
    }
    
    public void clickContinue() {
    	assertElementPresent(continueButton);
    	continueButton.click();
    	continueButton.click();
    }
    
}
