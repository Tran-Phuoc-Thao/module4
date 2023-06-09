package Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;


@Controller
@RequestMapping("/sandwich")
public class ControllerSandWich {

    @GetMapping(value = "")
    public String show(){
        return "/index";
    }

    @PostMapping(value = "/choose")
    public String show2(@RequestParam("condiment") String[] condiment, Model model){
        if(condiment != null){
        model.addAttribute("giaVi", Arrays.toString(condiment));
        }else model.addAttribute("message","Không có gia vị nào");
        return "/index";
    }

}
