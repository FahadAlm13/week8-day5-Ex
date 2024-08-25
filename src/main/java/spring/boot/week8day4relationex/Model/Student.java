package spring.boot.week8day4relationex.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //ID , name , age , major
    @NotEmpty(message = "Name shouldn't be empty")
    @Column(columnDefinition = "varchar(20) not null ")
    private String name;
    @NotNull(message = "Age shouldn't be null")
    @Positive
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "Major shouldn't be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
