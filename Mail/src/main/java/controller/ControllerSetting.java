package controller;


import modal.SettingsMail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
@RequestMapping("/Mail")
public class ControllerSetting {

    @GetMapping("")
    public String showCheck(Model model){
        model.addAttribute("settingsMail",new SettingsMail());
        model.addAttribute("languagesList",new String[]{"English" ,"Vietnamese"," Japanese","Chinese"});
        model.addAttribute("pageSizeList",new String[]{"5","10","15","20","25"});
        return "index";
    }

    @PostMapping("")
    public ModelAndView save(@ModelAttribute SettingsMail settingsMail){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("mess","thanh cong");
        modelAndView.addObject("mail", settingsMail.toString());
        return  modelAndView ;
    }



}
