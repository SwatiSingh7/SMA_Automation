package com.morrisons.common.action;

import com.google.inject.Guice;
import com.google.inject.Injector;




import org.apache.log4j.Logger;
import com.morrisons.common.testng.TestNgStart;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.SmaAppTaskModule;

public class ApplicationLaunch {

	//private final Logger log = Logger.getLogger(ApplicationLaunch.class);
	private static final Logger log = Logger.getLogger(ApplicationLaunch.class);
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	

	public static void main(String[] args) {

		log.info("Launching Tests");
		//System.out.println("Start");
		Injector injector = Guice.createInjector(new SmaAppTaskModule(applicationConfig));
		TestNgStart ngmain = injector.getInstance(TestNgStart.class);
		ngmain.testNgXmlSuite();
	}

}
