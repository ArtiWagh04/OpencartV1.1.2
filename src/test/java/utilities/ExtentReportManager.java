package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseClass;

public class ExtentReportManager implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    // Create ExtentReports instance
    public static ExtentReports getExtentReports() {

        if (extent == null) {

            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String reportPath = System.getProperty("user.dir")
                    + "/reports/ExtentReport_" + timeStamp + ".html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("OpenCart UI Automation");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // System info
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Browser", "Chrome"); // dynamic if needed
            extent.setSystemInfo("Tester", "Arti Wagh");
        }
        return extent;
    }

    // Set test instance
    public static void setTest(ExtentTest test) {
        extentTest.set(test);
    }

    // Get test instance
    public static ExtentTest getTest() {
        return extentTest.get();
    }

    // Remove test instance
    public static void removeTest() {
        extentTest.remove();
    }
    
    String repName;
    
    
    
    @Override
    public void onStart(ITestContext testContext) {

        extent = getExtentReports();

        // Static system info
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        // Parameters from testng.xml
        String os = testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", os);

        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", browser);

        // Groups info
        if (!testContext.getCurrentXmlTest().getIncludedGroups().isEmpty()) {
            extent.setSystemInfo(
                "Groups",
                testContext.getCurrentXmlTest().getIncludedGroups().toString()
            );
        }
    }


    // 🔹 Triggered when a test case starts
    @Override
    public void onTestStart(ITestResult result) {
    	ExtentReportManager.setTest(
                extent.createTest(result.getMethod().getMethodName())
        );
    }

    // 🔹 Triggered when test PASSES
    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTest test = ExtentReportManager.getTest();

        // Assign groups as categories in Extent report
        test.assignCategory(result.getMethod().getGroups());

        // Log success message
        test.log(
            Status.PASS,
            result.getMethod().getMethodName() + " got successfully executed"
        );
    }


    // 🔹 Triggered when test FAILS
    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTest test = ExtentReportManager.getTest();

        // Assign groups as categories
        test.assignCategory(result.getMethod().getGroups());

        // Log failure status
        test.log(
            Status.FAIL,
            result.getMethod().getMethodName() + " got failed"
        );

        // Log exception details
        test.log(
            Status.INFO,
            result.getThrowable()
        );

        // Capture and attach screenshot
        try {
            String imgPath = BaseClass.captureScreen(result.getMethod().getMethodName());
            test.addScreenCaptureFromPath(imgPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 🔹 Triggered when test is SKIPPED
    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentTest test = ExtentReportManager.getTest();

        // Assign groups as categories
        test.assignCategory(result.getMethod().getGroups());

        // Log skip status
        test.log(
            Status.SKIP,
            result.getMethod().getMethodName() + " got skipped"
        );

        // Log skip reason (if available)
        if (result.getThrowable() != null) {
            test.log(Status.INFO, result.getThrowable().getMessage());
        }
    }

    // 🔹 Triggered after <suite> ends
    @Override
    public void onFinish(ITestContext testContext) {
    	
    	
    	

        // Flush Extent report
        extent.flush();

        // Path of the generated report
        String pathOfExtentReport = System.getProperty("user.dir")
                + "\\reports\\" + repName;

        File extentReport = new File(pathOfExtentReport);

        // Automatically open report in browser
     
        try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        extentTest.remove();
        extent = null;
        

    

   /* 
    try {
        URL url = new URL(
            "file:///" + System.getProperty("user.dir") + "\\reports\\" + repName
        );

        // Create the email message
        ImageHtmlEmail email = new ImageHtmlEmail();
        email.setDataSourceResolver(new DataSourceUrlResolver(url));
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(
            new DefaultAuthenticator("pavanoltraining@gmail.com", "password")
        );
        email.setSSLOnConnect(true);

      //  email.setFrom("pavanoltraining@gmail.com"); // Sender
        email.setSubject("Test Results");
        email.setMsg("Please find Attached Report...");
        //email.addTo("pavankumar.busya@gmail.com"); // Receiver

        email.attach(url, "extent report", "please check report...");
        email.send(); // send the email

    } catch (Exception e) {
        e.printStackTrace();
    }
    */

}
    
   
}

