package com.creational.builder;

public class BuilderLunchOrderDemo {

	public static void main(String args[]) {
		
		LunchOrder.Builder builder = new LunchOrder.Builder();
		
		// 빌더에 있는 메소드들은 모두 자기자신의 인스턴스를 반환하기 때문에 
		// 아래와 같이 사용이 가능한것
		// builder = builder.bread("Wheat");
		builder.bread("Wheat").condiments("Lettuce").dressing("Mayo").meat("Turkey");
		
		// 빌더 패턴의 장점 
		// : 속성을 많이 가진 모델은 중간에 속성이 빠뜨리기가 쉽지않다.
		// 하지만 빌더 패턴은 속성중 몇개가 빠지거나 해도 괜찮고 유연하게 모델 객체 인스턴스화가 가능하다.
		// 프레임워크나 라이브러리에서 객체를 인스턴스화 할때 많이 보이는 패턴이다.
		// 안드로이드의 alert dialog 또한 마찬가지 
		LunchOrder lunchOrder = builder.build();
		
		System.out.println(lunchOrder.getBread());
		System.out.println(lunchOrder.getCondiments());
		System.out.println(lunchOrder.getDressing());
		System.out.println(lunchOrder.getMeat());	
	}
}

