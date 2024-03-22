package view.user;

import dto.UsuarioDTO;

import javax.swing.*;
import java.util.List;

public class UsuarioViewPane implements IUsuarioView {

    @Override
    public UsuarioDTO cadastrarUsuario() {

        JLabel nomeLabel = new JLabel("Nome");
        JTextField nomeField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel telefoneLabel = new JLabel("Telefone:");
        JTextField telefoneField = new JTextField();
        JLabel cargoLabel = new JLabel("Cargo:");
        JTextField cargoField = new JTextField();

        JComponent[] components = new JComponent[]{
                nomeLabel,
                nomeField,
                emailLabel,
                emailField,
                telefoneLabel,
                telefoneField,
                cargoLabel,
                cargoField
        };

        int result = JOptionPane.showConfirmDialog(null, components, "Cadastrar usuario", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            return new UsuarioDTO(
                    nomeField.getText(),
                    emailField.getText(),
                    telefoneField.getText(),
                    cargoField.getText()
            );
        }

        return null;
    }

    @Override
    public void listarPenalidades(List<UsuarioDTO> usuariosComPenalidade) {

        StringBuilder sb = new StringBuilder();
        sb.append("Usuarios com penalidade:\n");
        usuariosComPenalidade.forEach(usuario -> sb.append(usuario.toString()).append("\n"));
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
