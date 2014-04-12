package interviews.graphs;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class KCoreTest {

  private static Graph setUp() {
    Graph g = new Graph(21);
    assertEquals(true, g.addEdge(1, 2));
    assertEquals(true, g.addEdge(1, 3));
    assertEquals(true, g.addEdge(2, 4));
    assertEquals(true, g.addEdge(3, 4));
    assertEquals(true, g.addEdge(4, 5));
    assertEquals(true, g.addEdge(6, 7));
    assertEquals(true, g.addEdge(7, 8));
    assertEquals(true, g.addEdge(7, 9));
    assertEquals(true, g.addEdge(7, 10));
    assertEquals(true, g.addEdge(8, 9));
    assertEquals(true, g.addEdge(9, 10));
    assertEquals(true, g.addEdge(9, 11));
    assertEquals(true, g.addEdge(9, 12));
    assertEquals(true, g.addEdge(9, 13));
    assertEquals(true, g.addEdge(10, 14));
    assertEquals(true, g.addEdge(10, 15));
    assertEquals(true, g.addEdge(10, 16));
    assertEquals(true, g.addEdge(11, 12));
    assertEquals(true, g.addEdge(11, 13));
    assertEquals(true, g.addEdge(12, 13));
    assertEquals(true, g.addEdge(13, 17));
    assertEquals(true, g.addEdge(13, 18));
    assertEquals(true, g.addEdge(14, 15));
    assertEquals(true, g.addEdge(14, 16));
    assertEquals(true, g.addEdge(14, 18));
    assertEquals(true, g.addEdge(15, 16));
    assertEquals(true, g.addEdge(17, 18));
    assertEquals(true, g.addEdge(17, 19));
    assertEquals(true, g.addEdge(17, 20));
    return g;
  }

  @Test
  public void test_unweighted1() {
    Graph g = GraphTest.setUp();
    KCore kc = new KCore(g);
    kc.computeUnweighted();
    assertArrayEquals(new int[]{2, 1, 1, 2, 2, 2, 2, 1, 1, 2, 1, 2, 2}, kc.core());
  }

  @Test
  public void test_unweighted2() {
    Graph g = setUp();
    KCore kc = new KCore(g);
    kc.computeUnweighted();
    assertArrayEquals(new int[]{0, 2, 2, 2, 2, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 1, 1},
        kc.core());
  }

  @Test
  public void test_weighted1() {
    Graph g = GraphTest.setUp();
    KCore kc = new KCore(g);
    kc.computeWeighted();
    assertArrayEquals(new int[]{2, 1, 1, 2, 2, 2, 2, 1, 1, 2, 1, 2, 2}, kc.core());
  }

  @Test
  public void test_weighted2() {
    Graph g = setUp();
    KCore kc = new KCore(g);
    kc.computeWeighted();
    assertArrayEquals(new int[]{0, 2, 2, 2, 2, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 1, 1},
        kc.core());
  }

  @Test
  public void test_edge_case1() {
    Graph g = new Graph(3);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    KCore kc = new KCore(g);
    kc.computeUnweighted();
    assertFalse(kc.addEdge(new Edge(0, 2)));
  }

  @Test
  public void test_edge_case2() {
    Graph g = new Graph(21);
    g.addEdge(1, 3);
    g.addEdge(1, 7);
    g.addEdge(1, 17);
    g.addEdge(2, 3);
    g.addEdge(2, 15);
    g.addEdge(2, 17);
    g.addEdge(2, 18);
    g.addEdge(3, 18);
    g.addEdge(4, 5);
    g.addEdge(4, 8);
    g.addEdge(4, 10);
    g.addEdge(4, 17);
    g.addEdge(6, 7);
    g.addEdge(7, 8);
    g.addEdge(7, 11);
    g.addEdge(8, 16);
    g.addEdge(8, 17);
    g.addEdge(9, 10);
    g.addEdge(9, 13);
    g.addEdge(9, 15);
    g.addEdge(9, 16);
    g.addEdge(10, 14);
    g.addEdge(10, 15);
    g.addEdge(10, 16);
    g.addEdge(11, 12);
    g.addEdge(11, 13);
    g.addEdge(11, 15);
    g.addEdge(12, 13);
    g.addEdge(12, 14);
    g.addEdge(14, 16);
    g.addEdge(17, 19);
    g.addEdge(17, 20);
    KCore kc = new KCore(g);
    kc.computeUnweighted();
    assertTrue(kc.addEdge(new Edge(7, 16)));
  }

  @Test
  public void test_edge_case3() {
    Graph g = new Graph(21);
    g.addEdge(1, 2);
    g.addEdge(1, 9);
    g.addEdge(1, 18);
    g.addEdge(2, 12);
    g.addEdge(3, 11);
    g.addEdge(3, 14);
    g.addEdge(4, 5);
    g.addEdge(4, 7);
    g.addEdge(4, 11);
    g.addEdge(4, 17);
    g.addEdge(6, 7);
    g.addEdge(7, 10);
    g.addEdge(7, 18);
    g.addEdge(8, 13);
    g.addEdge(8, 14);
    g.addEdge(9, 10);
    g.addEdge(9, 13);
    g.addEdge(9, 15);
    g.addEdge(9, 17);
    g.addEdge(10, 12);
    g.addEdge(10, 14);
    g.addEdge(10, 16);
    g.addEdge(11, 12);
    g.addEdge(11, 13);
    g.addEdge(11, 14);
    g.addEdge(11, 15);
    g.addEdge(12, 13);
    g.addEdge(13, 16);
    g.addEdge(14, 15);
    g.addEdge(15, 16);
    g.addEdge(17, 18);
    g.addEdge(17, 19);
    g.addEdge(17, 20);
    KCore kc = new KCore(g);
    kc.computeUnweighted();
    assertTrue(kc.addEdge(new Edge(7, 15)));
  }

  @Test
  public void test_edge_case4() {
    Graph g = new Graph(21);
    g.addEdge(1, 2);
    g.addEdge(1, 3);
    g.addEdge(2, 4);
    g.addEdge(2, 8);
    g.addEdge(2, 18);
    g.addEdge(3, 4);
    g.addEdge(3, 13);
    g.addEdge(4, 5);
    g.addEdge(4, 12);
    g.addEdge(6, 7);
    g.addEdge(7, 8);
    g.addEdge(7, 9);
    g.addEdge(7, 10);
    g.addEdge(8, 9);
    g.addEdge(9, 10);
    g.addEdge(9, 11);
    g.addEdge(9, 12);
    g.addEdge(9, 13);
    g.addEdge(10, 14);
    g.addEdge(10, 15);
    g.addEdge(10, 16);
    g.addEdge(11, 12);
    g.addEdge(11, 13);
    g.addEdge(12, 13);
    g.addEdge(12, 14);
    g.addEdge(13, 16);
    g.addEdge(13, 17);
    g.addEdge(13, 18);
    g.addEdge(14, 15);
    g.addEdge(14, 16);
    g.addEdge(14, 18);
    g.addEdge(15, 16);
    g.addEdge(17, 18);
    g.addEdge(17, 19);
    g.addEdge(17, 20);
    KCore kc = new KCore(g);
    kc.computeUnweighted();
    assertTrue(kc.addEdge(new Edge(13, 15)));
  }

  @Test
  public void test_edge_case5() {
    Graph g = new Graph(21);
    g.addEdge(1, 2);
    g.addEdge(1, 3);
    g.addEdge(2, 4);
    g.addEdge(2, 8);
    g.addEdge(2, 18);
    g.addEdge(3, 4);
    g.addEdge(3, 13);
    g.addEdge(4, 5);
    g.addEdge(4, 12);
    g.addEdge(6, 7);
    g.addEdge(7, 8);
    g.addEdge(7, 9);
    g.addEdge(7, 10);
    g.addEdge(8, 9);
    g.addEdge(9, 10);
    g.addEdge(9, 11);
    g.addEdge(9, 12);
    g.addEdge(9, 13);
    g.addEdge(10, 14);
    g.addEdge(10, 15);
    g.addEdge(10, 16);
    g.addEdge(11, 12);
    g.addEdge(11, 13);
    g.addEdge(12, 13);
    g.addEdge(12, 14);
    g.addEdge(13, 15);
    g.addEdge(13, 16);
    g.addEdge(13, 17);
    g.addEdge(13, 18);
    g.addEdge(14, 15);
    g.addEdge(14, 16);
    g.addEdge(14, 18);
    g.addEdge(15, 16);
    g.addEdge(17, 18);
    g.addEdge(17, 19);
    g.addEdge(17, 20);
    KCore kc = new KCore(g);
    kc.computeUnweighted();
    assertFalse(kc.addEdge(new Edge(8, 17)));
  }

  @Test
  public void test_addEdge() {
    Graph g = setUp();
    KCore kc = new KCore(g);
    kc.computeUnweighted();
    int[] golden = Arrays.copyOf(kc.core(), g.V);
    for(int i = 0; i < 10000; i++) {
      Edge e = newRandomEdge(g);
      try {
        if(kc.addEdge(e)) {
          kc.computeUnweighted();
          assertArrayEquals(golden, kc.core());
        } else {
          g.addEdge(e);
          kc.computeUnweighted();
          assertThat(golden, not(equalTo(kc.core())));
          g.removeEdge(e);
          kc.computeUnweighted();
        }
      } catch(UnsupportedOperationException uoe) {}
    }
  }

  @Test
  public void test_removeEdge() {
    Graph g = setUp();
    KCore kc = new KCore(g);
    kc.computeUnweighted();
    int[] golden = Arrays.copyOf(kc.core(), g.V);
    for(int i = 0; i < 10000; i++) {
      Edge e = alreadyExistingRandomEdge(g);
      if(kc.removeEdge(e)) {
        kc.computeUnweighted();
        assertArrayEquals(golden, kc.core());
      } else {
        g.removeEdge(e);
        kc.computeUnweighted();
        assertThat(golden, not(equalTo(kc.core())));
        g.addEdge(e);
        kc.computeUnweighted();
      }
    }
  }

  @Test
  public void test_addAndRemoveEdge() {
    Graph g = setUp();
    KCore kc = new KCore(g);
    kc.computeUnweighted();
    int[] golden = Arrays.copyOf(kc.core(), g.V);
    for(int i = 0; i < 100000; i++) {
      if(i % 2 == 0){
        Edge e = newRandomEdge(g);
        if(kc.addEdge(e)) {
          kc.computeUnweighted();
          assertArrayEquals(golden, kc.core());
        } else {
          g.addEdge(e);
          kc.computeUnweighted();
          assertThat(golden, not(equalTo(kc.core())));
          g.removeEdge(e);
          kc.computeUnweighted();
        }
      } else {
        Edge e = alreadyExistingRandomEdge(g);
        if(kc.removeEdge(e)) {
          kc.computeUnweighted();
          assertArrayEquals(golden, kc.core());
        } else {
          g.removeEdge(e);
          kc.computeUnweighted();
          assertThat(golden, not(equalTo(kc.core())));
          g.addEdge(e);
          kc.computeUnweighted();
        }
      }
    }
  }

  @Test
  public void test_addAndRemoveEdge2() {
    Graph g = new Graph(1000);
    for(int i = 0; i < 10000; i++) {
      g.addEdge(newRandomEdge(g));
    }
    KCore kc = new KCore(g);
    kc.computeUnweighted();
    int[] golden = Arrays.copyOf(kc.core(), g.V);
    for(int i = 0; i < 1000; i++) {
      if(i % 2 == 0){
        Edge e = newRandomEdge(g);
        if(kc.addEdge(e)) {
          kc.computeUnweighted();
          assertArrayEquals(golden, kc.core());
        } else {
          g.addEdge(e);
          kc.computeUnweighted();
          assertThat(golden, not(equalTo(kc.core())));
          g.removeEdge(e);
          kc.computeUnweighted();
        }
      } else {
        Edge e = alreadyExistingRandomEdge(g);
        if(kc.removeEdge(e)) {
          kc.computeUnweighted();
          assertArrayEquals(golden, kc.core());
        } else {
          g.removeEdge(e);
          kc.computeUnweighted();
          assertThat(golden, not(equalTo(kc.core())));
          g.addEdge(e);
          kc.computeUnweighted();
        }
      }
    }
  }

  @Test
  public void test_addAndRemoveEdge_time() {
    Graph g = new Graph(1000);
    for(int i = 0; i < 10000; i++) {
      g.addEdge(newRandomEdge(g));
    }
    KCore kc = new KCore(g);
    kc.computeUnweighted();
    for(int i = 0; i < 10000; i++) {
      if(i % 2 == 0){
        kc.addEdge(newRandomEdge(g));
      } else {
        kc.removeEdge(alreadyExistingRandomEdge(g));
      }
    }
  }

  private static Random r = new Random(1234);
  private static Edge newRandomEdge(Graph g) {
    int v, w;
    do {
      v = r.nextInt(g.V);
      do {
        w = r.nextInt(g.V);
      } while(v == w);
    } while(g.containsEdge(v, w));
    return new Edge(v, w);
  }

  private static Edge alreadyExistingRandomEdge(Graph g) {
    int v, w;
    do {
      v = r.nextInt(g.V);
      do {
        w = r.nextInt(g.V);
      } while(v == w);
    } while(!g.containsEdge(v, w));
    return new Edge(v, w);
  }
}
