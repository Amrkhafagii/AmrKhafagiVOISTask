package scenarios;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class restClass {

    public static String userId = "1";

    @Test(priority = 1)
    public void getUserIdPrintEmail() {
/*
        given().get("https://jsonplaceholder.typicode.com/users/1").then().statusCode(200).
                body("email", equalTo("Sincere@april.biz"));

               */

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("https://jsonplaceholder.typicode.com/users/" + userId);
        JsonPath jsonPathEvaluator = response.jsonPath();
        String email = jsonPathEvaluator.get("email");
        System.out.println("email of the user " + email);


    }

    @Test(priority = 3)
    public void postPosts() {

        JSONObject request = new JSONObject();
        request.put("id", 4);
        request.put("title", "Post 4");
        request.put("userId", userId);
        request.put("body", "I love automation and created new post");

        given()
                .body(request.toJSONString())
                .when().post("https://my-json-server.typicode.com/amrkhafagii/demo/posts/")
                .then().statusCode(201);

    }


    @Test(priority = 2)
    public void getSpecificUserPosts() {
        /*
        given().get("https://jsonplaceholder.typicode.com/posts?userId=1"+userId)
                .then().statusCode(200)
                .body("id", greaterThanOrEqualTo(1))
                .body("id", lessThanOrEqualTo(100));
                */
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("https://jsonplaceholder.typicode.com/posts?userId=" + userId);
        JsonPath json = new JsonPath(response.asString());
        //System.out.println(json);
        int sizes = json.getInt("id.size()");
        for (int i = 0; i < sizes; i++) {
            //String try=json.getString();
            int num = json.getInt("id[" + i + "]");
            if (num > 0 && num < 101)
                System.out.println(num);
        }


    }
}
