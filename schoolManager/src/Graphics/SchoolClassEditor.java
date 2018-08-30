/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import Network.DatabaseController;
import Network.QueryDelete;
import Network.QueryUpdate;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import schoolManager.Classroom;
import schoolManager.Faculty;
import schoolManager.SchoolClass;

/**
 *SchoolClassEditor is java Jframe class, for the creation of
 *SchoolClass objects.
 */
public class SchoolClassEditor extends javax.swing.JFrame {
    DatabaseController controller;
    int Language;
    ArrayList<SchoolClass> schoolclasses;
    ArrayList<Faculty> faculties;
    public SchoolClassEditor(DatabaseController controller,ArrayList<Faculty> faculties,ArrayList<SchoolClass> schoolclasses, ArrayList<Classroom> classrooms,int Language) {
        initComponents();
        if(Language==1){
            translate();
        }
        this.controller=controller;
        this.Language=Language;
        this.faculties=faculties;
        this.schoolclasses=schoolclasses;
        for(int i=0;i<schoolclasses.size();i++){
         jComboBox7.addItem(schoolclasses.get(i).getName());
        }
        for(int i=0;i<faculties.size();i++){
         jComboBox1.addItem(faculties.get(i).getName());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jTextField1 = new javax.swing.JTextField();
        jComboBox7 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(179, 163, 255));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("NAME");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("YEAR");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("INSERT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("SECTION");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("STUDENTS");

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(15, 15, null, 1));

        jComboBox7.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox7ItemStateChanged(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("FACULTY");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(72, 72, 72)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))
                        .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jButton3)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * The event jButton3ActionPerformed perform the update if there valid values in the fields,
 * otherwise it shows an JoptionPane message dialog warning the user of the invalid data inserted.
 * The update procedure consists in a creation of a single SchoolClass object selected from the schooclass
 * ArrayList, then it gets modified with new data, only to be sent as a parameter for  QueryUpdate.updateSchoolClass,
 * if the query is successfull then the array schoolclasses is updated with new data.
 */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            // TODO add your handling code here:
            if(jTextField1.getText().length()!=0 && Integer.parseInt(jSpinner1.getValue().toString())>0 && Integer.parseInt(jSpinner3.getValue().toString())>0 ){
                try {
                    SchoolClass schoolclass = schoolclasses.get(jComboBox7.getSelectedIndex());
                    schoolclass.setName(jTextField1.getText());
                    schoolclass.setSection(jComboBox5.getItemAt(jComboBox5.getSelectedIndex()).charAt(0));
                    schoolclass.setYear((Integer)jSpinner1.getValue());
                    schoolclass.setNumberOfStudents((Integer)jSpinner3.getValue());
                    QueryUpdate.updateSchoolClass(controller, schoolclass);
                    QueryUpdate.updatePartOf(controller,schoolclass.getId(),faculties.get(jComboBox1.getSelectedIndex()).getId());
                } catch (SQLException ex) {
                    Logger.getLogger(SchoolClassEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                if(Language==1){
                    JOptionPane.showMessageDialog(null,"errore,alcuni campi non hanno valori autorizzati", "Errore",JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"error some fields don't have authorized values ", "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        
    }//GEN-LAST:event_jButton3ActionPerformed
/**
 * The jButton1ActionPerformed event takes selected index from jComboBox7, and passes the schoolclasses element
 * located in said index, to be passed as paremeter for   QueryDelete.deleteSchoolClass;
 * if the query is successfull then the ArrayList schoolclasses and jComboBox7 are updated.
 */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int index=jComboBox7.getSelectedIndex();
        try {
            QueryDelete.deleteSchoolClass(controller, schoolclasses.get(index).getId());
            jComboBox7.removeItemAt(index);
            schoolclasses.remove(index);
            if(schoolclasses.isEmpty()){
                this.dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SchoolClassEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
/**
 * The jComboBox7ItemStateChanged event writes the values of the 
 * selected SchoolClass object.
 */
    private void jComboBox7ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox7ItemStateChanged
       int index=jComboBox7.getSelectedIndex();
       jTextField1.setText(schoolclasses.get(index).getName());
       jSpinner1.setValue(schoolclasses.get(index).getYear());
       jSpinner3.setValue(schoolclasses.get(index).getNumberOfStudents());
       jComboBox5.setSelectedIndex(schoolclasses.get(index).getSection()-'A');
    }//GEN-LAST:event_jComboBox7ItemStateChanged
     /**
    * The function translate, translates the text of the labels and button from english to italian.
    */
    private void translate(){
       jLabel5.setText("NOME");
       jLabel6.setText("ANNO");
       jLabel7.setText("SEZIONE");
       jLabel8.setText("STUDENTI");
       jButton1.setText("INSERISCI");
       jLabel1.setText("FACOLTA'");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}