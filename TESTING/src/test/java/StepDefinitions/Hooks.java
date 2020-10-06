package StepDefinitions;

import Utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Hooks {

    @After
    public void afterClass(Scenario scenario) {

        System.out.println("Scenario Status: " + scenario.getStatus());
        System.out.println("Scenario ID: " + scenario.getId());
        System.out.println("Scenario Name: " + scenario.getName());

        if (scenario.getStatus().equalsIgnoreCase("failed")) {

            TakesScreenshot ScreenShot = ((TakesScreenshot) Driver.getDriver());

            File src_file = ScreenShot.getScreenshotAs(OutputType.FILE);

            String feature_file_name = scenario.getName();

            Date now = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH mm ss");

            String date_String = formatter.format(now);

            File destinationFile = new File("target/FailedScreenShots/" + feature_file_name + date_String + ".png");

            try {
                FileUtils.copyFile(src_file, destinationFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Driver.QuitDriver();
    }

}

