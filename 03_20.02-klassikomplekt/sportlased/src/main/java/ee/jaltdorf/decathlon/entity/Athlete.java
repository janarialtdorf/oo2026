package ee.jaltdorf.decathlon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Athlete { //userit ei saa postgreSQL parast kasutada
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String country;
    private Integer age;

    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL)
    private List<Result> results;

}
