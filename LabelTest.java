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


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
