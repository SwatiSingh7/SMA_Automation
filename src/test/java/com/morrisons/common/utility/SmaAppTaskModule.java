package com.morrisons.common.utility;


import com.google.inject.AbstractModule;

import com.google.inject.Provides;



public class SmaAppTaskModule extends AbstractModule {
    private ApplicationConfig applicationConfig;

    public SmaAppTaskModule(ApplicationConfig applicationConfig){
        this.applicationConfig = applicationConfig;
    }

    @Provides
    public ApplicationConfig getConfig() {
        return applicationConfig;
    }

    @Override
	protected void configure() {
		/*//bind the service to implementation class
		//bind(MessageService.class).to(EmailService.class);
		
		//bind MessageService to Facebook Message implementation
		bind(PromotionServiceData.class).to(.class);*/
		
	}
}
