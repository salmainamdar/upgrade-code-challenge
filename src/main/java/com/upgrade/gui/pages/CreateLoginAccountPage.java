package com.upgrade.gui.pages;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class CreateLoginAccountPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(name = "username")
    private ExtendedWebElement username;
    
    @FindBy(name = "password")
    private ExtendedWebElement password;
    
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[2]/div/label/div[1]")
    private ExtendedWebElement termsOfUse;
        
    @FindBy(xpath="//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[3]/button")
    private ExtendedWebElement checkYourRate;
    		
    public CreateLoginAccountPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public void enterBorrowerUsername(String email) {
        assertElementPresent(username);
        username.getElement().sendKeys(email);
    }

    public void enterBorrowerPassword(String pwd) {
        assertElementPresent(password);
        password.getElement().sendKeys(pwd);
    }
    
    public void checkYourRate() {
    	termsOfUse.check();
    	checkYourRate.click();
    }
    
}
