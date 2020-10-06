package Runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;

import java.io.File;

@CucumberOptions(

        plugin = {
                "html:target/cucumber-Html-Report",
                "com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/ExtentReportEnd2End.html"
        },
        tags = {"@SmokeTest"},
        features={"src/test/java/FeatureFiles"}, //the location of feature files.
        glue={"StepDefinitions"}, // location of the step definition
        dryRun = false

)

public class SmokeTest extends AbstractTestNGCucumberTests {
        @AfterClass
        public static void afterClass(){

//                Location of the xml file

                Reporter.loadXMLConfig(new File("src/test/java/FeatureFiles/extentReport.xml"));
                Reporter.setSystemInfo("User Name" , "Abduhamid");
                Reporter.setSystemInfo("Application Name", "TECHNO BANK");
                Reporter.setSystemInfo("Operating System Type" , System.getProperty("os.name"));
                Reporter.setSystemInfo("Environment", "QA");
                Reporter.setTestRunnerOutput("Test execution Cucumber report");
        }
}
