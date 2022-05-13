package kr.human.java0502;

import java.io.Serializable;

public class DataVO implements Serializable {
	private String stringData;
	private int intData;
	public DataVO(String stringData, int intData) {
		super();
		this.stringData = stringData;
		this.intData = intData;
	}
	@Override
	public String toString() {
		return "DataVO [stringData=" + stringData + ", intData=" + intData + "]";
	}
}
