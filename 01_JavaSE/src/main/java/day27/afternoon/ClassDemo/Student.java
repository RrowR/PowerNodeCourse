package day27.afternoon.ClassDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person{
    private String name;
    private int age;
}
