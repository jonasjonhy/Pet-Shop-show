/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Bean.Animal;
import Bean.Cliente;
import Controller.AnimalController;
import View.AlterarAnimal;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jocsa
 */
public class VerAnimal extends javax.swing.JFrame {

    private AnimalController ac;
    
    private Cliente infoCliente;
    private int modo;
    public VerAnimal(){}
    public VerAnimal(Cliente infoCliente) {
        initComponents();
        ac = new AnimalController();
        this.infoCliente = infoCliente;
        
        
        cliente.setText(this.infoCliente.getNome());
        id.setText(String.valueOf(this.infoCliente.getId()));
        
        this.listarNaTabela();
    }
    public void carregarTabela(){
        List<Animal> lista = this.ac.listar(infoCliente.getId());
        
        Vector<String> nomeColunas = new Vector<String>();
        
        nomeColunas.add("ID");
        nomeColunas.add("Nome");
        nomeColunas.add("Sexo");
        nomeColunas.add("Raça");
        
        Vector<Object> tuplas = new Vector<Object>();
        
        for (Animal animal : lista) {
            
            Vector<Object> tupla = new Vector<Object>();
            
            tupla.add(animal.getId());
            tupla.add(animal.getNome());
            tupla.add(animal.getSexo());
            tupla.add(animal.getRaca());
            tuplas.add(tupla);
        }
        
        this.tabelaAnimais.setModel(new DefaultTableModel(tuplas, nomeColunas));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAnimais = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cliente = new javax.swing.JTextField();
        adicionar = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        exlcuir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabelaAnimais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Sexo", "Raça"
            }
        ));
        jScrollPane1.setViewportView(tabelaAnimais);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cliente");

        cliente.setEditable(false);

        adicionar.setText("ADICIONAR");
        adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarActionPerformed(evt);
            }
        });

        alterar.setText("ALTERAR");
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });

        exlcuir.setText("EXCLUIR");
        exlcuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exlcuirActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("ID");

        id.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(exlcuir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adicionar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionar)
                    .addComponent(alterar)
                    .addComponent(exlcuir))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(613, 258));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed
        AdicionarAnimal adicionarA = new AdicionarAnimal(infoCliente.getId(),infoCliente.getNome(), this);
        adicionarA.setVisible(true);
    }//GEN-LAST:event_adicionarActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
        
        //PEGANDO O ID DO ANIMAL PARA BUSCAR E PASSAR O ANIMAL PARA SER ALTERADO
         
        int id = (int) this.tabelaAnimais.getModel().getValueAt(this.tabelaAnimais.getSelectedRow(), 0);
        
        
        Animal animal = this.ac.buscarUm(id);
        
        AlterarAnimal alterarA = new AlterarAnimal(animal, this.infoCliente.getNome(), animal.getSexo(), this);
        
        
        
        
    }//GEN-LAST:event_alterarActionPerformed

    private void exlcuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exlcuirActionPerformed
        
        int id = (int) this.tabelaAnimais.getModel().getValueAt(this.tabelaAnimais.getSelectedRow(),0);
        int decisao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o animal?");
        
        if(decisao==0){

            if(this.ac.deletar(id)){

                JOptionPane.showMessageDialog(null, "Animal removido com sucesso!!!");
                this.carregarTabela();
            }else{
                JOptionPane.showMessageDialog(null, "Falha na exclusão!!!");
            }
        }else{
            this.setVisible(true);
        }       
    }//GEN-LAST:event_exlcuirActionPerformed

    private void listarNaTabela(){
        List<Animal> listaDeAnimais = this.ac.listar(infoCliente.getId());
        
        Vector<String> colunas = new Vector<String>();        
        colunas.add("ID");
        colunas.add("Nome");
        colunas.add("Sexo");
        colunas.add("Raça");
        
        Vector tuplas = new Vector();
        
        for(Animal c: listaDeAnimais){
            
            Vector<Object> tupla = new Vector<Object>();
            tupla.add(c.getId());
            tupla.add(c.getNome());
            tupla.add(c.getSexo());
            tupla.add(c.getRaca());
            tuplas.add(tupla);
        }
        
        this.tabelaAnimais.setModel(new DefaultTableModel(tuplas, colunas));
    }
    
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
            java.util.logging.Logger.getLogger(VerAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerAnimal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionar;
    private javax.swing.JButton alterar;
    private javax.swing.JTextField cliente;
    private javax.swing.JButton exlcuir;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaAnimais;
    // End of variables declaration//GEN-END:variables
}
