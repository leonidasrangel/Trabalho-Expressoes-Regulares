/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.expressaoregular;

/**
 *
 * @author Rangel
 */
public class ExpressaoRegular {

    public String BRANCO, BRANCOS;     //' ' (espaço), '\t' TAB, '\n' new line, '\r' volta o cursos para o inicio da linha, '\f' avanço de pagina, '\v' vertical TAB - (usado em configuraçoes de impressora)
    public String DIGITO, DIGITOS;
    public String LETRA , LETRAS;
    
    public String IDENT;
    public String TIPO;
    public String PARAMETRO;
    public String LISTA_PARAMETROS;
    public String ASSINATURA_FUNCAO;
    
    public String PARAMETROS_FUNCAO;
    public String NOME_VAR;
    
    public String OP_MAT;      // Operadores Matemáticos (+, -, *, /)
    public String OPERANDO;    // Uma variável ou um número
    public String EXPRESSAO;   // Ex: a, 1990, 3*a, 4+t
    public String OP_REL;      // Operadores Relacionais (>, <, ==, !=, etc)
    public String CONDICAO;    // Ex: ano < 1990
    public String CONDICIONAL; // O 'if' completo
    
    public String EXPONENCIAL;
    public String FRACIONARIA;
    public String REAL;
    public String IMAGEM;
    public String DATA;
    
    public String INTEIRO;
    public String NUMEROS;
    public String ATRIBUICAO;   
    public String INDEXADOR;    
    public String DESIGNADOR;
    public String CHAMADA_FUNCAO;
    public String LISTA_ARGUMENTOS;
    public String VARIAVEL_AVANCADA;
    public String OPERANDO_MAT;
    public String EXPRESSAO_MATEMATICA;
        
    public ExpressaoRegular() {        
        BRANCO = "(\\s)"; // metacaracter que significa: [ \t\n\r\f\v]
        BRANCOS = BRANCO + "*";
        DIGITO = "([0-9])";
        DIGITOS = DIGITO + "*";
        LETRA = "([A-Za-z])";
        LETRAS = LETRA + "*";
        
        //Numeros reais
        EXPONENCIAL = "(E(\\+|-)" + DIGITOS + ")";
        FRACIONARIA = "\\.?" + DIGITOS + EXPONENCIAL+"?";
        REAL = "\\-?" + DIGITOS + FRACIONARIA + "?";
        
        //identificador é nomeDeVariavel, nomeDeFuncao, nomeClasse
        IDENT = "(" + LETRA + "(" + LETRA + "|" + DIGITO + ")*)";
        TIPO = IDENT; // tipo de retorno (ex: int, void, string)
        NOME_VAR = IDENT;
        
        PARAMETRO = "(" + TIPO + BRANCO + BRANCOS + NOME_VAR + ")"; //ex: "int a"
        LISTA_PARAMETROS = "(" + PARAMETRO + "(" + BRANCOS + "," + BRANCOS + PARAMETRO + ")*)?"; //
        ASSINATURA_FUNCAO = TIPO + BRANCO + BRANCOS + IDENT + BRANCOS + "\\(" + BRANCOS + LISTA_PARAMETROS + BRANCOS + "\\)" + BRANCOS + ";";
        PARAMETROS_FUNCAO = "\\(" + BRANCOS + "(" + LISTA_PARAMETROS + ")?" + BRANCOS + "\\)";
        
        INTEIRO = "\\-?" + DIGITO + "+"; // pode ser um numero positivo ou negativo (pelo menos 1 dígito)
        OPERANDO = "(" + IDENT + "|" + INTEIRO + ")"; // pode ser um Identificador (variável) OU um Número Inteiro
        OP_MAT = "([+\\-*/])";
        EXPRESSAO = "(" + OPERANDO + "(" + BRANCOS + OP_MAT + BRANCOS + OPERANDO + ")*)"; //expressão matemática (Ex: "ano", "1990", "3*a", "4+t")
        OP_REL = "(==|!=|<=|>=|<|>)";
        CONDICAO = "(" + EXPRESSAO + BRANCOS + OP_REL + BRANCOS + EXPRESSAO + ")"; //condição completa (Ex: "ano < 1990")
        CONDICIONAL = "if" + BRANCOS + "\\(" + BRANCOS + CONDICAO + BRANCOS + "\\)"; 
        
        INDEXADOR = "(\\[" + BRANCOS + OPERANDO + BRANCOS + "\\])"; //usando colchetes ex:[1]
        DESIGNADOR = "(\\." + IDENT + ")"; //ex: .idade
        LISTA_ARGUMENTOS = "(" + OPERANDO + "(" + BRANCOS + "," + BRANCOS + OPERANDO + ")*)?"; //segue a mesma regra do interior do vetor (variáveis ou números)
        CHAMADA_FUNCAO = "(" + IDENT + BRANCOS + "\\(" + BRANCOS + LISTA_ARGUMENTOS + BRANCOS + "\\))"; //ex: soma(a,b)
        
        //pontos de interrogação "?" dizem que o indexador e o designador são opcionais. ex: vetor[5].idade
        VARIAVEL_AVANCADA = "(" + IDENT + INDEXADOR + "?" + DESIGNADOR + "?" + ")"; 
        OPERANDO_MAT = "(" + CHAMADA_FUNCAO + "|" + VARIAVEL_AVANCADA + "|" + REAL + "|" + INTEIRO + ")";
        EXPRESSAO_MATEMATICA = "(" + OPERANDO_MAT + "(" + BRANCOS + OP_MAT + BRANCOS + OPERANDO_MAT + ")*)";
        
        //Nome de imagens
        IMAGEM = ".*(\\.png|\\.jpe?g|\\.bmp)";
        
        //dd/dd/dddd
        //dd-dd-dddd
        DATA = DIGITO+"{2}" + "/" 
                + DIGITO + DIGITO 
                +"/" + DIGITO+"{4}";
        
    }

    public void confere(String exp, String sentenca) {
        if ((sentenca != null) && !sentenca.isEmpty()) {
            if (sentenca.matches(exp)) {
                System.out.println("W:'" + sentenca + "'........ ACEITA!");
            } else {
                System.err.println("W:'" + sentenca + "'........ rejeitada.");
            }
        } else {
            System.err.println("Sentença vazia.");
        }
    }

}
