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
@DiscriminatorValue("LAUA")
public class Lauaarvuti extends Arvuti {

    private String korpuseTyyp; // nt ATX, Micro-ATX
    private boolean eraldiGPU;

    public Lauaarvuti(String tootja, String mudel, int muutamaht, String protsessor,
                      String korpuseTyyp, boolean eraldiGPU) {
        super(tootja, mudel, muutamaht, protsessor);
        this.korpuseTyyp = korpuseTyyp;
        this.eraldiGPU = eraldiGPU;
    }
}
