package Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestCreate.class, TestRead.class, TestShowDetailForAUser.class, TestShowDetails.class, TestUpdateCart.class, TestDeleteProduct.class, TestAddProductToCart.class})
public class AllTests {

}
