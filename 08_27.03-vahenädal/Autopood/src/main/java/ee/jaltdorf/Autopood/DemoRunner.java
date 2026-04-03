package ee.jaltdorf.Autopood;

import ee.jaltdorf.Autopood.entity.Auto;
import ee.jaltdorf.Autopood.entity.Bensiiniauto;
import ee.jaltdorf.Autopood.entity.Elektriauto;
import ee.jaltdorf.Autopood.repository.AutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner {

    private final AutoRepository autoRepository;

    public DemoRunner(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Bensiiniauto bmw = new Bensiiniauto("BMW", "X5", "maastur", "automaat");
        Bensiiniauto audi = new Bensiiniauto("Audi", "A4", "sedaan", "automaat");
        Bensiiniauto toyota = new Bensiiniauto("Toyota", "Corolla", "sedaan", "manuaal");

        Elektriauto tesla = new Elektriauto("Tesla", "Model 3", "sedaan", "automaat");
        Elektriauto hyundai = new Elektriauto("Hyundai", "Ioniq", "hatchback", "automaat");
        Elektriauto nissan = new Elektriauto("Nissan", "Leaf", "hatchback", "automaat");

        autoRepository.save(bmw);
        autoRepository.save(audi);
        autoRepository.save(toyota);
        autoRepository.save(tesla);
        autoRepository.save(hyundai);
        autoRepository.save(nissan);

        for (Auto auto : autoRepository.findAll()) {
            System.out.println(
                    auto.getMark() + " " +
                            auto.getMudel() + " " +
                            auto.getKeretyyp() + " " +
                            auto.getKaigukast() + " " +
                            auto.getTyyp()
            );
        }
    }
}