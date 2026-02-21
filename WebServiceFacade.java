import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webservice")
public class WebServiceFacade {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @PostMapping("/sumar")
    public int sumar(@RequestBody int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}