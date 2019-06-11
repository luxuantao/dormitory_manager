package com.bean;

public class StudentBean {
    private int Student_ID ;
    private String Student_Username ;
    private String Student_Password ;
    private String Student_Name ;
    private String Student_Sex ;
    private String Student_Dept ;
    private String Student_Tel ;
    
	public int getStudent_ID() {
		return Student_ID;
	}
	public void setStudent_ID(int studentID) {
		Student_ID = studentID;
	}
	public String getStudent_Username() {
		return Student_Username;
	}
	public void setStudent_Username(String studentUsername) {
		Student_Username = studentUsername;
	}
	public String getStudent_Password() {
		return Student_Password;
	}
	public void setStudent_Password(String studentPassword) {
		Student_Password = studentPassword;
	}
	public String getStudent_Name() {
		return Student_Name;
	}
	public void setStudent_Name(String studentName) {
		Student_Name = studentName;
	}
	public String getStudent_Sex() {
		return Student_Sex;
	}
	public void setStudent_Sex(String studentSex) {
		Student_Sex = studentSex;
	}
	public String getStudent_Dept() {
		return Student_Dept;
	}
	public void setStudent_Dept(String studentDept) {
		Student_Dept = studentDept;
	}
	public String getStudent_Tel() {
		return Student_Tel;
	}
	public void setStudent_Tel(String studentTel) {
		Student_Tel = studentTel;
	}
	
	private int Dormitory_ID ;
	private String Dormitory_Name ;
	private String Building_Name ;
	private int Building_ID ;
	private int Dormitory_Size ;
    private int Dormitory_Now ;
	
    public int getDormitory_ID() {
		return Dormitory_ID;
	}
	public void setDormitory_ID(int dormitory_ID) {
		Dormitory_ID = dormitory_ID;
	}		
	public String getDormitory_Name() {
		return Dormitory_Name;
	}
	public void setDormitory_Name(String dormitoryName) {
		Dormitory_Name = dormitoryName;
	}
	public String getBuilding_Name() {
		return Building_Name;
	}
	public void setBuilding_Name(String buildingName) {
		Building_Name = buildingName;
	}
    public int getDormitory_Size() {
		return Dormitory_Size;
	}
	public void setDormitory_Size(int dormitory_Size) {
		Dormitory_Size = dormitory_Size;
	}
	public int getDormitory_Now() {
		return Dormitory_Now;
	}
	public void setDormitory_Now(int dormitory_Now) {
		Dormitory_Now = dormitory_Now;
	}
	
	private String SD_State ;
	
	public String getSD_State() {
		return SD_State;
	}
	public void setSD_State(String sD_State) {
		SD_State = sD_State;
	}
	public int getBuilding_ID() {
		return Building_ID;
	}
	public void setBuilding_ID(int building_ID) {
		Building_ID = building_ID;
	}
	
	private String SD_Date;
	
	public String getSD_Date() {
		return SD_Date;
	}
	public void setSD_Date(String sd_Date) {
		SD_Date = sd_Date;
	}	
	
	private int OldDormitory_ID;
	
	public int getOldDormitory_ID() {
		return OldDormitory_ID;
	}

	public void setOldDormitory_ID(int oldDormitory_ID) {
		OldDormitory_ID = oldDormitory_ID;
	}
}
