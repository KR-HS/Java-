package kr.human.java0502;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileIOEx02 {
	public static void main(String[] args) {
		//최근 방식 : 자동 닫기
		try {
			FileInputStream fls= new FileInputStream("src/main/resources/chunja2.txt");
			int n=0;
			byte[] data = new byte[2048]; // 바이트배열
			while((n=fls.read())>0) { //read(바이트배열) : 배열 크기만큼씩 읽는다. n은 읽은 길이리턴
				System.out.println((char)n);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
