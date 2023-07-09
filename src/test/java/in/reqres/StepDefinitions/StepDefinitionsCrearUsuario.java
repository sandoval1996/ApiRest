package in.reqres.StepDefinitions;

import in.reqres.Questions.CheckResponse;
import in.reqres.Task.Data;
import in.reqres.UI.GeneradorData;
import in.reqres.integrations.Api;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

public class StepDefinitionsCrearUsuario {

    @Given("crear usuario con data random")
    public void crearUsuarioConDataRandom() {
        OnStage.theActorInTheSpotlight().attemptsTo(Data.employeeData());
    }


    @When("Crear usuario")
    public void crearUsuario() {
     OnStage.theActorInTheSpotlight().attemptsTo(Api.CrearUsuarios());
    }


    @Then("verifico que se cree")
    public void verificoQueSeCree() {
    OnStage.theActorInTheSpotlight().should(CheckResponse.UsuarioCreado());

    }


    @Then("Se verifica codigo {int}")
    public void seVerificaCodigo(int codigo) {
        OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse
                (validatableResponse -> validatableResponse.statusCode(codigo)));
    }






}
