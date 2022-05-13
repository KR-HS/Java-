package kr.human.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx07 {

	public static void main(String[] args) {
		IntStream
		.rangeClosed(1,10)
		.map(n->n*n)
		.forEach(n->System.out.print(n+" "));
		System.out.println("\n"+"-".repeat(50));
		
		// 사원목록에서 이름만 대문자로
		Employee.persons().stream().map(Employee::getName).forEach(n->System.out.print(n.toUpperCase()+" "));
		System.out.println("\n"+"-".repeat(50));
		
		Stream.of(1,2,3,4,5)
		.flatMap(n->Stream.of(n,n+1))
		.forEach(n->System.out.print(n+ " "));
		System.out.println("\n"+"-".repeat(50));
		
		Stream.of("XML","JAVA","HTML","CSS")
		.map(name->name.chars())
		.flatMap(intStream->intStream.mapToObj(n->(char)n))
		.forEach(e->System.out.println(e));
		System.out.println("-".repeat(50));
		
		Stream.of("XML","JAVA","HTML","CSS")
		.flatMap(name->IntStream.range(0,name.length())
		.mapToObj(name::charAt))
		.forEach(e->System.out.println(e));
		System.out.println("-".repeat(50));
		
	}

}
