package com.qa.test;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pageLayer.TestBase.TestBase;

public class TestA extends TestBase{

	
	
	@Test
	public void MethodA()
	{
		System.out.println("hello test A");
	}

	
	@Test
	public void MethodB()
	{
	SoftAssert as=new SoftAssert();
	as.assertTrue(true);
	System.out.println("hello test b");
	
	System.out.println("hello sfter assert all");
	as.assertAll();
	}
	
}
