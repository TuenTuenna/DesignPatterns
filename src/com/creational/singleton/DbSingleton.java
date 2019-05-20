package com.creational.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 싱글턴 적용 클래스 
public class DbSingleton {
	
	// 두번체크 
	// volatile 을 추가하면 thread safe 
	private static volatile DbSingleton instance = null;
	
	private static volatile Connection conn = null;
	
	private DbSingleton() {
		
		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(conn != null) {
			throw new RuntimeException("생성하기 위해 getInstance() 메소드를 사용하시오.");
		}
		
		if(instance != null) {
			throw new RuntimeException("생성하기 위해 getInstance() 메소드를 사용하시오.");
		}
	}
	
	// 해당메소드를 사용함으로써 하나의 인스턴스 만을 사용하도록 한다.
	public static DbSingleton getInstance() {
		// lazyloading 이 더 낫다 
		// 왜냐면 필요할때만 인스턴스를 할당하기 때문 
		if(instance == null) {
			// 멀티쓰레드 환경에서 확실하게 싱글턴임을 보장하기 위해 synchronized() 사용 
			synchronized(DbSingleton.class) {
				if(instance == null) {
					instance = new DbSingleton();
				}
			}
		}
		
		return instance;
	}

	// 디비연결을 가져오는 메소드 
	public Connection getConnection() {
		if(conn == null) {
			synchronized (DbSingleton.class) {
				if(conn == null) {
					try {
						String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";
						
						conn = DriverManager.getConnection(dbUrl);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return conn;
	}
	
	
	
}
