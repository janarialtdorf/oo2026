package ee.jaltdorf.Autopood.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("BENSIIN")
@NoArgsConstructor
public class Bensiiniauto extends Auto {

    public Bensiiniauto(String mark, String mudel, String keretyyp, String kaigukast) {
        super(mark, mudel, keretyyp, kaigukast);
        setTyyp("BENSIIN");
    }
}
