// JList que permite seleções multiplas
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MultipleSelectionFrame extends JFrame 
{
   private final JList<String> colorJList; // lista de armazanemaneto de nome de cores
   private final JList<String> copyJList; // lista de armazanemaneto de nomes copiados
   private final JList<String> copyJList2; //  lista de armazanemaneto 2 de nomes copiados
   private JButton copyJButton; // botão para copiar nomes selecionados
   private JButton copyJButton2; //  botão 2 para copiar nomes selecionados
   
   private static final String[] colorNames = {"Black", "Blue", "Cyan",
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", 
      "Pink", "Red", "White", "Yellow"};

   // MultipleSelectionFrame construtor
   public MultipleSelectionFrame()
   {
      super("Multiple Selection Lists");
      setLayout(new FlowLayout());

      colorJList = new JList<String>(colorNames); // lista de nome de cores
      colorJList.setVisibleRowCount(5); // mostra 5 linhas
      colorJList.setSelectionMode(
         ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      add(new JScrollPane(colorJList)); // adiciona lista com barra de rolagem

      copyJButton = new JButton("Copy >>>"); 
      copyJButton.addActionListener(
         new ActionListener() // classe anonima
         {  
            // botão do evento
            @Override
            public void actionPerformed(ActionEvent event)
            {
               // coloca os valores selecionados na coluna abaixo
               copyJList.setListData(
                  colorJList.getSelectedValuesList().toArray(
                     new String[0]));
            }
         } 
      ); 
      add(copyJButton); // adiciona o botão de cópia ao JFrame

      copyJList = new JList<String>(); // lista para armezanar os nomes das cores
      copyJList.setVisibleRowCount(5); // mostra 5 linhas
      copyJList.setFixedCellWidth(100); // define a largura da célula fixa
      copyJList.setFixedCellHeight(15); // define a altura da célula fixa
      copyJList.setSelectionMode(
         ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      add(new JScrollPane(copyJList)); // adiciona lista com barra de rolagem

   copyJButton2 = new JButton("Copy >>>"); 
   copyJButton2.addActionListener(
      new ActionListener() // classe anonima
      {  
         // botão do evento
         @Override
         public void actionPerformed(ActionEvent event)
         {
            // coloca os valores selecionados na coluna abaixo
            copyJList2.setListData(
               copyJList.getSelectedValuesList().toArray(
                  new String[0]));
         }
      } 
   ); 
   add(copyJButton2); // adiciona o botão de cópia ao JFrame

   copyJList2 = new JList<String>(); // lista para armezanar os nomes das cores
   copyJList2.setVisibleRowCount(5); // mostra 5 linhas
   copyJList2.setFixedCellWidth(100); // define a largura da célula fixa
   copyJList2.setFixedCellHeight(15); // define a altura da célula fixa
   copyJList2.setSelectionMode(
      ListSelectionModel.SINGLE_INTERVAL_SELECTION);
   add(new JScrollPane(copyJList2)); // adiciona lista com barra de rolagem
 }
}// fim da classe MultipleSelectionFrame