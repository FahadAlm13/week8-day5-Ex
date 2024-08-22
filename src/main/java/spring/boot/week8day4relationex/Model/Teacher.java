package spring.boot.week8day4relationex.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name shouldn't be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotNull(message = "Age shouldn't be null")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotNull(message = "Salary shouldn't be null")
    @Column(columnDefinition = "double not null")
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;


    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Course> course;

}
