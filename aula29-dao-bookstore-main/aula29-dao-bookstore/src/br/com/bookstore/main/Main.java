package br.com.bookstore.main;

import br.com.bookstore.dao.LivroDAO;
import br.com.bookstore.dao.LivroDAOSqlite;
import br.com.bookstore.model.Livro;

import java.util.Locale;

/**
 * Roteiro de testes da lista: salvar, buscar por id, buscar id inexistente e listar.
 */
public class Main {

    public static void main(String[] args) {
        // A variável é do tipo da interface (DIP)
        LivroDAO dao = new LivroDAOSqlite();

        Livro l1 = new Livro("Clean Code", "Robert C. Martin", 129.90);
        Livro l2 = new Livro("Design Patterns", "Gang of Four", 189.50);
        Livro l3 = new Livro("Refactoring", "Martin Fowler", 149.00);
        dao.salvar(l1);
        dao.salvar(l2);
        dao.salvar(l3);
        System.out.println("IDs gerados: " + l1.getId() + ", " + l2.getId() + ", " + l3.getId());

        System.out.println("\n--- Busca do livro de ID 2 ---");
        dao.buscarPorId(2L).ifPresentOrElse(
                livro -> System.out.println(livro),
                () -> System.out.println("Livro de ID 2 não encontrado."));

        System.out.println("\n--- Busca do livro de ID 999 ---");
        dao.buscarPorId(999L).ifPresentOrElse(
                livro -> System.out.println(livro),
                () -> System.out.println("Nenhum livro com ID 999. (sem NullPointerException)"));

        System.out.println("\n--- Catálogo completo ---");
        System.out.printf("%-4s | %-20s | %-18s | %10s%n", "ID", "TÍTULO", "AUTOR", "PREÇO");
        for (Livro livro : dao.listarTodos()) {
            System.out.printf(Locale.US, "%-4d | %-20s | %-18s | R$ %7.2f%n",
                    livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getPreco());
        }
    }
}
