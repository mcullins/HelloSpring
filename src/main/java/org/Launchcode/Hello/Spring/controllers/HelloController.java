package org.Launchcode.Hello.Spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello " + name + "!";
    }

    @PostMapping("languageHello")
    public static String createMessage(@RequestParam String name, @RequestParam String language){
        if (language.equals("english")){
            return "<html>" +
                    "<body>" +
                    "<h1 style='color:red; text-align:center;'>Hello " + name + "!</h1>" +
                    "</body>" +
                    "</html>";
        } else if (language.equals("french")){
            return "<html>" +
                    "<body>" +
                    "<h1 style='color:blue; text-align:center;'>Bonjour " + name + "!</h1>" +
                    "</body>" +
                    "</html>";
        } else if (language.equals("spanish")){
            return "<html>" +
                    "<body>" +
                    "<h1 style='color:yellow; text-align:center;'>Hola " + name + "!</h1>" +
                    "</body>" +
                    "</html>";
        } else if (language.equals("german")){
            return "<html>" +
                    "<body>" +
                    "<h1 style='color:orange; text-align:center;'>Hallo " + name + "!</h1>" +
                    "</body>" +
                    "</html>";
        } else if (language.equals("swahili")){
            return "<html>" +
                    "<body>" +
                    "<h1 style='color:green; text-align:center;'>Habari " + name + "!</h1>" +
                    "</body>" +
                    "</html>";
        } else {
            return "Something didn't jive. Try again";
        }
    }

    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello " + name + "! Woo!";
    }

    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type = 'text' name='name'>" +
                "<input type = 'submit' value='greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("languageForm")
    public static String helloLanguageForm(){
        return "<html>" +
                "<body>" +
                "<form action='languageHello' method='post'>" +
                "<input type = 'text' name='name'>" +
                "<select name ='language'>" +
                "<option value ='english'>English</option>" +
                "<option value ='french'>French</option>" +
                "<option value ='spanish'>Spanish</option>" +
                "<option value ='german'>German</option>" +
                "<option value ='swahili'>Swahili</option>" +
                "</select>" +
                "<input type = 'submit' value='greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
