package in.reqres.Questions;

import in.reqres.Models.CreacionUsuario;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.hamcrest.Matchers;

import static org.hamcrest.Matchers.*;

public class CheckResponse {

    public static Question<Boolean>statusCodeReponse(int statusCode)
    {
        return actor -> statusCode == SerenityRest.lastResponse().statusCode();
    }

    public static ResponseConsequence UsuarioCreado()
    {
        CreacionUsuario UsuarioCreado = OnStage.theActorInTheSpotlight().recall("createObject");
        SerenityRest.lastResponse().body().prettyPrint();
        return ResponseConsequence.seeThatResponse(response -> response
                .body("name", equalTo(UsuarioCreado.getName()))
                .body("company", equalTo(UsuarioCreado.getCompany()))

        );


    }

    public static ResponseConsequence ValidarID()
    {

        String validarId = OnStage.theActorInTheSpotlight().recall("IdUser");
        int numeroEntero = Integer.parseInt(validarId);
        return  ResponseConsequence.seeThatResponse(response -> response
                .body("data.id", equalTo(numeroEntero)));


    }

    public static ResponseConsequence ValidarNombres()
    {
        String PrimerNombre = OnStage.theActorInTheSpotlight().recall("User");
        return ResponseConsequence.seeThatResponse(response -> response.body("data.first_name" , equalTo(PrimerNombre)));
    }




}
