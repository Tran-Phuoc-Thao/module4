package controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/CaCuLaTor")
public class ControllerCaculator {


    @GetMapping("")
    public String showCheck(){
        return "index";
    }

    @PostMapping("/result")
    public String save(@RequestParam float operand1, @RequestParam float operand2, @RequestParam String operator, Model model) {
        float result = 0;
        switch (operator) {
            case "+" :
                result = operand1 + operand2 ;
                break;
            case "-":
                result = operand1 - operand2 ;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if(operand2 != 0){
                result = operand1 / operand2;}
                else {
                    model.addAttribute("message","Mẫu không được bằng 0");
                    return "index";
                }
                break;
        }
        model.addAttribute("result", result);
        return "index";
    }

}
