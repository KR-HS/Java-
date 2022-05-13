package kr.human.java0427;

import java.util.Date;
import java.util.Calendar;

public class Singleton {

	private static Singleton instance=new Singleton();
	
	private Singleton() {
		;
	}
	public static Singleton getInstance() {
		return instance;
	}
}

class NonSingleton{}


public class SingletonEx{
	public static void main(String args[]) {
		
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		Singleton singleton3 = Singleton.getInstance();
		
		System.out.println(singleton1.hashCode());
		System.out.println(singleton1.hashCode());
		System.out.println(singleton1.hashCode());
		
		NonSingleton ns1=new NonSingleton();
		NonSingleton ns2=new NonSingleton();
		System.out.println(ns1.hashCode);
		System.out.println(ns2.hashCode);
		
		Date date = new Date();
		Calender calendar = Calendar.getInstace();
		
	}
}
