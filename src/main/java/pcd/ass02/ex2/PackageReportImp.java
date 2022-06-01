package pcd.ass02.ex2;

import pcd.ass02.ClassReport;
import pcd.ass02.InterfaceReport;
import pcd.ass02.PackageReport;

import java.util.ArrayList;
import java.util.List;

public class PackageReportImp implements PackageReport {

	private List<InterfaceReport> interfaces;
	private List<ClassReport> classes;
	private String packageName;
	
	public PackageReportImp() {
		interfaces = new ArrayList<InterfaceReport>();
		classes = new ArrayList<ClassReport>();
	}

	public void setPackageName(String name) {
		this.packageName = name;
	}
	
	public void addClassReport(ClassReport c) {
		classes.add(c);
	}
	
	public void addInterfaceReport(InterfaceReport i) {
		interfaces.add(i);
	}
	

	@Override
	public String getPackageName() {
		return packageName;
	}

	@Override
	public List<ClassReport> getClassesInfo() {
		return classes;
	}

	@Override
	public List<InterfaceReport> getInterfacesInfo() {
		return interfaces;
	}

}
