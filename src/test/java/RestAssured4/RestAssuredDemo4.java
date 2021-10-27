package RestAssured4;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import com.aventstack.extentreports.*;



public class RestAssuredDemo4 {
    String autho = "PMAK-610d6eb49f079f004612b0e6-a75330366a76e08f9237173190acaad31e";


    @Test
    public void validategetrequest() {
        given().
                baseUri("https://api.getpostman.com").
                header("X-Api-Key", autho).
                when().
                get("/workspaces").
                then().
                log().all().
                assertThat().
                statusCode(200).
                body("workspaces.name", hasItems("Arafat_Workspace", "Khanom Workspace", "Khanom Workspace",
                        "JOBAYDA's Workspace"),
                        "workspaces.type", hasItems("personal", "personal", "personal", "team"),
                        "workspaces[3].name", equalTo("JOBAYDA's Workspace"),
                        "workspaces.size()", equalTo(14));


    }

    @Test
    public void validatepostrequest() {
        String payload = "{\n" +
                "      \"workspace\": { \n" +
                "          \"name\": \"New Workspace\", \n" +
                "              \"type\": \"personal\", \n" +
                "                 \"description\": \"Some description\" \n" +
                "    } \n" +
                "   }";
        given().
                baseUri("https://api.getpostman.com").
                header("X-Api-Key", autho).
                body(payload).
                when().
                post("/workspaces").
                then().
                log().all().
                assertThat().
                statusCode(200);

    }

    @Test
    public void validategetrequest2() {
        given().
                baseUri("https://api.getpostman.com").
                header("X-Api-Key", autho).
                when().
                get("/workspaces").
                then().
                log().all().
                assertThat().
                statusCode(200);

    }
}
