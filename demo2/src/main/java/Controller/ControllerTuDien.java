package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/tuDien")
public class ControllerTuDien {

    static final String[] VN = {"Qua dua hau", "Qua cam", "Qua xoai", "Qua dua", "Qua chanh"};
    static final String[] US = {"Water Melon", "Orange", "Mango", "Pineapple", "Lemon"};

    @GetMapping("")
    public String tuDien(){
        return "/index";
    }


    @PostMapping("")
    public String search(@RequestParam String tiengAnh, Model model){
        if (check(tiengAnh) != -1){
            String tiengViet = VN[check(tiengAnh)];
            model.addAttribute("tiengViet",tiengViet);
        }else
            model.addAttribute("message","Không tìm thấy");

        return "/index";
    }

    public int check(String tiengAnh){
        for (int i = 0; i < US.length; i++) {
            if (US[i].equals(tiengAnh)  ) return i;
        }
        return -1;
    }
}
