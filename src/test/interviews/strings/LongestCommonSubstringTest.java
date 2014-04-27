package interviews.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class LongestCommonSubstringTest {
  @Test
  public void test_f1() {
    Assert.assertEquals(
        " peter go",
        LongestCommonSubstring.f1("Please, peter go swimming!", "I'm peter goliswi"));
    Assert.assertEquals(
        "sajchsichsaoioooooivhsdoivhsdoivhsoachasiucbisachsiuhsaxjaaahaks",
        LongestCommonSubstring.f1("sajchsichsaoioooooivhsdoivhsdoivhsoachasiucbisachsiuhsaxjaaahaks",
            "sajchsichsaoioooooivhsdoivhsdoivhsoachasiucbisachsiuhsaxjaaahaks"));
  }

  @Test
  public void test_f2() {
    Assert.assertEquals(
        " peter go",
        LongestCommonSubstring.f2("Please, peter go swimming!", "I'm peter goliswi"));
    Assert.assertEquals(
        "sajchsichsaoioooooivhsdoivhsdoivhsoachasiucbisachsiuhsaxjaaahaks",
        LongestCommonSubstring.f2("sajchsichsaoioooooivhsdoivhsdoivhsoachasiucbisachsiuhsaxjaaahaks",
            "sajchsichsaoioooooivhsdoivhsdoivhsoachasiucbisachsiuhsaxjaaahaks"));
  }
}
