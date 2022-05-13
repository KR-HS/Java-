package kr.human.thread1;

import javax.swing.JOptionPane;

// 멀티스레드 : 프로세스 내에 실행 흐름이 여러개인 프로그램. 모든 스레드가 종료해야 프로그램 종료
public class MultiThreadEx {
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				for(int i=0;i<20;i++) {
					System.out.println(i+1);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		String name= JOptionPane.showInputDialog("이름은?");		
		JOptionPane.showMessageDialog(null, name+"님 환영합니다.");
	}
}
