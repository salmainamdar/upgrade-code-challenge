package com.upgrade.challenge;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.upgrade.api.brfunnelorch.v2.ResumeService;

public class BRFunnelOrchAPITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "salmainamdar")
    public void testByLeadSecret() throws Exception {
    	
        LOGGER.info("testByLeadSecret");
        setCases("123");
        ResumeService api = new ResumeService();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponse(); // Validates the entire response object per resume_rq.json, including productType expected and declared in resume.properties
        
    }    
    
    @Test()
    @MethodOwner(owner = "salmainamdar")
    public void testByLeadSecretInvalidLoanApp() throws Exception {
    	
        LOGGER.info("testByLeadSecretInvalidLoanApp");
        setCases("456");
        ResumeService api = new ResumeService();
        api.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        api.addProperty("loanAppUuid", "b8096ec7-2150-405f-84f5-ae99864b3e97");
        
        String response = api.callAPI().getBody().asString();
        Assert.assertEquals(new JsonPath(response).getString("codeName"), "MISSING_LOAN_APPLICATION");
        Assert.assertEquals(new JsonPath(response).getString("message"), "Loan application does not exist.");       
    
    }  
    
    @Test()
    @MethodOwner(owner = "salmainamdar")
    public void testByLeadSecretInvalidLoanAppFormat() throws Exception {
    	
        LOGGER.info("testByLeadSecretInvalidLoanApp");
        setCases("456");
        ResumeService api = new ResumeService();
        
        api.addProperty("loanAppUuid", "b8096ec7-2150-405f-84f5");
        Assert.assertEquals(api.callAPI().getStatusCode(), 500);
        
    } 
    

    @Test()
    @MethodOwner(owner = "salmainamdar")
    public void testByLeadSecretMissingLoanApp() throws Exception {
    	
        LOGGER.info("testByLeadSecretInvalidLoanApp");
        setCases("456");
        ResumeService api = new ResumeService();
        
        api.removeProperty("loanAppUuid");
        Assert.assertEquals(api.callAPI().getStatusCode(), 400);
        
    } 
}
