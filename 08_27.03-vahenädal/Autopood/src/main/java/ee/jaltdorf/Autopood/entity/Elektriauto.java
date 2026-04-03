package ee.jaltdorf.Autopood.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("ELEKTER")
@NoArgsConstructor
public class Elektriauto extends Auto {

    public Elektriauto(String mark, String mudel, String keretyyp, String kaigukast) {
        super(mark, mudel, keretyyp, kaigukast);
        setTyyp("ELEKTER");
    }
}
