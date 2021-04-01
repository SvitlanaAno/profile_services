package com.profileService.profile.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Profile {

    private long id;
    private String name;
    private String firstName;
    private String lastName;
    private String headline;
    private String position;
    private String about;
    private List<String> experiences;
    private List<String> educations;

    public Profile(){

    }

    public Profile(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Profile(long id, String name, String lastName, String position) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.position = position;
    }

    public Profile(long id, String name, String lastName, String position, String education, String about, String experience) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.position = position;
        this.about = about;
        this.educations = new ArrayList<>();
        educations.add(education);
        this.experiences = new ArrayList<>();
        experiences.add(experience);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getExperience() {
        return experiences.get(0);
    }
    public List<String> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<String> experiences) {
        this.experiences = experiences;
    }

    public List<String> getEducations() {
        return educations;
    }
    public String getEducation() {
        return educations.get(0);
    }

    public void setEducations(List<String> educations) {
        this.educations = educations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return id == profile.id &&
                Objects.equals(name, profile.name) &&
                Objects.equals(firstName, profile.firstName) &&
                Objects.equals(lastName, profile.lastName) &&
                Objects.equals(headline, profile.headline) &&
                Objects.equals(position, profile.position) &&
                Objects.equals(about, profile.about) &&
                Objects.equals(experiences, profile.experiences) &&
                Objects.equals(educations, profile.educations);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, firstName, lastName, headline, position, about, experiences, educations);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", headline='" + headline + '\'' +
                ", position='" + position + '\'' +
                ", about='" + about + '\'' +
                ", experiences=" + experiences +
                ", educations=" + educations +
                '}';
    }
}