package aaa.model;

import lombok.Data;

@Data
public class StudCalc {

	String name;
	int [] jum;
	
	public StudCalc(String name, int...jum) {
		super();
		this.name = name;
		this.jum = jum;
	}
	
}
