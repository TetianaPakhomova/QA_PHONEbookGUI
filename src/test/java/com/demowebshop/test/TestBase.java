package com.demowebshop.test;

import com.yourprojectname.core.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import org.testng.ITestResult;
import java.lang.reflect.Method;

public class TestBase {

    public static ApplicationManager app = new ApplicationManager(System.getProperty("browser","chrome"));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @BeforeMethod
    public void startTest(Method method){
        logger.info("Start test {}", method.getName());
    }

    @AfterMethod
    public void stopTest(ITestResult result){
        if(result.isSuccess()){
            logger.info("PASSED: {}", result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: {}", result.getMethod().getMethodName());
        }
        logger.info("Stop test");
        logger.info("************************************");
    }

    @AfterSuite
    public void tearDown(){
        app.stop();
    }
}