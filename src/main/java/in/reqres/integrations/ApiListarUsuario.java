package in.reqres.integrations;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.List;
import java.util.Map;

public class ApiListarUsuario {

    private static DataTable data;

    public ApiListarUsuario(DataTable data) {
        this.data = data;
    }


    public static Performable ObtenerUsuario(DataTable data)

    {
        List<Map<String,String>> values = data.asMaps(String.class,String.class);
        return Task.where(actor -> {

            actor.attemptsTo(Get.resource("/users"));



        });


    }







}
