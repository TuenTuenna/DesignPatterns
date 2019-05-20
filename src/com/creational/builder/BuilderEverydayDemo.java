package com.creational.builder;

//빌더 패턴 데모 클래스 
public class BuilderEverydayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuilder builder = new StringBuilder();
		
		builder.append("이것은 빌터 패턴");
		builder.append(" 예제 입니다.	");
		builder.append("append() 라는 메소드가 있습니다.");
		builder.append(42);
		System.out.println(builder.toString());
		
		
	}

}

