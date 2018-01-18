/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import arquivo.Arquivo;
import decoracao.BordaNumerica;
import decoracao.TextoDecoracao;
import gerador.Gerador;
import interpretador.Interpretador;
import interpretador.TesteInterpretador;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import lexico.AnalisadorLexico;
import lexico.Item;
import semantico.AnalisadorSemantico;
import semantico.TabelaErrosSemantico;
import sintatico.Grammar;
import sintatico.JavaCCTest;
import sintatico.RecuperacaoErros;
//import sintatico.Lexer;
//import sintatico.Parser;
//import sintatico.RecuperacaoErros;

/**
 * @author brunoslima
 * @author leandroungari
 */
public class IUPrincipal extends javax.swing.JFrame {

    public Arquivo arq;
    public String fonte;
    public AnalisadorLexico lexico;
    public TextoDecoracao decoracao;
    public AnalisadorLexico analisador;
    public static String sistema;
    public Grammar g;

    /**
     * Creates new form IUPrincipal
     */
    public IUPrincipal() {

        initComponents();

        //Interface padrão ao sistema.
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Titulo da aplicação
        this.setTitle("Compilador - Analisador Sintático");

        //Icone da aplicação
        ImageIcon imagemTituloJanela = new ImageIcon("imagens/logo.png");
        setIconImage(imagemTituloJanela.getImage());

        //Inicializando variaveis
        this.arq = new Arquivo();
        this.lexico = null;
        this.fonte = "";

        this.decoracao = new TextoDecoracao(jTextPane);
        this.analisador = new AnalisadorLexico();

        sistema = System.getProperty("os.name");

        this.jTextPane.setBorder(new BordaNumerica());
        g = new Grammar(new StringReader(""));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jMenuItem8 = new javax.swing.JMenuItem();
        Aba = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane = new javax.swing.JTextPane();
        jConsolePanel = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaLexica = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneConsole = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuAbrir = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        MenuFechar = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        MenuAnalisar = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem8.setText("jMenuItem8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1044, 634));

        jTextPane.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextPane.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextPaneKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTextPane);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );

        Aba.addTab("Novo", jPanel1);

        TabelaLexica.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TabelaLexica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema", "Token", "Linha", "Coluna inicial", "Coluna final"
            }
        ));
        TabelaLexica.setName("Tabela de Símbolos"); // NOI18N
        TabelaLexica.getTableHeader().setResizingAllowed(false);
        TabelaLexica.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TabelaLexica);

        jConsolePanel.addTab("Tabela de símbolos", jScrollPane1);

        jScrollPane2.setViewportView(jTextPaneConsole);

        jConsolePanel.addTab("Console", jScrollPane2);

        MenuAbrir.setText("Arquivo");

        jMenu1.setText("Abrir ...");

        jMenuItem1.setText("Código fonte");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        jMenuItem10.setText("Código intermediário");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        MenuAbrir.add(jMenu1);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Salvar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        MenuAbrir.add(jMenuItem6);

        MenuFechar.setText("Fechar");
        MenuFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFecharActionPerformed(evt);
            }
        });
        MenuAbrir.add(MenuFechar);

        jMenuItem4.setText("Sair");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        MenuAbrir.add(jMenuItem4);

        jMenuBar1.add(MenuAbrir);

        MenuAnalisar.setText("Analisar");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem2.setText("Análise Léxica");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MenuAnalisar.add(jMenuItem2);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem5.setText("Análise Sintática");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        MenuAnalisar.add(jMenuItem5);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItem7.setText("Análise Semântica");
        MenuAnalisar.add(jMenuItem7);
        MenuAnalisar.add(jSeparator1);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jMenuItem9.setText("Geração de Código");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        MenuAnalisar.add(jMenuItem9);
        MenuAnalisar.add(jSeparator2);

        jMenuItem11.setText("Compilar e Executar");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        MenuAnalisar.add(jMenuItem11);

        jMenuBar1.add(MenuAnalisar);

        jMenu3.setText("Ajuda");

        jMenuItem3.setText("Sobre");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Aba)
            .addComponent(jConsolePanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Aba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jConsolePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:

        int returnVal = jFileChooser1.showOpenDialog(this);
        File file;

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            file = jFileChooser1.getSelectedFile();
            String localizacao = file.getAbsolutePath();
            String nomeArquivo = file.getName();

            try {

                arq = new Arquivo(localizacao);
                this.fonte = arq.getTexto();
                this.jTextPane.setText(this.fonte);
                this.Aba.setTitleAt(0, nomeArquivo);
                JOptionPane.showMessageDialog(null, "Arquivo aberto com sucesso!");

                decoracao.colorirTexto();
                jTextPane.repaint();

            } catch (FileNotFoundException ex) {

                Logger.getLogger(IUPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo!");

            }
        } else {
            System.out.println("Escolha do arquivo cancelada pelo usuário!");
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        //executa a analise léxica
        this.TabelaLexica.setVisible(true);
        this.fonte = this.jTextPane.getText();

        DefaultTableModel model = (DefaultTableModel) this.TabelaLexica.getModel();
        if (model.getRowCount() > 0) {
            while (this.TabelaLexica.getModel().getRowCount() > 0) {
                model.removeRow(0);
            }
        }

        if (!this.fonte.equals("")) {

            this.lexico = new AnalisadorLexico();

            lexico.analisar(this.fonte, 0);

            //JOptionPane.showMessageDialog(null, "Análise Léxica realizada com sucesso!");
            //Inserindo linhas na tabela
            String lexema, token, numLinha, numColunaInicial, numColunaFinal;
            for (Item i : lexico.getTabela()) {

                lexema = i.getSimbolo();
                token = i.getTipo().toString();
                numLinha = String.valueOf(i.getNumLinha() + 1);
                numColunaInicial = String.valueOf(i.getNumColunaInicial() + 1);
                numColunaFinal = String.valueOf(i.getNumColunaFinal() + 1);

                model.addRow(new String[]{lexema, token, numLinha, numColunaInicial, numColunaFinal});
            }

        } else {
            JOptionPane.showMessageDialog(null, "Area de texto vazia!\nAbra um arquivo texto ou escreva um programa na area de texto!");
        }

        jConsolePanel.setSelectedIndex(0);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:

        this.dispose();

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void MenuFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFecharActionPerformed
        // TODO add your handling code here:

        this.arq = null;
        this.lexico = null;
        this.jTextPane.setText("");
        this.Aba.setTitleAt(0, "Inicio");

        DefaultTableModel model = (DefaultTableModel) this.TabelaLexica.getModel();
        if (model.getRowCount() > 0) {
            while (this.TabelaLexica.getModel().getRowCount() > 0) {
                model.removeRow(0);
            }
        }

        this.jTextPaneConsole.setText("");

    }//GEN-LAST:event_MenuFecharActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:

        IUSobre cad = new IUSobre(this, true);
        cad.setLocationRelativeTo(this);
        cad.setVisible(true);

        cad.dispose();

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jTextPaneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPaneKeyReleased

        decoracao.colorirTexto();
        jTextPane.repaint();

    }//GEN-LAST:event_jTextPaneKeyReleased

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        //executa analise sintatica

        String result = "";
        RecuperacaoErros.listaErros.clear();
        StyledDocument doc = jTextPaneConsole.getStyledDocument();
        Style style = jTextPaneConsole.addStyle("I'm a Style", null);

        this.fonte = this.jTextPane.getText();

        //this.g = new Grammar(new StringReader(this.fonte));
        Grammar.ReInit(new StringReader(this.fonte));

        Gerador.init();

        try {
            Grammar.compilationUnit();
        } catch (sintatico.ParseException ex) {
            Logger.getLogger(JavaCCTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (RecuperacaoErros.getErros().isEmpty()) {

            StyleConstants.setForeground(style, Color.GREEN);
            result += "Análise Sintática concluida com sucesso, sem erros!";
        } else {

            result = RecuperacaoErros.getErros();
            StyleConstants.setForeground(style, Color.RED);

            result += "\nAnálise Sintática concluida com sucesso, porém há erros...";
        }

        jTextPaneConsole.setText("");

        jConsolePanel.setSelectedIndex(1);

        try {
            doc.insertString(doc.getLength(), result, style);
        } catch (BadLocationException e) {
        }


    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:

        this.arq.salvarArquivo(this.Aba.getTitleAt(0), this.jTextPane.getText());

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed

        //executa gerador de código
        //////////
        //Já é verificado se o analisador semantico tem erros, se tiver não roda
        if (!AnalisadorSemantico.foiExecutado) {

            JOptionPane.showMessageDialog(this, "Você deve executar o analisador semântico antes!!", "Analisador Semântico", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (AnalisadorSemantico.temErro) {

            JOptionPane.showMessageDialog(this, "Há erros semânticos, você deve corrigí-los antes!", "Analisador Semântico", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JFileChooser salvar = new JFileChooser();
        if (JFileChooser.APPROVE_OPTION == salvar.showSaveDialog(this)) {

            try {
                System.out.println(salvar.getSelectedFile().getAbsolutePath());
                Gerador.gerarArquivo(salvar.getSelectedFile().getAbsolutePath());

                Gerador.foiExecutado = true;

            } catch (FileNotFoundException ex) {
                Logger.getLogger(IUPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed

        //interpretação de código
        /*if (!Gerador.foiExecutado) {
            JOptionPane.showMessageDialog(this, "Você deve executar o gerador de código antes!!", "Gerador de Código", JOptionPane.INFORMATION_MESSAGE);
            return;
        }*/
        JFileChooser abrir = new JFileChooser();

        if (JFileChooser.APPROVE_OPTION == abrir.showOpenDialog(this)) {

            Interpretador in = new Interpretador();
            try {

                in.lerArquivo(abrir.getSelectedFile().getAbsolutePath());

                in.executar();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(TesteInterpretador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed

        //compilar e executar
        //executar análise léxica
        this.jMenuItem2ActionPerformed(evt);
        if (AnalisadorLexico.isTemErro()) {
            JOptionPane.showMessageDialog(this, "Há erros léxicos, você deve corrigí-los antes!", "Analisador Léxico", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        //executar análise sintática
        this.jMenuItem5ActionPerformed(evt);

        if (!RecuperacaoErros.getErros().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Há erros sintáticos, você deve corrigí-los antes!", "Analisador Sintático", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        //executar análise semântica
        
        
        
        if (AnalisadorSemantico.temErro) {

            JOptionPane.showMessageDialog(this, "Há erros semânticos, você deve corrigí-los antes!", "Gerador de Código", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        //geração de código
        try {
            Gerador.gerarArquivo("intermediario.in");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IUPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        Gerador.foiExecutado = true;

        //interpretação de código
        Interpretador in = new Interpretador();
        try {

            in.lerArquivo("intermediario.in");
            in.executar();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TesteInterpretador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IUPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUPrincipal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Aba;
    private javax.swing.JMenu MenuAbrir;
    private javax.swing.JMenu MenuAnalisar;
    private javax.swing.JMenuItem MenuFechar;
    private javax.swing.JTable TabelaLexica;
    private javax.swing.JTabbedPane jConsolePanel;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextPane jTextPane;
    private javax.swing.JTextPane jTextPaneConsole;
    // End of variables declaration//GEN-END:variables
}
