/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

import gerador.Gerador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Pattern;
import static semantico.AnalisadorSemantico.conjunto;

/**
 *
 * @author brunoslima
 * @author leandroungari
 */
public class Tabela {
    
    public ArrayList<Variaveis> listaParametros = new ArrayList<>();
    public HashMap<String, Variaveis> tabelaVariaveis = new HashMap<>();
    
    public String nome;
    
    public Tabela(String nome) {
        
        this.nome = nome;
        listaParametros.clear();
        tabelaVariaveis.clear();
    }
    
    public void addParametro(String nome, int tipo){
        
        Variaveis v = null;
        
        if (tipo == Variaveis.BOOLEAN) {
            
            v = new Boolean(nome, tipo);
        }
        else if (tipo == Variaveis.INT) {
            
            v = new Integer(nome, tipo);
        }
        
        listaParametros.add(v);
        tabelaVariaveis.put(nome, v);
    }
    
    public void addParametro(String nome, int tipo, String valor){
        
        Variaveis v = null;
        
        if (tipo == Variaveis.BOOLEAN) {
            
            v = new Boolean(valor, nome, tipo);
        }
        else if (tipo == Variaveis.INT) {
            
            v = new Integer(valor, nome, tipo);
        }
        
        listaParametros.add(v);
        tabelaVariaveis.put(nome, v);
    }

    public void addVariavel(String nome, int tipo){
        
        Variaveis v = null;
        
        if (tipo == Variaveis.BOOLEAN) {
            
            v = new Boolean(nome, tipo);
        }
        else if (tipo == Variaveis.INT) {
            
            v = new Integer(nome, tipo);
        }
        
        tabelaVariaveis.put(nome, v);
    }
    
    public void addVariavel(String nome, int tipo, String valor){
        
        Variaveis v = null;
        
        if (tipo == Variaveis.BOOLEAN) {
            
            v = new Boolean(valor, nome, tipo);
        }
        else if (tipo == Variaveis.INT) {
            
            v = new Integer(valor, nome, tipo);
        }
        
        tabelaVariaveis.put(nome, v);
    }

    public void separarVariaveis(String literal, int linha, int coluna){

        String [] elementos;
        literal = literal.replace(";", "");
        
        if(literal.charAt(0) == 'i' && literal.charAt(1) == 'n' && literal.charAt(2) == 't'){ //int
            
            literal = literal.replace("int", "");
            
            elementos = literal.split(",");
            for(int i = 0; i < elementos.length; i++){
                
                if(!verificarExistencia(elementos[i])) {
                    
                    addVariavel(elementos[i], 5);
                    
                    Gerador.declararVariavel(elementos[i], gerador.Variavel.INT);
                    
                } //5 == int
                else TabelaErrosSemantico.add("Variável " + elementos[i] + " já declarada neste escopo.", linha, coluna);
            }
            
        }
        else if(literal.charAt(0) == 'b' && literal.charAt(1) == 'o'){ //boolean
            
            literal = literal.replace("boolean", "");
            
            elementos = literal.split(",");
            for(int i = 0; i < elementos.length; i++){

                if(!verificarExistencia(elementos[i])) {
                    addVariavel(elementos[i], 2);
                    
                    Gerador.declararVariavel(elementos[i], gerador.Variavel.BOOLEAN);
                } //2 == boolean
                else TabelaErrosSemantico.add("Variável " + elementos[i] + " já declarada neste escopo.", linha, coluna);
            }
            
        }
        
    }
    
    public void separarParametros(String literal, int linha, int coluna){

        String [] elementos;
        
        if(literal.contains("int")){ //int
            
            literal = literal.replace("int", "");

            elementos = literal.split(",");
            for(int i = 0; i < elementos.length; i++){
                
                if(!verificarExistencia(elementos[i])) addParametro(elementos[i], 5); //5 == int
                else TabelaErrosSemantico.add("Variável " + elementos[i] + " já declarada neste parâmetro.", linha, coluna);
            }
            
        }
        else if(literal.contains("boolean")){ //boolean
            
            literal = literal.replace("boolean", "");
            
            elementos = literal.split(",");
            for(int i = 0; i < elementos.length; i++){

                if(!verificarExistencia(elementos[i]))addParametro(elementos[i], 2); //2 == boolean
                else TabelaErrosSemantico.add("Variável " + elementos[i] + " já declarada neste escopo.", linha, coluna);
            }
            
        }
        
    }
    
    public boolean verificarExistencia(String nome){

        for (Variaveis v : listaParametros) {
            if(v.nome.equals(nome)){
                return true;
            }
        }
        
        Set<String> chaves = tabelaVariaveis.keySet();
        for (String chave : chaves){
            if(chave.equals(nome)){
                return true;
            }
        }
        
        return false;
    }
    
    public void visualizar(){
        
        System.out.println("Lista de parâmetros: ");
        for (Variaveis v : listaParametros) {
            v.visualizar();
        }
        
        System.out.println("Variáveis: ");
        Set<String> chaves = tabelaVariaveis.keySet();
        for (String chave : chaves){
            if(chave != null){
                tabelaVariaveis.get(chave).visualizar();
            }
        }
    }
    
    public void atribuirValor(String variavel, String valor, int linha, int coluna){

        Variaveis v = tabelaVariaveis.get(variavel);
        v.setValor(valor); //String que vem como parametro
        
        this.verificaAtribuicao(v,linha,coluna,0);
    }
    
    public void verificaAtribuicao(Variaveis v, int linha, int coluna, int msg){
        
        //msg == 0 - Para atribuição
        //msg == 1 - Para parametros
        
        if(v.tipo.equals("INT")){
            
            this.verificaAtribuicaoINT(v,linha,coluna,msg);
            
        }
        else if(v.tipo.equals("BOOLEAN")){
            
            this.verificaAtribuicaoBOOLEAN(v,linha,coluna,msg);
        }
        
    }
    
    public void verificaAtribuicaoINT(Variaveis v, int linha, int coluna, int msg){

        //msg == 0 - Para atribuição
        //msg == 1 - Para parametros
        
        String valor = v.valor;
        
        if(valor.contains("true") || valor.contains("false")){ //Inteiro não pode receber true ou false
            if(msg == 0) TabelaErrosSemantico.add("ERRO - Atribuindo valor BOOLEAN em uma variável do tipo INT.", linha, coluna);
            else if(msg == 1) TabelaErrosSemantico.add("ERRO - Parâmetro esperado do tipo INT recebendo um tipo BOOLEAN.", linha, coluna); 
            return;
        }
        else if(this.existeOperadorLogico(valor)){ //Inteiro não pode receber uma expressão lógica
            if(msg == 0) TabelaErrosSemantico.add("ERRO - Atribuindo valor BOOLEAN em uma variável do tipo INT.", linha, coluna);
            else if(msg == 1) TabelaErrosSemantico.add("ERRO - Parâmetro esperado do tipo INT recebendo um tipo BOOLEAN.", linha, coluna); 
            return;
        }
        
        //Verificação de tipos das variaveis que formam a expressão
        valor = this.retirarOperadores(valor);
        String[] valores = valor.split (Pattern.quote (" "));        
        
        for(int i = 0; i < valores.length; i++){
            
            //Se não for um número, é uma variavel, então precisa verificar se seu tipo é inteiro;
            if(!this.isNumber(valores[i])){
                
                Variaveis aux = tabelaVariaveis.get(valores[i]);
                if(aux != null && !aux.tipo.equals("INT")){
                    if(msg == 0) TabelaErrosSemantico.add("ERRO - Atribuindo valor BOOLEAN em uma variável do tipo INT.", linha, coluna);
                    else if(msg == 1) TabelaErrosSemantico.add("ERRO - Parâmetro esperado do tipo INT recebendo um tipo BOOLEAN.", linha, coluna); 
                    break;
                }//Fim do if
                
            }//Fim do if que verifica se é diferente de uma número
            
        }//Fim do for
        
    }
    
    public void verificaAtribuicaoBOOLEAN(Variaveis v, int linha, int coluna, int msg){

        //msg == 0 - Para atribuição
        //msg == 1 - Para parametros
        
        String valor = v.valor;
        if(this.existeOperadorLogico(valor)){ //Se existe operador logico
            
            //Se existe operação logica, deve conter apenas um operador logico
            if(this.getQuantidadeOperadorLogico(valor) == 1){
                
                valor = this.retirarOperadoresLogicos(valor);
                
                //Separando as duas expressoes: exp1 op_logico exp2;
                String[] expressoes = valor.split (Pattern.quote (" "));
                String exp1 = expressoes[0];
                String exp2 = expressoes[1];
                
                exp1 = this.retirarOperadores(exp1);
                String[] valores1 = exp1.split (Pattern.quote (" "));
                
                exp2 = this.retirarOperadores(exp2);
                String[] valores2 = exp2.split (Pattern.quote (" "));
                
                //Verificando se ambas as expressoes contém apenas valores ou variaveis inteiras
                if(!this.isInteiros(valores1) || !this.isInteiros(valores2)){
                    if(msg == 0) TabelaErrosSemantico.add("ERRO - Atribuindo uma expressão de resultando INT a uma variável do tipo BOOLEAN.", linha, coluna);
                    else if(msg == 1) TabelaErrosSemantico.add("ERRO - Parâmetro esperado do tipo BOOLEAN recebendo expressão de resultando INT.", linha, coluna); 
                }
                
            }
            else{
                if(msg == 0) TabelaErrosSemantico.add("ERRO - Atribuição de uma expressão inválida a uma variável do tipo BOOLEAN.", linha, coluna);
                else if(msg == 1) TabelaErrosSemantico.add("ERRO - Parâmetro esperado do tipo BOOLEAN recebendo uma expressão inválida.", linha, coluna);
                return;
            }
            
        }
        else{
            
            if(this.existeOperadorAritmetico(valor)){ //Verificando se uma expressão aritmetica está sendo atribuida
                if(msg == 0) TabelaErrosSemantico.add("ERRO - Atribuindo o resultado de uma operação aritmética em uma variável do tipo BOOLEAN.", linha, coluna);
                else if(msg == 1) TabelaErrosSemantico.add("ERRO - Parâmetro esperado do tipo BOOLEAN recebendo o resultado de uma operação aritmética.", linha, coluna);
                return;
            }
            
            if(this.isNumber(valor)){ //Verificando se um número está sendo atribuido
                if(msg == 0) TabelaErrosSemantico.add("ERRO - Atribuindo um valor INT em uma variável do tipo BOOLEAN.", linha, coluna);
                else if(msg == 1) TabelaErrosSemantico.add("ERRO - Parâmetro esperado do tipo BOOLEAN recebendo um valor INT.", linha, coluna);
                return;
            }
            
            if(!valor.equalsIgnoreCase("true") && !valor.equalsIgnoreCase("false")){ //Significa que é uma variavel
                
                Variaveis aux = tabelaVariaveis.get(valor);

                if(aux.tipo.equals("INT")){ //Atribuir uma variavel do tipo inteiro em uma do tipo booleano da erro
                    if(msg == 0) TabelaErrosSemantico.add("ERRO - Atribuindo uma variável de valor INT em uma variável do tipo BOOLEAN.", linha, coluna);
                    else if(msg == 1) TabelaErrosSemantico.add("ERRO - Parâmetro esperado do tipo BOOLEAN recebendo uma variável de valor INT.", linha, coluna);
                    return;
                }//Fim do if interno
                
            }//Fim do if externo
            
        }
        
    }
    
    public boolean existeOperadorLogico(String valor){
        
        if(valor.contains(">") || valor.contains("<") || valor.contains(">=") || valor.contains("<=")){
            return true;
        }
        else if(valor.contains("=") || valor.contains("<>")){
            return true;
        }
        else if(valor.contains("and") || valor.contains("not")|| valor.contains("or")){
            return true;
        }
        return false;
    }
    
    public int getQuantidadeOperadorLogico(String valor){
        
        int cont = 0;
        for(int i = 0; i < valor.length(); i++){
            
            if(valor.charAt(i) == '>' || valor.charAt(i) == '<' || valor.charAt(i) == '='){
                
                cont++;
                if(valor.charAt(i+1) == '=' || valor.charAt(i+1) == '>') i++;
            }
        }
        return(cont);
    }
    
    public boolean existeOperadorAritmetico(String valor){
        
        return (valor.contains("+") || valor.contains("-") || valor.contains("*") || valor.contains("div"));
    }
    
    public String retirarOperadores(String valor){
        
        //Operadores aritimeticos: + - * div;
        
        valor = valor.replace("+"," ");
        valor = valor.replace("-"," ");
        valor = valor.replace("*"," ");
        valor = valor.replace("div"," ");
        
        //Parenteses ( );
        
        valor = valor.replace("("," ");
        valor = valor.replace(")"," ");

        return valor;
        
    }
    
    public String retirarOperadoresLogicos(String valor){
        
        //Operadores: > < >= <=;
        
        valor = valor.replace(">"," ");
        valor = valor.replace("<"," ");
        valor = valor.replace(">="," ");
        valor = valor.replace("<="," ");
        valor = valor.replace("="," ");
        valor = valor.replace("<>"," ");
        
        valor = valor.replace("and"," ");
        valor = valor.replace("not"," ");
        valor = valor.replace("or"," ");

        return valor;
        
    }
    
    public boolean isInteiros(String [] valores){
        
        for(int i = 0; i < valores.length; i++){
            
            //Se não for um número, é uma variavel, então precisa verificar se seu tipo é inteiro;
            if(!this.isNumber(valores[i])){
                
                Variaveis aux = tabelaVariaveis.get(valores[i]);
                if(!aux.tipo.equals("INT")){
                    return false;
                }//Fim do if
                
            }//Fim do if que verifica se é diferente de uma número
            
        }//Fim do for
        
        return true;
    }
    
    public boolean isNumber(String s) {
        
        char[] c = s.toCharArray();
        
        for(int i=0; i < c.length; i++ ){
            
            // verifica se o char não é um dígito
            if (!Character.isDigit(c[i])) return(false);
        }
        
        return true;
    }
    
    public void verificarVariaveisNaoUtilizadas(){
        
        Set<String> chaves = tabelaVariaveis.keySet();
        for (String chave : chaves){
            if(tabelaVariaveis.get(chave).valor == null){
                TabelaErrosSemantico.add("WARNING - Variável " + tabelaVariaveis.get(chave).nome + " foi declarada mas não foi utililizada.");
            }
        }
        
    }
    
    public void verificarVariavelNulaUtilizada(String nomeVariavel, int linha, int coluna){
        
        Set<String> chaves = tabelaVariaveis.keySet();
        for (String chave : chaves){
            if(tabelaVariaveis.get(chave).nome.equals(nomeVariavel) && tabelaVariaveis.get(chave).valor == null){
                TabelaErrosSemantico.add("ERRO - Variável " + tabelaVariaveis.get(chave).nome + " está sendo utilizada porem ainda não foi inicializada.", linha, coluna);
            }
        }
        
    }
    
    public void verificarTiposParametros(String lista, int linha, int coluna){
        
        String[] expressoes = lista.split (Pattern.quote (","));
        
        if(expressoes.length != listaParametros.size()){
            TabelaErrosSemantico.add("ERRO - Quantidade de parâmetros informados não atende a quantidade de parâmetros esperada pelo procedimento.", linha, coluna);
            return;            
        }
        
        for (int i = 0; i < listaParametros.size(); i++) {
            
            Variaveis p = listaParametros.get(i);
            p.setValor(expressoes[i]); //String que vem como parametro
        
            this.verificaAtribuicao(p,linha,coluna,1);
        }
    }
    
}
