package com.tests;

import org.testng.annotations.Test;

import com.baseClass.Base;
import com.pages.LoginPage;

public class LoginTest extends Base{
  
  @Test
  public void LoginWithValidCredential() {
	  
	  LoginPage loginPage = new LoginPage()
			  .login("userName","password");
	  System.out.println("Login With Valid Credential");
	  
  }
  @Test
  public void LoginWithInValidCredential() {
	  
	  LoginPage loginPage = new LoginPage()
			  .login("userName1","password1");
	  System.out.println("Login With In Valid Credential");
	  
  }
}
