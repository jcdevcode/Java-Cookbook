package com.amk.sac.consolidate.application.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationProperties {
	 private static final Logger LOG = LoggerFactory.getLogger(ApplicationProperties.class);
	    private static final String APPLICATION_PROPERTIES = "application.properties";
	    private static Properties config;
	    private static InputStream is = null;
	    
	    static {       
	        if (config == null) {
	            config = new Properties();
	            is = ApplicationProperties.class
	                    .getResourceAsStream(APPLICATION_PROPERTIES);            
	        }
	    }
	    
	    private ApplicationProperties(){        
	    }
	    
	    private static Properties getConfig(){
	        try {
	            config.load(is);
	        } catch (IOException e){
	        	LOG.error(e.getMessage());    
	    	} catch(NullPointerException e) {                      
	            LOG.error(e.getMessage());            
	        }
	        return config;
	    }
	    
	    public static String getStringValue(String key){
	        return getConfig().getProperty(key);
	    }
	    
	    public static Integer getIntegerValue(String key){
	        return new Integer(getConfig().getProperty(key));
	    }
}
