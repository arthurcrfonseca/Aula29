package br.com.bookstore.dao;

import br.com.bookstore.model.Livro;

import java.util.List;
import java.util.Optional;

/**
 * Contrato de persistência do livro. Quem usa não sabe se é SQLite, PostgreSQL ou memória.
 */
public interface LivroDAO {

    void salvar(Livro livro);

    Optional<Livro> buscarPorId(Long id);

    List<Livro> listarTodos();
}
