package gr.george.volosbeerservice.web.mappers;

import gr.george.volosbeerservice.domain.Beer;
import gr.george.volosbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    Beer BeerDtoToBeer(BeerDto beerDto);
    BeerDto BeerToBeerDto(Beer beer);
}
