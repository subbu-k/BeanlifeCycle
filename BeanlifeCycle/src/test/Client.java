package test;

import java.util.Scanner;

 

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Test;
import beans.Test2;
import beans.Test3;

public class Client {
	public static void main(String[] args) throws Exception {
		
		String strfile[]= {"resource/Spring.xml","resource/Spring2.xml","resource/Spring3.xml"};
		ConfigurableApplicationContext cf=new ClassPathXmlApplicationContext(strfile);
	
		//Test t=(Test)cf.getBean("t");
		Test3 t1=(Test3)cf.getBean("t3");
		
		Scanner sc =new Scanner(System.in);
		while(true) {
		
		System.out.println("Enter 1 for Save and 2 For Close..");
		int key=sc.nextInt();
		switch (key) {
		case 1:
			System.out.println("enter the id:");
			int id=sc.nextInt();     
			System.out.println("enter the name:");
			String Name=sc.next();
			
			
			System.out.println("enter the email:");
			String email=sc.next();
			
			System.out.println("enter the address:");
			String address=sc.next();
			t1.save(id, Name, email, address);
			break;
		case 2:
			
			cf.close();
			break;
		default:
			cf.close();
			break;
		}
		
	}
		
	}

}
