myRetail RESTful service

This is the repository for the myRetail products API.

Prerequisites

JDK 1.7
Maven 3.3 embedded with Spring BOOT 
To build, test and run

First, navigate to /code.

cd code
Next, clean install maven

mvn clean install

Finally, start the application by executing  jar with java

java -jar target\myRetailApi-0.0.1-SNAPSHOT.jar

Interacting with the application:

Example 1:Getting product details (positive test case).

Performing a GET request on the url http://localhost:8080/myRetailApi/product/{id} will return a JSON object containing the name and pricing info for the requested product.

GET http://localhost:8080/myRetailApi/products/13860428

response:
{
    "id": 13860428,
    "name": "The Big Lebowski (Blu-ray)",
    "current_price": {
        "value": 13.89,
        "currency_code": "USD"
    }
}


Example 2: Updating product details (positive test case)

To set the price of an item, perform a PUT request to the same URL with the request body being a JSON object containing the id & updated pricing information.


PUT  http://localhost:8080/myRetailApi/products/13860428
content-type: application/json;charset=UTF-8
body:
{
    "id": 13860428,
    "name": "The Big Lebowski (Blu-ray)",
    "current_price": {
        "value": 14.25,
        "currency_code": "USD"
    }
}

{
    "id": 13860428,
    "name": "The Big Lebowski (Blu-ray)",
    "current_price": {
        "value": 14.25,
        "currency_code": "USD"
    }
}

Example 3: Getting product details (negative test case)

GET http://localhost:8080/myRetailApi/products/1386042

Response:
{
    "url": "http://localhost:8080/myRetailApi/products/1386042",
    "message": "No Data exists!!",
    "errorCode": "ERR_NO_DATA"
}