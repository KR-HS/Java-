package kr.human.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {
	private Map<String, Cookie> map = new HashMap<>();
	
	public CookieUtil(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null && cookies.length>0) {
			for(Cookie cookie : cookies) {
				map.put(cookie.getName(), cookie);
			}
		}
	}
	
	
	// 쿠키 저장
	public static Cookie createCookie (String name, String value) {
		Cookie cookie = null;
		try {
			cookie = new Cookie(name,URLEncoder.encode(value,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return cookie;
	}
	
	public static Cookie createCookie (String name, String value,int maxAge) {
		Cookie cookie = null;
		try {
			cookie = new Cookie(name,URLEncoder.encode(value,"UTF-8"));
			cookie.setMaxAge(maxAge);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return cookie;
	}
	
	public static Cookie createCookie (String name, String value,String path,int maxAge) {
		Cookie cookie = null;
		try {
			cookie = new Cookie(name,URLEncoder.encode(value,"UTF-8"));
			cookie.setMaxAge(maxAge);
			cookie.setPath(path);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return cookie;
	}
	
	public static Cookie createCookie (String name, String value,String domain,String path,int maxAge) {
		Cookie cookie = null;
		try {
			cookie = new Cookie(name,URLEncoder.encode(value,"UTF-8"));
			cookie.setMaxAge(maxAge);
			cookie.setPath(path);
			cookie.setDomain(domain);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return cookie;
	}
	
	// 이름으로 쿠키얻기
	public Cookie getCookie(String name) {
		return map.get(name);
	}
	
	// 이름으로 쿠키값 얻기
	public String getValue(String name) {
		String value=null;
		Cookie cookie = map.get(name);
		if(cookie!=null) {
			try {
				value=URLDecoder.decode(cookie.getValue(),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		return value;
	}
	
	// 쿠키 존재 유무 반환
	public boolean exists(String name) {
		return map.get(name)!=null;
	}
	
	
}
