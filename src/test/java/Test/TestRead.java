package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import URLApi.Main;

public class TestRead {
	
	private Main main;
	
	@BeforeEach
	void setUp() throws Exception {
		main = new Main();
	}
	
	@ParameterizedTest
	@CsvSource({
		"true"
	})
	public void test(boolean excepted) {
		try {
			boolean temp = main.read();
			assertEquals(excepted, temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
