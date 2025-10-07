package cucumbertestrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@smoke", features = {"src/test/resources/FeaturewithTags"}, 
glue = {"stepDefinations"}
,plugin = {"pretty","html:target/htmlreport.html"})
public class Testrunnerwithtags extends AbstractTestNGCucumberTests {

}
