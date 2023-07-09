package in.reqres.StepDefinitions;

import in.reqres.Questions.CheckResponse;
import in.reqres.Task.Llamar;
import in.reqres.integrations.Api;
import in.reqres.integrations.ApiListarUsuario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.hamcrest.Matchers;

public class StepDefinitionsListarUsuario {

    @Given("Yo quiero obtener un usuario con id")
    public void yoQuieroObtenerUnUsuarioConId(io.cucumber.datatable.DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(Llamar.listarUsuario(dataTable));
       OnStage.theActorInTheSpotlight().attemptsTo(Llamar.obtenerDatosUsuario(dataTable));
    }
    @Then("verifico que se genere codigo {int}")
    public void verificoQueSeGenereCodigo(int statuscode) {
    OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse
            (validatableResponse -> validatableResponse.statusCode(statuscode)));
    }
    @Then("verifico que tenga ID")
    public void verificoQueTengaID() {
    OnStage.theActorInTheSpotlight().should(CheckResponse.ValidarID());
    }
    @Then("verfico que tenga nombre")
    public void verficoQueTengaNombre() {
        OnStage.theActorInTheSpotlight().should(CheckResponse.ValidarNombres());
    }





}
