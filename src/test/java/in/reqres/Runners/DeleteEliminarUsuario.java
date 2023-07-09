package in.reqres.Runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "C:\\practicaAutomatizacion\\PracticaApis\\src\\test\\resources\\Features\\EliminarUsuario.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "in.reqres.StepDefinitions",
        monochrome = true,
        plugin = {"pretty", "summary",
                "junit:target/cucumber-reports/cucumber.xml",
                "html:target/cucumber-reports/report.html"}
)
public class DeleteEliminarUsuario {
}
