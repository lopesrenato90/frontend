// import javax.swing.JFrame; // provides basic window features
// import javax.swing.JLabel; // displays text and images
// import javax.swing.SwingConstants; // common constants used with Swing
// import javax.swing.Icon; // interface used to manipulate images
// import javax.swing.ImageIcon; // loads images
import java.awt.*; // especifica como os componentes são organizados
import javax.swing.*; // carrega todos os componentes do módulo da biblioteca javax

public class LabelFrame extends JFrame // inicio da classe que herda tudo do componente JFrame
{
   private final JLabel label1; // JLabel com apenas texto
   private final JLabel label2; // JLabel construido com texto e icone
   private final JLabel label3; // JLabel com texto e icone adicionados

   // LabelFrame constructor adds JLabels to JFrame
   public LabelFrame()
   {
      super("Testing JLabel"); // Define o titulo na parte superior
      setLayout(new FlowLayout()); // definir o tipo de layout

      // Construtor de JLabel com um argumento string
      label1 = new JLabel("Label with text");
      label1.setToolTipText("This is label1"); // texto do ferramento de dica label1
      add(label1); // adiciona label1 para o JFrame

      // Construto JLabel com uma string, argumentos para icone e alinhamentos
      Icon bug = new ImageIcon(getClass().getResource("bug1.png"));
      label2 = new JLabel("Label with text and icon", bug, 
         SwingConstants.LEFT);
      label2.setToolTipText("This is label2"); // texto do ferramento de dica label2
      add(label2); // adiciona label2 para o JFrame

      label3 = new JLabel(); // Construtor do JLabel sem argumentos
      label3.setText("Label with icon and text at bottom");
      label3.setIcon(bug); // adiciona icone para o JLabel
      label3.setHorizontalTextPosition(SwingConstants.CENTER);
      label3.setVerticalTextPosition(SwingConstants.BOTTOM);
      label3.setToolTipText("This is label3"); // texto do ferramento de dica label3
      add(label3); // adiciona label3 para o JFrame
   } 
} // fim da classe LabelFrame
