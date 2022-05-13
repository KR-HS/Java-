package kr.human.thread3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// 소비자 스레드 : 공유 영역의 데이터를 소모하는 스레드
@NoArgsConstructor
@Getter
@Setter
public class PrintThread extends Thread {
	// volatile 지시어는 컴파일러가 자동으로 변경하지 못하게 한다.
    private volatile SharedArea sharedArea;
    public void run() {
    	
    	// 계산이 완료되기전까지는 아래 출력문을 출력하지 않는다
    	while(sharedArea.isReady()!=true) {
    		continue;
    	}
        System.out.println("원주율 : "+sharedArea.getResult());
    }
}
