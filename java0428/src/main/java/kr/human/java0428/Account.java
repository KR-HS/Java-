package kr.human.java0428;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor

public class Account {
	private String accoutNo;
	private String ownerName;
	private int balance;
	
	public void deposit(int amount) {
		balance+=amount;
	}
	
	public int withdraw(int amount) {
		if(balance<amount) {
//			throw new Exception("잔액이 부족합니다.");
			throw new RuntimeException("잔액부족!!");
		}
		balance -=amount;
		return amount;
	}
}
