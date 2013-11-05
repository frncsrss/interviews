package interviews.numbers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class RomanNumeralToIntegerTest {
  @Test(expected = IllegalArgumentException.class)
  public void test_exception1() {
    RomanNumeralToInteger.f(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_exception2() {
    RomanNumeralToInteger.f("");
  }

  @Test(expected = NumberFormatException.class)
  public void test_exception3() {
    RomanNumeralToInteger.f("B");
  }

  @Test
  public void test_basic() {
    Assert.assertEquals(1,    RomanNumeralToInteger.f("i"));
    Assert.assertEquals(2,    RomanNumeralToInteger.f("ii"));
    Assert.assertEquals(3,    RomanNumeralToInteger.f("iii"));
    Assert.assertEquals(4,    RomanNumeralToInteger.f("iv"));
    Assert.assertEquals(5,    RomanNumeralToInteger.f("v"));
    Assert.assertEquals(6,    RomanNumeralToInteger.f("vi"));
    Assert.assertEquals(7,    RomanNumeralToInteger.f("vii"));
    Assert.assertEquals(8,    RomanNumeralToInteger.f("viii"));
    Assert.assertEquals(9,    RomanNumeralToInteger.f("ix"));
    Assert.assertEquals(10,   RomanNumeralToInteger.f("x"));
    Assert.assertEquals(11,   RomanNumeralToInteger.f("xi"));
    Assert.assertEquals(12,   RomanNumeralToInteger.f("xii"));
    Assert.assertEquals(13,   RomanNumeralToInteger.f("xiii"));
    Assert.assertEquals(14,   RomanNumeralToInteger.f("xiv"));
    Assert.assertEquals(15,   RomanNumeralToInteger.f("xv"));
    Assert.assertEquals(16,   RomanNumeralToInteger.f("xvi"));
    Assert.assertEquals(17,   RomanNumeralToInteger.f("xvii"));
    Assert.assertEquals(18,   RomanNumeralToInteger.f("xviii"));
    Assert.assertEquals(19,   RomanNumeralToInteger.f("xix"));
    Assert.assertEquals(20,   RomanNumeralToInteger.f("xx"));
    Assert.assertEquals(1910, RomanNumeralToInteger.f("MCMX"));
    Assert.assertEquals(1954, RomanNumeralToInteger.f("MCMLIV"));
    Assert.assertEquals(1990, RomanNumeralToInteger.f("mcmxc"));
    Assert.assertEquals(2008, RomanNumeralToInteger.f("mmviii"));
  }

  @Test
  public void test_weird() {
    Assert.assertEquals(3,    RomanNumeralToInteger.f("iiv"));
    Assert.assertEquals(15,   RomanNumeralToInteger.f("vvv"));
    Assert.assertEquals(1910, RomanNumeralToInteger.f("MDCCCCX"));
  }
}
