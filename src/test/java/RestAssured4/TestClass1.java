package RestAssured4;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import com.aventstack.extentreports.*;

public class TestClass1 {

    public static void main(String[] args) {
        String autho = "PMAK-610d6eb49f079f004612b0e6-a75330366a76e08f9237173190acaad31e";
        PojoClass obj = new PojoClass();
        obj.setName("pojo Workspace");
        obj.getName();
        obj.setType("personal");
        obj.getType();
        obj.setDescription("some description");
        obj.getDescription();

        given().
                baseUri("https://api.getpostman.com").
                header("X-Api-Key", autho).
                body(obj).
                when().
                post("/workspaces").
                then().
                log().all().
                assertThat().
                statusCode(200);
    }
}
