package gr.george.volosbeerservice.events;

import gr.george.volosbeerservice.web.model.BeerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerEvent {

    private  BeerDto beerDto;
}
