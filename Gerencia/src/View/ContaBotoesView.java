/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.GerenciaController;
import Model.cliente.Cliente;
import javax.swing.JLabel;

/**
 *
 * @author dell
 */
public class ContaBotoesView extends javax.swing.JPanel {
    private GerenciaController controller;
    /**
     * Creates new form BotonesConta
     */
    public ContaBotoesView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxTipoConta = new javax.swing.JComboBox<>();
        btnVincular = new javax.swing.JButton();
        labelClienteName = new javax.swing.JLabel();

        cbxTipoConta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o tipo de conta", "Conta Corrente", "Conta Investimento" }));
        cbxTipoConta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoContaItemStateChanged(evt);
            }
        });
        cbxTipoConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxTipoContaMouseClicked(evt);
            }
        });
        cbxTipoConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoContaActionPerformed(evt);
            }
        });

        btnVincular.setText("Vincular");
        btnVincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVincularActionPerformed(evt);
            }
        });

        labelClienteName.setText("Cliente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxTipoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(labelClienteName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(btnVincular)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTipoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVincular)
                    .addComponent(labelClienteName))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxTipoContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoContaActionPerformed
    
    }//GEN-LAST:event_cbxTipoContaActionPerformed

    private void btnVincularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVincularActionPerformed
        String tipoConta = cbxTipoConta.getSelectedItem().toString();
        Cliente cliente = controller.getClienteClicado();
//        this.btnVincular.addActionListener(e -> controller.vincularConta(tipoConta,cliente)); 
        
    }//GEN-LAST:event_btnVincularActionPerformed

    private void cbxTipoContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxTipoContaMouseClicked
        
    }//GEN-LAST:event_cbxTipoContaMouseClicked

    private void cbxTipoContaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoContaItemStateChanged
         String tipoConta = cbxTipoConta.getSelectedItem().toString();
        
        if(tipoConta.equalsIgnoreCase("Conta Corrente")){
            controller.setInvestimentoNull();
        }else if(tipoConta.equalsIgnoreCase("Conta Investimento")){
            controller.setCorrenteNull();
        }else
            controller.resetTipoContaSelector();// TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoContaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVincular;
    private javax.swing.JComboBox<String> cbxTipoConta;
    private javax.swing.JLabel labelClienteName;
    // End of variables declaration//GEN-END:variables

    public void setController(GerenciaController controller){
        this.controller = controller;
        this.btnVincular.addActionListener(e -> controller.VincularConta());
    }
    
    public void setClienteClicado(Cliente cliente){
        if(cliente == null){
            cliente = new Cliente();
            cliente.setName("");
        }
        labelClienteName.setText("Cliente: "+cliente.getNome());
    }

}
