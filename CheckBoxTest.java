// Testando CheckBoxFrame.
import javax.swing.JFrame;

public class CheckBoxTest
{
   public static void main(String[] args)
   { 
      // Cria uma instância de CheckBoxFrame
      CheckBoxFrame checkBoxFrame = new CheckBoxFrame(); 
      
      // Define a operação padrão de fechamento da janela
      checkBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Define o tamanho da janela
      checkBoxFrame.setSize(275, 100); 
      
      // Torna a janela visível
      checkBoxFrame.setVisible(true); 
   } 
} // Fim da classe CheckBoxTest
