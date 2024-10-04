package tealium.ExtendReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReport {
	
	
	static public ExtentReports reports()
	{
		
		String path = "C:\\Users\\silppa\\eclipse-workspace\\tealium\\reports";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
		sparkReporter.config().setDocumentTitle("Tealium Demo Project");
		sparkReporter.config().setDocumentTitle("Tealium Reports");
		sparkReporter.config().setReportName("Shilpa");
		ExtentReports  report = new ExtentReports();
		report.attachReporter(sparkReporter);
		report.setSystemInfo("Tester", "Shilpa");
		return report;
	}

}
