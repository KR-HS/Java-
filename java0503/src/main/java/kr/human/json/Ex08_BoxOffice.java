package kr.human.json;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;

import kr.human.json.vo.BoxOfficeVO;

public class Ex08_BoxOffice {
	public static void main(String[] args) {
		Gson gson = new Gson();
	      String urlAddress = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
	      urlAddress += "?key=f5eef3421c602c6cb7ea224104795888";
	      urlAddress += "&targetDt=20220502";
	      
	      try {
			URL url = new URL(urlAddress);
			InputStreamReader isr = new InputStreamReader(url.openStream());
			
			BoxOfficeVO vo = gson.fromJson(isr, BoxOfficeVO.class);
			System.out.println(vo.getBoxOfficeResult().getBoxofficeType());
			System.out.println(vo.getBoxOfficeResult().getShowRange());
			for(BoxOfficeVO.DailyBoxOfficeList d : vo.getBoxOfficeResult().getDailyBoxOfficeList()) {
				System.out.println(d.getRank() + ". "+d.getMovieNm()+"("+d.getOpenDt()+")");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
