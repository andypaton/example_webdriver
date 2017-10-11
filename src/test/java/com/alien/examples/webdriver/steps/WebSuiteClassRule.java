package com.alien.examples.webdriver.steps;

import java.io.IOException;

import org.junit.rules.ExternalResource;

import com.alien.utils.webdriver.WebDriverFactory;


public class WebSuiteClassRule extends ExternalResource {
	
    @Override
    protected void before() throws Throwable {
        WebDriverFactory.getWebDriver();
    }

    @Override
    protected void after() {
    	
        try {
			WebDriverFactory.getWebDriver().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        WebDriverFactory.clear();
    };

}
