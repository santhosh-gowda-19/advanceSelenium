package test_scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM_class.Facebook_Login;
import generic.Base_Test;
import generic.Generic_read_excel;

public class ValidLogin extends Base_Test
{
	@Test
	public void login()
	{
		String uname=Generic_read_excel.getData("Sheet1",0,0);
		String pwd=Generic_read_excel.getData("Sheet1",0,1);
		Facebook_Login fb=new Facebook_Login(driver);
		fb.setEmail(uname);
		fb.setPass(pwd);
		fb.passBtn();
		Assert.fail();
	}
}
