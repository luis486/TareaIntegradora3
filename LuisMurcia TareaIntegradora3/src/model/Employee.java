package model;
public abstract class Employee{

private String name;
private String id;
private double salary;
private boolean status;
private double level;
private double price;

public  Employee(String name, String id, double salary){
	this.name=name;
	this.id=id;
	this.salary=salary;
	this.status = true;
}
public String getName() {
	return name;
}
public double getSalary(){
	return this.salary;
}
public void setName(String name) {
	this.name = name;
}
public String getId(){
	return this.id;
}
public void setSalary(double salary){
	this.salary=salary;
}
public void setStatus(String status) {
	boolean st;
	if(status.equalsIgnoreCase("Activo")){
		st=true;
	} else{
		st= false;
	}
	this.status = st;
}
public double getPrice(){
	return this.price;
}
public double getLevel(){
	return this.level;
}
public String getStatus(){
	String msg="";
	if(this.status==true){
		msg="Activo";
	}else{
		msg="Inactivo";
	}
	return msg;
}
public abstract String showInfo();
}
