import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WebServiceFacade {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("/sumar")
    public int sumar(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }
}