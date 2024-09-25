import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
//import java.util.*;

public class TelaDeAtualizacao extends JFrame {
    public static JLabel lblId;
    public static JComboBox<String> cbxId;
    public static String[] ids;

    public static JLabel lblNome;
    public static JTextField txtNome;

    public static JLabel lblEmail;
    public static JTextField txtEmail;

    public static JLabel lblSenha;
    public static JPasswordField txtSenha;

    public static JLabel lblNotificacoes;

    public static JButton btnAtualizar;
    public static JButton btnCancelar;

    public static int tamanhoInputs = 20;

    public TelaDeAtualizacao() {
        super("Tela de Atualização");
        setLayout(new GridLayout(6, 1, 5, 5));

        JPanel linha_id = new JPanel(new GridLayout(1, 2));
        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        linha_id.add(lblId);

        NavegadorDeRegistro.popularIds();
        cbxId = new JComboBox(ids);
        linha_id.add(cbxId);
        add(linha_id);

        JPanel linha_nome = new JPanel(new GridLayout(1, 2));
        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        linha_nome.add(lblNome);
        txtNome = new JTextField(tamanhoInputs);
        linha_nome.add(txtNome);
        add(linha_nome);

        JPanel linha_email = new JPanel(new GridLayout(1, 2));
        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        linha_email.add(lblEmail);
        txtEmail = new JTextField(tamanhoInputs);
        linha_email.add(txtEmail);
        add(linha_email);

        JPanel linha_senha = new JPanel(new GridLayout(1, 2));
        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT);
        linha_senha.add(lblSenha);
        txtSenha = new JPasswordField(tamanhoInputs);
        linha_senha.add(txtSenha);
        add(linha_senha);

        JPanel linha_botoes = new JPanel(new GridLayout(1, 2));
        btnAtualizar = new JButton("Atualizar");
        linha_botoes.add(btnAtualizar);
        btnCancelar = new JButton("Cancelar");
        linha_botoes.add(btnCancelar);
        add(linha_botoes);

        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));
        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        linha_notificacoes.add(lblNotificacoes);
        add(linha_notificacoes);

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                update();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                clearFields();
            }
        });

        cbxId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    selectId();
                }
            }
        });

        setSize(250, 300);
        ImageIcon img = new ImageIcon("./senac-logo.png");
        setIconImage(img.getImage());
        setVisible(true);
        cbxId.requestFocus();
    }

    private void update() {
        String selectedId = (String) cbxId.getSelectedItem();
        String nome = txtNome.getText();
        String email = txtEmail.getText();
        String senha = new String(txtSenha.getPassword());

        // Atualizar os dados no banco de dados
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlUpdate = "UPDATE `db_senac`.`tbl_senac` SET `nome` = ?, `email` = ?, `senha` = ? WHERE `id` = ?;";
            PreparedStatement stmt = conexao.prepareStatement(strSqlUpdate);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha);
            stmt.setString(4, selectedId);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                lblNotificacoes.setText("Dados atualizados com sucesso!");
            } else {
                lblNotificacoes.setText("Erro ao atualizar os dados!");
            }

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            lblNotificacoes.setText(setHtmlFormat("Erro ao atualizar dados!"));
            System.err.println("Erro: " + e);
        }
    }

    private void clearFields() {
        txtNome.setText("");
        txtEmail.setText("");
        txtSenha.setText("");
        lblNotificacoes.setText("Campos limpos!");
    }

    private void selectId() {
        String selectedId = (String) cbxId.getSelectedItem();

        // Lógica para buscar os dados do banco de dados
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlSelect = "SELECT nome, email, senha FROM `db_senac`.`tbl_senac` WHERE `id` = ?;";
            PreparedStatement stmt = conexao.prepareStatement(strSqlSelect);
            stmt.setString(1, selectedId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                txtNome.setText(rs.getString("nome"));
                txtEmail.setText(rs.getString("email"));
                txtSenha.setText(rs.getString("senha"));
            } else {
                lblNotificacoes.setText(setHtmlFormat("ID não encontrado!"));
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            lblNotificacoes.setText(setHtmlFormat("Erro ao buscar dados!"));
            System.err.println("Erro: " + e);
        }
    }

    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }

    public static void main(String[] args) {
        TelaDeAtualizacao appTelaDePesquisa = new TelaDeAtualizacao();
        appTelaDePesquisa.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
