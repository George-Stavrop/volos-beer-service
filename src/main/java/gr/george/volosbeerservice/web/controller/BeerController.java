package gr.george.volosbeerservice.web.controller;

import gr.george.volosbeerservice.services.BeerService;
import gr.george.volosbeerservice.web.model.BeerDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {
        BeerDto beerDto = beerService.getBeerByID(beerId);
        return ResponseEntity.status(HttpStatus.OK).body(beerDto);
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer(@Valid @RequestBody BeerDto beerDto){
        BeerDto savedBeerDto = beerService.saveNewBeer(beerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBeerDto);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDto> updateBeer(@Valid @PathVariable UUID beerId, @RequestBody BeerDto beerDto){
        BeerDto updatedDto = beerService.updateBeer(beerId, beerDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedDto);
    }

}
