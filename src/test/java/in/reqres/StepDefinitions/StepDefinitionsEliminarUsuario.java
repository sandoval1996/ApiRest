package in.reqres.StepDefinitions;

import in.reqres.Task.Llamar;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;

public class StepDefinitionsEliminarUsuario {

    @Given("Quiero eliminar usuario con ID")
    public void quieroEliminarUsuarioConID(io.cucumber.datatable.DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(Llamar.EliminarUsuarios(dataTable));
    }

}
