package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * @author Jones
 * @date 23-08-2022
 * @description Used to Generate JVM Report 
 */
public class Reporting {
	public static void generateJVMReport(String jsonFile) {
		File f= new File("C:\\Users\\PAVI\\eclipse-workspace\\OMRBranchAdactinHotelAutomation\\target");
		Configuration config = new Configuration(f,"Adactin Hotel Booking");
		
		
		config.addClassifications("Operating Platform", "Windows 10");
		config.addClassifications("Browser Name", "Chrome");
		config.addClassifications("Version", "10.105");
		config.addClassifications("Worked Sprint", "23");
		
		List<String> li = new ArrayList<String>();
		li.add(jsonFile);
		
		ReportBuilder builder = new ReportBuilder(li, config);
		
		builder.generateReports();
		
	}

}
