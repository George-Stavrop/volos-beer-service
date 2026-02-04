package gr.george.volosbeerservice.web.controller;

import gr.george.volosbeerservice.web.model.BeerDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {
        //todo impl
        return ResponseEntity.status(HttpStatus.OK).body(BeerDto.builder().build());
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@Valid @RequestBody BeerDto beerDto){
        //todo impl
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@Valid @PathVariable UUID beerId, @RequestBody BeerDto beerDto){

        //todo impl
        return ResponseEntity.noContent().build();
    }

}
