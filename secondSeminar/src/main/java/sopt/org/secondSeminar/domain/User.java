package sopt.org.secondSeminar.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {

    private Long id;

    private String gender;

    private String name;

    private String contact;

    private int age;

    public User(String gender, String name, String contact, int age) {
        this.gender = gender;
        this.name = name;
        this.contact = contact;
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
