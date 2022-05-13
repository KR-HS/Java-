package kr.human.selenium;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// Selenium 4는 Chrome v75 이상과 호환
// Chrome 브라우저 버전과 chromedriver 버전이 주 버전과 일치해야 합니다.
public class Ex01 {
	public static void main(String[] args) {
		// 1.웹드라이버의 경로를 지정해 준다.
		System.setProperty("webdriver.chrome.driver",
				new File("src/main/resources/chromedriver.exe").getAbsolutePath());
		
		// 2. Selenium으로 브라우저 열기
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		
		
		// 2-1 원하는 주소로 이동
		driver.get("https://www.naver.com");
		// 브라우저를 최대화
		driver.manage().window().maximize();
		//암시적 대기
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500)); //0.5초 대기
		// name속성의 값이 query인 요소 찾기
		WebElement searchBox= driver.findElement(By.name("query"));
		//문자열을 보낸다.
		searchBox.sendKeys("Selenium");
		// 검색버튼을 찾는다.
		WebElement searchButton = driver.findElement(By.id("search_btn"));
		searchButton.click();
		
		// 대기
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500)); 
			
		String title = driver.getTitle();
		System.out.println("제목 : "+title);
		
		System.out.println(driver.findElement(By.id("nx.qeury")).getAttribute("placeholder"));
		// 3. Selenium으로 브라우저 닫기
//		driver.quit();
	}
}
