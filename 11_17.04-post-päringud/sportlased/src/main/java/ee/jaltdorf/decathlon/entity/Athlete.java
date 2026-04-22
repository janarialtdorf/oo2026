package ee.jaltdorf.decathlon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String country;

    private Integer age;

    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Result> result = new ArrayList<>();
}