package in.reqres.Task;

import in.reqres.integrations.Api;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.List;
import java.util.Map;

public class Llamar {

    private static DataTable data;

    public Llamar(DataTable data) {
        this.data = data;
    }


    public static Performable listarUsuarios()
    {
        return Task.where( Api.getParametros("/users", "page","2" ));
    }


    public static Performable listarUsuario(DataTable data)
    {
        List<Map<String,String>> values = data.asMaps(String.class,String.class);
        String titulo = String.valueOf(values.get(0).get("Id"));
        System.out.println("numero del id a consulta:   " + titulo);

        return Task.where( actor -> {
            actor.attemptsTo(Get.resource("/users/{id}").with(request -> request.pathParams("id", titulo)));


        });
    }


    public static Performable ActualizarUsuario(DataTable data)
    {
        List<Map<String,String>> values = data.asMaps(String.class,String.class);
        String idUser = String.valueOf(values.get(0).get("IdUser"));
        return Task.where("Actualizar Usuario", actor -> {

            actor.attemptsTo(Put.to("/users/{ids}").with(request -> request.pathParams("ids",idUser )).
                    with(request -> request.body(OnStage.theActorInTheSpotlight().recall("createBody").toString())));

        });
    }




    public static Performable obtenerDatosUsuario(DataTable data)
    {
        List<Map<String,String>> values = data.asMaps(String.class,String.class);
         String validarID =  String.valueOf(values.get(0).get("Id"));
        String Name =  String.valueOf(values.get(0).get("Firstname"));
        return Task.where(actor -> {
            actor.remember("IdUser",validarID);
            actor.remember("User",Name);
        });
    }

public static Performable EliminarUsuarios (DataTable data)
{
    List<Map<String,String>> values = data.asMaps(String.class,String.class);
    String idUser = String.valueOf(values.get(0).get("idsUsers"));
    return Task.where("Actualizar Usuario", actor -> {

        actor.attemptsTo(Delete.from("/users/{ids}").with(request -> request.pathParams("ids",idUser )));
});





}}
