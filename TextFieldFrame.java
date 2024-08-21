import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFieldFrame extends JFrame 
{
   private final JTextField textField1; // Campo de texto com tamanho definido
   private final JTextField textField2; // Campo de texto com texto padrão
   private final JTextField textField3; // Campo de texto com texto padrão e tamanho definido
   private final JPasswordField passwordField; // Campo de senha para entrada de texto oculto

   // Construtor de TextFieldFrame que configura e adiciona os componentes ao JFrame
   public TextFieldFrame()
   {
      super("Teste de JTextField e JPasswordField"); // Define o título da janela
      setLayout(new FlowLayout()); // Define o layout dos componentes como FlowLayout

      // Cria um campo de texto com 10 colunas (largura)
      textField1 = new JTextField(10); 
      add(textField1); // Adiciona textField1 ao JFrame

      // Cria um campo de texto com texto padrão
      textField2 = new JTextField("Digite seu texto aqui");
      add(textField2); // Adiciona textField2 ao JFrame

      // Cria um campo de texto com texto padrão e 21 colunas (largura), e desativa a edição
      textField3 = new JTextField("Campo de texto não editável", 21);
      textField3.setEditable(false); // Define o campo como não editável
      add(textField3); // Adiciona textField3 ao JFrame

      // Cria um campo de senha com texto padrão (o texto é ocultado)
      passwordField = new JPasswordField("Texto oculto");
      add(passwordField); // Adiciona passwordField ao JFrame

      // Registra um manipulador de eventos para os campos de texto e campo de senha
      TextFieldHandler handler = new TextFieldHandler();
      textField1.addActionListener(handler); // Adiciona o manipulador de eventos a textField1
      textField2.addActionListener(handler); // Adiciona o manipulador de eventos a textField2
      textField3.addActionListener(handler); // Adiciona o manipulador de eventos a textField3
      passwordField.addActionListener(handler); // Adiciona o manipulador de eventos a passwordField
   } // Fim do construtor TextFieldFrame

   // Classe interna privada para manipulação de eventos de ação dos campos de texto
   private class TextFieldHandler implements ActionListener 
   {
      // Processa os eventos gerados quando o usuário pressiona Enter em um dos campos de texto
      @Override
      public void actionPerformed(ActionEvent event)
      {
         String string = ""; // Inicializa a variável para armazenar a mensagem a ser exibida
         
         // Verifica qual campo gerou o evento e formata a mensagem correspondente
         if (event.getSource() == textField1)
            string = String.format("textField1: %s", event.getActionCommand());
         
         else if (event.getSource() == textField2)
            string = String.format("textField2: %s", event.getActionCommand());
         
         else if (event.getSource() == textField3)
            string = String.format("textField3: %s", event.getActionCommand());
         
         else if (event.getSource() == passwordField)
            string = String.format("passwordField: %s", event.getActionCommand());;
         
         // Exibe uma caixa de diálogo com o conteúdo do campo de texto onde o evento ocorreu
         JOptionPane.showMessageDialog(null, string); 
      } 
   } // Fim da classe interna TextFieldHandler
} // Fim da classe TextFieldFrame
