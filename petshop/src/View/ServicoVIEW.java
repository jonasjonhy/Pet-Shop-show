/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Bean.Animal;
import Bean.Cliente;
import Bean.Servico;
import Bean.TipoServico;
import Controller.AnimalController;
import Controller.ClienteController;
import Controller.ServicoController;
import Controller.TipoServicoController;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jocsa
 */
public class ServicoVIEW extends javax.swing.JInternalFrame {

    ServicoController sc;

    public ServicoVIEW() {
        initComponents();
        sc = new ServicoController();
        this.listarTabela();
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaServicos = new javax.swing.JTable();
        adicionar = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        finalizarServico = new javax.swing.JButton();
        tipoDeServicos = new javax.swing.JButton();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(990, 540));

        tabelaServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Animal", "Serviço", "Horario", "Data", "Finalizado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaServicos);
        if (tabelaServicos.getColumnModel().getColumnCount() > 0) {
            tabelaServicos.getColumnModel().getColumn(0).setResizable(false);
            tabelaServicos.getColumnModel().getColumn(1).setResizable(false);
            tabelaServicos.getColumnModel().getColumn(2).setResizable(false);
            tabelaServicos.getColumnModel().getColumn(3).setResizable(false);
            tabelaServicos.getColumnModel().getColumn(4).setResizable(false);
            tabelaServicos.getColumnModel().getColumn(5).setResizable(false);
            tabelaServicos.getColumnModel().getColumn(6).setResizable(false);
        }

        adicionar.setText("Adicionar");
        adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarActionPerformed(evt);
            }
        });

        alterar.setText("Alterar");
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        finalizarServico.setText("Finalizar Serviço");
        finalizarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarServicoActionPerformed(evt);
            }
        });

        tipoDeServicos.setText("Tipos de Serviços");
        tipoDeServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoDeServicosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tipoDeServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(finalizarServico, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finalizarServico, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoDeServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void listarTabela() {
        List<Servico> listaServicoss = this.sc.listar();

        Vector<String> colunas = new Vector<String>();
        colunas.add("ID");
        colunas.add("Cliente");
        colunas.add("Animal");
        colunas.add("Serviço");
        colunas.add("Horario");
        colunas.add("Data");
        colunas.add("Finalizado");

        Vector tuplas = new Vector();

        for (Servico servicos : listaServicoss) {

            Vector<Object> tupla = new Vector<Object>();

            tupla.add(servicos.getId());
            tupla.add(servicos.getNomeDonoAnimal());
            tupla.add(servicos.getNomeAnimal());
            tupla.add(servicos.getNomeServico());
            tupla.add(servicos.getHorario());
            tupla.add(servicos.getData());
            if(servicos.isFinalizado()){
                tupla.add("Finalizado");
            }else{
                tupla.add("Em andamento");
            }
            

            tuplas.add(tupla);
        }

        this.tabelaServicos.setModel(new DefaultTableModel(tuplas, colunas));

    }
   
    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed

        ClienteController cc = new ClienteController();
        AnimalController ac = new AnimalController();

        AdicionarServico as = new AdicionarServico(cc.listar(), this);
        as.setVisible(true);

    }//GEN-LAST:event_adicionarActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
        ServicoController sc = new ServicoController();

        int id = (int) this.tabelaServicos.getModel().getValueAt(this.tabelaServicos.getSelectedRow(), 0);
        Servico servico = sc.listarUm(id);

        AlterarServico as = new AlterarServico(servico, this);
        as.setVisible(true);

    }//GEN-LAST:event_alterarActionPerformed

    private void finalizarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarServicoActionPerformed
        int id = (int) this.tabelaServicos.getModel().getValueAt(this.tabelaServicos.getSelectedRow(), 0);

        if (this.sc.verificaFinalizacao(id)) {

            int resultado = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar este serviço?");
            if (resultado == 0) {
                this.sc.finalizarServico(id);
                JOptionPane.showMessageDialog(this, "Serviço finalizado com sucesso!");
            }
        } else {
            
            JOptionPane.showMessageDialog(null, "Este serviço já foi finalizado");
        }
        
        this.listarTabela();
        /*
         assim que clicar em finalizar servico consulte se a tabela participa esta com o campo finalizado como false, se tiver
         como false entao pergunte se relmente deseja finalizar o servico, caso na tabela o campo finalizado não esteja como
         false entao dispare uma mensagem avisando que o servico selecionado já está finalizado.
       
         */
    }//GEN-LAST:event_finalizarServicoActionPerformed

    private void tipoDeServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDeServicosActionPerformed
        ListaServico ls = new ListaServico();
        ls.setVisible(true);
    }//GEN-LAST:event_tipoDeServicosActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        int id = (int) this.tabelaServicos.getModel().getValueAt(this.tabelaServicos.getSelectedRow(), 0);

        int resultado = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este serviço?");
        if (resultado == 0) {
            this.sc.deletar(id);
            JOptionPane.showMessageDialog(null, "Serviço excluido com sucesso");
        }
        this.listarTabela();;

    }//GEN-LAST:event_excluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionar;
    private javax.swing.JButton alterar;
    private javax.swing.JButton excluir;
    private javax.swing.JButton finalizarServico;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaServicos;
    private javax.swing.JButton tipoDeServicos;
    // End of variables declaration//GEN-END:variables
}