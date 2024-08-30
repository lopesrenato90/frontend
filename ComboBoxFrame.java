// Importações necessárias para criar a interface gráfica
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxFrame extends JFrame {
   // JComboBox que exibe uma lista de nomes de imagens
   private final JComboBox<String> imagesJComboBox; // mantém os nomes dos ícones
   private final JLabel label; // exibe o ícone selecionado

   // Nomes dos arquivos de imagem
   private static final String[] names = 
      {"bug1.gif", "bug2.gif", "travelbug.gif", "buganim.gif", "5517062.png"};
   
   // Ícones correspondentes aos nomes das imagens
   private final Icon[] icons = { 
      new ImageIcon(getClass().getResource(names[0])),
      new ImageIcon(getClass().getResource(names[1])), 
      new ImageIcon(getClass().getResource(names[2])),
      new ImageIcon(getClass().getResource(names[3])),
      new ImageIcon(getClass().getResource(names[4]))};

   // Construtor do ComboBoxFrame adiciona o JComboBox ao JFrame
   public ComboBoxFrame() {
      super("Testing JComboBox"); // Define o título da janela
      setLayout(new FlowLayout()); // Define o layout do frame como FlowLayout

      // Inicializa o JComboBox com os nomes das imagens
      imagesJComboBox = new JComboBox<>(names); 
      imagesJComboBox.setMaximumRowCount(2); // Exibe três linhas dentro da caixa

      // Adiciona um ItemListener ao JComboBox
      imagesJComboBox.addItemListener(
         new ItemListener() { // classe interna anônima
            // Trata o evento do JComboBox
            @Override
            public void itemStateChanged(ItemEvent event) {
               // Verifica se um item foi selecionado
               if (event.getStateChange() == ItemEvent.SELECTED)
                  // Atualiza o ícone do JLabel com o ícone selecionado
                  label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
            } 
         } // fim da classe interna anônima
      ); // fim da chamada para addItemListener

      // Adiciona o JComboBox ao JFrame
      add(imagesJComboBox);
      // Inicializa o JLabel com o primeiro ícone e adiciona ao JFrame
      label = new JLabel(icons[0]); 
      add(label);
   }
} // fim da classe ComboBoxFrame
