package alishev.Controller;

import alishev.DAO.personDAO;
import alishev.model.person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstController {

 @GetMapping("/hello") public String helloPage(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "surname", required = false) String surname, Model model) {
       model.addAttribute("message", "hello " + name + surname);
       return "first/hello";
   }

    @GetMapping("/bye")
    public String good() {
        return "first/good";
    }

    @GetMapping("/person")
    public String text() {
        return "Second/Person";
    }
//
//    @GetMapping("/calculate")
//    public String cacl(@RequestParam(value = "number",required = false) int number,
//                       @RequestParam(value="number2") int number2,
//                       @RequestParam(value = "name",required = false) String name,Model alishev.model){
//        double result;
//        switch (name){
//            case "mulctipclicatin":
//              result =number+number2;
//              break;
//            case "addition":
//                result=number-number2;
//                break;
//            default:
//                result=0;
//                break;
//        }
//        alishev.model.addAttribute("result",result);
//        return "first/calculate";


    personDAO personDAO;

    public FirstController(personDAO personDAO) {
        this.personDAO = personDAO;
    }


    @GetMapping("/people")
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/show";


    }
    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person",new person());
        return "people/new";
    }
    @PostMapping("/post")
    public String crate(@ModelAttribute("person")person person){
        personDAO.save(person);
        return "redirect://post";

    }
}




