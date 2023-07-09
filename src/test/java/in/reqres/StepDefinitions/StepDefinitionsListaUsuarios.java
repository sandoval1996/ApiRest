package in.reqres.StepDefinitions;

import in.reqres.Task.Llamar;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class StepDefinitionsListaUsuarios {

    @Given("Quiero listar los usuarios registrados en la api")
    public void quieroListarLosUsuariosRegistradosEnLaApi() {
        OnStage.theActorInTheSpotlight().attemptsTo(Llamar.listarUsuarios());

    }


    @Then("Verifico el codigo {int}")
    public void verificoElCodigo(int int1) {

 OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse
         (validatableResponse -> validatableResponse.statusCode(int1)));



    }
    @Then("Verifico que se listen")
    public void verificoQueSeListen() {
       OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse(
               response -> response.body("data.last_name" , Matchers.hasItems("Howell","Funke")
       )));
    }




}
