package gr.george.volosbeerservice.services.brewing;

import gr.george.volosbeerservice.config.JmsConfig;
import gr.george.volosbeerservice.domain.Beer;
import gr.george.volosbeerservice.events.BrewBeerEvent;
import gr.george.volosbeerservice.events.NewInventoryEvent;
import gr.george.volosbeerservice.repository.BeerRepository;
import gr.george.volosbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent event) {
        BeerDto beerDto = event.getBeerDto();

        Beer beer = beerRepository.getReferenceById(beerDto.getId());
        beerDto.setQuantityOnHand(beer.getQuantityToBrew());

        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);
        log.debug("Brewed beer " + beer.getMinOnHand() + "QOH: " + beerDto.getQuantityOnHand());

        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
    }
}
