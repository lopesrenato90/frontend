// Testando ComboBoxFrame.
import javax.swing.JFrame;

public class ComboBoxTest
{
   public static void main(String[] args)
   { 
      ComboBoxFrame comboBoxFrame = new ComboBoxFrame(); // criação de objeto para a variavél ComboBoxFrame
      comboBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // invocação de método para fechar a tela
      comboBoxFrame.setSize(350, 150); // invocação de método para definir tamanho
      comboBoxFrame.setVisible(true); // invocação de método para tornar visivel
   } 
} // fim da classe ComboBoxTest