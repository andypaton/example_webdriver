package com.alien.examples.webdriver.steps;

import static com.alien.examples.webdriver.runtime.ThreadManager.getWebDriver;

import java.lang.management.ManagementFactory;

import org.apache.log4j.Logger;
import org.junit.rules.ExternalResource;

import org.springframework.test.context.ContextConfiguration;

import com.alien.examples.webdriver.config.CucumberConfig;
import com.alien.examples.webdriver.runtime.ThreadManager;
import com.alien.utils.webdriver.WebDriverFactory;

@ContextConfiguration(classes=CucumberConfig.class)
public class WebSuiteClassRule extends ExternalResource {
	
    private static final Logger LOGGER = Logger.getLogger(WebSuiteClassRule.class.getName());

	
    @Override
    protected void before() throws Throwable {
    	   
    	ThreadManager.webDriver.set(WebDriverFactory.getWebDriver());
    	    
        LOGGER.debug("WebDriver instance created : " + getWebDriver().hashCode() 
        		+ " [JVM process name : " + ManagementFactory.getRuntimeMXBean().getName() + "]");
    }

    @Override
    protected void after() {
    	
        getWebDriver().close();
        WebDriverFactory.clear();

        LOGGER.debug("WebDriver instance destroyed : " + getWebDriver().hashCode());
    }

}
