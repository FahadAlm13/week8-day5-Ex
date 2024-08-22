package spring.boot.week8day4relationex.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(30) not null")
    private String street;
    @Column(columnDefinition = "varchar(30) not null")

    private String area;

    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
