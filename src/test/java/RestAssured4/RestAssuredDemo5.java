package RestAssured4;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class RestAssuredDemo5 {
    String testkey5 = "PMAK-610b56adab72d200347abc79-c0c3d2ade8284ed614605fa06ec2dc1191";

    @Test
    public void validategetrequest5() {
        given().
                baseUri("https://api.getpostman.com").
                header("x-api-key", "testkey5").
                when().
                get("/workspaces").
                then().
                log().all().
                assertThat().
                statusCode(200);
//                    body("workspaces.name", hasItem("My Workspace"),
//                            "workspaces.type", hasItem("personal"),
//                    "workspaces[0].name", equalTo("My Workspace"),
//                            "workspaces.size()", equalTo(1));
    }

    @Test
    public void validategetallworkspaces() {
        given().
                baseUri("https://api.getpostman.com").
                header("x-api-key", "testkey5").
                when().
                get("/workspaces").
                then().
                log().all().
                assertThat().
                statusCode(200).
                body("workspaces.name", hasItems("Arafat_Workspace", "New Workspace", "New Workspace",
                        "Khanom Workspace", "Khanom Workspace", "JOBAYDA's Workspace", "New Workspace", "New Workspace",
                        "New Workspace", "My Workspace", "JO's Workspace", "Arafat_Workspace", "New Workspace", "New Workspace",
                        "Team Workspace", "New Workspace", "Khanom Workspace", "New Workspace", "Arafat_Workspace",
                        "New Workspace", "New Workspace", "New Workspace"),
                        "workspaces.type", hasItems("personal", "personal", "personal", "personal",
                                "personal", "team", "personal", "personal", "personal", "personal", "team", "personal", "personal",
                                "personal", "team", "personal", "personal", "personal", "personal", "personal", "personal", "personal"),
                        "workspaces[8].name", equalTo("My Workspace"),
                        "workspaces.size()", equalTo(22));

    }

}
