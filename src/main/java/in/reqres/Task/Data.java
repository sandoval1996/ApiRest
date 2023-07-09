package in.reqres.Task;

import com.devskiller.jfairy.producer.person.Person;
import com.google.gson.Gson;
import in.reqres.Models.CreacionUsuario;
import in.reqres.UI.GeneradorData;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.apache.commons.lang3.RandomUtils;

public class Data {

    private Data() {
    }

    public static Performable employeeData() {
        return Task.where("Crear Usuario", actor -> {
            Person person = GeneradorData.getPerson();
            CreacionUsuario createusuario = CreacionUsuario.builder()
                    .name(person.getFirstName())
                    .company(person.getLastName()).build();


            Gson gson = new Gson();
            actor.remember("createBody", gson.toJson(createusuario));
            actor.remember("createObject", createusuario);
        });
    }






}
