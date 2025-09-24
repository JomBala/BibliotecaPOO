📚 Sistema de Biblioteca em Java

Este projeto é um sistema de gerenciamento de biblioteca desenvolvido em Java, como parte da disciplina de Organização e Abstração de Programação Orientada a Objetos.

O objetivo é aplicar conceitos de classes abstratas, herança, polimorfismo e encapsulamento, além de implementar todas as funcionalidades trabalhadas em sala de aula, incluindo o desafio da Aula 07.

✨ Funcionalidades Implementadas

✅ Cadastro de livros físicos e livros digitais

✅ Listagem de todos os livros do acervo

✅ Pesquisa por título e por autor

✅ Atualização e remoção de livros por índice

✅ Contagem do total de livros cadastrados

✅ Validação de duplicidade de títulos

✅ Pesquisa de livros por intervalo de anos

✅ Exibição do livro mais antigo e do mais novo

🛠 Estrutura do Projeto

Livro → Classe abstrata com atributos e métodos comuns

LivroFisico e LivroDigital → Classes finais que herdam de Livro

Biblioteca → Responsável por gerenciar o acervo

Input → Classe auxiliar para entrada de dados com validação

Main → Classe principal que contém o menu interativo