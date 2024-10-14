package guerrero.rocha.pricezara.application.find;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import guerrero.rocha.pricezara.domain.model.Price;
import guerrero.rocha.pricezara.domain.repository.PriceRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriceFindUseCase {

    private final PriceRepository priceRepository;

    public Price findByParameters(Long brandId,
            Long productId,
            LocalDateTime applicationDate) throws Exception {
        return priceRepository.getPriceByParameters(brandId, productId, applicationDate);
    }

}
