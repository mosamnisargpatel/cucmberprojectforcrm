package stepdefinations;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Page.Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginpage {
	 WebDriver d1;
	 Hooks h = new Hooks();
	 Login l = new Login(h.getDriver()) ;
	 

	 
	 @When("the user enters a valid username {string}")
	public void the_user_enters_a_valid_username_username(String username) throws InterruptedException {
		
				l.enterusername(username);
				// d1.findElement(By.name("email")).sendKeys(username);
				// Thread.sleep(5000);

	}

	 @And("the user enters a valid password {string}")
	public void the_user_enters_a_valid_password_password(String password) throws Exception {
	 l.enterpassword(password);
	 Thread.sleep(5000);
	}

	 @And("the user clicks the Login button")
	public void the_user_clicks_the_button() throws Exception {
	
		 l.clickonloginbutton();
		    Thread.sleep(5000);
	}

	@Then("the user should be redirected to the homepage")
	public void the_user_should_be_redirected_to_the_homepage() throws Exception {
	
		boolean help1 = l.help();
	    assertTrue(help1);
	    Thread.sleep(5000);
	    }

	@When("the user enters an invalid username {string}")
	public void the_user_enters_an_invalid_username_mosampatel175_gmail_com(String username) {
	    l.enterusername(username);
	}

	@And("the user enters an invalid password {string}")
	public void the_user_enters_an_invalid_password_mosam(String password) {
	    l.enterpassword(password);
	}
	
	 @And("the user clicks the Login button1")
	public void the_user_clicks_the_button1() throws Exception {
	
		 l.clickonloginbutton();
		 Thread.sleep(5000);
	}


	@Then("the user should see an error message")
	public void the_user_should_see_an_error_message() throws Exception {
		//boolean error = d1.findElement(By.xpath("//*[text()='Invalid login']")).isDisplayed();
	    //assertTrue(error);
		boolean error1 = l.errormsg1();
		assertTrue(error1);
	    Thread.sleep(5000);
	}



}
