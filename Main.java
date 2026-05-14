/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expressaoregular;

/**
 *
 * @author Rangel
 */
public class Main {

    public static void main(String[] args) {
        ExpressaoRegular ER = new ExpressaoRegular();
        
        //Teste 1, expressão regular: DIGITOS
        ER.confere(ER.DIGITOS, "000511200021");
        
        //Teste 2, expressão regular: DIGITOS
        ER.confere(ER.DIGITOS, "000511ADAF");
      
        //Teste 3, expressão regular: LETRAS
        ER.confere(ER.LETRAS, "ASDFEAFdafsafdsf");

        //Teste 4, expressão regular: LETRAS
        ER.confere(ER.LETRAS, "AAbb44");
        
        //Teste 5.1
        ER.confere(ER.IMAGEM, "Foto.jpg");
        
        //Teste 5.2
        ER.confere(ER.IMAGEM, "Foto.jpeg");

        //Teste 5.3, 
        ER.confere(ER.IMAGEM, "imagem_01.png");
              
        //Teste 6.1, expressão regular: IDENT (nome de variável, função e classes)
        ER.confere(ER.IDENT, "Altura1");

        //Teste 6.2, expressão regular: IDENT (nome de variável, função e classes)
        ER.confere(ER.IDENT, "1Altura");
                
        //Teste 7, expressão regular: REAL
        ER.confere(ER.REAL, "123.908777E+30");
        
        //Teste 8, expressão regular: REAL
        ER.confere(ER.REAL, "0.17E-5");

        //Teste 9, expressão regular: REAL
        ER.confere(ER.REAL, "22");
        
        //Teste 10, expressão regular: REAL
        ER.confere(ER.DATA, "90/12/2023");
        ER.confere(ER.DATA, "02-12-2023");
        
        // TESTES DO TRABALHO
        
        //Teste 01, assinatura de funções
        ER.confere(ER.ASSINATURA_FUNCAO, "void funcao01(int a, float b) ;");
        ER.confere(ER.ASSINATURA_FUNCAO, "String funcao2();");
        
        //Teste 02, parâmetros de funções
        ER.confere(ER.PARAMETROS_FUNCAO, "(int a, float b)");
        ER.confere(ER.PARAMETROS_FUNCAO, "(float media, String nome)");
        ER.confere(ER.PARAMETROS_FUNCAO, "(  int   x ,float y  )");
        ER.confere(ER.PARAMETROS_FUNCAO, "(a, b)"); // rejeitado, falta o tipo
        
        //Teste 03 Condicional
        ER.confere(ER.CONDICIONAL, "if(ano < 1990)");
        ER.confere(ER.CONDICIONAL, "if(3*a != 4+t)");
        ER.confere(ER.CONDICIONAL, "if(ano < )");// rejeitado (falta o operando da direita)
        
        //Teste 04 Expressão matemática
        ER.confere(ER.EXPRESSAO_MATEMATICA, "3 + media/3");
        ER.confere(ER.EXPRESSAO_MATEMATICA, "-4 + beta * media[1].x * soma(a,b)/4 * vetor[5].idade");
        ER.confere(ER.EXPRESSAO_MATEMATICA, "x");// aceita (só uma variável)
        ER.confere(ER.EXPRESSAO_MATEMATICA, "10 * obj.valor");// aceita (com designador)
        ER.confere(ER.EXPRESSAO_MATEMATICA, "3 + * 4");// rejeitada (operador duplo)


    }
}
