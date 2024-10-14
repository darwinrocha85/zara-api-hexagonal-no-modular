package guerrero.rocha.pricezara.infraestructure.inbound.controllers;

import guerrero.rocha.pricezara.application.find.PriceFindUseCase;
import guerrero.rocha.pricezara.domain.model.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceFindUseCase useCase;

    @GetMapping("/findByParameters")
    public Price findByParameters(@RequestParam(name = "brandId", required = true) Long brandId,
            @RequestParam(name = "productId", required = true) Long productId,
            @RequestParam(required = true) String applicationDate) throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        LocalDateTime dateTime = java.time.LocalDateTime.parse(applicationDate, formatter);
        return useCase.findByParameters(brandId, productId, dateTime);
    }

}
