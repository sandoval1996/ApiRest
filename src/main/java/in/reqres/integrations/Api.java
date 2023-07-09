package in.reqres.integrations;

import in.reqres.Questions.CheckResponse;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class Api {
    public static Performable getParametros(String path, String nombreParametro, String ValorParamentro) {

        return Task.where(

                Get.resource(path).with(
                        request -> request.queryParam(nombreParametro,ValorParamentro)
                )

        );


    }

    public static Performable CrearUsuarios()
    {
        return Task.where( "Creacion usuario", actor -> {
           actor.attemptsTo(Post.to("/users")
                   .with(request -> request.body(OnStage.theActorInTheSpotlight().recall("createBody").toString())));
            System.out.println("validar que imprime= " + actor.recall("createBody"));

        });
    }







}
