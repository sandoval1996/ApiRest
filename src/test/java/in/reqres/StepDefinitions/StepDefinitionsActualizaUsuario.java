package in.reqres.StepDefinitions;

import in.reqres.Questions.CheckResponse;
import in.reqres.Task.Llamar;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

public class StepDefinitionsActualizaUsuario {

    @When("I quiero actualizar usuario")
    public void iQuieroActualizarUsuario(io.cucumber.datatable.DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(Llamar.ActualizarUsuario(dataTable));
    }
    @Then("validar codigo de respuesta {int}")
    public void validarCodigoDeRespuesta(int code) {
     OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse(validatableResponse -> validatableResponse.statusCode(code)));
    }

    @Then("Validar que se actualizo el nombre usuario")
    public void validarQueSeActualizoElNombreUsuario() {
        OnStage.theActorInTheSpotlight().should(CheckResponse.UsuarioCreado());
    }

}
