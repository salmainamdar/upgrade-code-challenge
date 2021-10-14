package com.upgrade.api.brfunnelorch.v2;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class ResumeService extends AbstractApiMethodV2 {
    public ResumeService() {
        super("api/resume/_post/resume_rq.json", "api/resume/_post/resume_rs.json", "api/resume/resume.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        setHeaders("x-cf-source-id=coding-challenge",
        		"x-cf-corr-id=fcb24980-be6c-11eb-8529-0242ac130003",
        		"Content-Type=application/json");
    }
}
