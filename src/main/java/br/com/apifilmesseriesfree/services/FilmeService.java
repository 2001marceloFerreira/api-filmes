package br.com.apifilmesseriesfree.services;

import br.com.apifilmesseriesfree.model.Filme;
import br.com.apifilmesseriesfree.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> obterTodos() {
        return filmeRepository.findAll();
    }

    public Optional<Filme> obterPorId(Long id) {
        return filmeRepository.findById(id);
    }

    public Filme adicionar(Filme filme) {
        filme.setId(null);

        return filmeRepository.save(filme);
    }

    public void deletar(Long id) {
        filmeRepository.deleteById(id);
    }

    public Filme atualizar(Long id, Filme filme){
        filme.setId(id);

        return filmeRepository.save(filme);
    }
    public Filme PersistirFilme(Filme filme) {
        return filmeRepository.saveAndFlush(filme);
    }
}
