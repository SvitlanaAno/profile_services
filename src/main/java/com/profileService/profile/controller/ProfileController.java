package com.profileService.profile.controller;


import com.profileService.profile.Repository;
import com.profileService.profile.errors.NameIsAlreadyTakenException;
import com.profileService.profile.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class ProfileController {
    private Repository rep = new Repository();


    @GetMapping("/profiles")
    public @ResponseBody Profile profile(@RequestParam(value = "name", required = true) String name) {

        return rep.peoplebyName(name);
    }


    @GetMapping("")
    public String viewHomePage() {
        rep.clearAll();
        return "index";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new Profile());
        return "profilePage";
    }

    @PostMapping("/process_register")
    public String processRegistration(Profile user){

        long id = Repository.profileIdSequence.incrementAndGet();
        Profile profile1 = new Profile(id, user.getName(), user.getLastName(), user.getPosition(),  user.getEducation(), user.getAbout(), user. getExperience());
        try {
            rep.addPeople(profile1);
        }catch (NameIsAlreadyTakenException e){
            return "name_is_taken";
        }
        return "register_success";
    }

    @PostMapping("/profiles")
    public Profile newProfile(@RequestParam(value = "name", required = true) String  name,
                              @RequestParam(value = "lastName", required = true) String lastName,
                              @RequestParam(value = "position", required = true) String position,
                              @RequestParam(value = "educations") String education,
                              @RequestParam(value = "about") String about,
                              @RequestParam(value = "experiences") String experience) {
        long id = Repository.profileIdSequence.incrementAndGet();
        Profile profile1 = new Profile(id, name, lastName, position, education, about, experience);
        rep.addPeople(profile1);
        return profile1;
    }


    @PutMapping("/profiles")
    public Profile updateProfile(@RequestParam(value = "name", required = true) String  name,
                                 @RequestParam(value = "lastName", required = true) String lastName,
                                 @RequestParam(value = "position") String position,
                                 @RequestParam(value = "educations") String education,
                                 @RequestParam(value = "about") String about,
                                 @RequestParam(value = "experiences") String experience) {

        Profile profile = rep.peoplebyName(name);
        profile.setLastName(lastName);
        profile.setPosition(position);
        profile.setAbout(about);
        rep.updatePeople(profile);
        return profile;
    }
}
