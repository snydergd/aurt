package xyz.snydergd.aurt.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HelloController
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String getName(Model model) {
        DefaultOAuth2User myUser = (DefaultOAuth2User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        myUser.getAttributes().forEach((x,y) -> {
            System.err.println("user attribute: " + x + " = " + y);
        });
        model.addAttribute("user", myUser.getAttributes());
        System.err.println("vals");
        model.asMap().forEach((x,y) -> {
            System.err.println(x + ": " + y);
        });
        return "test";
    }
    
}