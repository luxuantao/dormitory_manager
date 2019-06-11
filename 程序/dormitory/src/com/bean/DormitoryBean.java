package com.bean;

public class DormitoryBean {
    private int Dormitory_ID ;
    private String Dormitory_Name ;
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
	public void setDormitory_Name(String dormitory_Name) {
		Dormitory_Name = dormitory_Name;
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
	
	private int Building_ID ;
	private String Building_Name ;
	
	public String getBuilding_Name() {
		return Building_Name;
	}
	public void setBuilding_Name(String buildingName) {
		Building_Name = buildingName;
	}
	public int getBuilding_ID() {
		return Building_ID;
	}
	public void setBuilding_ID(int building_ID) {
		Building_ID = building_ID;
	}
	
	private int DB_BuildingID ;
	
	public int getDB_BuildingID() {
		return DB_BuildingID;
	}
	public void setDB_BuildingID(int dB_BuildingID) {
		DB_BuildingID = dB_BuildingID;
	}
}
