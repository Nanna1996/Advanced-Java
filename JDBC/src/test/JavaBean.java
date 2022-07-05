//Program to demonstrate RowSet is connected to Java Bean
package test;
import java.io.*;
 @SuppressWarnings("serial")
class Emp implements Serializable//Class must be Implements Serializable interface
{
	private int age;//private Instance Variable
	
	public void setAge(int age) //Setter Method
	{
		if(age>60)
			this.age=60;
		else if(age<21)
			this.age=21;
		else
		this.age = age;
	}
	public int getAge() //Getter Method
	{
		return age;
	}
}

public class JavaBean {
	public static void main(String[] args) {
		Emp e = new Emp();
		e.setAge(75);
		int x = e.getAge();
		System.out.println(x);
		
	}

}
