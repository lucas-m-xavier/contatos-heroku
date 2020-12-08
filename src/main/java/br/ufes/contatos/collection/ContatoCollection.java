/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.contatos.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.web.client.RestTemplate;
import br.ufes.contatos.model.Contato;

/**
 *
 * @author Lucas
 */
public class ContatoCollection {
    private ArrayList<Contato> contatos;
    private final String url = "https://contatospss.herokuapp.com/";

    public ContatoCollection() {
        contatos = getContatosREST().contatos;
    }

    private ContatoCollection(List<Contato> asList) {
        contatos = new ArrayList<>();
    }

    public void add(Contato contato) {
        if (contatos.contains(contato))
            throw new RuntimeException("Contato já existe");
        
        if (contato != null) {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject(url, contato, Contato.class);
        } else {
            throw new RuntimeException("Forneça uma instância válida de um contato");
        }
    }
    
    public ContatoCollection getContatosREST() {
        RestTemplate restTemplate = new RestTemplate();
        Contato[] contatos = restTemplate.getForObject(url, Contato[].class);
        return new ContatoCollection(Arrays.asList(contatos));
    }
    
    public List<Contato> getContatos() {
        return Collections.unmodifiableList(contatos);
    }

}
