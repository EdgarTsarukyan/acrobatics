package model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private int id;
    private String name;
    private String surname;
    private int age;
    private Gander gander;
    private String password;
    private int trainerId;
    private  Trainer trainer;
}
