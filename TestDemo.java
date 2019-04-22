package test;

import java.util.ArrayList;
import java.util.List;

public class TestDemo {
	
	public static int test() {
		int i=0;
		try {
			return i;
		} catch (Exception e) {
			// TODO: handle exception
			return 2;
		}finally {
			i=1;
		}
	}

	
	public static int test1() {
	
		try {
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 2;
		}finally {
			return 3;
		}
	}
	
	public static String test2() {
		String s="hello";
		try {
			s+=" world";
			return s;
		} catch (Exception e) {
			// TODO: handle exception
			return "";
		}finally {
			s+=" demo";
		}
	}
	
	public static StringBuilder test3() {
		StringBuilder s = new StringBuilder("Hello");
		try {
			s.append(" world");
			return s;
		} catch (Exception e) {
			// TODO: handle exception
			return s;
		}finally {
			s.append(" demo");
		}
	}
	public static void main(String[] args) {
		System.out.print(test3());
	}
}
