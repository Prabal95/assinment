import java.util.*;
import java.io.*;

public class Employee{

	private static int choice,keyNo=0,ch=0,emailCount=100;
	private static String name,age,city,mob,email,gen,salary,fmail;
	private static int id=0;
	private static BufferedReader br;
	private static Map<Integer, List<String>> map;
	private static List<String> list;

	public Employee(){
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.city = city;
		this.mob = mob;
		this.email = email;
		this.gen = gen;
	}

	
	private static void add(){
		
		list = new ArrayList<String>();
        		addName();
		
	}
	private static void addRecord(){
		
		map.put(keyNo, list);
		
		System.out.println("Record Added Successfully");
		home();
	}

		private static void addName(){
			System.out.println("Enter Employee Name");
			try{
			name = br.readLine();
				if (!name.matches("[a-zA-Z_ ]+")){
    				System.out.println("Invalid name (Enter only alphabate)");
    				addName();
				}
			list.add(name);
			}catch(Exception e){System.out.println("Wrong Input Try Again..");}
			addAge();
		}
		private static void addAge(){
			System.out.println("Enter Employee Age (*Between 18 to 60)");
			try{
			age = br.readLine();
				
				if(!age.matches("[1-5][8-9]")){
				System.out.println("Your Age is Not Right to be a Employee");
				addAge();
				}	
				
			list.add(age);
			}catch(Exception e){System.out.println("Wrong Input Try Again..");}
			addSalary();
		}
		private static void addSalary(){
			System.out.println("Enter Employee Salary");
			try{
			salary = br.readLine();
				
				if(!salary.matches("[1-9]")){
					System.out.println("Wrong Input");
					addSalary();
				}
			list.add(salary);
			}catch(Exception e){System.out.println("Wrong Input Try Again..");}
			addCity();
		}
		private static void addCity(){
			System.out.println("Enter Employee City");
			try{
			city = br.readLine();
				if(!city.matches("[a-zA-Z_ ]+")){
    				System.out.println("Invalid city (Enter only Alphabate)");
    				addCity();
				}
			list.add(city);
			}catch(Exception e){System.out.println("Wrong Input Try Again..");}
			addMob();
		}
		private static void addMob(){
			System.out.println("Enter Employee Mobile (10 digits and start from 6-9)");
			try{
			mob = br.readLine();
			if (!mob.matches("(0/91)?[6-9][0-9]{9}")) {
    				System.out.println("Invalid number (Number Should be start with between 6to9) (And Digit of Mob. Number should be 10)");addMob();}
			
			list.add(mob);
			}catch(Exception e){System.out.println("Wrong Input Try Again..");}
			addEmail();
		}
		private static void addEmail(){
			System.out.println("Enter Employee Email (only prefix (Ex. abc.. ))");
			try{
			email = br.readLine();
				if(!email.matches("[a-z_]+")){
					System.out.println("Invalid Email");
					addEmail();
				}emailCount+=1;
			list.add(email+""+emailCount+"@gmail.com");
			}catch(Exception e){System.out.println("Wrong Input Try Again..");}
			addGen();
		}
		private static void addGen(){
			System.out.println("Enter Employee Gender (m/M Or f/F)");
			try{
			gen = br.readLine();
				if(!gen.matches("[mMFf]")){System.out.println("select from given");
					addGen();}
			list.add(gen);
			}catch(Exception e){System.out.println("Wrong Input Try Again..");}
			addRecord();
		}
		
		
		
		

	private static void viewCondition(){
		System.out.println("1 - View All");
		System.out.println("2 - View By Id");
		System.out.println("3 - View By Email");
		System.out.println("Select And Press Key for Your Choice :");
		
		try{
			choice = Integer.parseInt(br.readLine());
		}catch(Exception ex){System.out.println("Wrong Input Try Again..");viewCondition();}

		try{
			switch(choice)
			{
				case 1:{
					view();
					break;
					}
				case 2:{
					viewById();
					break;}
				case 3:{
					viewByEmail();
					break;
					}
				default:
					System.out.println("Wrong Selection / Press Key From Given Ch");
					viewCondition();	break;
			}
		}catch(Exception e){
			System.out.println("Wrong Input Try Again..");viewCondition();
		}
		
	}
	
	private static void viewByEmail(){
		System.out.println("Enter Employee Email To View Record");
		try{
			fmail = br.readLine();
		}catch(Exception e){
			System.out.println("Wrong Input Try Again..");}
		
		System.out.println(" ID. Emp. Name | Age | Salary | City | Mobile | Email | gen ");
		for(Map.Entry<Integer,List<String>> entry : map.entrySet()){
			int key = entry.getKey();
			List<String> values = entry.getValue();
			
			//String emailf = values.toString().get(6);
			//for(int i=1;i<=entry.length();i++){
			if(values.contains(fmail)){
				System.out.println("  "+key+"    "+values.toString()+ "   ");
			}
		}
		home();
	}
	
	private static void viewById(){
		System.out.println("Enter Employee Id");
		try{
			id = Integer.parseInt(br.readLine());
		}catch(Exception ex){System.out.println("Wrong Input Try Again..");viewCondition();}
		
		System.out.println(" ID. Emp. Name | Age | Salary | City | Mobile | Email | gen ");
		for(Map.Entry<Integer,List<String>> entry : map.entrySet()){
			int key = entry.getKey();
			List<String> values = entry.getValue();
			
			if(id == key){
			System.out.println("  "+key+"    "+values.toString()+ "   ");
			}	
		}viewCondition();
	home();
	}
	
	private static void view(){
		
 	    System.out.println(" ID. Emp. Name | Age | Salary | City | Mobile | Email | gen ");
	 try{
	    for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            	int key = entry.getKey();
		
               	List<String> values = entry.getValue();
		System.out.println("  "+key+"    "+values.toString()+ "   ");	
            }
	    }catch(Exception e){System.out.println("Wrong Input Try Again..");view();}
	home();
	}

	private static void update(){
	
	System.out.println(" ID. Emp. Name | Age | Salary | City | Mobile | Email | gen ");
	for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            	int key = entry.getKey();
            	List<String> values = entry.getValue();
	    	System.out.println("  "+key+"   "+values.toString()+ " ");
	}
		System.out.println("Enter Your Choice to Update Record");
		try{
			ch = Integer.parseInt(br.readLine());
			
		}catch(Exception ex){System.out.println("Wrong Input Try Again..");update();}
		
	
		System.out.println("Which value want to change ?");
		System.out.println("1 - Name");
		System.out.println("2 - Age");
		System.out.println("3 - Salary");
		System.out.println("4 - City");
		System.out.println("5 - Mobile");
		System.out.println("6 - Email");
		System.out.println("7 - Gender");
		System.out.println("Select And Press Key for Your Choice :");
		try{
			choice = Integer.parseInt(br.readLine());
		}catch(Exception ex){System.out.println("Wrong Input Try Again..");update();}

		//System.out.println("You Are Update the value of key : "+ch);
		list = map.get(ch);
		System.out.println(list);
		try{
			switch(choice)
			{
				case 1:{
					System.out.println("Enter Employee Name");
					name = br.readLine();
					list.set(0,name);
					break;
					}
				case 2:{
					System.out.println("Enter Employee Age");
					age = br.readLine();
					list.set(1,""+age);
					break;}
				case 3:{
					System.out.println("Enter Employee Salary");
					salary = br.readLine();
					list.set(2,""+salary);
					break;}
				case 4:{
					System.out.println("Enter Employee City");
					city = br.readLine();
					list.set(3,city);
					break;}
				case 5:{
					System.out.println("Enter Employee Mobile");
					mob = br.readLine();
					list.set(4,mob);
					break;}
				case 6:{
					System.out.println("Enter Employee Email");
					email = br.readLine();
					list.set(5,email);
					break;}
				case 7:{
					System.out.println("Enter Employee Gender");
					gen = br.readLine();
					list.set(6,gen);
					break;}
				default:
					System.out.println("Wrong Selection / Select From Given");
					getChoice();	
			}
		    
		}catch(Exception e){
			System.out.println("Wrong Input Try Again..");update();
		}
		
		map.replace(ch, list);
		System.out.println("Record Update SuccessFully"); 
	home();	
	}

	private static void delete(){
	int key;
	System.out.println(" ID. Emp. Name | Age | Salary | City | Mobile | Email | gen ");
	for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            	key = entry.getKey();
            	List<String> values = entry.getValue();
	    	System.out.println("  "+key+"   "+values.toString()+ " ");
	}
		System.out.println("Enter Your Choice to Delete Record");
		try{
			ch = Integer.parseInt(br.readLine());
		}catch(Exception ex){System.out.println("Wrong Input Try Again..");delete();}
		
		map.remove(ch);
		//System.out.println("map is: "+ch); 
		
		System.out.println("Record Deleted Successfully ");
		
		 try{
	    
		for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            	key = entry.getKey(); 
  		for(int i=1;i<=map.size();i++){
			if(key>ch){
			     int tmp = key;
			     key = ch;
			     ch = tmp;
			     	
				map.put(key, map.remove(keyNo));
			}
			
		}
		List<String> values = entry.getValue();
		
      			
            }
	    }catch(Exception e){System.out.println("Wrong Input Try Again..");delete();}
		keyNo=ch;
	home();	
	}
	
	private static void home(){
		
		System.out.println("1 - Add More Record");
		System.out.println("2 - Home");
		System.out.println("0 - Exit");
		System.out.println("Select And Press Key for Your Choice :");
		try{
			choice = Integer.parseInt(br.readLine());
		}catch(Exception ex){System.out.println("Wrong Input Try Again..");home();}
		

		try{
			switch(choice)
			{
				case 1:{
					keyNo+=1;
					add();
					break;
					}
				case 2:
					getChoice();
					break;
				case 0:
					exit();
					break;
				default:
					System.out.println("Wrong selection / Select From Given");
					home();break;	
			}
		    
		}catch(Exception e){
			System.out.println("Wrong Input Try Again..");home();
		}
	}

	private static void exit(){
		System.out.println("Bye Bye !! Have A Good Day....");
		System.exit(0);
	}
	
	private static void getChoice(){
		System.out.println(" ----------Welcome---------- ");
		
		System.out.println("1 - Add");
		System.out.println("2 - View");
		System.out.println("3 - Update");
		System.out.println("4 - Delete");
		System.out.println("0 - Exit");
		System.out.println("Select And Press Key for Your Choice :");
		try{
			choice = Integer.parseInt(br.readLine());
		}catch(Exception ex){System.out.println("Wrong Input Try Again..");getChoice();}
		

		try{
			switch(choice)
			{
		    
				case 1:{
					keyNo+=1;
					add();
					break;
					}
				case 2:
					{
					viewCondition();
					break;
					}
				case 3:
					update();
					break;
				case 4:
					delete();
			
					break;
				case 0:
					exit();
					break;
		    
				default:
					System.out.println("Wrong Selection / Press Key From Given");
					getChoice();break;	
			}
		    
		}catch(Exception e){
			System.out.println("Wrong Input Try Again..");getChoice();
		}
	}

	public static void main(String[] args){
	
		br = new BufferedReader(new InputStreamReader(System.in)); 
	
		map = new HashMap<Integer, List<String>>();
		list = new ArrayList<String>();
		
		getChoice();
	
	}
}
