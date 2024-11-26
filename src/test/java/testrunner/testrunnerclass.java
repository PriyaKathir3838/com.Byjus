package testrunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\DELL\\eclipse-workspace\\COM.BYJUS\\src\\test\\resources\\course.feature",
                glue = "stepdifinition",
              dryRun = false,
            //  monochrome = true,
             // +tags = "@create or @loginfunction",
              //plugin = {"html:target"}
              plugin = {"html:target","json:target/report.json"}
          
            )

public class testrunnerclass {

}
