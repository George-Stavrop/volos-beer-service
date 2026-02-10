package gr.george.volosbeerservice.web.mappers;

import gr.george.volosbeerservice.domain.Beer;
import gr.george.volosbeerservice.web.model.BeerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@DecoratedWith(BeerMapperDecorator.class)
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDto beerDto);

    BeerDto beerToBeerDtoWithInventory(Beer beer);

    BeerDto beerToBeerDto(Beer beer);


}
