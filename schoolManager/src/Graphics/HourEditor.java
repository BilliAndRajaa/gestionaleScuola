/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import Network.DatabaseController;
import Network.Queries;
import Network.QueryDelete;
import Network.QuerySelect;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import schoolManager.Classroom;
import schoolManager.Course;
import schoolManager.Hour;
import schoolManager.Methods;
import schoolManager.SchoolClass;
import schoolManager.Teacher;

/**
 *
 * @author Bilel
 */
public class HourEditor extends javax.swing.JFrame {
DatabaseController controller;
ArrayList<Classroom> classrooms;
ArrayList<SchoolClass> schoolclasses;
ArrayList<Teacher> teachers;
ArrayList<Course> courses;
ArrayList<Integer> addedTeachers=new ArrayList<>();
DefaultListModel<String> modelTeacherList = new DefaultListModel<>();
int Language;
int idHour;
    /**
     * Creates new form HourEditor
     */
    public HourEditor() {
        initComponents();
    }

    HourEditor(DatabaseController controller, Hour hour,int Language, Teacher teacher){
        initComponents();
    try {
        this.controller=controller;
        this.idHour=hour.getIdHour();
        jComboBox4.addItem(teacher.getName()+ " "+teacher.getSurname());
        classrooms=QuerySelect.selectClassrooms(controller);
        courses=QuerySelect.selectCourses(controller);
        schoolclasses=QuerySelect.selectSchoolclasses(controller);
        this.teachers=new ArrayList<Teacher>();
        teachers.add(teacher);
        this.Language=Language;
        if(Language==1){
            translate();
        }
        for(int i=0;i<classrooms.size();i++){
            jComboBox2.addItem(classrooms.get(i).getName());
        }
        for(int i=0;i<courses.size();i++){
            jComboBox3.addItem(courses.get(i).getName());
        }
        jComboBox5.setSelectedIndex(hour.getBegin()-8);
        jComboBox6.setSelectedIndex(hour.getEnd()-8);
        int idClass=QuerySelect.getClassFromHour(controller, idHour);
        int indexToKeep=0;
        for(int i=0;i<schoolclasses.size();i++){
            jComboBox1.addItem(schoolclasses.get(i).getName());
            if(idClass==schoolclasses.get(i).getId()){
                indexToKeep=i;
            }
        }
        jComboBox1.setSelectedIndex(indexToKeep);
        remove(jList1);
        remove(jButton1);
        remove(jButton2);
        revalidate();
        repaint();
    } catch (SQLException ex) {
        Logger.getLogger(HourEditor.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }

    HourEditor(DatabaseController controller, Hour hour,int Language, Classroom classroom) {
        initComponents();
    try {
        this.controller=controller;
        this.idHour=hour.getIdHour();
        jComboBox2.addItem(classroom.getName());
        this.classrooms=new ArrayList<>();
        classrooms.add(classroom);
        schoolclasses=QuerySelect.selectSchoolclasses(controller);
        courses=QuerySelect.selectCourses(controller);
        this.Language=Language;
        for(int i=0;i<schoolclasses.size();i++){
            jComboBox2.addItem(schoolclasses.get(i).getName());
        }
        for(int i=0;i<courses.size();i++){
            jComboBox3.addItem(courses.get(i).getName());
        }
        jComboBox5.setSelectedIndex(hour.getBegin()-8);
        jComboBox6.setSelectedIndex(hour.getEnd()-8);
        teachers=QuerySelect.selectTeachers(controller);
        jList1.setModel(modelTeacherList);
        addedTeachers=QuerySelect.selectTeachersByHour(controller, hour.getIdHour());
        for(int i=0;i<addedTeachers.size();i++){
            for(int x=0;x<teachers.size();x++){
                if(addedTeachers.get(i)==teachers.get(x).getId()){
                    modelTeacherList.addElement(teachers.get(x).getName()+" "+teachers.get(x).getSurname());
                }
            }
        }
        int idClass=QuerySelect.getClassFromHour(controller, idHour);
        int indexToKeep=0;
        for(int i=0;i<schoolclasses.size();i++){
            jComboBox1.addItem(schoolclasses.get(i).getName());
            if(idClass==schoolclasses.get(i).getId()){
                indexToKeep=i;
            }
        }
        jComboBox1.setSelectedIndex(indexToKeep);
    } catch (SQLException ex) {
        Logger.getLogger(HourEditor.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    HourEditor(DatabaseController controller, Hour hour,int Language, SchoolClass schoolclass) {
    initComponents();
    try {
        this.controller=controller;
        this.idHour=hour.getIdHour();
        jComboBox1.addItem(schoolclass.getName());
        classrooms=QuerySelect.selectClassrooms(controller);
        courses=QuerySelect.selectCourses(controller);
        this.schoolclasses=new ArrayList<>();
        this.schoolclasses.add(schoolclass);
        this.Language=Language;
        for(int i=0;i<classrooms.size();i++){
            jComboBox2.addItem(classrooms.get(i).getName());
        }
        for(int i=0;i<courses.size();i++){
            jComboBox3.addItem(courses.get(i).getName());
        }
        jComboBox5.setSelectedIndex(hour.getBegin()-8);
        jComboBox6.setSelectedIndex(hour.getEnd()-8);
        teachers=QuerySelect.selectTeachers(controller);
        jList1.setModel(modelTeacherList);
        addedTeachers=QuerySelect.selectTeachersByHour(controller, hour.getIdHour());
        for(int i=0;i<addedTeachers.size();i++){
            for(int x=0;x<teachers.size();x++){
                if(addedTeachers.get(i)==teachers.get(x).getId()){
                    modelTeacherList.addElement(teachers.get(x).getName()+" "+teachers.get(x).getSurname());
                }
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(HourEditor.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(179, 163, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("SCHOOLCLASS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CLASSROOM");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("SUBJECT");

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("REMOVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("TEACHERS");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18" }));
        jComboBox5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox5ItemStateChanged(evt);
            }
        });

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19" }));
        jComboBox6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox6ItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("BEGIN");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("END");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("SUBMIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("DAY");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jComboBox3, 0, 230, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel4)
                        .addContainerGap(178, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton2))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

/**
 * 
 * @param evt
 * The jButton1ActionPerformed event adds an element to the ArrayList addedTeachers.
 */    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int index=jComboBox4.getSelectedIndex();
        if(!addedTeachers.contains(teachers.get(index).getId())){
            addedTeachers.add(teachers.get(index).getId());
            modelTeacherList.addElement(teachers.get(index).getName());
        }
    }//GEN-LAST:event_jButton1ActionPerformed
/**
 * 
 * @param evt
 * The jButton2ActionPerformed event removes an element from the ArrayList addedTeachers.
 */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int index=jList1.getSelectedIndex();
        if(index!=-1){
            addedTeachers.remove(index);
            modelTeacherList.remove(index);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
/**
 * @param evt
 * The jButton3ActionPerformed event controlls the values in the fields, and if the values are
 * valid then the method createHour is called.
 */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int begin=Integer.parseInt(jComboBox5.getItemAt(jComboBox5.getSelectedIndex()));
        int end=Integer.parseInt(jComboBox6.getItemAt(jComboBox6.getSelectedIndex()));
        int idSchoolClass=schoolclasses.get(jComboBox1.getSelectedIndex()).getId();
        int idClassroom=classrooms.get(jComboBox2.getSelectedIndex()).getId();
        int dayIndex=jComboBox7.getSelectedIndex();
        int idCourse=courses.get(jComboBox3.getSelectedIndex()).getIdCourse();
        boolean replacable=true;
        if(!teachers.isEmpty()){
            try {
                if(Queries.TimeReplaceOverlap(controller, idHour, begin,end, idSchoolClass, dayIndex)){
                    if(Queries.TimeReplaceOverlapClassroom(controller, idHour, begin,end, idClassroom,idSchoolClass, dayIndex)){
                       for(int i=0;i<teachers.size();i++){ 
                            if(!Queries.TimeReplaceOverlapTeacher(controller, idHour, begin,end, teachers.get(i).getId(), dayIndex)){
                                replacable=false;
                                break;
                            }
                       }
                       if(replacable){
                            QueryDelete.deleteHour(controller, idHour);
                            if(Methods.createHour(controller, begin, end, dayIndex,idSchoolClass,classrooms.get(jComboBox2.getSelectedIndex()), addedTeachers, idCourse,"")){
                                         if(Language==1){
                                             JOptionPane.showMessageDialog(null,"ora inserita con successo", "",JOptionPane.ERROR_MESSAGE);
                                         }else{
                                             JOptionPane.showMessageDialog(null,"hour inserted with success", "",JOptionPane.ERROR_MESSAGE);
                                         }
                                     }else{
                                         if(Language==1){
                                             JOptionPane.showMessageDialog(null,"errore di sovraposizione", "",JOptionPane.ERROR_MESSAGE);
                                         }else{
                                             JOptionPane.showMessageDialog(null,"error of overlapping", "",JOptionPane.ERROR_MESSAGE);
                                         }
                                        }
                       }else{
                           if(Language==1){
                                             JOptionPane.showMessageDialog(null,"errore di sovraposizione", "",JOptionPane.ERROR_MESSAGE);
                            }else{
                                             JOptionPane.showMessageDialog(null,"error of overlapping", "",JOptionPane.ERROR_MESSAGE);
                            }
                       }
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(TimetableCreator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            if(Language==1){
                JOptionPane.showMessageDialog(null,"nessun professore selezionato", "",JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"no teacher selected", "",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed
/**
 * The jComboBox5ItemStateChanged event it's triggered when the value is changed, 
 * it controlls the value of jcombobox6 and if the value is greater then it changes the value 
 * to a valid one.
 * @param evt 
 */
    private void jComboBox5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox5ItemStateChanged
        int index=jComboBox5.getSelectedIndex();
        if(index>jComboBox6.getSelectedIndex()){
            jComboBox6.setSelectedIndex(index);
        }
    }//GEN-LAST:event_jComboBox5ItemStateChanged
/**
 * The jComboBox6ItemStateChanged event it's triggered when the value is changed, 
 * it controlls the value of jcombobox5 and if the value is lower then it changes the value 
 * to a valid one.
 * @param evt 
 */
    private void jComboBox6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox6ItemStateChanged
        int index=jComboBox6.getSelectedIndex();
        if(index<jComboBox5.getSelectedIndex()){
            jComboBox5.setSelectedIndex(index);
        }
    }//GEN-LAST:event_jComboBox6ItemStateChanged

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed
    /**
    * The function translate, translates the text of the labels and button from english to italian.
    */
    private void translate(){
        jLabel1.setText("CLASSE");
        jLabel2.setText("AULA");
        jLabel3.setText("CORSO");
        jLabel4.setText("INSEGNANTE");
        jButton1.setText("AGGIUNGI");
        jButton2.setText("RIMUOVI");
        jLabel7.setText("GIORNO");
        jLabel5.setText("INIZIO");
        jLabel6.setText("FINE");
        jButton3.setText("INSERISCI");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
