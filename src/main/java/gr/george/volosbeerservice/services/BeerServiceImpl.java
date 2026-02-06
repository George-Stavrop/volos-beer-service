package gr.george.volosbeerservice.services;

import gr.george.volosbeerservice.domain.Beer;
import gr.george.volosbeerservice.repository.BeerRepository;
import gr.george.volosbeerservice.web.controller.BeerNotFoundException;
import gr.george.volosbeerservice.web.mappers.BeerMapper;
import gr.george.volosbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getBeerByID(UUID beerId) {
        Beer beer = beerRepository.findById(beerId)
                .orElseThrow(BeerNotFoundException::new);
        return beerMapper.beerToBeerDto(beer);
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
          Beer savedBeer = beerRepository.save(beerMapper.beerDtoToBeer(beerDto));
          return beerMapper.beerToBeerDto(savedBeer);
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId)
                .orElseThrow(BeerNotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        Beer savedBeer = beerRepository.save(beer);
        return beerMapper.beerToBeerDto(savedBeer);
    }
}
