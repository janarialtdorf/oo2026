package ee.jaltdorf.arvutipood_backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("SYLE")
public class Sylearvuti extends Arvuti {

    private double kaal; // kg
    private int akuKestvus; // tunnid

    public Sylearvuti(String tootja, String mudel, int muutamaht, String protsessor,
                      double kaal, int akuKestvus) {
        super(tootja, mudel, muutamaht, protsessor);
        this.kaal = kaal;
        this.akuKestvus = akuKestvus;
    }
}
