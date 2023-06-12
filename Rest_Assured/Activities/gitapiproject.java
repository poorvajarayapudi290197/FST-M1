package examples;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class gitapiproject {
    RequestSpecification reqspec;
    ResponseSpecification respspec;
    String SSHKey;
    int keyid;

    @BeforeClass
    public void setup() {
        SSHKey="ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIFSJbTh3FV9gRsgwZpXnWGO1S8vxARUPfMfZDiSnPbfB";

        reqspec = new RequestSpecBuilder().setBaseUri("https://api.github.com")
                .setContentType(ContentType.JSON).
                addHeader("Authorization","token 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").build();


        respspec = new ResponseSpecBuilder().build();

        // Build response specification

    }


    @Test(priority=1)
    public void postdetails(){
        Map<String,String> map=new HashMap<>();
        map.put("title","TestAPIKey");
        map.put("key",SSHKey);


        Response response =given().spec(reqspec).body(map).when().post("/user/keys");
        String responseBody=response.asPrettyString();
        System.out.println(responseBody);




        // Assertions

        keyid=response.then().spec(respspec).extract().path("id");
        System.out.println(keyid);
        response.then().spec(respspec).statusCode(201);


    }

    @Test(priority=2)
    public void getData(){
        Response response =given().spec(reqspec).pathParam("keyId",keyid).when().get("/user/keys/{keyId}");
        String responseBody=response.asPrettyString();
        System.out.println("Response Body is =>  " + responseBody);

        // Assertions
        response.then().spec(respspec).statusCode(200);
    }
    @Test(priority=3)
    public void deleteData(){
        Response response =given().spec(reqspec).pathParam("keyId",keyid).when().delete("/user/keys/{keyId}");
        String responseBody=response.asPrettyString();
        System.out.println("Response Body is =>  " + responseBody);

        // Assertions
        response.then().spec(respspec).statusCode(204);
    }

}