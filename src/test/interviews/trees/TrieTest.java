package interviews.trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class TrieTest {
  private Trie trie;

  @Before
  public void setUp() {
    trie = new Trie();
    trie.add("0039");
    trie.add("004478");
    trie.add("0044");
    trie.add("0044566");
    trie.add("0044557");
    trie.add("0044558");
  }

  @Test
  public void test_completion() {
    Assert.assertEquals("044", trie.completion("0"));
    Assert.assertEquals("44", trie.completion("00"));
    Assert.assertEquals("4", trie.completion("004"));
    Assert.assertEquals(null, trie.completion("0044"));
    Assert.assertEquals("557", trie.completionForced("0044"));
    Assert.assertEquals("57", trie.completion("00445"));
    Assert.assertEquals("6", trie.completion("004456"));
    Assert.assertEquals(null, trie.completion("00446"));
    Assert.assertEquals(null, trie.completion("00397"));
  }

  @Test
  public void test_contains() {
    Assert.assertEquals(true, trie.contains("0044"));
    Assert.assertEquals(true, trie.contains("00445"));
  }

  @Test
  public void test_clear() {
    Assert.assertEquals(true, trie.contains("0"));
    Assert.assertEquals(true, trie.contains("0044"));
    trie.clear();
    Assert.assertEquals(false, trie.contains("0"));
    Assert.assertEquals(false, trie.contains("0044"));
  }

  @Test
  public void test_frequency() {
    Assert.assertEquals(5, trie.frequency("004"));
    Assert.assertEquals(3, trie.frequency("00445"));
  }

  @Test
  public void test_isValid() {
    Assert.assertEquals(true, trie.isValid("0044"));
    Assert.assertEquals(false, trie.isValid("00445"));
  }

  @Test
  public void test_longestPrefix() {
    Assert.assertEquals("004478", trie.longestPrefix("004478231310"));
    Assert.assertEquals("0044", trie.longestPrefix("004471231310"));
    Assert.assertEquals("0044", trie.longestPrefix("004455231310"));
  }

  @Test
  public void test_remove() {
    Assert.assertEquals(true, trie.contains("0044"));
    Assert.assertEquals(true, trie.isValid("0044"));
    Assert.assertEquals(true, trie.remove("0044"));
    Assert.assertEquals(true, trie.contains("0044"));
    Assert.assertEquals(false, trie.isValid("0044"));

    Assert.assertEquals(false, trie.remove("0044"));

    Assert.assertEquals(true, trie.contains("0039"));
    Assert.assertEquals(true, trie.contains("003"));
    Assert.assertEquals(true, trie.contains("00"));
    Assert.assertEquals(true, trie.remove("0039"));
    Assert.assertEquals(false, trie.contains("0039"));
    Assert.assertEquals(false, trie.contains("003"));
    Assert.assertEquals(true, trie.contains("00"));

    Assert.assertEquals(false, trie.remove("0039"));
  }
}