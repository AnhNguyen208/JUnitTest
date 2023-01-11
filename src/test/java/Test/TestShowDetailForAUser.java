package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import URLApi.Main;

class TestShowDetailForAUser {

	private Main main;

	@BeforeEach
	void setUp() throws Exception {
		main = new Main();
	}

	@ParameterizedTest
	@CsvSource({ "1, true", "2, true", "3, true", "4, true", "5, true" })
	public void test(String input, boolean excepted) {
		try {
			boolean temp = main.showDetailsForAUser(input);
			assertEquals(excepted, temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
