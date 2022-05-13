package kr.human.java0502;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextIOEx01 {
	public static void main(String args[]) {
		try (FileWriter fw = new FileWriter("text.txt")) {
			fw.write("저장이 될까요?\n");
			fw.write("정말 저장이 될까요?\n");
			fw.write("진짜 저장이 될까요?\n");
			fw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("-".repeat(50));
		
		try(FileReader fr=new FileReader("text.txt")){
			int n=0;
			char[] data=new char[1024];
			while((n=fr.read(data))>0) {
				System.out.print(new String(data,0,n));
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("-".repeat(50));
		
		try(BufferedReader br = new BufferedReader(new FileReader("text.txt"))){
			String line="";
			while((line=br.readLine())!=null)System.out.println(line);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("-".repeat(50));		
		
		try(Scanner sc= new Scanner(new File("text.txt"))){
			while(sc.hasNextLine())System.out.println(sc.nextLine());
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("-".repeat(50));
	}
}
