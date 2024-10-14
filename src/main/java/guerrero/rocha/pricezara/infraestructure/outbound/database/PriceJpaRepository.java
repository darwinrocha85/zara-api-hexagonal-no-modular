package guerrero.rocha.pricezara.infraestructure.outbound.database;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import guerrero.rocha.pricezara.domain.model.Price;

@Repository
public interface PriceJpaRepository extends JpaRepository<Price, Long> {

    @Query("SELECT p FROM Price p " +
            "WHERE p.brandId = :brandId " +
            "AND p.productId = :productId " +
            "AND :applicationDate BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC " +
            "Limit 1")
    List<Price> getPricesByParameters(@Param("brandId") Long brandId,
                                  @Param("productId") Long productId,
                                  @Param("applicationDate") LocalDateTime applicationDate);

}
