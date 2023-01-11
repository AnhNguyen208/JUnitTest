package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import URLApi.Main;

class TestDeleteProduct {

	private Main main;

	@BeforeEach
	void setUp() throws Exception {
		main = new Main();
	}

	@ParameterizedTest
	@CsvSource({ "'{\"cart_id\": 1,\"product_id\": 2}', true",
			"'{\"cart_id\": 2,\"product_id\": 1}', true",
			"'{\"cart_id\": 3,\"product_id\": 3}', true",
			"'{\"cart_id\": 10,\"product_id\": 5}', true",
			"'{\"cart_id\": 2,\"product_id\": 3}', true",
			"'{\"cart_id\": 5,\"product_id\": 6}', true" })
	public void test(String input, boolean excepted) {
		try {
			boolean temp = main.daleteProductInCart(input);
			assertEquals(excepted, temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
