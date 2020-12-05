package model;

	public abstract class Employee{

	private String name;
	private String id;
	private double salary;
	private boolean status;
	private double level;
	private double price;

	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * <b> pre: two Employees can't have the same name </b>
	 * @param name, id, salary= name String, id String, salary double
	 */
	public  Employee(String name, String id, double salary){
		this.name=name;
		this.id=id;
		this.salary=salary;
		this.status = true;
	}

	/**
	* get method <br>
	* <b> pre: constructor method </b> 
	* @return name= Employee name
	*/
	public String getName() {
		return name;
	}

	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return salary= Employee salary
	 */

	public double getSalary(){
		return this.salary;
	}
	
	/**
	 * set constructor <br>
	 * <b> pre: constructor method </b> 
	 * @param name= Employee name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return id= Employee id 
	 */
	public String getId(){
		return this.id;
	}
	
	/**
	 * set constructor <br>
	 * <b> pre: constructor method </b> 
	 * @param salary= Employee salary
	 */
	public void setSalary(double salary){
		this.salary=salary;
	}
	
	/**
	 * set constructor <br>
	 * <b> pre: constructor method </b> 
	 * @param status= Employee status(Active or inactive)
	 */
	public void setStatus(String status) {
		boolean st;
		if(status.equalsIgnoreCase("Activo")){
			st=true;
		} else{
			st= false;
		}
		this.status = st;
	}
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return price= Employee price 
	 */
	public double getPrice(){
		return this.price;
	}
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return level= Employee level
	 */
	public double getLevel(){
		return this.level;
	}
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return msg= Employee status(Active or Inactive)
	 */
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
