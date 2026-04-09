package ee.jaltdorf.arvutipood_backend.entity;

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
public abstract class Arvuti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tootja;
    private String mudel;
    private int muutamaht; // RAM GB
    private String protsessor;

    @Transient
    private String tyyp;

    public Arvuti(String tootja, String mudel, int muutamaht, String protsessor) {
        this.tootja = tootja;
        this.mudel = mudel;
        this.muutamaht = muutamaht;
        this.protsessor = protsessor;
    }

    @PostLoad
    public void setTyypFromDiscriminator() {
        if (this instanceof Sylearvuti) {
            this.tyyp = "SYLE";
        } else if (this instanceof Lauaarvuti) {
            this.tyyp = "LAUA";
        }
    }
}
