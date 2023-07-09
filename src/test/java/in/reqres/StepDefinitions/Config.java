package in.reqres.StepDefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.core.annotations.events.AfterScenario;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class Config {

    EnvironmentVariables environmentVariables;


        @Before
    public void init() {
            OnStage.setTheStage(new OnlineCast());
            OnStage.theActorCalled("Cliente");
            String BaseUrl = environmentVariables.optionalProperty("API.reqres").orElse("https://reqres.in/api");
            OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(BaseUrl));
        }
        @AfterScenario
        public void printResponse() {
        SerenityRest.lastResponse().body().prettyPrint();
            SerenityRest.reset();
       }
    }



