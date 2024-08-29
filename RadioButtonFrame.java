import java.awt.*; // Importa classes para interfaces gráficas de usuário
import java.awt.event.*; // Importa classes para lidar com eventos
import javax.swing.*; // Importa classes Swing para criar interfaces gráficas

public class RadioButtonFrame extends JFrame
{
    // Campo de texto para mostrar a mudança de estilo e cor
    private JTextField textField;

    // Fontes para diferentes estilos de texto
    private Font plainFont;
    private Font boldFont;
    private Font italicFont;
    private Font boldItalicFont;

    // Cores para diferentes opções
    private Color blueColor;
    private Color redColor;
    private Color yellowColor;
    private Color blackColor;

    // Botões para escolher o estilo da fonte
    private JRadioButton plainJRadioButton;
    private JRadioButton boldJRadioButton;
    private JRadioButton italicJRadioButton;
    private JRadioButton boldItalicJRadioButton;
    private ButtonGroup radioGroup; // Grupo para gerenciar a seleção dos botões de estilo

    // Botões para escolher a cor do texto
    private JRadioButton blueJRadioButton;
    private JRadioButton redJRadioButton;
    private JRadioButton yellowJRadioButton;
    private JRadioButton blackJRadioButton;
    private ButtonGroup colorRadioGroup; // Grupo para gerenciar a seleção dos botões de cor

    public RadioButtonFrame()
    {
        super("RadioButton Test"); // Define o título da janela
        setLayout(new FlowLayout()); // Define o layout para o painel de componentes

        // Cria e adiciona o campo de texto à janela
        textField = new JTextField("Watch the font style change", 25);
        add(textField);

        // Cria e adiciona os botões de rádio para escolher o estilo da fonte
        plainJRadioButton = new JRadioButton("Plain", true); // Botão para estilo normal
        boldJRadioButton = new JRadioButton("Bold", false); // Botão para estilo negrito
        italicJRadioButton = new JRadioButton("Italic", false); // Botão para estilo itálico
        boldItalicJRadioButton = new JRadioButton("Bold/Italic", false); // Botão para estilo negrito e itálico
        add(plainJRadioButton);
        add(boldJRadioButton);
        add(italicJRadioButton);
        add(boldItalicJRadioButton);

        // Adiciona os botões de rádio ao grupo para garantir que apenas um seja selecionado de cada vez
        radioGroup = new ButtonGroup();
        radioGroup.add(plainJRadioButton);
        radioGroup.add(boldJRadioButton);
        radioGroup.add(italicJRadioButton);
        radioGroup.add(boldItalicJRadioButton);

        // Cria e adiciona os botões de rádio para escolher a cor do texto
        blueJRadioButton = new JRadioButton("Blue", false); // Botão para a cor azul
        redJRadioButton = new JRadioButton("Red", false); // Botão para a cor vermelha
        yellowJRadioButton = new JRadioButton("Yellow", false); // Botão para a cor amarela
        blackJRadioButton = new JRadioButton("Black", true); // Botão para a cor preta
        add(blueJRadioButton);
        add(redJRadioButton);
        add(yellowJRadioButton);
        add(blackJRadioButton);

        // Adiciona os botões de rádio ao grupo para garantir que apenas um seja selecionado de cada vez
        colorRadioGroup = new ButtonGroup();
        colorRadioGroup.add(blueJRadioButton);
        colorRadioGroup.add(redJRadioButton);
        colorRadioGroup.add(yellowJRadioButton);
        colorRadioGroup.add(blackJRadioButton);

        // Define as fontes para diferentes estilos
        plainFont = new Font("Serif", Font.PLAIN, 14);
        boldFont = new Font("Serif", Font.BOLD, 14);
        italicFont = new Font("Serif", Font.ITALIC, 14);
        boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
        textField.setFont(plainFont); // Define a fonte inicial do campo de texto

        // Define as cores para diferentes opções
        blueColor = new Color(0, 0, 255); // Azul
        redColor = new Color(255, 0, 0); // Vermelho
        yellowColor = new Color(255, 255, 0); // Amarelo
        blackColor = new Color(0, 0, 0); // Preto

        // Adiciona ouvintes de eventos para os botões de estilo
        plainJRadioButton.addItemListener(
                new RadioButtonHandler(plainFont));
        boldJRadioButton.addItemListener(
                new RadioButtonHandler(boldFont));
        italicJRadioButton.addItemListener(
                new RadioButtonHandler(italicFont));
        boldItalicJRadioButton.addItemListener(
                new RadioButtonHandler(boldItalicFont));

        // Adiciona ouvintes de eventos para os botões de cor
        blueJRadioButton.addItemListener(
                new ColorRadioButtonHandler(blueColor));
        redJRadioButton.addItemListener(
                new ColorRadioButtonHandler(redColor));
        yellowJRadioButton.addItemListener(
                new ColorRadioButtonHandler(yellowColor));
        blackJRadioButton.addItemListener(
                new ColorRadioButtonHandler(blackColor));
    }

    // Classe interna para tratar eventos dos botões de estilo
    private class RadioButtonHandler implements ItemListener
    {
        private Font font; // Fonte a ser aplicada

        public RadioButtonHandler(Font f) {
            font = f; // Inicializa a fonte
        }

        @Override
        public void itemStateChanged(ItemEvent event) {
            textField.setFont(font); // Aplica a fonte ao campo de texto
        }
    }

    // Classe interna para tratar eventos dos botões de cor
    private class ColorRadioButtonHandler implements ItemListener
    {
        private Color color; // Cor a ser aplicada

        public ColorRadioButtonHandler(Color c) {
            color = c; // Inicializa a cor
        }

        @Override
        public void itemStateChanged(ItemEvent event) {
            textField.setForeground(color); // Aplica a cor ao texto do campo
        }
    }
}
