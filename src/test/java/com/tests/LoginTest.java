package com.tests;

import org.testng.annotations.Test;

import com.baseClass.Base;
import com.pages.LoginPage;

public class LoginTest extends Base{
  
  @Test
  public void LoginWithValidCredential() {
	  
	  LoginPage loginPage = new LoginPage()
			  .login("userName","password");
	  
  }
}
