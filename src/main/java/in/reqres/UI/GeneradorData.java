package in.reqres.UI;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;

import java.util.Locale;

public class GeneradorData {

    private GeneradorData() {
    }

    public static Person getPerson() {
        Fairy fairy = Fairy.create(Locale.forLanguageTag("es"));
        return fairy.person();
    }



}
