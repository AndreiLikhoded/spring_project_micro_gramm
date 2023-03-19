package com.example.boot_project.entity;


import com.example.boot_project.util.Generator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Publication publication;

    private String name;
    private String login;
    private String email;
    private int id;
    private int age;
    private String password;
    private int numberOfPublications;
    private int numberOfSubscribes;
    private int numberOfSubscribers;


    public static User random() {
        return builder()
                .email(Generator.makeEmail())
                .name(Generator.makeName())
                .build();
    }


//    public User(String name, String login, String email, int id, int age, String password, int numberOfPublications, int numberOfSubscribes, int numberOfSubscribers) {
//        this.name = name;
//        this.login = login;
//        this.email = email;
//        this.id = id;
//        this.age = age;
//        this.password = password;
//        this.numberOfPublications = numberOfPublications;
//        this.numberOfSubscribes = numberOfSubscribes;
//        this.numberOfSubscribers = numberOfSubscribers;
//    }
//

}
