package com.demowebshop.test.core;

import com.demowebshop.core.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.lang.reflect.Method;

public class TestBase {

    protected static ApplicationManager app;

    protected Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() {
        app = new ApplicationManager(System.getProperty("browser", "chrome"));
        app.init();
        logger.info("=== Test suite started ===");
    }

    @AfterSuite
    public void tearDown() {
        if (app != null) app.stop();
        logger.info("=== Test suite finished ===");
    }

    @BeforeMethod
    public void startTest(Method method) {
        logger.info("========== START TEST: {} ==========", method.getName());
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: {}", result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: {}", result.getMethod().getMethodName());
            try {
                app.takeScreenshot(result.getMethod().getMethodName());
                logger.info("Screenshot saved for failed test: {}", result.getMethod().getMethodName());
            } catch (Exception e) {
                logger.error("Error while taking screenshot: {}", e.getMessage());
            }
        }
        logger.info("========== END TEST ==========\n");
    }
}