RESTful App sample in Java  
This App is a RESTful API which receive HTTP requests like GET and return a JSON object as a response.
Initial code (scaffolding architecture) created with "Sprint Initializr" (https://start.spring.io/) having JAR as packaging which has Tomcat embedded.

REST APIs available:  
GET http://localhost:8080/greeting  
GET http://localhost:8080/greeting?name=<provide your name>  
POST http://localhost:8080/greeting  
POST http://localhost:8080/greeting?greeting-message=<provide new greeting>  
  
GET http://localhost:8080/vehicle  
GET http://localhost:8080/vehicle?id=<provide vehicle id>  
POST http://localhost:8080/vehicle (Body JSON as below)  
{  
    "id": 5,  
    "model": "Ferrari",  
    "manufacturer": "Fiat"  
}  
  
Tips:  
0- run the app: "mvnw spring-boot:run"; or packaging (JAR) & run: "mvnw clean package" and "java -jar target/gs-rest-service-0.1.0.jar"
1- This application uses the Jackson JSON library to automatically marshal instances of type Greeting into JSON. Jackson is included by default by the web starter. This is how it works - Thanks to Spring’s HTTP message converter support, you need not do this conversion manually. Because Jackson 2 is on the classpath, Spring’s MappingJackson2HttpMessageConverter is automatically chosen to convert the Greeting instance to JSON.
2- Tomcat web server is embedded in this project, so when running through spring-boot or packaging (JAR file) the app will run under the Tomcat.
3- In case you need a .WAR file to deploy the app in a Web server container (not the embedded Tomcat) checkout the link "convert-jar-to-war" in the References section OR create the java project through "Spring Initializr" and set the packaging as WAR instead of JAR.  


References:  
RESTful Get Started Tutorial with Spring - https://spring.io/guides/gs/rest-service/  
Spring Initializr - https://start.spring.io/  
Convert JAR to WAR - https://spring.io/guides/gs/convert-jar-to-war/  
Tutorial with JSON Body examples - https://mari-azevedo.medium.com/construindo-uma-api-restful-com-java-e-spring-framework-46b74371d107  
JSON library toolkit - https://code.google.com/archive/p/json-simple/