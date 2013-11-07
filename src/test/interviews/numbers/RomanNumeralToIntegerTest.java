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
    Assert.assertEquals(3999, RomanNumeralToInteger.f("mmmcmxcix"));
  }

  @Test
  public void test_weird() {
    Assert.assertEquals(3,    RomanNumeralToInteger.f("iiv"));
    Assert.assertEquals(15,   RomanNumeralToInteger.f("vvv"));
    Assert.assertEquals(1910, RomanNumeralToInteger.f("MDCCCCX"));
  }

  @Test
  public void test_f2_basic() {
    Assert.assertEquals(1,    RomanNumeralToInteger.f2("i"));
    Assert.assertEquals(2,    RomanNumeralToInteger.f2("ii"));
    Assert.assertEquals(3,    RomanNumeralToInteger.f2("iii"));
    Assert.assertEquals(4,    RomanNumeralToInteger.f2("iv"));
    Assert.assertEquals(5,    RomanNumeralToInteger.f2("v"));
    Assert.assertEquals(6,    RomanNumeralToInteger.f2("vi"));
    Assert.assertEquals(7,    RomanNumeralToInteger.f2("vii"));
    Assert.assertEquals(8,    RomanNumeralToInteger.f2("viii"));
    Assert.assertEquals(9,    RomanNumeralToInteger.f2("ix"));
    Assert.assertEquals(10,   RomanNumeralToInteger.f2("x"));
    Assert.assertEquals(11,   RomanNumeralToInteger.f2("xi"));
    Assert.assertEquals(12,   RomanNumeralToInteger.f2("xii"));
    Assert.assertEquals(13,   RomanNumeralToInteger.f2("xiii"));
    Assert.assertEquals(14,   RomanNumeralToInteger.f2("xiv"));
    Assert.assertEquals(15,   RomanNumeralToInteger.f2("xv"));
    Assert.assertEquals(16,   RomanNumeralToInteger.f2("xvi"));
    Assert.assertEquals(17,   RomanNumeralToInteger.f2("xvii"));
    Assert.assertEquals(18,   RomanNumeralToInteger.f2("xviii"));
    Assert.assertEquals(19,   RomanNumeralToInteger.f2("xix"));
    Assert.assertEquals(20,   RomanNumeralToInteger.f2("xx"));
    Assert.assertEquals(1910, RomanNumeralToInteger.f2("MCMX"));
    Assert.assertEquals(1954, RomanNumeralToInteger.f2("MCMLIV"));
    Assert.assertEquals(1990, RomanNumeralToInteger.f2("mcmxc"));
    Assert.assertEquals(2008, RomanNumeralToInteger.f2("mmviii"));
    Assert.assertEquals(3999, RomanNumeralToInteger.f2("mmmcmxcix"));
  }

  @Test(expected = NumberFormatException.class)
  public void test_f2_weird1() {
    Assert.assertEquals(3, RomanNumeralToInteger.f2("iiv"));
  }

  @Test(expected = NumberFormatException.class)
  public void test_f2_weird2() {
    Assert.assertEquals(15, RomanNumeralToInteger.f2("vvv"));
  }

  @Test(expected = NumberFormatException.class)
  public void test_f2_weird3() {
    Assert.assertEquals(1910, RomanNumeralToInteger.f2("MDCCCCX"));
  }
}
