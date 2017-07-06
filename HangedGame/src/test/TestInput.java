package test;

import org.junit.Assert;
import org.junit.Test;

import util.Input;


public class TestInput {
	
	@Test
	public void testScannInt(){
		Integer a = Input.scannInt();
		Float f = Input.scannFloat();
		String str = Input.scannLine();
		
		Assert.assertEquals(a.getClass(), (Integer.class));
		Assert.assertEquals(f.getClass(), (Float.class));
		Assert.assertEquals(str.getClass(), (String.class));
		
	}
	
	
}
