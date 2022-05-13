package kr.human.java0502;


import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupEx01 {
	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("음력을 보고 싶은 년월을 입력하시오 : ");
			int year = sc.nextInt();
			int month = sc.nextInt();
			
			Document doc = Jsoup.connect("https://astro.kasi.re.kr/life/pageView/5"+String.format("?search_year=%4d&search_month=%02d", year,month)).get();
			System.out.println("제목 : "+doc.title());
			
			Elements elements = doc.select("table tbody tr");
			System.out.println(elements.size()+"개");
			
			for(Element e : elements) {
//				System.out.println(e);
				Elements tds= e.select("td");
				System.out.println("양력 : " + tds.get(0).text()+" -> 음력 : ("+tds.get(1).text()+"): "+tds.get(2).text());
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
