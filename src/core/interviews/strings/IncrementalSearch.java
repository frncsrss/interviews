package interviews.strings;

import interviews.trees.Trie;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Incremental search.
 * @author Francois Rousseau
 */
public class IncrementalSearch extends JFrame implements KeyListener {
  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.add("0039");
    trie.add("004478");
    trie.add("0044");
    trie.add("0044566");
    trie.add("0044557");
    trie.add("0044558");
    trie.add("00445585");
    new IncrementalSearch(trie);
  }


  private static final long serialVersionUID = 1L;

  private Trie trie;
  private JTextField textField;

  public IncrementalSearch(Trie trie) {
    this.trie = trie;
    init();
  }

  private void init() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Incremental search");
    this.setSize(300,300);
    this.setLocationRelativeTo(null);
    
    JPanel container = new JPanel();
    
    textField = new JTextField();
    textField.setPreferredSize(new Dimension(300,30));
    textField.setEditable(true);
    textField.addKeyListener(this);
    container.add(textField,BorderLayout.NORTH);  
    
    this.setContentPane(container);
    this.pack();
    this.setVisible(true);    
  }

  public void keyPressed(KeyEvent e) {}
  public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();
    if((key >= KeyEvent.VK_0 && key <= KeyEvent.VK_9)
       || (key >= KeyEvent.VK_NUMPAD0 && key <= KeyEvent.VK_NUMPAD9)) {
      update(trie.completion(textField.getText()));
    } else if(key == KeyEvent.VK_RIGHT) {
      update(trie.completionForced(textField.getText()));
    }
  }
  public void keyTyped(KeyEvent e) {}

  private void update(String suffix) {
    if(suffix != null) {
      textField.setText(textField.getText() + suffix);
      textField.select(textField.getText().length() - suffix.length(), textField.getText().length());
    }
  }
}

