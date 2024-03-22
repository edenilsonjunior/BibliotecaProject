package view.livro;

import dto.LivroDTO;

import javax.swing.*;
import java.util.List;
import java.util.Set;

public class LivroViewPane implements ILivroView {

    @Override
    public LivroDTO cadastrarLivro() {

        JLabel tituloLabel = new JLabel("Titulo:");
        JTextField tituloField = new JTextField();
        JLabel autorLabel = new JLabel("Autor:");
        JTextField autorField = new JTextField();
        JLabel edicaoLabel = new JLabel("Edicao:");
        JTextField edicaoField = new JTextField();
        JComboBox<String> disponibilidadeComboBox = new JComboBox<>();
        disponibilidadeComboBox.addItem("Disponível");
        disponibilidadeComboBox.addItem("Indisponível");

        JComponent[] components = new JComponent[]{
                tituloLabel,
                tituloField,
                autorLabel,
                autorField,
                edicaoLabel,
                edicaoField,
                disponibilidadeComboBox
        };

        int result = JOptionPane.showConfirmDialog(null, components, "Cadastrar livro", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            return new LivroDTO(
                    tituloField.getText(),
                    autorField.getText(),
                    edicaoField.getText(),
                    disponibilidadeComboBox.getSelectedItem().equals("Disponível"));
        }

        return null;
    }

    @Override
    public void listarLivros(Set<LivroDTO> livros) {

        StringBuilder sb = new StringBuilder();
        sb.append("Livros:\n");
        livros.forEach(livro -> sb.append(livro.toString()).append("\n"));
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    @Override
    public void listarQntLivrosEmprestados(List<String> livrosEmprestados) {

        StringBuilder sb = new StringBuilder();
        sb.append("Livros emprestados:\n");
        livrosEmprestados.forEach(livro -> sb.append(livro).append("\n"));
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
