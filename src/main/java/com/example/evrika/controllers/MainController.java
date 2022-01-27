package com.example.evrika.controllers;

import com.example.evrika.models.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sun.jna.platform.win32.Netapi32Util;

@Controller
public class MainController {
    public boolean flag = false;

    @GetMapping("/greeting")
    public String greeting(Model model) {
        return "home";
    }

    @RequestMapping(value="/greeting", params="button")
    public String button(@RequestParam String userName, Model model) {
        flag = false;
        UserModel userModel = new UserModel();
        userModel.setName(userName);
        model.addAttribute("user", userModel);
        Netapi32Util.User[] users = Netapi32Util.getUsers();
        for(Netapi32Util.User user : users) {
            System.out.println(user.name);
            if(userName.equals(user.name))
                flag = true;
        }
        if(flag && !userName.equals(""))
        {
            System.out.println("Exists");
            return "exists";
        }
        else if(!flag && !userName.equals("")){
            System.out.println("Not exists");
            return "notexists";
        }
        return "home";
    }
}
