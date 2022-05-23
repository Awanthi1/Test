package testScripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.selenium.AxeReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class A11YTest {
	WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
	}
  @Test
  public void sampleTest() {
	  String RepostFile="ReportFIle";
	  AxeBuilder axebuilder=new AxeBuilder();
	  Results result=axebuilder.analyze(driver);
	List<Rule> violations = result.getViolations();
	System.out.println("no.of violations:"+violations.size());
	AxeReporter.writeResultsToJsonFile(RepostFile, result);
  }
  
  @Test
  public void selectorTest() {
	  String RepostFile="TestWithSelector";
	  List<String> selctors=new ArrayList<String>();
	  selctors.add("tittle");
	  AxeBuilder axebuilder=new AxeBuilder();
	  axebuilder.include(selctors);
	  Results result=axebuilder.analyze(driver);
	List<Rule> violations = result.getViolations();
	System.out.println("no.of violations:"+violations.size());
	AxeReporter.writeResultsToTextFile(RepostFile, result);
  }
  @Test
  public void testWebElement() {
	  String RepostFile="TestWithWeb";
	 	  AxeBuilder axebuilder=new AxeBuilder();
	  Results result=axebuilder.analyze(driver,driver.findElement(By.tagName("div")));
	List<Rule> violations = result.getViolations();
	System.out.println("no.of violations:"+violations.size());
	AxeReporter.writeResultsToTextFile(RepostFile, result);
  }
  
}
