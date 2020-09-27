package com.sincrodigital.discountapp;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class DiscountappApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void shouldReturnBillAmountWithRegularDiscount() throws Exception{
		String customerType = "regular";;
		this.mockMvc.perform(get("/purchase{customerType}", customerType).param("purchaseAmount","5000")).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.billAmount").value("5000.0"));

		this.mockMvc.perform(get("/purchase{customerType}", customerType).param("purchaseAmount","10000")).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.billAmount").value("9500.0"));

		this.mockMvc.perform(get("/purchase{customerType}", customerType).param("purchaseAmount","15000")).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.billAmount").value("13500.0"));

	}

	@Test
	public void shouldReturnBillAmountWithPremiumDiscount() throws Exception{

		String customerType = "premium";
		this.mockMvc.perform(get("/purchase{customerType}", customerType).param("purchaseAmount","4000")).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.billAmount").value("3600.0"));

		this.mockMvc.perform(get("/purchase{customerType}", customerType).param("purchaseAmount","8000")).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.billAmount").value("7000.0"));

		this.mockMvc.perform(get("/purchase{customerType}", customerType).param("purchaseAmount","12000")).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.billAmount").value("10200.0"));

		this.mockMvc.perform(get("/purchase{customerType}", customerType).param("purchaseAmount","20000")).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.billAmount").value("15800.0"));

	}


}
