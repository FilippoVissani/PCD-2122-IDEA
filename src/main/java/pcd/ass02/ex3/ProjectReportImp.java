package pcd.ass02.ex3;

import pcd.ass02.PackageReport;
import pcd.ass02.ProjectReport;

import java.util.ArrayList;
import java.util.List;

public class ProjectReportImp implements ProjectReport {

	private String mainClass;
	private List<PackageReport> packages;
	
	public ProjectReportImp(){
		packages = new ArrayList<PackageReport>();
	}
		
	@Override
	public String getMainClass() {
		return mainClass;
	}
		
	public void addPackageReport(PackageReport rep) {
		packages.add(rep);
	}
	
	@Override
	public List<PackageReport> getPackages() {
		return packages;
	}

}
