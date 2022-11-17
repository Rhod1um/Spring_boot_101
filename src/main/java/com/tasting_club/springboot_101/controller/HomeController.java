package com.tasting_club.springboot_101.controller;

import com.tasting_club.springboot_101.model.Person; //importere package, ikke Person
import com.tasting_club.springboot_101.model.*; //kan også gøres sådan - import alt fra den package
//men at tage alt fra et import kan gøre den langsommere
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class HomeController {

    //gamle dage brugte man requestmapping, gør det samme som getmapping og postmapping
    /*@RequestMapping(value="/", method= RequestMethod.GET)
    public String index(){
        return "index";
    }*/
    //lav block comment - highlight -> "Code" i øvre menu -> comment with block comment

    @GetMapping("/")
    public String index(){ //controller kontakter view og får et view tilbage
        return "home/index"; //det virker med undermappe!
    }

    /*@PostMapping("/personData") //metode behøver ikke det samme som endpointet men man gør det så det passer sammen
    //postmapping tager webrequest ind som er formen, og model fordi data fra formen skal sendes videre
    public String personData(WebRequest request, Model model){
        String firstName = request.getParameter("fname"); //tager fname fra formen
        String lastName = request.getParameter("lname");

        model.addAttribute("first_name", firstName); //smider det i model så vi kan printe det ud
        model.addAttribute("last_name", lastName); //MÅ IKKE HAVE BINDESTREG - må være pga thymeleaf

        return "home/personData";
    }*/ //hvis 404 fejl, det endpoint formen vil gå til er forkert

    //"string" er string literal - med quotes

    //her gør vi samme som sidst men laver Person objekt og sender ud
    @PostMapping("/personData") //metode behøver ikke det samme som endpointet men man gør det så det passer sammen
    //postmapping tager webrequest ind som er formen, og model fordi data fra formen skal sendes videre
    public String personData(@ModelAttribute Person person, Model model){
        //@Modelattribute laver objekter af Personklassen, attributtere i
        //person klassen SKAL hedde det samme som i html formen, derfor blev fname og lname
        //ændret til first_name og last_name i formen så de passer med javaklassen og er mere læseligt.
        //Personattributterne kunne også bare blive fname og lname
        //@Modelattribute laver faktisk ikke et objekt af Person men den kan bruge dens attributter
        //og poste det til html'en
        //det laver en slags objekt, men det er ikke noget vi ser eller har kontakt til

        model.addAttribute("Person", person);


        return "home/personData";
    }

}
