package interviews.trees;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class BTTest {

  @Test
  public void test_me() {
    final String s = "10(8)(7(6)(3()(4)))";
    Assert.assertEquals(s, BT.serialize(BT.deserialize(s)));
  }

  @Test
  public void test_interviewer() {
    final String s = "10(8)(7(6()(5()(9)))(3()(4)))";
    Assert.assertEquals(s, BT.serialize(BT.deserialize(s)));
  }

  @Test
  public void test_extreme() {
    Assert.assertEquals("10", BT.serialize(BT.deserialize("10")));
    Assert.assertEquals("10()(7)", BT.serialize(BT.deserialize("10()(7)")));
  }
}
