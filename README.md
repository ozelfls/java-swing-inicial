# java-swing-inicial

Este projeto é uma aplicação simples de Cadastro de Veículos desenvolvida em Java, utilizando conceitos de Programação Orientada a Objetos (POO) e interface gráfica com a biblioteca Swing.

O sistema permite que o usuário:

Cadastre diferentes tipos de veículos: Carro, Moto e Caminhão.

Liste todos os veículos cadastrados.

Exclua veículos da lista.

Interaja com o sistema por meio de caixas de diálogo (JOptionPane).


Tecnologias Utilizadas
Java (JDK 17 ou superior)

Swing 
IntelliJ IDEA

Estrutura do projeto

src/
├── app/
│   └── Main.java
├── interfaces/
│   └── Exibivel.java
└── model/
    ├── Veiculo.java
    ├── Carro.java
    ├── Moto.java
    └── Caminhao.java




Conceitos de POO Aplicados
Herança:
A classe Veiculo é a classe base, e as classes Carro, Moto e Caminhao são subclasses.

Polimorfismo:
A lista de veículos (List<Veiculo>) armazena objetos de diferentes tipos, mas tratados de forma genérica.

Abstração:
A classe Veiculo contém atributos e métodos comuns a todos os veículos.

Interface:
A interface Exibivel garante que todos os veículos implementem o método de exibição dos seus dados.
