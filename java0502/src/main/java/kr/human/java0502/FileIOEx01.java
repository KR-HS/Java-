package kr.human.java0502;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileIOEx01 {
	public static void main(String[] args) {
		FileInputStream fls=null;
		try {
			fls=new FileInputStream("src/main/resources/chunja2.txt");
			int n=0;
			while((n=fls.read())>0) {
				System.out.println((char)n);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fls.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
