# Analisador Léxico com Expressões Regulares em Java

Este projeto demonstra a construção de um mini-analisador léxico utilizando Expressões Regulares (Regex) na linguagem Java. O objetivo principal é validar diferentes tipos de sentenças, desde elementos básicos (como números e identificadores) até estruturas complexas de programação (como expressões matemáticas e assinaturas de funções).

## 🚀 Como Funciona

A arquitetura do projeto baseia-se na criação de **Macros** (blocos de construção). Em vez de escrever expressões regulares gigantescas e ilegíveis, o código inicializa padrões pequenos e os concatena para formar regras mais avançadas. 

Por exemplo: a validação de uma **Expressão Matemática Complexa** é construída juntando as regras de *Dígitos*, *Identificadores*, *Operadores* e *Chamadas de Função*.

## 📁 Estrutura do Projeto

O projeto é composto por duas classes principais:

* **`ExpressaoRegular.java`**: É o motor do analisador. Contém o construtor que inicializa todas as expressões regulares de forma hierárquica (de baixo para cima). Também possui o método `confere(exp, sentenca)`, que utiliza a função `.matches()` do Java com uma abordagem *Fail-Fast* para validar as strings e exibir os resultados no console.
* **`Main.java`**: Classe de execução responsável por realizar as baterias de testes. Ela submete sentenças válidas e inválidas ao analisador para garantir a robustez das expressões criadas.

## ⚙️ Estruturas Reconhecidas (Tokens)

O analisador é capaz de identificar e validar as seguintes categorias:

* **Tipos Primitivos:** Dígitos, Letras, Inteiros (positivos e negativos), Números Reais (com suporte a notação científica/exponencial e casas decimais).
* **Identificadores:** Nomes de variáveis, funções ou classes (iniciando com letras, seguidas de letras ou números).
* **Arquivos e Formatos:** Validação de nomes de imagens de arquivos (`.png`, `.jpg`, `.jpeg`, `.bmp`) e formatos de Data (`dd/mm/aaaa` ou `dd-mm-aaaa`).
* **Estruturas de Código:**
    * **Assinatura de Funções:** Ex: `void funcao(int a, float b);` ou `String funcao2();`
    * **Parâmetros:** Ex: `(float media, String nome)`
    * **Condicionais (IF):** Ex: `if(ano < 1990)` ou `if(3*a != 4+t)`
    * **Expressões Matemáticas Complexas:** Valida operações matemáticas que incluem acesso a propriedades de objetos, indexação de vetores e chamadas de funções aninhadas. Ex: `-4 + beta * media[1].x * soma(a,b)/4 * vetor[5].idade`

## 🛠️ Como Executar

1. Clone este repositório na sua máquina.
2. Abra o projeto em uma IDE Java (como NetBeans, Eclipse ou IntelliJ).
3. Execute a classe `Main.java` para visualizar os resultados dos testes no terminal.
