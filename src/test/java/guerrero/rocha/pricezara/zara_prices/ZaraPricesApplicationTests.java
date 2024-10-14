package guerrero.rocha.pricezara.zara_prices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ZaraPricesApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@Sql("/data.sql")
	void test1() {
		try {
			ResultActions result = mockMvc.perform(
					get("/prices/findByParameters?brandId=1&productId=35455&applicationDate=2020-12-30 00:00:00"));

			// Assertion
			result.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$.id").value(1))
					.andExpect(jsonPath("$.brandId").value(1))
					.andExpect(jsonPath("$.startDate").value("2020-06-14T05:00:00.000+00:00"))
					.andExpect(jsonPath("$.endDate").value("2021-01-01T04:59:59.000+00:00"))
					.andExpect(jsonPath("$.priceList").value(1))
					.andExpect(jsonPath("$.productId").value(35455))
					.andExpect(jsonPath("$.priority").value(0))
					.andExpect(jsonPath("$.price").value(35.5))
					.andExpect(jsonPath("$.currency").value("EUR"));
		} catch (Exception e) {
		}

	}

}
