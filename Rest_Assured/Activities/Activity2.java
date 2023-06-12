package Activities;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity2 {
    @Test(priority = 1)
    public void postpetdetails() throws IOException {
        baseURI="https://petstore.swagger.io/v2/user";
        FileInputStream fis=new FileInputStream("src//test//resources//reqbody.json");
        String reqbody=new String(fis.readAllBytes());
        Response response=given().contentType(ContentType.JSON).body(reqbody).when().post(baseURI);
        String responsebody=response.getBody().toString();
        System.out.println(responsebody);
        response.then().body("code",equalTo(200));
        response.then().body("message",equalTo("9991"));
    }
    @Test(priority = 2)
    public void getpetdetails(){
        baseURI="https://petstore.swagger.io/v2/user/";
        Response response=given().contentType(ContentType.JSON).pathParam("username","indra1").when().get(baseURI+"{username}");
        String responsebody=response.getBody().prettyPrint();
        System.out.println(responsebody);

        response.then().body("id",equalTo(9991));
        response.then().body("username",equalTo("indra1"));
        response.then().body("firstName",equalTo("Justin"));
        response.then().body("lastName",equalTo("Case"));
        response.then().body("email",equalTo("justincase@mail.com"));
        response.then().body("password",equalTo("password123"));
        response.then().body("phone",equalTo("9812763450"));


    }
    @Test(priority=3)
    public void deletepetdetails(){
        baseURI="https://petstore.swagger.io/v2/user/";
        Response response=given().contentType(ContentType.JSON).pathParam("username","indra1").when().delete(baseURI+"{username}");
        String responsebody=response.getBody().prettyPrint();
        System.out.println(responsebody);

        response.then().body("code",equalTo(200));
        response.then().body("message",equalTo("indra1"));


    }

}
