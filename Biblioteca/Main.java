package Biblioteca;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE BIBLIOTECA =====");
            System.out.println("1 - Adicionar livro (físico)"); 
            System.out.println("2 - Adicionar livro (digital)"); 
            System.out.println("3 - Listar acervo"); 
            System.out.println("4 - Pesquisar por título"); 
            System.out.println("5 - Pesquisar por autor"); 
            System.out.println("6 - Remover livro (por índice)"); 
            System.out.println("7 - Atualizar livro (por índice)"); 
            System.out.println("8 - Contar livros"); 
            System.out.println("9 - Pesquisar por intervalo de anos"); 
            System.out.println("10 - Livro mais antigo / mais novo"); 
            System.out.println("0 - Sair"); 

            opcao = Input.lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> {
                    String titulo = Input.lerString("Título: ");
                    String autor = Input.lerString("Autor: ");
                    int ano = Input.lerInt("Ano de publicação: ");
                    int paginas = Input.lerInt("Número de páginas: ");
                    boolean ok = biblioteca.adicionarLivro(new LivroFisico(titulo, autor, ano, paginas));
                    if (ok) System.out.println("Livro físico cadastrado."); 
                }
                case 2 -> {
                    String titulo = Input.lerString("Título: ");
                    String autor = Input.lerString("Autor: ");
                    int ano = Input.lerInt("Ano de publicação: ");
                    int paginas = Input.lerInt("Número de páginas: ");
                    boolean ok = biblioteca.adicionarLivro(new LivroDigital(titulo, autor, ano, paginas));
                    if (ok) System.out.println("Livro digital cadastrado."); 
                }
                case 3 -> {
                    List<Livro> lista = biblioteca.listarAcervo();
                    if (lista.isEmpty()) {
                        System.out.println("Acervo vazio."); 
                    } else {
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println("[" + i + "] " + lista.get(i));
                        }
                    }
                }
                case 4 -> {
                    String t = Input.lerString("Título para pesquisar: ");
                    List<Livro> res = biblioteca.pesquisarPorTitulo(t);
                    if (res.isEmpty()) System.out.println("Nenhum livro encontrado com esse título."); 
                    else res.forEach(System.out::println);
                }
                case 5 -> {
                    String a = Input.lerString("Autor para pesquisar: ");
                    List<Livro> res = biblioteca.pesquisarPorAutor(a);
                    if (res.isEmpty()) System.out.println("Nenhum livro encontrado com esse autor."); 
                    else res.forEach(System.out::println);
                }
                case 6 -> {
                    int idx = Input.lerInt("Índice do livro para remover: ");
                    if (biblioteca.removerPorIndice(idx)) System.out.println("Removido com sucesso."); 
                    else System.out.println("Índice inválido."); 
                }
                case 7 -> {
                    int idx = Input.lerInt("Índice do livro a atualizar: ");
                    String novoTitulo = Input.lerString("Novo título: ");
                    String novoAutor = Input.lerString("Novo autor: ");
                    int novoAno = Input.lerInt("Novo ano de publicação: ");
                    int novasPaginas = Input.lerInt("Novo número de páginas: ");
                    boolean ok = biblioteca.atualizarPorIndice(idx, new LivroFisico(novoTitulo, novoAutor, novoAno, novasPaginas));
                    if (ok) System.out.println("Atualizado com sucesso."); 
                    else System.out.println("Falha ao atualizar (índice/validação).");
                }
                case 8 -> System.out.println("Total de livros: " + biblioteca.contarLivros());
                case 9 -> {
                    int inicio = Input.lerInt("Ano inicial: ");
                    int fim = Input.lerInt("Ano final: ");
                    List<Livro> r = biblioteca.pesquisarPorIntervaloAno(inicio, fim);
                    if (r.isEmpty()) System.out.println("Nenhum livro encontrado no intervalo."); 
                    else r.forEach(System.out::println);
                }
                case 10 -> {
                    Livro maisAntigo = biblioteca.livroMaisAntigo();
                    Livro maisNovo = biblioteca.livroMaisNovo();
                    System.out.println("Mais antigo: " + (maisAntigo == null ? "-" : maisAntigo));
                    System.out.println("Mais novo: " + (maisNovo == null ? "-" : maisNovo));
                }
                case 0 -> System.out.println("Saindo..."); 
                default -> System.out.println("Opção inválida."); 
            }

        } while (opcao != 0);
    }
}
