import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/main/features" // < -- features location
        ,glue={"steps"} // steps package name
        ,plugin = {"pretty", "html:target/homeRunner.html" // <--- reports
                   ,"rerun:target/failed-scenarios/homeRunner.txt"} // <--- failed reports
//        ,stepNotifications = true // Optional
        ,dryRun = true // <--- Optional
//        ,tags = "@SecondRequirement" // <--- May or may not use. In case of having specific test cases needed to be run
)
public class SearchRunner {
}
