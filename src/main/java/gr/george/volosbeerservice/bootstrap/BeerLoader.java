package gr.george.volosbeerservice.bootstrap;

import gr.george.volosbeerservice.domain.Beer;
import gr.george.volosbeerservice.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Alpha")
                    .beerStyle("Ale")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(34301000000L)
                    .price(new BigDecimal("3.50"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Mythos")
                    .beerStyle("Pale Ale")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(34301000002L)
                    .price(new BigDecimal("2.50"))
                    .build());
        }
        System.out.println("Loaded Beers" + beerRepository.count());
    }
}
