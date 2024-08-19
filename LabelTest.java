// Fig. 12.7: LabelTest.java
// Testing LabelFrame.
import javax.swing.JFrame;

public class LabelTest 
{
   public static void main(String[] args)
   { 
      LabelFrame labelFrame = new LabelFrame(); // define abertura do label-janela
      labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // comando no frame para encerrar a janela ao clicar "x"
      labelFrame.setSize(380, 480); // define largura e altura width=largura/height=altura 
      labelFrame.setVisible(true); // tornar vísivel a janela 
   } 
} // encerramento da classe LabelTest
