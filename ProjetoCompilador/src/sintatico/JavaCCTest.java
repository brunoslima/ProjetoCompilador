package sintatico;


import arquivo.Arquivo;
import gerador.Gerador;
import gerador.Variavel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import semantico.AnalisadorSemantico;
import semantico.TabelaErrosSemantico;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author leandroungari
 */
public class JavaCCTest {

    public static void main(String[] args) throws FileNotFoundException {

        String sourcecode = "correto1.txt";
        
        ////////////////
        // Gerador

        //incluir essa linha na parte de linkar o analisador semantico também, porque o gerador é inicializado junto
        Gerador.init();
        
        Arquivo arq = new Arquivo(new File(sourcecode));
        String texto = arq.getTexto();

        Grammar g = new Grammar(new StringReader(texto));

        Grammar.ReInit(new StringReader(texto));
        try {        
            Grammar.compilationUnit();
        } catch (sintatico.ParseException ex) {
            Logger.getLogger(JavaCCTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("\nAnálise sintática concluída com sucesso.");
        
        System.out.println(RecuperacaoErros.getErros());
        
        HashMap<String, Variavel> lista = Gerador.getListaVariaveis();
        String comandos = Gerador.getListaComandos().toString();
        
        Gerador.gerarArquivo("programa.in");
        
        Set<String> chaves = AnalisadorSemantico.conjunto.keySet();
        for (String chave : chaves){
            if(chave != null){
                System.out.println("chave: " + chave);
                AnalisadorSemantico.conjunto.get(chave).visualizar();
            }
        }
        
        System.out.println("\n");
        TabelaErrosSemantico.visualizar();

    }

    public static List<Token> tokenize(Grammar parser) throws FileNotFoundException {
        List<Token> tokens = new ArrayList<>();

        Token token = Grammar.getNextToken();
        while (token.kind != GrammarConstants.EOF) {
            tokens.add(token);
            token = Grammar.getNextToken();
        }
        return tokens;
    }
}
