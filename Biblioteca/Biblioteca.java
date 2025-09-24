package Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    public static final int ANO_PUBLICACAO_MINIMO = 1450;

    private List<Livro> acervo = new ArrayList<>();

    public boolean adicionarLivro(Livro livro) {
        if (livro.getTitulo() == null || livro.getTitulo().trim().isEmpty()) {
            System.out.println("Título obrigatório.");
            return false;
        }
        if (livro.getAutor() == null || livro.getAutor().trim().isEmpty()) {
            System.out.println("Autor obrigatório.");
            return false;
        }
        if (livro.getAnoPublicacao() < ANO_PUBLICACAO_MINIMO) {
            System.out.println("Ano de publicação abaixo do permitido (min: " + ANO_PUBLICACAO_MINIMO + ").");
            return false;
        }
        if (livro.getNumeroPaginas() <= 0) {
            System.out.println("Número de páginas deve ser maior que zero.");
            return false;
        }

        // evita duplicidade: título + autor + ano
        for (Livro l : acervo) {
            if (l.getTitulo().equalsIgnoreCase(livro.getTitulo())
                    && l.getAutor().equalsIgnoreCase(livro.getAutor())
                    && l.getAnoPublicacao() == livro.getAnoPublicacao()) {
                System.out.println("Livro duplicado (Título+Autor+Ano).");
                return false;
            }
        }

        acervo.add(livro);
        return true;
    }

    public List<Livro> listarAcervo() {
        return new ArrayList<>(acervo);
    }

    public List<Livro> pesquisarPorTitulo(String titulo) {
        List<Livro> encontrados = new ArrayList<>();
        for (Livro l : acervo) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                encontrados.add(l);
            }
        }
        return encontrados;
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> encontrados = new ArrayList<>();
        for (Livro l : acervo) {
            if (l.getAutor().equalsIgnoreCase(autor)) {
                encontrados.add(l);
            }
        }
        return encontrados;
    }

    public boolean removerPorIndice(int indice) {
        if (indice < 0 || indice >= acervo.size()) return false;
        acervo.remove(indice);
        return true;
    }

    public boolean atualizarPorIndice(int indice, Livro novoLivro) {
        if (indice < 0 || indice >= acervo.size()) return false;
        // validações mínimas (mesmas do adicionar)
        if (novoLivro.getAnoPublicacao() < ANO_PUBLICACAO_MINIMO) return false;
        acervo.set(indice, novoLivro);
        return true;
    }

    public int contarLivros() {
        return acervo.size();
    }

    public List<Livro> pesquisarPorIntervaloAno(int inicio, int fim) {
        List<Livro> encontrados = new ArrayList<>();
        for (Livro l : acervo) {
            if (l.getAnoPublicacao() >= inicio && l.getAnoPublicacao() <= fim) {
                encontrados.add(l);
            }
        }
        return encontrados;
    }

    public Livro livroMaisAntigo() {
        if (acervo.isEmpty()) return null;
        Livro maisAntigo = acervo.get(0);
        for (Livro l : acervo) {
            if (l.getAnoPublicacao() < maisAntigo.getAnoPublicacao()) {
                maisAntigo = l;
            }
        }
        return maisAntigo;
    }

    public Livro livroMaisNovo() {
        if (acervo.isEmpty()) return null;
        Livro maisNovo = acervo.get(0);
        for (Livro l : acervo) {
            if (l.getAnoPublicacao() > maisNovo.getAnoPublicacao()) {
                maisNovo = l;
            }
        }
        return maisNovo;
    }
}
