package ee.jaltdorf.Autopood.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tyyp")
public abstract class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mark;
    private String mudel;
    private String keretyyp;
    private String kaigukast;

    @Transient  // JSON-i jaoks, ei salvestata DB-sse
    private String tyyp;

    // Konstruktor alamklasside jaoks
    public Auto(String mark, String mudel, String keretyyp, String kaigukast) {
        this.mark = mark;
        this.mudel = mudel;
        this.keretyyp = keretyyp;
        this.kaigukast = kaigukast;
    }

    @PostLoad
    public void setTyypFromDiscriminator() {
        if (this instanceof Bensiiniauto) {
            this.tyyp = "BENSIIN";
        } else if (this instanceof Elektriauto) {
            this.tyyp = "ELEKTER";
        }
    }
}