package kr.human.java0502;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOEx05 {
	public static void main(String[] args) {
		//파일 복사
		try {
			FileInputStream fls = new FileInputStream("src/main/resources/chunja.txt");
			FileOutputStream fos = new FileOutputStream("test2.txt");
				
			byte[] data = new byte[2048];
			int n=0;
			while((n=fls.read(data))>0) {
				fos.write(data,0,n);
				fos.flush();
			}
			System.out.println("chunja.txt 파일을 test2.txt로 복사완료");
	}catch(

	FileNotFoundException e)
	{
		e.printStackTrace();
	}catch(
	IOException e)
	{
		e.printStackTrace();
	}
}}
