package br.ufes.contatos.presenter;

import br.ufes.contatos.view.ManterContatoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import br.ufes.contatos.collection.ContatoCollection;
import br.ufes.contatos.model.Contato;

/**
 *
 * @author clayton
 */
public class ManterContatoPresenter {

    private ManterContatoView view;
    private ContatoCollection contatos;

    public ManterContatoPresenter(ContatoCollection contatos) {
        this.contatos = contatos;
        view = new ManterContatoView();

        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }

        });

        view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar();
            }
        });

        view.setVisible(true);
    }

    private void fechar() {
        view.dispose();
    }

    private void salvar() {
        String nome = view.getTxtNome().getText();
        String telefone = view.getTxtTelefone().getText();

        Contato contato = new Contato(nome, telefone);

        contatos.add(contato);

        JOptionPane.showMessageDialog(view,
                "Contato " + contato.getNome() + " salvo com sucesso!",
                "Salvo com sucesso",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
