package mytest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import bl.Calculator;

@RunWith(Parameterized.class)
public class CalciTestCase {

	Calculator obj = new Calculator();
	int first;
	int second;
	int eanswer;
	

	public CalciTestCase(int a,int b,int c) {
		this.first = a;
		this.second = b;
		this.eanswer = c;
	}
	
	@BeforeClass
	public static void fun1() {
		System.out.println("This is before Class");
	}
	
	@Test(expected=java.lang.NullPointerException.class)
	public void testAdd() {
		
		System.out.println("This is add test " + first + " " + second);
		int ret = obj.add(first, second);
		assertEquals(eanswer, ret);
		System.out.println("testAdd passed");
		//fail("Not yet implemented");
	}
	
	@Parameters
	public static Collection mydata() {
		Object obj[][] = {
				{10,2,12},
				{100,200,300},
				{1,1,2},
				{1,-3,-2},
				{-10,-5,-15},
				{150,0,150}
		};
		return Arrays.asList(obj);
	}

}
