package guerrero.rocha.pricezara.infraestructure;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import guerrero.rocha.pricezara.domain.model.Price;
import guerrero.rocha.pricezara.domain.repository.PriceRepository;
import guerrero.rocha.pricezara.infraestructure.outbound.database.PriceJpaRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceJpaRepository repository;

    @Override
    public Price getPriceByParameters(Long brandId,
            Long productId,
            LocalDateTime applicationDate) throws Exception{
        List<Price> prices = this.repository.getPricesByParameters(brandId, productId, applicationDate);
        if(prices.isEmpty()){
            throw new Exception("No hay precios relacionados a la consulta realziada");
        }else{
            return prices.get(0);
        }
    }

}
