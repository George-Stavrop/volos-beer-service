package gr.george.volosbeerservice.bootstrap;

import gr.george.volosbeerservice.domain.Beer;
import gr.george.volosbeerservice.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

//@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "036000291452";
    public static final String BEER_2_UPC = "012345678905";
    public static final String BEER_3_UPC = "639382000393";
    public static final UUID BEER_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
    public static final UUID BEER_2_UUID = UUID.fromString("a712d914-61ea-4623-8bd0-32c0f6545bfd");
    public static final UUID BEER_3_UUID = UUID.fromString("026cc3c8-3a0c-4083-a05b-e908048c1b08");

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
                    .upc(BEER_1_UPC)
                    .price(new BigDecimal("3.50"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Mythos")
                    .beerStyle("Pale Ale")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal("2.50"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Pills")
                    .beerStyle("Pale Ale")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal("1.50"))
                    .build());
        }
        System.out.println("Loaded Beers" + beerRepository.count());
    }
}
