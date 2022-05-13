package kr.human.json.vo;

import lombok.Data;

@Data
public class BoxOfficeVO {
	private BoxOfficeResult boxOfficeResult;
	
	@Data
	public static class BoxOfficeResult{
		private String boxofficeType;
		private String showRange;
		private DailyBoxOfficeList[] dailyBoxOfficeList;
	}
	
	@Data
	public class DailyBoxOfficeList{
		private String rank;
		private String openDt;
		private String movieNm;
	}
}
