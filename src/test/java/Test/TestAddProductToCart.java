package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import URLApi.Main;

class TestAddProductToCart {

private Main main;
	
	@BeforeEach
	void setUp() throws Exception {
		main = new Main();
	}
	
	@ParameterizedTest
	@CsvSource({
		"'{\"cart_id\": 9,\"product_id\": 2}', true",
		"'{\"cart_id\": 1,\"product_id\": 2}', true",
		"'{\"cart_id\": 2,\"product_id\": 1}', true",
		"'{\"cart_id\": 1,\"product_id\": 2,\"quantity\": 1}', true",
		"'{\"cart_id\": 2,\"product_id\": 1,\"quantity\": 3}', true",
		"'{\"cart_id\": 3,\"product_id\": 3,\"quantity\": 2}', true",
		"'{\"cart_id\": 10,\"product_id\": 5,\"quantity\": 4}', true",
		"'{\"cart_id\": 2,\"product_id\": 3,\"quantity\": 8}', true",
		"'{\"cart_id\": 5,\"product_id\": 6,\"quantity\": 10}', true"
	})
	public void test(String input, boolean excepted) {
		try {
			boolean temp = main.updateCart(input);
			assertEquals(excepted, temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
