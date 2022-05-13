package kr.human.java0428;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

// 윈도우를 종료하는 기능의 외부 클래스
class WinClose extends WindowAdapter{
	@Override
	public void windowClosing(WindowEvent e) {
		super.windowClosing(e);
		System.exit(0); // 프로그램 강제 종료!!! 숫자는 0은 정상 종료 -1은 비 정상종료
	}
}

public class WinEx {
	public static void main(String[] args) {
		JFrame frame = new JFrame("내부클래스 예제"); // 윈도우 만들고
		frame.setSize(500, 500); // 크기 지정
		frame.setLocationRelativeTo(null); // 화면 중앙에 나타나게 하고
		
		// 윈도우가 닫힐때 프로그램도 종료하라고 지정한다
		//WinClose close = new WinClose();
		//frame.addWindowListener(close);
		frame.addWindowListener(new WinClose()); // 위의 두줄을 1줄로
		
		frame.setVisible(true); // 이제 보여줘!!!
	}
}
