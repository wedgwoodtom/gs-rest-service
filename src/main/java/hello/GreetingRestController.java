package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// This code uses Spring 4’s new @RestController annotation, which marks the class as a controller where every
// method returns a domain object instead of a view.
//  Because Jackson 2 is on the classpath, Spring’s MappingJackson2HttpMessageConverter is automatically
// chosen to convert the Greeting instance to JSON.
@RestController
public class GreetingRestController
{
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name)
    {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}