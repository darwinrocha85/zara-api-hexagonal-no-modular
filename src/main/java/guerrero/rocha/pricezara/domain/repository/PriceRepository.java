package guerrero.rocha.pricezara.domain.repository;

import java.time.LocalDateTime;

import guerrero.rocha.pricezara.domain.model.Price;

public interface PriceRepository {

    Price getPriceByParameters(Long brandId,
            Long productId,
            LocalDateTime applicationDate) throws Exception;

}