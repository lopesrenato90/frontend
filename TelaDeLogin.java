import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;

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

        btnEntrar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    Connection conexao = MySQLConnector.conectar();
                    String strSqlLogin = "select * from 'db_senac', tbl_senac' where 'email = '" + txtLogin.getText() + "'and' 'senha' ='" + txtSenha.getPassword() + "';'";
                    Statament stmSqlLogin = conexao.createStatement();
                    ResultSet rstLogin = stmSqlLogin.executeQuery(strSqlLogin);
                    try {
                        rstSqlLogin.next();
                        stmSqlLogin.close();
                    } catch (Exception e) {
                        lblNotificacoes.setText("Não foi possível enconrar o login e/ou senha digitados/informados!  Por favor verifique e tente novamente. Veja o erro: " + e);
                    }
                }
                
            };
        );

        setSize(150, 200);
        setVisible(true);

        MySQLConnector.conectar();
    }

    public static void main(String[] args){ TelaDeLogin appTelaDeLogin = new TelaDeLogin();
        appTelaDeLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}

