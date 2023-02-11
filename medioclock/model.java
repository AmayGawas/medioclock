package com.example.medioclock;

import androidx.annotation.NonNull;

public class model {
    String administration_route,age_group,category,group,habit_forming,name,product_form,side_effects,used_for;


    model(){

    }


    public model(String administration_route, String age_group, String category, String group, String habit_forming, String name, String product_form, String side_effects, String used_for) {
        this.administration_route = administration_route;
        this.age_group = age_group;
        this.category = category;
        this.group = group;
        this.habit_forming = habit_forming;
        this.name = name;
        this.product_form = product_form;
        this.side_effects = side_effects;
        this.used_for = used_for;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAdministration_route() {
        return administration_route;
    }

    public void setAdministration_route(String administration_route) {
        this.administration_route = administration_route;
    }

    public String getAge_group() {
        return age_group;
    }

    public void setAge_group(String age_group) {
        this.age_group = age_group;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



    public String getHabit_forming() {
        return habit_forming;
    }

    public void setHabit_forming(String habit_forming) {
        this.habit_forming = habit_forming;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct_form() {
        return product_form;
    }

    public void setProduct_form(String product_form) {
        this.product_form = product_form;
    }

    public String getSide_effects() {
        return side_effects;
    }

    public void setSide_effects(String side_effects) {
        this.side_effects = side_effects;
    }

    public String getUsed_for() {
        return used_for;
    }

    public void setUsed_for(String used_for) {
        this.used_for = used_for;
    }
}
