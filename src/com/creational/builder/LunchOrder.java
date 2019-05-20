package com.creational.builder;

public class LunchOrder {

	public static class Builder {
		private String bread;
		private String condiments;
		private String dressing;
		private String meat;
		
		public Builder() {
			
		}
		
		public LunchOrder build() {
			return new LunchOrder(this);
		}
		
		// 빌더디자인 패턴의 장점은 모델의 속성을 설정하는 메소드들이 모두 자기자신의 인스턴스를 
		// 반환하기 때문에 동시에 많은 속성을 가진 모델의 속성을 정하기에 아주 편하다 
		public Builder bread(String bread) {
			this.bread = bread;
			return this;
		}
		
		public Builder condiments(String condiments) {
			this.condiments = condiments;
			return this;
		}
		
		public Builder dressing(String dressing) {
			this.dressing = dressing;
			return this;
		}
		
		public Builder meat(String meat) {
			this.meat = meat;
			return this;
		} 
		
	}
	
	private final String bread;
	private final String condiments;
	private final String dressing;
	private final String meat;

	private LunchOrder(Builder builder) {
		this.bread = builder.bread;
		this.condiments = builder.condiments;
		this.dressing = builder.dressing;
		this.meat = builder.meat;
	}

	public String getBread() {
		return bread;
	}

	public String getCondiments() {
		return condiments;
	}
	
	public String getDressing() {
		return dressing;
	}
	
	public String getMeat() {
		return meat;
	}
	
}
