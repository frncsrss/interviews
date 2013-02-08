package interviews.numbers;

import org.junit.Assert;
import org.junit.Test;

import static interviews.numbers.Heavy.average_value_digits;
import static interviews.numbers.Heavy.f;
import static interviews.numbers.Heavy.f2;

public class HeavyTest {
  @Test
  public void test_good() {
    Assert.assertEquals(5, f(8675, 8689));
    Assert.assertEquals(5, f2(8675, 8689));
    Assert.assertEquals(15, f(1214, 5678));
    Assert.assertEquals(15, f2(1214, 5678));
  }

  @Test
  public void test_average() {
    Assert.assertEquals(0.0,  average_value_digits(0),     0.01d);
    Assert.assertEquals(1.0,  average_value_digits(1),     0.01d);
    Assert.assertEquals(6.5,  average_value_digits(8675),  0.01d);
    Assert.assertEquals(6.25, average_value_digits(8683),  0.01d);
    Assert.assertEquals(7.75, average_value_digits(8689),  0.01d);
    Assert.assertEquals(2.8,  average_value_digits(53141), 0.01d);
  }
}
