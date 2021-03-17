package com.profileService.profile.controller;


import com.profileService.profile.Repository;
import com.profileService.profile.model.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProfileController {
    Repository rep = new Repository();


    @GetMapping("/profiles")
    public Profile profile(@RequestParam(value = "name", required = true) String name) {
        return rep.peoplebyName(name);
    }

    @PostMapping("/profiles")
    public Profile newProfile(@RequestParam(value = "name", required = true) String  name) {
        long id = Repository.profileIdSequence.incrementAndGet();
        Profile profile1 = new Profile(id, name);
        rep.addPeople(profile1);
        return profile1;
    }


    @PutMapping("/profiles")
    public Profile updateProfile(@RequestParam(value = "name", required = true) String  name,
                                 @RequestParam(value = "lastName", required = true) String lastName,
                                 @RequestParam(value = "position") String position) {

        Profile profile = rep.peoplebyName(name);
        profile.setLastName(lastName);
        profile.setPosition(position);
        rep.updatePeople(profile);
        return profile;
    }
}
