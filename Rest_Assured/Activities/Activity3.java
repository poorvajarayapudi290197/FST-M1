package Activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.*;

import static org.hamcrest.CoreMatchers.equalTo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity3 {
    RequestSpecification reqspec;
    ResponseSpecification respspec;

    @BeforeClass
    public void setup() {
        reqspec = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri("https://petstore.swagger.io/v2/pet").build();


        respspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType("application/json").
                expectBody("status", equalTo("alive"))
                // Build response specification
                .build();
    }
    @DataProvider
    public Object[][] petInfoProvider() {
        // Setting parameters to pass to test case
        Object[][] testData = new Object[][] {
                { 77232, "Riley", "alive" },
                { 77233, "Hansel", "alive" }
        };
        return testData;
    }

    @Test(priority=1)
    public void postdetails(){

        String reqBody=// For pet 1
                "{\"id\": 77232, \"name\": \"Riley\", \"status\": \"alive\"}";
        Response response =given().spec(reqspec).body(reqBody).when().post();


        reqBody=  "{\"id\": 77233, \"name\": \"Hansel\", \"status\": \"alive\"}";
        response =given().spec(reqspec).body(reqBody).when().post();
        response.then().spec(respspec);


    }
    @Test(dataProvider = "petInfoProvider",priority = 2)
    public void getdetails(int id, String name, String status){


        Response response =given().spec(reqspec).pathParam("petId",id).when().get("/{petId}");
        String responseBody=response.asPrettyString();
        System.out.println("Response Body is =>  " + responseBody);

        // Assertions
        response.then().spec(respspec).body("name", equalTo(name));


    }
    @Test(dataProvider = "petInfoProvider",priority = 3)
    public void deletedetails(int id, String name, String status){


        Response response =given().spec(reqspec).pathParam("petId",id).when().delete("/{petId}");
        String responseBody=response.asPrettyString();
        System.out.println("Response Body is =>  " + responseBody);

        // Assertions
        response.then().body("code", equalTo(200));
    }
}
