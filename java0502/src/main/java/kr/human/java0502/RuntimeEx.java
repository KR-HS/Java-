package kr.human.java0502;

import java.io.IOException;

public class RuntimeEx {
	public static void main(String[] args) {
		try {
			Runtime.getRuntime().exec("notepad.exe"); // 메모장
			Runtime.getRuntime().exec("mspaint.exe"); // 그림판
			
			ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe");
			processBuilder.start();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
