// JCheckBoxes e eventos de item.
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class CheckBoxFrame extends JFrame 
{
   private final JTextField textField; // exibe texto em fontes variáveis
   private final JCheckBox boldJCheckBox; // para selecionar/deselecionar negrito
   private final JCheckBox italicJCheckBox; // para selecionar/deselecionar itálico

   // Construtor CheckBoxFrame adiciona JCheckBoxes ao JFrame
   public CheckBoxFrame()
   {
      super("Teste JCheckBox");
      setLayout(new FlowLayout());

      // configura JTextField e define sua fonte
      textField = new JTextField("Watch the font style change", 20);
      textField.setFont(new Font("Serif", Font.PLAIN, 14));
      add(textField); // adiciona textField ao JFrame

      boldJCheckBox = new JCheckBox("Bold"); 
      italicJCheckBox = new JCheckBox("Italic"); 
      add(boldJCheckBox); // adiciona checkbox de negrito ao JFrame
      add(italicJCheckBox); // adiciona checkbox de itálico ao JFrame

      // registra ouvintes para os JCheckBoxes
      CheckBoxHandler handler = new CheckBoxHandler();
      boldJCheckBox.addItemListener(handler);
      italicJCheckBox.addItemListener(handler);
   } 

   // classe interna privada para tratamento de eventos ItemListener
   private class CheckBoxHandler implements ItemListener 
   {
      // responde a eventos de checkbox
      @Override
      public void itemStateChanged(ItemEvent event)
      {
         Font font = null; // armazena a nova fonte

         // determina quais JCheckBoxes estão selecionados e cria a fonte correspondente
         if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected())
            font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
         else if (boldJCheckBox.isSelected())
            font = new Font("Serif", Font.BOLD, 14);
         else if (italicJCheckBox.isSelected())
            font = new Font("Serif", Font.ITALIC, 14);
         else
            font = new Font("Serif", Font.PLAIN, 14);

         textField.setFont(font); // aplica a nova fonte ao textField
      } 
   }
} // fim da classe CheckBoxFrame
