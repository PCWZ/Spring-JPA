package sg.edu.ntu.simplecrm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller
// @ResponseBody
@RestController
public class HomeController {

  @GetMapping("/home")
  public String home() {
    return "home";
  }

}
