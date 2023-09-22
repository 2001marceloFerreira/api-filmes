package br.com.apifilmesseriesfree.resources;

import br.com.apifilmesseriesfree.model.Filme;
import br.com.apifilmesseriesfree.repositories.FilmeRepository;
import br.com.apifilmesseriesfree.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/filme")
public class FilmeResource {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public List<Filme> obterTodos() {
        return filmeService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Filme> obterPorId(@PathVariable Long id){
        return filmeService.obterPorId(id);
    }

    @PostMapping
    public Filme adicionar(@RequestBody Filme filme){
        return filmeService.adicionar(filme);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        filmeService.deletar(id);
    }

    @PutMapping("/{id}")
    public Filme atualizar(@PathVariable Long id, @RequestBody Filme filme){

        Optional<Filme> filmeSalvo = filmeService.obterPorId(id);

        filmeSalvo.get().setNome(filme.getNome());
        filmeSalvo.get().setImagemBase64(filme.getImagemBase64());
        filmeSalvo.get().setDescricao(filme.getDescricao());


     Filme filmeEditar = filmeService.PersistirFilme(filmeSalvo.get());

        return filmeEditar;
    }

}
