package in.reqres.Runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/Features/ListaUsuarios.feature",
        glue = "in.reqres.StepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "summary",
                "junit:target/cucumber-reports/cucumber.xml",
                "html:target/cucumber-reports/report.html"}


)
public class RunnerListaUusuarios {
}
