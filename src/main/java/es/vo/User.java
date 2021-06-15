package es.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String name;
    private String sex;
    private int age;
    private String hobby;

}
