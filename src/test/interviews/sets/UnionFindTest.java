package interviews.sets;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class UnionFindTest {
  @Test
  public void test_QuickFind() {
    UnionFind uf = new QuickFind(10);
    Assert.assertEquals(10, uf.count());
    uf.union(4, 3);
    Assert.assertEquals(9, uf.count());
    uf.union(3, 8);
    Assert.assertEquals(8, uf.count());
    uf.union(6, 5);
    Assert.assertEquals(7, uf.count());
    uf.union(9, 4);
    Assert.assertEquals(6, uf.count());
    uf.union(9, 8);
    Assert.assertEquals(6, uf.count());
    uf.union(2, 1);
    Assert.assertEquals(5, uf.count());
    Assert.assertEquals(false, uf.connected(0, 7));
    Assert.assertEquals(true, uf.connected(8, 9));
    uf.union(5, 0);
    Assert.assertEquals(4, uf.count());
    uf.union(7, 2);
    Assert.assertEquals(3, uf.count());
    uf.union(6, 1);
    Assert.assertEquals(2, uf.count());
    uf.union(1, 0);
    Assert.assertEquals(2, uf.count());
    Assert.assertEquals(true, uf.connected(0, 7));
    uf.union(3, 6);
    Assert.assertEquals(1, uf.count());
  }

  @Test
  public void test_QuickUnion() {
    UnionFind uf = new QuickUnion(10);
    Assert.assertEquals(10, uf.count());
    Assert.assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, uf.id);
    uf.union(4, 3);
    Assert.assertEquals(9, uf.count());
    Assert.assertArrayEquals(new int[] {0, 1, 2, 4, 4, 5, 6, 7, 8, 9}, uf.id);
    uf.union(3, 8);
    Assert.assertEquals(8, uf.count());
    Assert.assertArrayEquals(new int[] {0, 1, 2, 4, 4, 5, 6, 7, 4, 9}, uf.id);
    uf.union(6, 5);
    Assert.assertEquals(7, uf.count());
    Assert.assertArrayEquals(new int[] {0, 1, 2, 4, 4, 6, 6, 7, 4, 9}, uf.id);
    uf.union(9, 4);
    Assert.assertEquals(6, uf.count());
    Assert.assertArrayEquals(new int[] {0, 1, 2, 4, 4, 6, 6, 7, 4, 4}, uf.id);
    uf.union(9, 8);
    Assert.assertEquals(6, uf.count());
    Assert.assertArrayEquals(new int[] {0, 1, 2, 4, 4, 6, 6, 7, 4, 4}, uf.id);
    uf.union(2, 1);
    Assert.assertEquals(5, uf.count());
    Assert.assertArrayEquals(new int[] {0, 2, 2, 4, 4, 6, 6, 7, 4, 4}, uf.id);
    Assert.assertEquals(false, uf.connected(0, 7));
    Assert.assertEquals(true, uf.connected(8, 9));
    uf.union(5, 0);
    Assert.assertEquals(4, uf.count());
    Assert.assertArrayEquals(new int[] {6, 2, 2, 4, 4, 6, 6, 7, 4, 4}, uf.id);
    uf.union(7, 2);
    Assert.assertEquals(3, uf.count());
    Assert.assertArrayEquals(new int[] {6, 2, 2, 4, 4, 6, 6, 2, 4, 4}, uf.id);
    uf.union(6, 1);
    Assert.assertEquals(2, uf.count());
    Assert.assertArrayEquals(new int[] {6, 2, 6, 4, 4, 6, 6, 2, 4, 4}, uf.id);
    uf.union(1, 0);
    Assert.assertEquals(2, uf.count());
    Assert.assertArrayEquals(new int[] {6, 2, 6, 4, 4, 6, 6, 2, 4, 4}, uf.id);
    Assert.assertEquals(true, uf.connected(0, 7));
    uf.union(3, 6);
    Assert.assertEquals(1, uf.count());
    Assert.assertArrayEquals(new int[] {6, 2, 6, 4, 6, 6, 6, 2, 4, 4}, uf.id);
  }

  @Test
  public void test_QuickUnionPathCompression() {
    UnionFind uf = new QuickUnionPathCompression(10);
    Assert.assertEquals(10, uf.count());
    Assert.assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, uf.id);
    uf.union(4, 3);
    Assert.assertEquals(9, uf.count());
    Assert.assertArrayEquals(new int[] {0, 1, 2, 4, 4, 5, 6, 7, 8, 9}, uf.id);
    uf.union(9, 8);
    Assert.assertEquals(8, uf.count());
    Assert.assertArrayEquals(new int[] {0, 1, 2, 4, 4, 5, 6, 7, 9, 9}, uf.id);
    uf.union(6, 5);
    Assert.assertEquals(7, uf.count());
    Assert.assertArrayEquals(new int[] {0, 1, 2, 4, 4, 6, 6, 7, 9, 9}, uf.id);
    uf.union(4, 9);
    Assert.assertEquals(6, uf.count());
    Assert.assertArrayEquals(new int[] {0, 1, 2, 4, 4, 6, 6, 7, 9, 4}, uf.id);
    uf.union(2, 1);
    Assert.assertEquals(5, uf.count());
    Assert.assertArrayEquals(new int[] {0, 2, 2, 4, 4, 6, 6, 7, 9, 4}, uf.id);
    Assert.assertEquals(false, uf.connected(0, 7));
    uf.union(5, 0);
    Assert.assertEquals(4, uf.count());
    Assert.assertArrayEquals(new int[] {6, 2, 2, 4, 4, 6, 6, 7, 9, 4}, uf.id);
    uf.union(7, 2);
    Assert.assertEquals(3, uf.count());
    Assert.assertArrayEquals(new int[] {6, 2, 2, 4, 4, 6, 6, 2, 9, 4}, uf.id);
    uf.union(6, 1);
    Assert.assertEquals(2, uf.count());
    Assert.assertArrayEquals(new int[] {6, 2, 6, 4, 4, 6, 6, 2, 9, 4}, uf.id);
    uf.union(1, 0);
    Assert.assertEquals(2, uf.count());
    Assert.assertArrayEquals(new int[] {6, 6, 6, 4, 4, 6, 6, 2, 9, 4}, uf.id);
    Assert.assertEquals(true, uf.connected(0, 7));
    Assert.assertArrayEquals(new int[] {6, 6, 6, 4, 4, 6, 6, 6, 9, 4}, uf.id);
    uf.union(3, 6);
    Assert.assertEquals(1, uf.count());
    Assert.assertArrayEquals(new int[] {6, 6, 6, 4, 6, 6, 6, 6, 9, 4}, uf.id);
    Assert.assertEquals(true, uf.connected(8, 7));
    Assert.assertArrayEquals(new int[] {6, 6, 6, 4, 6, 6, 6, 6, 4, 4}, uf.id);
    Assert.assertEquals(true, uf.connected(8, 9));
    Assert.assertArrayEquals(new int[] {6, 6, 6, 4, 6, 6, 6, 6, 6, 6}, uf.id);
    Assert.assertEquals(true, uf.connected(0, 3));
    Assert.assertArrayEquals(new int[] {6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, uf.id);
  }
}
