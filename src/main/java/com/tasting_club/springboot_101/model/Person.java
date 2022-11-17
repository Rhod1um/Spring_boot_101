package com.tasting_club.springboot_101.model;

public class Person {
    private String first_name, last_name;
    private int age;

    public String getFirst_name()   {return first_name;}
    public String getLast_name()    {return last_name;}
    public int getAge()             {return age;}

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
