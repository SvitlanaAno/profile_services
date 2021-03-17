package com.profileService.profile;

import com.profileService.profile.errors.NameIsAlreadyTakenException;
import com.profileService.profile.errors.NoDataFoundException;
import com.profileService.profile.errors.ProfileNotFoundException;
import com.profileService.profile.model.Profile;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

//Fake Database
public class Repository {
    static Map<String, Profile> people = new Hashtable<>();
    public static final AtomicLong profileIdSequence = new AtomicLong();

    static {
        people.put("Sveta", new Profile(profileIdSequence.incrementAndGet(), "Sveta", "Anoshchenko", "SE"));
        people.put("Ivan", new Profile(profileIdSequence.incrementAndGet(), "Ivan"));
        people.put("Andriy", new Profile(profileIdSequence.incrementAndGet(), "Andriy"));
    }

    public Profile peoplebyName(String name){
        if(!people.containsKey(name)){
            throw new ProfileNotFoundException(
                    String.format("Profile with name=%s not found.", name));
        }
        return people.get(name);
    }

    public Profile addPeople(Profile p){
        if (people.containsKey(p.getName())) {
            throw new NameIsAlreadyTakenException(
                    String.format("Name=%s is already taken.", p.getName()));
        }
        people.put(p.getName(), p);
        return p;
    }
    public Profile updatePeople(Profile p){
        if (!people.containsKey(p.getName())) {
            throw new NoDataFoundException();
        }
        people.put(p.getName(), p);
        return p;
    }
}
