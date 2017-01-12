package com.amk.sac.consolidate.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amk.sac.consolidate.application.config.SpringConfig;
import com.amk.sac.consolidate.services.ConsolidateService;

/**
 * 
 * @author Julio Cesar Bolaños Palacios
 * @since 10/01/2017
 * @version 1.0
 */
public class App 
{
	
	private static ApplicationContext ctx;	
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	
    public static void main( String[] args )
    {
        App.start();
    }
    
    
    
    /**
     * 
     */
    private static void start(){
    	logger.info(" ---------------- ");
		logger.info("Loading Service Beans from application context.");		
		ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		ConsolidateService consolidateService = (ConsolidateService) ctx.getBean("consolidateServiceImpl");
		consolidateService.runProcessConsolidate();
		
		
		logger.info("Close application context and exit process.");
		logger.info("Done!!!");
		logger.info(" ---------------- ");
    }
}
