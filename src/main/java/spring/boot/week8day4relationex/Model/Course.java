package spring.boot.week8day4relationex.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "The name can not be empty")
    @Column(columnDefinition = "varchar(20) not null ")
    private String name;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;
}
