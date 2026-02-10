package gr.george.volosbeerservice.web.controller;

import gr.george.volosbeerservice.services.BeerService;
import gr.george.volosbeerservice.web.model.BeerDto;
import gr.george.volosbeerservice.web.model.BeerPagedList;
import gr.george.volosbeerservice.web.model.BeerStyleEnum;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/")
@RestController
public class BeerController {
    @Autowired
    private BeerService beerService;

    private static final int DEFAULT_PAGE_NUMBER = 0; // first page
    private static final int DEFAULT_PAGE_SIZE = 25;  // default size

    @GetMapping( path = "/beer", produces = {"application/json"})
    public ResponseEntity<BeerPagedList> listBeers(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                   @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                   @RequestParam(value = "beerName", required = false) String beerName,
                                                   @RequestParam(value = "beerStyle", required = false)BeerStyleEnum beerStyle,
                                                   @RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand
                                                   ){
        //todo put all the default values at the params
        if (showInventoryOnHand == null) {
            showInventoryOnHand = false;
        }

        if (pageNumber == null || pageNumber < 0) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        BeerPagedList beerList = beerService.listBeers(beerName, beerStyle, PageRequest.of(pageNumber, pageSize), showInventoryOnHand);

        return ResponseEntity.status(HttpStatus.OK).body(beerList);
    }



    @GetMapping("beer/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId,
                                               @RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand
    )

    {
        if (showInventoryOnHand == null) {
            showInventoryOnHand = false;
        }

        BeerDto beerDto = beerService.getBeerByID(beerId, showInventoryOnHand);
        return ResponseEntity.status(HttpStatus.OK).body(beerDto);
    }


    @GetMapping("beerUpc/{upc}")
    public ResponseEntity<BeerDto> getBeerByUpc(@PathVariable String upc)

    {

        BeerDto beerDto = beerService.getBeerByUpc(upc);
        return ResponseEntity.status(HttpStatus.OK).body(beerDto);
    }





    @PostMapping("/beer")
    public ResponseEntity<BeerDto> saveNewBeer(@Valid @RequestBody BeerDto beerDto){
        BeerDto savedBeerDto = beerService.saveNewBeer(beerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBeerDto);
    }

    @PutMapping("beer/{beerId}")
    public ResponseEntity<BeerDto> updateBeer(@Valid @PathVariable UUID beerId, @RequestBody BeerDto beerDto){
        BeerDto updatedDto = beerService.updateBeer(beerId, beerDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedDto);
    }

}