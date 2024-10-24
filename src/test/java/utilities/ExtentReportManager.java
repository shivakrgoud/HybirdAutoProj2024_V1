package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;

	public void onStart(ITestContext testContext)
	{
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
	 String repName = "Test-Report-" + timeStamp+".html";
	 
	 sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\" + repName);
	

	extent = new ExtentReports();
	extent.attachReporter(sparkReporter);
	sparkReporter.config().setDocumentTitle("Automation Test Report"); // title of the report
	sparkReporter.config().setReportName("Automation Functional Testing");// Name of the report
	sparkReporter.config().setTheme(Theme.DARK);
	extent.setSystemInfo("Application", "Parasoft");
	extent.setSystemInfo("Module", "Admin");
	extent.setSystemInfo("Sub Module", "Customers");
	extent.setSystemInfo("User Name",System.getProperty("User Name"));
	extent.setSystemInfo("Environment", "QA");
	
	String os=testContext.getCurrentXmlTest().getParameter("os");
	extent.setSystemInfo("Operating System", os);
	
	String browser=testContext.getCurrentXmlTest().getParameter("browser");
	extent.setSystemInfo("Browser", browser);
	
	List<String> includeGroups=testContext.getCurrentXmlTest().getIncludedGroups();
	if(!includeGroups.isEmpty()) {
		
		extent.setSystemInfo("Groups", includeGroups.toString());
	}	
}
	public void onTestSuccess(ITestResult result) 
	 { 	
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+" got successfully executed");     
	  }
	
	public void onTestFailure(ITestResult result) 
	 { 	
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+" got Failed"); 
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			
			String imgPath= new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}catch(IOException e1){
			e1.printStackTrace();
		}
	  }
	
	public void onTestSkipped(ITestResult result) 
	 { 	
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+" got Skipped"); 
		test.log(Status.INFO, result.getThrowable().getMessage());
	  }
	
	public void onFinish(ITestContext testContext) 
	 { 	
		extent.flush();
//		String PathOfExtentReport= System.getProperty("user.dir")+"\\reports\\"+repName;
//		File extentReport =new File(PathOfExtentReport);
//		try {
//			Desktop.getDesktop().browse(extentReport.toURI());
//		}catch(IOException e1) {
//			e1.printStackTrace();}
	  }
	
	
}