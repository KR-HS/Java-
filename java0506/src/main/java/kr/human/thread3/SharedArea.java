package kr.human.thread3;

import lombok.Data;

// 두개의 스레드가 데이터를 공유하는 클래스
@Data
public class SharedArea {
    private double result;
    private boolean ready; // 계산 완료 유무를 확인.
    
}
