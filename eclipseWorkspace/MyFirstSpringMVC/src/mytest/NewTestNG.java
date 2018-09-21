package mytest;

import static org.testng.Assert.assertEquals;

import org.junit.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import bl.Calculator;

public class NewTestNG {
	
	@BeforeClass
	public static void bc() {
		System.out.println("---------------Before Class Execution");
	}
	
	@BeforeMethod
	public void bf() {
		System.out.println("------------before Execution");
	}
	
  @Test(dependsOnMethods= {"xtest","ztest"})
  public void addTest() {
	  System.out.println("-----test case executed" + Thread.currentThread());
	  Calculator obj = new Calculator();
	  int ret = obj.add(10, 2);
	  
	  assertEquals(ret, 12);
  }
  @Test(groups = {"sub"})
  public void subTest() {
	  System.out.println("-----test case executed"+ Thread.currentThread());
	  Calculator obj = new Calculator();
	  int ret = obj.sub(10, 2);
	  
	  assertEquals(ret, 8);
  }
  @Test(groups = {"add","mango"})
  public void xtest() {
	  System.out.println("-------------x test case"+ Thread.currentThread());
  }
  @Test(groups = {"add","apple"})
  public void ytest() {
	  System.out.println("-------------y test case"+ Thread.currentThread());
  }
  @Test(groups = {"add","apple","mango"})
  public void ztest() {
	  System.out.println("-------------z test case"+ Thread.currentThread());
  }
  
  
}
