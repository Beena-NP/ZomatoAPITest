package zomatotests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ZomatoApiTests {
   /* Generate API Key in the "https://developers.zomato.com/api#headline1" by providing the name, email id,
   phone number and company/blog url
   */
    String apiKey = " ";

    @Test (priority = 0)
    public void getAllCategories()
    {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("user-key", apiKey);
        headers.put("Content-Type", "application/json");

        Response res = given()
                .headers(headers)
                .get("https://rapidapi.io/connect/Zomato/categories");
        Assert.assertEquals(res.statusCode(), 200);
        System.out.println(res.prettyPeek());

    }

    @Test(priority = 1)

    public void getCities()
    {
        Map<String, String> head = new HashMap<String, String>();
        head.put("user-key", apiKey);
        head.put("Content-Type", "application/json");
        String reqBody = "{\n\"cityIds\": \"280\"\n}";

        Response resp = given()
                .headers(head)
                .body(reqBody)
                .get("https://rapidapi.io/connect/Zomato/cities");
        Assert.assertEquals(resp.statusCode(), 200);
        System.out.println(resp.prettyPeek());

    }
}
