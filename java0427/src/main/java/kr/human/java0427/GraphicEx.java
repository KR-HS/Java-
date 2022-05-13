package kr.human.java0427;
/*
 * 1. 동일한 부모를 가진다.
 * 2. 부모의 메서드를 오버라이딩한다
 * 3. 부모의 변수에 자식 객체를 대입해서 자식을 컨트롤 한다.
 * 
 * */
abstract class Shape{
	public static final double PI = 3.141592;
	abstract public void draw(); 
}
class Point extends Shape{
	public void draw() { System.out.println("점을 그립니다."); }
}
class Line extends Shape{
	public void draw() { System.out.println("선을 그립니다."); }
}
class Circle extends Shape{
	public void draw() { System.out.println("원을 그립니다."); }
}
class Rectangle extends Shape{
	public void draw() { System.out.println("사각형을 그립니다."); }
}
public class GraphicEx {
	public static void main(String[] args) {
		Shape[] shapes = {new Point(),new Line(), new Circle(), new Rectangle()};
		
		for(Shape shape : shapes) {
			shape.draw();
		}
	}
}
