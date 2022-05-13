package kr.human.thread1;

import javax.swing.JOptionPane;


public class SingleThreadEx {
	public static void main(String[] args) {
		String name="";
		while(true) {
			name= JOptionPane.showInputDialog("이름은?");
			if(name!=null) break;
		}
		JOptionPane.showMessageDialog(null, name+"님 환영합니다.");
		for(int i=0;i<20;i++) {
			System.out.println(i+1);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
