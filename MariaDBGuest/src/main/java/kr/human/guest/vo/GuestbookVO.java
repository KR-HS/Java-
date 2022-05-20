package kr.human.guest.vo;

import java.util.Date;
import lombok.Data;

@Data
public class GuestbookVO {
	private int idx;
	private String name;
	private String password;
	private String content;
	private Date regDate;
	private String ip;
	
	// 추가 변수 (저장 , 수정 , 삭제를 구분하기 위한 변수)
	private String mode;
	
}
