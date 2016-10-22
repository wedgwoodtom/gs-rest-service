package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 *  This web application is 100% pure Java and you didn’t have to deal with configuring any plumbing or
 *  infrastructure.
 *
 *  You package everything in a single, executable JAR file, driven by a good old Java main() method.
 *  Along the way, you use Spring’s support for embedding the Tomcat servlet container as the HTTP runtime,
 *  instead of deploying to an external instance.
 *
 * http://localhost:8080/greeting
 *
 * Great tutorials here: https://spring.io/guides/gs/rest-service/
 *
 * @SpringBootApplication is a convenience annotation that adds all of the following:

 @Configuration tags the class as a source of bean definitions for the application context.

 @EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings,
 other beans, and various property settings.
 Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically
 when it sees spring-webmvc on the classpath. This flags the application as a web application and
 activates key behaviors such as setting up a DispatcherServlet.

 @ComponentScan tells Spring to look for other components, configurations, and services in the
 the hello package, allowing it to find the HelloController.
 The main() method uses Spring Boot’s SpringApplication.run() method to launch an application.
 *
 *
 * Then you can run the JAR file:
 java -jar target/gs-rest-service-0.1.0.jar
 or, just run with an IDEA SpringBoot run config
 */

@SpringBootApplication
public class Application
{
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Resource
    private QuoteClient quoteClient;

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init()
    {
        // start your monitoring in here
        quoteClient.getRandomQuote();
        quoteClient.getRandomQuote();
        quoteClient.getRandomQuote();
    }
}
