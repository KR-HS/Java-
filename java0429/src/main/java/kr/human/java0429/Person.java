package kr.human.java0429;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Person implements Comparable<Person>{
	private String name;
	private int age;
	
	//같으면 0 , 내가크면 양수, 내가 작으면 음수를 리턴.
	@Override
	public int compareTo(Person o) {
		//this가 있기 때문에 인수가 1개
		
//		return this.name.compareTo(o.name); // 이름 오름차순
//		return -(this.name.compareTo(o.name)); // 이름 내림차순
//		return this.age-o.age; // 나이 오름차순
//		return -(this.age-o.age); // 나이 내림차순
		
		//이름 오름차순 나이 내림차순
//		return this.name.compareTo(o.name)==0? o.age-this.age: this.name.compareTo(o.name);
		return this.name.compareTo(o.name)-(this.age-o.age);
	}
	
}
