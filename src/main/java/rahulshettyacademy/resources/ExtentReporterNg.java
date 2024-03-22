package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {
	
	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir") +"\\reports\\index.html";
		ExtentSparkReporter reports = new ExtentSparkReporter(path);
		
		reports.config().setReportName("Web Autmation Results");
		reports.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		 extent.attachReporter(reports);
		extent.setSystemInfo("Tester", "Shyam");
		return extent;
		
		
	}

}
