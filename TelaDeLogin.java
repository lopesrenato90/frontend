import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class TelaDeLogin extends JFrame
{
    private final JLabel lblLogin;
    private final JTextField txtLogin;

    private final JLabel lblSenha;
    private final JPasswordField txtSenha;

    private final JButton btnEntrar;

    private final JLabel lblNotificacoes;

    public TelaDeLogin()
    {
        super("Tela de Login");
        setLayout(new FlowLayout());

        lblLogin = new JLabel("Login");
        add(lblLogin);

        txtLogin = new JTextField(10);
        add(txtLogin);

        lblSenha = new JLabel("Senha");
        add(lblSenha);

        txtSenha = new JPasswordField(10);
        add(txtSenha);
        
        btnEntrar = new JButton("Entrar");
        add(btnEntrar);

        add(new JLabel("         "));
        lblNotificacoes = new JLabel ("Notificações", SwingConstants.CENTER);
        add(lblNotificacoes);

        setSize(200, 200);
        setVisible(true);

        MySQLConnector.conectar();
    }

    public static void main(String[] args){ TelaDeLogin appTelaDeLogin = new TelaDeLogin();
        appTelaDeLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}

