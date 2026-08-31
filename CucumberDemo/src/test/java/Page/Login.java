package Page;

import java.time.Duration;

import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.types.Hook;
import stepdefinations.Hooks;


public class Login {
	private WebDriver d1;
	private WebDriverWait wait;
    Hooks h;
	
@FindBy(name="email")
WebElement txt_username;

@FindBy(name="password")
public WebElement txt_password;

@FindBy(xpath ="//*[@class=\"ui fluid large blue submit button\"]")
public WebElement btn_loginbutton;

@FindBy(xpath = "//*[@class=\"ui vk basic icon button\"]")
WebElement btn_Home_Help;

@FindBy(xpath ="//*[text()='Invalid login1']")
WebElement error_message;


public Login(WebDriver d1)
{
    

    this.d1 = d1;
    this.wait = new WebDriverWait(d1, Duration.ofSeconds(10));
    PageFactory.initElements(d1, this);
	
	
}

public void enterusername(String username)
{
	wait.until(ExpectedConditions.visibilityOf(txt_username));

	txt_username.sendKeys(username);
	
	
}

public void enterpassword(String password)
{
	wait.until(ExpectedConditions.visibilityOf(txt_password));
	 txt_password.sendKeys(password);
}

public void clickonloginbutton()
{
	wait.until(ExpectedConditions.visibilityOf(btn_loginbutton));
	btn_loginbutton.click();
}

public boolean help() {
	wait.until(ExpectedConditions.visibilityOf(btn_Home_Help));
	boolean button = btn_Home_Help.isDisplayed();
	return button;
}

public boolean errormsg1() {
	wait.until(ExpectedConditions.visibilityOf(error_message));
	boolean msg = error_message.isDisplayed();
	return msg;
}

}
