package com.upgrade.challenge;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.upgrade.gui.pages.ContactPage;
import com.upgrade.gui.pages.CreateLoginAccountPage;
import com.upgrade.gui.pages.IncomePage;
import com.upgrade.gui.pages.NonDMFunnelPage;
import com.upgrade.gui.pages.OfferPage;
import com.upgrade.gui.pages.PortalLoginPage;

public class NonDMFunnelTest implements IAbstractTest {
	
	private String userName = "candidate1@upgrade-challenge.com";
	private String pwd = "Secret12";
	
	@Test()
    @MethodOwner(owner = "salmainamdar")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testNonDMFunnelPersonalLoanFlow() {
		
		//STEP 1: Open https://www.credify.tech/funnel/nonDMFunnel
		NonDMFunnelPage nonDMFunnelPage = new NonDMFunnelPage(getDriver());
		nonDMFunnelPage.open();
		        
        //Step 2: Enter Loan Amount & Purpose
        nonDMFunnelPage.enterLoanAmt("2000");
        nonDMFunnelPage.selectLoanPurpose("HOME_IMPROVEMENT");
        nonDMFunnelPage.checkYourRate();
        
        //Step 3: Enter Contact details
        ContactPage contactPage = new ContactPage(getDriver());
        contactPage.selectApplicationType("Individual");
        contactPage.enterContactFN("Tom");
        contactPage.enterContactLN("Cruz");
        contactPage.enterContactStreet("123 State Street");
        contactPage.enterContactCity("Los Angeles");
        contactPage.enterContactState("CA");
        contactPage.enterContactZip("98989");
        contactPage.enterContactDoB("10/10/1980");
        contactPage.clickContinue();
        
        //Step 4: Enter Income details
        IncomePage incomePage = new IncomePage(getDriver());
        incomePage.enterBorrowerIncome("150000");
        incomePage.enterBorrowerAdditionalIncome("50000");
        incomePage.clickContinue();
        
        //Step 5: Create login/account
        CreateLoginAccountPage createLoginAccountPage = new CreateLoginAccountPage(getDriver());
        createLoginAccountPage.enterBorrowerUsername(userName);
        createLoginAccountPage.enterBorrowerPassword(pwd);
        createLoginAccountPage.checkYourRate();
        
        //Step 6: View Offers and sign out
        OfferPage offerPage = new OfferPage(getDriver());
        String offerloanAmount = offerPage.getLoanAmount();
        String offerMonthlyPayment = offerPage.getMonthlyPayment();
        String offerTerm = offerPage.getTerm();
        String offerInterestRate = offerPage.getInterestRate();
        offerPage.clickSignOut();
        
        //Step 7: Sign into Portal
        PortalLoginPage portalLoginPage = new PortalLoginPage(getDriver());
        portalLoginPage.open();
        
        portalLoginPage.enterBorrowerUsername(userName);
        portalLoginPage.enterBorrowerPassword(pwd);
        portalLoginPage.signIn();
        
        //Step 8: Compare offer details
        OfferPage offerPagePostLogin = new OfferPage(getDriver());
        Assert.assertEquals(offerPagePostLogin.getLoanAmount(), offerloanAmount, "Loan Amount Do not match!");
        Assert.assertEquals(offerPagePostLogin.getMonthlyPayment(), offerMonthlyPayment, "Monthly Payment Do not match!");
        Assert.assertEquals(offerPagePostLogin.getTerm(), offerTerm, "Term Do not match!");
        Assert.assertEquals(offerPagePostLogin.getInterestRate(), offerInterestRate, "Interest Rate Do not match!");
        
	}

}
