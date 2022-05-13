package kr.human.java0502;

import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class GsonEx02 {
	public static void main(String[] args) {
		Gson gson = new Gson();
		try {
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("name","한사람");
			jsonObject.addProperty("age",33);
			jsonObject.addProperty("gender",true);
			jsonObject.addProperty("height",178.9);
			
			System.out.println(jsonObject);

			//저장하기
			FileWriter fw= new FileWriter("src/main/resources/person.json");
			gson.toJson(jsonObject,fw);
//			fw.flush(); // 버퍼있는것을 저장
			fw.close(); // 닫는것 -> 닫을떄 자동으로 저장후 닫음.
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
