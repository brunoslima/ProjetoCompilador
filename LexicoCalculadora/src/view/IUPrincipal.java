/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import arquivo.Arquivo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileView;
import javax.swing.table.DefaultTableModel;
import lexico.AnalisadorLexico;
import lexico.Item;

/**
 * @author brunoslima
 * @author leandroungari
 */
public class IUPrincipal extends javax.swing.JFrame {

    public Arquivo arq;
    public AnalisadorLexico lexico;
    
    /**
     * Creates new form IUPrincipal
     */
    public IUPrincipal() {
        initComponents();
        
        //Interface padrão ao sistema.
        try {    
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
        //Titulo da aplicação
        this.setTitle("Analisador Lexico - Calculadora Simples");
        
        //Inicializando variaveis
        this.arq = null;
        this.lexico = null;
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
        Aba = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaLexica = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuAbrir = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        MenuFechar = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        MenuAnalisar = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 600));

        TextArea.setEditable(false);
        TextArea.setColumns(20);
        TextArea.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        TextArea.setRows(5);
        jScrollPane2.setViewportView(TextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
        );

        Aba.addTab("Inicial", jPanel1);

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

        MenuAbrir.setText("Arquivo");

        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuAbrir.add(jMenuItem1);

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

        jMenuItem2.setText("Análise Léxica");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MenuAnalisar.add(jMenuItem2);

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
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Aba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
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
                this.TextArea.setText(arq.getTexto());
                this.Aba.setTitleAt(0,nomeArquivo);
                JOptionPane.showMessageDialog(null, "Arquivo aberto com sucesso!");
                
            } catch (FileNotFoundException ex) {
                
                Logger.getLogger(IUPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo!");
                
            }
        } else {
            System.out.println("Escolha do arquivo cancelada pelo usuário!");
        }
                        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
        if(arq != null){
            
            this.lexico = new AnalisadorLexico();

            for (String s : arq.getLinhas()) {

                lexico.analisar(s, arq.getLinhas().indexOf(s));
            }

            System.out.println(lexico.getTabela());
            JOptionPane.showMessageDialog(null, "Análise Léxica realizada com sucesso!");
            
            //Inserindo linhas na tabela
            DefaultTableModel model = (DefaultTableModel) this.TabelaLexica.getModel();
            String lexema, token, numLinha, numColunaInicial, numColunaFinal;
            for(Item i : lexico.getTabela()){
                
                lexema = i.getSimbolo();
                token = i.getTipo().toString();
                numLinha = String.valueOf(i.getNumLinha());
                numColunaInicial = String.valueOf(i.getNumColunaInicial());
                numColunaFinal = String.valueOf(i.getNumColunaFinal());
                
                model.addRow(new String[]{lexema,token,numLinha,numColunaInicial,numColunaFinal});
            }
            
            
        }
        else JOptionPane.showMessageDialog(null, "Arquivo não encontrado!\nAbra um arquivo texto primeiro!");
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void MenuFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFecharActionPerformed
        // TODO add your handling code here:
        
        this.arq = null;
        this.lexico = null;
        this.TextArea.setText("");
        this.Aba.setTitleAt(0,"Inicio");
        
        DefaultTableModel model = (DefaultTableModel) this.TabelaLexica.getModel();
        if (model.getRowCount() > 0){
            while (this.TabelaLexica.getModel().getRowCount() > 0) model.removeRow(0);         
        }
        
    }//GEN-LAST:event_MenuFecharActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        
        IUSobre cad = new IUSobre(this, true);
        cad.setLocationRelativeTo(this);
        cad.setVisible(true);
        
        cad.dispose();
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
    private javax.swing.JTextArea TextArea;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
