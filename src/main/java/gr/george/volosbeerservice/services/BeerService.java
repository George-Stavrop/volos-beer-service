package gr.george.volosbeerservice.services;

import gr.george.volosbeerservice.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
        BeerDto getBeerByID(UUID beerId);
        BeerDto saveNewBeer(BeerDto beerDto);
        BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
