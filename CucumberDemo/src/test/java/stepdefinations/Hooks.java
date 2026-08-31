package stepdefinations;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.messages.types.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	 public static WebDriver d1;
	 private WebDriverWait wait; 
	Properties p;
	
	public WebDriver getDriver() {
		return d1;
	}
	
	@Before
	public void openbrowser() throws Exception
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\mosam\\eclipse-workspace\\CucumberDemo\\config.properties");
		p = new Properties();
		p.load(fis);
		if(p.getProperty("Browser").equals("chrome"))
		{
			//  WebDriverManager.chromedriver().setup(); 
		d1 = new ChromeDriver();
		d1.manage().window().maximize();
		wait = new WebDriverWait(d1, java.time.Duration.ofSeconds(20));
	//	d1.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    d1.get(p.getProperty("URL"));
		if(d1 != null)
		{
			d1 = getDriver();
		}
		

		}
	
	}

	
	@After
	public void teardown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			byte[] screenshot = ((TakesScreenshot)d1).getScreenshotAs(OutputType.BYTES);		
		
			
			
			scenario.attach(screenshot, "image/png", scenario.getName());
			
			
		}
	
		if (d1 != null)
				{
					d1.quit();
				}
	}
}
