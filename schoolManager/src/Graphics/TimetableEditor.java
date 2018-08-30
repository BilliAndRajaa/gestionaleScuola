/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import Network.DatabaseController;
import Network.QueryDelete;
import Network.QuerySelect;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoundedRangeModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import schoolManager.Classroom;
import schoolManager.Course;
import schoolManager.Hour;
import schoolManager.Methods;
import schoolManager.SchoolClass;
import schoolManager.Teacher;
import schoolManager.Week;

/**
 *
 * @author Bilel
 */
public class TimetableEditor extends javax.swing.JFrame {
DatabaseController controller;
Week week;
Teacher teacher;
Classroom classroom;
SchoolClass schoolclass;
int selectedDay=0;
int selectedHour=0;
int idSelectedHour=0;
ArrayList<Integer> teachers;
ArrayList<Course>courses;
int Language;
String type;
/*
    * Creates new form TimetableEditor
    */
    public TimetableEditor(DatabaseController controller,Week week, Teacher teacher,ArrayList<Course>courses,int Language) {
        initComponents();
        BoundedRangeModel model= jScrollPane1.getVerticalScrollBar().getModel();
        jScrollPane3.getVerticalScrollBar().setModel( model );
        model= jScrollPane1.getHorizontalScrollBar().getModel();
        jScrollPane2.getHorizontalScrollBar().setModel(model);
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.controller=controller;
        this.week=week;
        this.teacher=teacher;
        this.courses=courses;
        this.type="teacher";
        teachers=new ArrayList<>();
        teachers.add(teacher.getId());
        this.Language=Language;
        if(Language==1){
            translate();
        }
        for(int i=0;i<week.getDays().size();i++){
             String day="";
                switch(week.getDays().get(i).getDay()){
                    case 0:if(Language==1){
                                day="lunedi'";
                           }else{
                                day="monday";
                           };
                    break;
                    case 1:if(Language==1){
                                day="martedi'";
                           }else{
                                day="tuesday";
                           };
                    break;
                    case 2:if(Language==1){
                                day="mercoledi'";
                           }else{
                                day="wednesday";
                           };
                    break;
                    case 3:if(Language==1){
                                day="giovedi'";
                           }else{
                                day="thursday";
                           };
                    break;
                    case 4:if(Language==1){
                                day="venerdi'";
                           }else{
                                day="friday";
                           };
                    break;
                    case 5:if(Language==1){
                                day="sabato";
                           }else{
                                day="saturday";
                           };
                    break;
                }
            for(int x=0;x<week.getDays().get(i).getHours().size();x++){
                jComboBox8.addItem(day+ ": "+week.getDays().get(i).getHours().get(x).getBegin()+"-"+week.getDays().get(i).getHours().get(x).getEnd());
            }
        }
    }
    public TimetableEditor(DatabaseController controller,Week week,Classroom classroom,ArrayList<Integer> teachers,ArrayList<Course>courses, int Language) {
        initComponents();
        BoundedRangeModel model= jScrollPane1.getVerticalScrollBar().getModel();
        jScrollPane1.getVerticalScrollBar().setModel( model );
        model= jScrollPane1.getHorizontalScrollBar().getModel();
        jScrollPane1.getHorizontalScrollBar().setModel(model);
        this.controller=controller;
        this.type="classroom";
        this.week=week;
        this.classroom=classroom;
        this.courses=courses;
        this.teachers=teachers;
         this.Language=Language;
        if(Language==1){
            translate();
        }
        for(int i=0;i<week.getDays().size();i++){
             String day="";
                switch(week.getDays().get(i).getDay()){
                    case 0:if(Language==1){
                                day="lunedi'";
                           }else{
                                day="monday";
                           };
                    break;
                    case 1:if(Language==1){
                                day="martedi'";
                           }else{
                                day="tuesday";
                           };
                    break;
                    case 2:if(Language==1){
                                day="mercoledi'";
                           }else{
                                day="wednesday";
                           };
                    break;
                    case 3:if(Language==1){
                                day="giovedi'";
                           }else{
                                day="thursday";
                           };
                    break;
                    case 4:if(Language==1){
                                day="venerdi'";
                           }else{
                                day="friday";
                           };
                    break;
                    case 5:if(Language==1){
                                day="sabato";
                           }else{
                                day="saturday";
                           };
                    break;
                }
            for(int x=0;x<week.getDays().get(i).getHours().size();x++){
                jComboBox8.addItem(day+ ": "+week.getDays().get(i).getHours().get(x).getBegin()+"-"+week.getDays().get(i).getHours().get(x).getEnd());
            }
        }
    }
    public TimetableEditor(DatabaseController controller,Week week,SchoolClass schoolclass,ArrayList<Integer> teachers,ArrayList<Course>courses,int Language) {
        initComponents();
         BoundedRangeModel model= jScrollPane1.getVerticalScrollBar().getModel();
        jScrollPane1.getVerticalScrollBar().setModel( model );
        model= jScrollPane1.getHorizontalScrollBar().getModel();
        jScrollPane1.getHorizontalScrollBar().setModel(model);
        this.controller=controller;
        this.week=week;
        this.schoolclass=schoolclass;
        this.courses=courses;
        this.teachers=teachers;
        this.Language=Language;
        this.type="schoolclass";
        if(Language==1){
            translate();
        }
        for(int i=0;i<week.getDays().size();i++){
             String day="";
                switch(week.getDays().get(i).getDay()){
                    case 0:if(Language==1){
                                day="lunedi'";
                           }else{
                                day="monday";
                           };
                    break;
                    case 1:if(Language==1){
                                day="martedi'";
                           }else{
                                day="tuesday";
                           };
                    break;
                    case 2:if(Language==1){
                                day="mercoledi'";
                           }else{
                                day="wednesday";
                           };
                    break;
                    case 3:if(Language==1){
                                day="giovedi'";
                           }else{
                                day="thursday";
                           };
                    break;
                    case 4:if(Language==1){
                                day="venerdi'";
                           }else{
                                day="friday";
                           };
                    break;
                    case 5:if(Language==1){
                                day="sabato";
                           }else{
                                day="saturday";
                           };
                    break;
                }
            for(int x=0;x<week.getDays().get(i).getHours().size();x++){
                jComboBox8.addItem(day+ ": "+week.getDays().get(i).getHours().get(x).getBegin()+"-"+week.getDays().get(i).getHours().get(x).getEnd());
            }
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
        jButton4 = new javax.swing.JButton();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(179, 163, 255));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("DELETE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox8.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox8ItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("HOURS");

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setAlignmentX(0.0F);
        jScrollPane1.setAlignmentY(0.0F);
        jScrollPane1.setOpaque(false);

        jLabel2.setBackground(new java.awt.Color(204, 204, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("<html><head> <style> table {         width: 100%;     } th, td {   text-align: left;    padding: 8px; }  th {             width: 150px;             height: 90px;             background-color: #725fdf;             color: white;         } </style></head><body> <table>        <tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr> <tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr><tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr><tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr><tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr><tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr><tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr><tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr><tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr><tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr><tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr></table> <body>   </html>");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setAlignmentY(0.0F);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel2.setOpaque(true);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jScrollPane1.setViewportView(jLabel2);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("EDIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jLabel3.setBackground(new java.awt.Color(204, 204, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("<html><head> <style> table {     margin: 10px 0;     width: 100%;     } th, td {   text-align: left;    padding: 8px; }  th {             width: 150px;             height: 70px;             background-color: #725fdf;             color: white;         } </style></head><body> <table>        <tr>                              \t<th>Lunedì</th>                      <th>Martedì</th> \t<th>Mercoledì</th> \t<th>Giovedì</th> \t<th>Venerdì</th>  \t<th>Sabato</th> </tr> </table> <body>   </html>");
        jLabel3.setAlignmentY(0.0F);
        jLabel3.setOpaque(true);
        jScrollPane2.setViewportView(jLabel3);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane3.setAlignmentX(0.0F);
        jScrollPane3.setAlignmentY(0.0F);

        jLabel5.setBackground(new java.awt.Color(204, 204, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("<html><head> <style> table {          width: 90;   } th, td {   text-align: left;    padding: 8px; height: 90px;  }  tr {             width: 600px;          height: 90px;              background-color: #725fdf;             color: white;         } </style></head> <body> <table>        <tr>8-9</tr>                      <tr>9-10</tr> \t<tr>10-11</tr> \t<tr>11-12</tr> <tr>12-13</tr>  \t<tr>13-14</tr><tr>14-15</tr> <tr>15-16</tr> <tr>16-17</tr> <tr>17-18</tr><tr>18-19</tr> </table> <body>   </html>");
        jLabel5.setOpaque(true);
        jLabel5.setVerifyInputWhenFocusTarget(false);
        jScrollPane3.setViewportView(jLabel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(91, 91, 91)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 987, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 728, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * The jButton1ActionPerformed event open the hourEditor class passing a week object.
 * @param evt 
 */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Hour hour=week.getDays().get(selectedDay).getHours().get(selectedHour);
        HourEditor editor=null;
        switch(type){
            case "teacher":editor=new HourEditor(controller,hour,Language,teacher);
            editor.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    update();
                }
            });
            editor.setVisible(true);
            break;
            case "classroom":editor=new HourEditor(controller,hour,Language,classroom);
            editor.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    update();
                }
            });
            editor.setVisible(true);
            break;
            case "schooclass":editor=new HourEditor(controller,hour,Language,schoolclass);
            editor.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    update();
                }
            });
            editor.setVisible(true);
            break;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox8ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox8ItemStateChanged
        if(jComboBox8.getSelectedIndex()>=0){
            calculateDayAndHour();
            draw(week.getDays().get(selectedDay).getHours().get(selectedHour).getIdHour());
            changePosition();
        }
    }//GEN-LAST:event_jComboBox8ItemStateChanged
/**
 * The jButton4ActionPerformed event calls the deleteHour passing an integer value.
 * @param evt 
 */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            QueryDelete.deleteHour(controller, idSelectedHour);
            update();
        } catch (SQLException ex) {
            Logger.getLogger(TimetableEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    /*
    * The calculateDayAndHour method calculates the indexes of an hour object inside a week object.
    */
    private void calculateDayAndHour(){
     int day=0;
     int jumpsToMake=jComboBox8.getSelectedIndex();
     selectedDay=0;
     selectedHour=0;
     while(true){
         if(jumpsToMake<week.getDays().get(day).getHours().size()){
            selectedHour=jumpsToMake;
            selectedDay=day;
            break;
         }else{
            jumpsToMake-=week.getDays().get(day).getHours().size();
            day++;
         }
     }
    }
    private void changePosition(){
         int begin=week.getDays().get(selectedDay).getHours().get(selectedHour).getBegin();
         if(selectedDay>=3){
            JScrollBar horizontal = jScrollPane1.getHorizontalScrollBar();
            horizontal.setValue( horizontal.getMaximum());
         }else{
             JScrollBar horizontal = jScrollPane1.getHorizontalScrollBar();
             horizontal.setValue( horizontal.getMinimum());
         }
         if(begin>11){
            if(begin>16){
                JScrollBar vertical = jScrollPane1.getVerticalScrollBar();        
                vertical.setValue( vertical.getMaximum());
            }else{
                JScrollBar vertical = jScrollPane1.getVerticalScrollBar();        
                vertical.setValue( vertical.getMaximum()*4/11);
            }
          }else{
             JScrollBar vertical = jScrollPane1.getVerticalScrollBar();        
             vertical.setValue( vertical.getMinimum());
         }
    }
    private void draw(int idHour){
    try {
        jLabel2.setText( Methods.generateTableWithSelectedHour(controller, week, courses, teachers, idHour));
    } catch (SQLException ex) {
        Logger.getLogger(TimetableEditor.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    /**
     * The function "update" updates the data with the most recent values.
     */
    private void update(){
    try {
        switch(type){
            case "teacher":week=QuerySelect.selectTimetableByTeacher(controller, teacher.getId());
            break;
            case "classroom":week=QuerySelect.selectTimetableByClassroom(controller, classroom.getId());
            break;
            case "schooclass":week=QuerySelect.selectTimetableBySchoolClass(controller, schoolclass.getId());
            break;
        }
        if(week!=null){
            if(!week.getDays().isEmpty()){
                jComboBox8.removeAllItems();
                for(int i=0;i<week.getDays().size();i++){
                    String day="";
                    switch(week.getDays().get(i).getDay()){
                        case 0:if(Language==1){
                            day="lunedi'";
                        }else{
                            day="monday";
                        };
                        break;
                        case 1:if(Language==1){
                            day="martedi'";
                        }else{
                            day="tuesday";
                        };
                        break;
                        case 2:if(Language==1){
                            day="mercoledi'";
                        }else{
                            day="wednesday";
                        };
                        break;
                        case 3:if(Language==1){
                            day="giovedi'";
                        }else{
                            day="thursday";
                        };
                        break;
                        case 4:if(Language==1){
                            day="venerdi'";
                        }else{
                            day="friday";
                        };
                        break;
                        case 5:if(Language==1){
                            day="sabato";
                        }else{
                            day="saturday";
                        };
                        break;
                    }
                    for(int x=0;x<week.getDays().get(i).getHours().size();x++){
                        jComboBox8.addItem(day+ ": "+week.getDays().get(i).getHours().get(x).getBegin()+"-"+week.getDays().get(i).getHours().get(x).getEnd());
                    }
                }
                calculateDayAndHour();
                changePosition();
            }else{
                this.dispose();
            }
        }else{
            this.dispose();
        }
    } catch (SQLException ex) {
        Logger.getLogger(TimetableEditor.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
     /**
    * The function translate, translates the text of the labels and button from english to italian.
    */
    private void translate(){
        jLabel1.setText("ore");
        jButton1.setText("MODIFICA");
        jButton4.setText("ELIMINA");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
