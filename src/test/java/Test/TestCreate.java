package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import URLApi.Main;

class TestCreate {

	private Main main;
	
	@BeforeEach
	void setUp() throws Exception {
		main = new Main();
	}
	
	@ParameterizedTest
	@CsvSource({
		"[{\"user_id\":2}], false",
		"[{\"user_id\":21}], false",
		"[{\"user_id\":10}], false"
	})
	public void test(String input, boolean excepted) {
		try {
			boolean temp = main.create(input);
			assertEquals(excepted, temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
