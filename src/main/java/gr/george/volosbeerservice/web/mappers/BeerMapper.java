package gr.george.volosbeerservice.web.mappers;

import gr.george.volosbeerservice.domain.Beer;
import gr.george.volosbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDto beerDto);

    BeerDto beerToBeerDto(Beer beer);
}
