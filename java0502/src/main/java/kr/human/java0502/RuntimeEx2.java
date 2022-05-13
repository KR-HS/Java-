package kr.human.java0502;

import java.io.IOException;
import java.util.Scanner;

public class RuntimeEx2 {
	public static void main(String[] args) {
		try {
			Process process = Runtime.getRuntime().exec("cmd /c ipconfig"); // 메모장
			Scanner sc = new Scanner(process.getInputStream(),"MS949");
			while(sc.hasNextLine()) System.out.println(sc.nextLine());
			sc.close();
			System.out.println("-".repeat(40));
			
			ProcessBuilder processBuilder = new ProcessBuilder("cmd","/c","ipconfig");
			Process process2=processBuilder.start();
			Scanner sc2=new Scanner(process2.getInputStream(),"MS949");
			while(sc2.hasNextLine()) System.out.println(sc.nextLine());
			sc2.close();
			System.out.println("-".repeat(40));
			processBuilder.start();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
