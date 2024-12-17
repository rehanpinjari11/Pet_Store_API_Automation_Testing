package api_automation;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Pet_Store_Automation {

    @Test
    public void createUser() {
        given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"username\": \"rehan1107\",\n" +
                        "  \"firstName\": \"rehan\",\n" +
                        "  \"lastName\": \"pinjari\",\n" +
                        "  \"email\": \"rehanp@gmail.com\",\n" +
                        "  \"password\": \"12345678\",\n" +
                        "  \"phone\": \"8421620220\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .statusCode(200);
    }

    @Test
    public void createWithArray() {
        given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 2,\n" +
                        "    \"username\": \"johndoe\",\n" +
                        "    \"firstName\": \"john\",\n" +
                        "    \"lastName\": \"doe\",\n" +
                        "    \"email\": \"johndoe@gmail.com\",\n" +
                        "    \"password\": \"Password2\",\n" +
                        "    \"phone\": \"1234567890\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  },\n" +
                        "{\n" +
                        "    \"id\": 3,\n" +
                        "    \"username\": \"james\",\n" +
                        "    \"firstName\": \"James\",\n" +
                        "    \"lastName\": \"Bond\",\n" +
                        "    \"email\": \"jamesbond@gmail.com\",\n" +
                        "    \"password\": \"Password3\",\n" +
                        "    \"phone\": \"2345678901\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }\n" +
                        "]")
                .post("https://petstore.swagger.io/v2/user/createWithArray")
                .then()
                .statusCode(200);
    }


    @Test
    public void createWithList() {
        given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 4,\n" +
                        "    \"username\": \"tom11\",\n" +
                        "    \"firstName\": \"Tom\",\n" +
                        "    \"lastName\": \"parker\",\n" +
                        "    \"email\": \"tomrizz@gmail.com\",\n" +
                        "    \"password\": \"Password4\",\n" +
                        "    \"phone\": \"9876543210\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  },\n" +
                        "{\n" +
                        "    \"id\": 5,\n" +
                        "    \"username\": \"peterparker\",\n" +
                        "    \"firstName\": \"Peter\",\n" +
                        "    \"lastName\": \"Parker\",\n" +
                        "    \"email\": \"peterparker@gmail.com\",\n" +
                        "    \"password\": \"Password5\",\n" +
                        "    \"phone\": \"9867952164\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }\n" +
                        "]")
                .post("https://petstore.swagger.io/v2/user/createWithList")
                .then()
                .statusCode(200);
    }

    @Test
    public void getUser(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/rehan1107");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void userLogin(){
        given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/login?username=rehan1107&password=12345678")
                .then()
                .statusCode(200);

    }

    @Test
    public void userLogout(){
        given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/logout")
                .then()
                .statusCode(200);

    }

    @Test
    public void userUpdate(){
        given()

                .accept("application/json")
                .contentType("application/json")
                .when()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"vikashjd\",\n" +
                        "  \"firstName\": \"Vikash\",\n" +
                        "  \"lastName\": \"Jadhao\",\n" +
                        "  \"email\": \"vikashjadhao@gmail.com\",\n" +
                        "  \"password\": \"Password12\",\n" +
                        "  \"phone\": \"877855412360\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")

                .put("https://petstore.swagger.io/v2/user/james")
                .then()
                .statusCode(200);
    }

    @Test
    public void deleteUser(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/user/james");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void postStore(){
        given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"petId\": 1,\n" +
                        "  \"quantity\": 1,\n" +
                        "  \"shipDate\": \"2024-11-18T08:37:22.661Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")

                .post("https://petstore.swagger.io/v2/store/order")
                .then()
                .statusCode(200);

    }

    @Test
    public void getStoreInventory(){
        given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory")
                .then()
                .statusCode(200);
    }

    @Test
    public void getOrderId(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/9");
        res.then().assertThat().statusCode(404);
        res.prettyPrint();

    }

    @Test
    public void deleteOrder(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/store/order/9");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void postPetToStore(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 1,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")

                .post("https://petstore.swagger.io/v2/pet");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void uploadImage(){
        Response res = given()
                .accept("application/json")
                .contentType("multipart/form-data")
                .when()
                .post("https://petstore.swagger.io/v2/pet/1/uploadImage");
        res.then().assertThat().statusCode(400);
        res.prettyPrint();

    }

    @Test
    public void updatePet(){
        Response res = given()
                .accept("application/json")
                .contentType("multipart/form-data")
                .when()
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"Cat\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 1,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")

                .put("https://petstore.swagger.io/v2/pet");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void getPetById(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/8");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void postPetInStore(){
        Response res = given()
                .accept("application/json")
                .contentType("application/x-www-form-urlencoded")
                .when()
                .body("\"id\": 5,\n" +
                        "        \"category\": {\n" +
                        "            \"id\": 1,\n" +
                        "            \"name\": \"Dog\"\n" +
                        "        },\n" +
                        "        \"name\": \"Max\",\n" +
                        "        \"photoUrls\": [\n" +
                        "            \"http://example.com/photo1.jpg\"\n" +
                        "        ],\n" +
                        "        \"tags\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"friendly\"\n" +
                        "            }\n" +
                        "        ],\n" +
                        "        \"status\": \"available\"\n" +
                        "    }\n" +
                        "    \"\"\"")
                .post("https://petstore.swagger.io/v2/pet/5");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void findByStatus(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
}
