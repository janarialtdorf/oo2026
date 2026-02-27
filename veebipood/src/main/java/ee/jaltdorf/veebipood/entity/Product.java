package ee.jaltdorf.veebipood.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Boolean active;
    private Integer stock;

    // @ManyToMany --> private List<Ingredients> ingredients
    // @OneToMany --> private List<Ingredients> ingredients
    // @ManyToOne --> tooted jagavad seda kategooriat
    // @OneToOne --> tooted ei jaga seda kategooriat


    @ManyToOne
    private Category category; //automaatselt voorvotmega (@id valjaga) siia tabelisse



    //Panen andmebaasi, aga ei maara seda vaartust:
    // Double -> 0
    // Boolean -> false
    // Integer -> 0

    //Panen andmebaasi, aga ei maara seda vaartust:
    // Double -> null
    // Boolean -> null
    // Integer -> null
}
