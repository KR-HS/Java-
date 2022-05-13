package kr.human.lunar;

import lombok.Data;

@Data
public class PollVO {
	private String title;
	private String[] item;
	private int[] itemCount;
	
	
	// 총 투표수 구하는 메서드 추가
	public int getTotal() {
		int total = 0;
		for(int i:itemCount) total+=i;
		return total;
	}
	
	// 백분율 구하는 메서드 추가 
	public String getPercent(int index) {
		if(getTotal()==0) return "0%";
		return String.format("%.2f", (double)itemCount[index]/getTotal()*100)+"%";
	}
}
