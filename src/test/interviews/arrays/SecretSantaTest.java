package interviews.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SecretSantaTest {
  @Test
  public void test() {
    String[] players = new String[] {"Fred", "Wilma", "Barney", "Pebbles", "Bam Bam"};

    Map<String, Map<String, Integer>> receivers = new HashMap<String, Map<String, Integer>>();
    for(String player : players) {
      receivers.put(player, new HashMap<String, Integer>());
    }

    final int T = 100000;
    for(int i = 0; i < T; i++) {
      String[][] santas = new SecretSanta().assign(players);
      for(int j = 0; j < players.length; j++) {
        final String giver = santas[j][0];
        final String receiver = santas[j][1];
        if(!receivers.get(giver).containsKey(receiver)) {
          receivers.get(giver).put(receiver, 0);
        }
        receivers.get(giver).put(receiver, receivers.get(giver).get(receiver) + 1);
      }
    }

    final int expected = T / (players.length - 1);
    final int low = (int) (expected * 0.95);
    final int high = (int) (expected * 1.05);
    for(Entry<String, Map<String, Integer>> e : receivers.entrySet()) {
      for(int count : e.getValue().values()) {
        Assert.assertTrue(low <= count && count <= high);
      }
    }
  }
}
