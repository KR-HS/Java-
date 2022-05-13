package kr.human.java0502;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOEx04 {
	public static void main(String[] args) {
		try (FileOutputStream fos = new FileOutputStream("test.txt");) {
			fos.write("Save\n".getBytes());
			fos.flush(); // 버퍼의 내용을 저장해라.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
