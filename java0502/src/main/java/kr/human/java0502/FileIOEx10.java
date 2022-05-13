package kr.human.java0502;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class FileIOEx10 {
	public static void main(String[] args) {

		ObjectOutputStream dos = null;
		try{
			dos= new ObjectOutputStream(new FileOutputStream("data1.dat"));
			dos.writeByte(123);
			dos.writeInt(345);
			dos.writeDouble(3.14);
			dos.writeUTF("한글");
			dos.writeObject(new Date()); // 객체도 저장가능
			dos.writeObject(new Person("한사람",24)); // 사용자 정의 객체도 저장 가능?
													// 직렬화 역직렬화 인터페이스를 구현화해줘야 함.
			dos.flush();
			System.out.println("데이터 타입별로 저장하기");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				dos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		try(ObjectInputStream dis = new ObjectInputStream(new FileInputStream("data1.dat"))){
			// 데이터를 정확하게 읽으려면 저장 순서를 반드시 알아야 한다.
			byte b = dis.readByte();
			int i=dis.readInt();
			double d = dis.readDouble();
			String str = dis.readUTF();
			Date date = (Date) dis.readObject(); // 객체 읽기 . 형변환과 ClassNotFoundException 처리해줘야함.
			Person person = (Person) dis.readObject();
			
			System.out.println(i);
			System.out.println(b);
			System.out.println(d);
			System.out.println(str);
			System.out.println(date);
			System.out.println(person);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
