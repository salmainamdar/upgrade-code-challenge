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

public class OfferPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[1]/div[2]/span[2]")
    private ExtendedWebElement loanAmount;
    
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[1]/div/div[2]/div")
    private ExtendedWebElement monthlyPayment;
    
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[2]/div/div/ul/li[2]/div")
    private ExtendedWebElement term;
    
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[2]/div/div/ul/li[3]/div")
    private ExtendedWebElement interestRate;
    
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[2]/div/div/ul/li[4]/div")
    private ExtendedWebElement apr;
    
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/header/div/label")
    private ExtendedWebElement hambergerMenu;
    
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/header/div/nav/ul/li[2]/a")
    private ExtendedWebElement signOut;
   
    public OfferPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public String getLoanAmount() {
    	return loanAmount.getText();
    }
    
    public String getMonthlyPayment() {
    	return monthlyPayment.getText();
    }
    
    public String getTerm() {
    	return term.getText();
    }
    
    public String getInterestRate() {
    	return interestRate.getText();
    }
    
    public String getAPR() {
    	return apr.getText();
    }
    
    public void clickSignOut() {
    	hambergerMenu.click();
    	signOut.click();
    }
    
}
