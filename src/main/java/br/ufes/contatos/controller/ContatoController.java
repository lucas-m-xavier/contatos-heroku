package br.ufes.contatos.controller;

import org.springframework.web.bind.annotation.*;
import br.ufes.contatos.model.Contato;
import br.ufes.contatos.repository.ContatoRepository;

import java.util.List;

@RestController
@RequestMapping("/")
public class ContatoController {

    private ContatoRepository contatoRepository;

    public ContatoController(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @GetMapping
    public List<Contato> getContatos() {
        return (List<Contato>) contatoRepository.findAll();
    }

    @PostMapping
    public void addContato(@RequestBody Contato contato) {
        contatoRepository.save(contato);
    }
}
