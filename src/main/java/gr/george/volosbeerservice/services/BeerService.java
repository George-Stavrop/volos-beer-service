package gr.george.volosbeerservice.services;

import gr.george.brewery.model.BeerDto;
import gr.george.brewery.model.BeerPagedList;
import gr.george.brewery.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {
        BeerDto getBeerByID(UUID beerId, Boolean showInventoryOnHand);
        BeerDto saveNewBeer(BeerDto beerDto);
        BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    BeerDto getBeerByUpc(String upc);
}
