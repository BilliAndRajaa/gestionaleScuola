/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import Network.DatabaseController;
import Network.QueryDelete;
import Network.QuerySelect;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoundedRangeModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import schoolManager.AdditionalInfo;
import schoolManager.Classroom;
import schoolManager.Course;
import schoolManager.Faculty;
import schoolManager.Methods;
import schoolManager.SchoolClass;
import schoolManager.Teacher;
import schoolManager.Week;


public class NewJFrame extends javax.swing.JFrame {
    boolean visibility=true;
    DatabaseController controller;
    Week selectedWeek=null;
    ArrayList <SchoolClass> schoolclasses=new ArrayList();
    ArrayList <Classroom> classrooms=new ArrayList();
    ArrayList <Teacher> teachers=new ArrayList();
    ArrayList <Course> courses=new ArrayList();
    ArrayList <Faculty> faculties=new ArrayList();
    ArrayList <Integer> resultIds=new ArrayList<>();
    int Language;
    int Building=0;
    /**
     * Creates new form NewJFrame.
     */
    public NewJFrame(DatabaseController controller,int Language) {
        initComponents();
        this.Language=Language;
        this.controller=controller;
        jButton5.setVisible(false);
        BoundedRangeModel model= jScrollPane1.getVerticalScrollBar().getModel();
        jScrollPane3.getVerticalScrollBar().setModel( model );
        model= jScrollPane1.getHorizontalScrollBar().getModel();
        jScrollPane2.getHorizontalScrollBar().setModel(model);
        Runnable myRunnable = new Runnable(){
        public void run(){
           try {
                teachers=QuerySelect.selectTeachers(controller);
                classrooms=QuerySelect.selectClassrooms(controller);
                schoolclasses=QuerySelect.selectSchoolclasses(controller);
                courses=QuerySelect.selectCourses(controller);
                faculties=QuerySelect.selectFaculties(controller);
                for(int i=0;i<faculties.size();i++){
                    faculties.get(i).setCourses(QuerySelect.selectCoursesFromFaculty(controller, faculties.get(i).getId()));
                }
                for(int i=0;i<teachers.size();i++){
                    teachers.get(i).setSubjects(QuerySelect.selectCoursesIdsFromTeacher(controller,teachers.get(i).getId()));
                    teachers.get(i).setClasses(QuerySelect.selectSchoolclassesIdsByTeacher(controller,teachers.get(i).getId()));
                }
                if(Language==1){
                    Building=1;
                    translate();
                    Building=0;
                }
                buildCombobox();
           } catch (SQLException ex) {
               Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
     };

   Thread thread = new Thread(myRunnable);
   thread.start();
        
         
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList<>();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton21 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jComboBox7 = new javax.swing.JComboBox<>();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        button1 = new java.awt.Button();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        jPanel3.setBackground(new java.awt.Color(179, 163, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(936, 681));
        jPanel3.setPreferredSize(new java.awt.Dimension(910, 681));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("FACULTIES");

        jList1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jScrollPane4.setViewportView(jList1);

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton8.setText("CREATE");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton9.setText("EDIT");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jList2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jScrollPane5.setViewportView(jList2);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("COURSES");

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton10.setText("ADD");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton11.setText("EDIT");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(81, 81, 81))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jPanel6.setBackground(new java.awt.Color(179, 163, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("FIRTSTNAME");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("SECOND NAME");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("DATE OF BIRTH");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("ID");

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane10.setViewportView(jTextArea3);

        jList5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList5MouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jList5);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("USEFULL LINKS");

        jScrollPane12.setViewportView(jList6);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("SUBJECTS");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jToggleButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jToggleButton1.setText("SHOW");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton21.setText("CREATE NEW TEACHER");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton12.setText("EDIT TEACHER");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jScrollPane6.setViewportView(jList3);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("CLASSES");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton1)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(39, 39, 39)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(289, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(301, 301, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel8)
                    .addComponent(jToggleButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel9))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton12)))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(179, 163, 255));

        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jComboBox7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox7.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox7ItemStateChanged(evt);
            }
        });

        jComboBox8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox8.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox8ItemStateChanged(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("NAME");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("FACULTY");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("MAIN CLASSROOM");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("NUMBER OF STUDENTS");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("SECTION AND YEAR");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("CLASSES");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("CLASSROOMS");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("ID");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setText("ID");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setText("NAME");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setText("MAX CAPACITY");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setText("TYPE");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButton22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton22.setText("ADD NEW CLASS");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton23.setText("ADD NEW ROOM");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton14.setText("EDIT");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton15.setText("EDIT");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jButton22)
                    .addComponent(jButton14)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(154, 154, 154)
                        .addComponent(jLabel37))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(129, 129, 129)
                        .addComponent(jLabel29))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(107, 107, 107)
                        .addComponent(jLabel30))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel26)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel28)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel33))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel27)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel32))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel45)
                            .addComponent(jLabel44)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton23)
                            .addComponent(jButton15))))
                .addGap(149, 149, 149))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel34))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel35)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel29))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel30))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel31))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel32))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel33))
                        .addGap(113, 113, 113)
                        .addComponent(jButton14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton22)
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel44))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(jLabel46))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(jLabel47))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton23)
                        .addGap(39, 39, 39))))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSplitPane1.setBorder(null);
        jSplitPane1.setEnabled(false);

        jPanel4.setBackground(new java.awt.Color(179, 163, 255));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(179, 163, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(936, 681));
        jPanel1.setPreferredSize(new java.awt.Dimension(910, 681));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 170, -1));

        button1.setActionCommand("SHOW ");
        button1.setLabel("SHOW ");
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button1MouseClicked(evt);
            }
        });
        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 90, 40));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teacher", "Schoolclass", "Classroom" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 240, 30));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 240, 30));

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setAlignmentX(0.0F);
        jScrollPane1.setAlignmentY(0.0F);
        jScrollPane1.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("<html><head> <style> table {         width: 100%;     } th, td {   text-align: left;    padding: 8px; }  th {             width: 150px;             height: 90px;             background-color: #725fdf;             color: white;         } </style></head><body> <table>        <tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr> <tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr><tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr><tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr><tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr><tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr><tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr><tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr><tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr><tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr><tr>                              \t<th></th>                      <th></th> \t<th></th> \t<th></th> \t<th></th>  \t<th></th> </tr></table> <body>   </html>");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setOpaque(true);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jScrollPane1.setViewportView(jLabel1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 430, 600));

        jScrollPane2.setBackground(new java.awt.Color(153, 255, 204));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setOpaque(false);

        jLabel3.setBackground(new java.awt.Color(204, 204, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("<html><head> <style> table {     margin: 10px 0;     width: 100%;     } th, td {   text-align: left;    padding: 8px; }  th {             width: 150px;             height: 70px;             background-color: #725fdf;             color: white;         } </style></head><body> <table>        <tr>                              \t<th>Lunedì</th>                      <th>Martedì</th> \t<th>Mercoledì</th> \t<th>Giovedì</th> \t<th>Venerdì</th>  \t<th>Sabato</th> </tr> </table> <body>   </html>");
        jLabel3.setOpaque(true);
        jScrollPane2.setViewportView(jLabel3);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, -10, 430, 100));

        jScrollPane3.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane3.setBorder(null);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane3.setOpaque(false);

        jLabel5.setBackground(new java.awt.Color(204, 204, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("<html><head> <style> table {          width: 90;   } th, td {   text-align: left;    padding: 8px; height: 90px;  }  tr {             width: 600px;          height: 90px;              background-color: #725fdf;             color: white;         } </style></head> <body> <table>        <tr>8-9</tr>                      <tr>9-10</tr> \t<tr>10-11</tr> \t<tr>11-12</tr> <tr>12-13</tr>  \t<tr>13-14</tr><tr>14-15</tr> <tr>15-16</tr> <tr>16-17</tr> <tr>17-18</tr><tr>18-19</tr> </table> <body>   </html>");
        jLabel5.setOpaque(true);
        jLabel5.setVerifyInputWhenFocusTarget(false);
        jScrollPane3.setViewportView(jLabel5);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 90, 610));

        jButton1.setText("SEARCH");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 90, 40));

        jButton2.setText("EDIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 100, 30));

        jButton7.setText("RESET");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 600, 110, 30));

        jButton5.setText("GENERATE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 640, 110, 30));

        jButton13.setText("INSERT HOUR");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, -1, 30));

        jPanel4.add(jPanel1);

        jSplitPane1.setRightComponent(jPanel4);

        jPanel5.setBackground(new java.awt.Color(153, 153, 255));
        jPanel5.setAlignmentX(0.0F);
        jPanel5.setAlignmentY(0.0F);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("<html>\n<head>\n</head>\n<body>FACULTIES</br>\nAND</br>\nSUBJECTS\n</body>\n</html>");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("ROOMS/CLASSES");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("PROFESSORS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jToggleButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jToggleButton2.setText("TIMETABLES");
        jToggleButton2.setBorder(null);
        jToggleButton2.setBorderPainted(false);
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(295, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel5);

        getContentPane().add(jSplitPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked
        try {
            int index=jComboBox1.getSelectedIndex();
            int id=0;
            ArrayList <Course> courses=new ArrayList<>();
            ArrayList <Integer> teachers_Id=new ArrayList<>();
            switch(jComboBox2.getSelectedIndex()){
                case 0:
                if(resultIds.isEmpty()){
                    id=teachers.get(index).getId();
                }else{
                    id=resultIds.get(index);
                }
                selectedWeek=QuerySelect.selectTimetableByTeacher(controller, id);
                courses=QuerySelect.selectCoursesFromTeacher(controller, id);
                if(id!=0){              
                    jLabel1.setText(Methods.generateTable(controller,selectedWeek,courses,teachers_Id,0));
                }
                jButton5.setVisible(false);
                break;
                case 2:
                if(resultIds.isEmpty()){
                    id=classrooms.get(index).getId();
                }else{
                    id=resultIds.get(index);
                }
                selectedWeek=QuerySelect.selectTimetableByClassroom(controller, id);
                courses=QuerySelect.selectCoursesFromClassroomTable(controller, selectedWeek);
                teachers_Id=QuerySelect.selectTeachersFromTable(controller, selectedWeek);
                if(id!=0){              
                    jLabel1.setText(Methods.generateTable(controller,selectedWeek,courses,teachers_Id,0));
                }
                jButton5.setVisible(false);
                break;
                case 1:
                if(resultIds.isEmpty()){
                    id=schoolclasses.get(index).getId();
                }else{
                    id=resultIds.get(index);
                }
                selectedWeek=QuerySelect.selectTimetableBySchoolClass(controller, id);
                courses=QuerySelect.selectFacultyPlanFromClass(controller, id);
                if(id!=0){              
                    jLabel1.setText(Methods.generateTable(controller,selectedWeek,courses,teachers_Id,1));
                }
                jButton5.setVisible(true);
                break;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button1MouseClicked

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        jPanel4.removeAll();
        jPanel4.revalidate();
        jPanel4.repaint();
        jPanel4.add(jPanel1);
        jPanel4.revalidate();
        jPanel4.repaint();
        jComboBox1.removeAllItems();
         for(int i=0;i<teachers.size();i++){
                    jComboBox1.addItem(teachers.get(i).getName() + " " +teachers.get(i).getSurname());
         }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        buildCombobox();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        buildCombobox();
        ArrayList<String> result=new ArrayList<>();
        if(!jTextField1.getText().equals("")){
            for(int i=0;i<jComboBox1.getItemCount();i++){
                if(jComboBox1.getItemAt(i).toLowerCase().contains(jTextField1.getText().toLowerCase())){
                   result.add(jComboBox1.getItemAt(i));
                    switch(jComboBox2.getSelectedItem().toString()){
                        case "Insegnanti":resultIds.add(teachers.get(i).getId());
                            break;
                        case "Aule":  resultIds.add(classrooms.get(i).getId());
                            break;
                        case "Classi":resultIds.add(schoolclasses.get(i).getId());
                            break;
                    }
                }
            }
            //aggiorno la combo box
            if(!result.isEmpty()){
                jComboBox1.removeAllItems();
                for(int i=0;i<result.size();i++){
                    jComboBox1.addItem(result.get(i));
                }
                 //avviso con n risultati
            }else{
                //avviso
                JOptionPane.showMessageDialog(null, "", "NESSUN RISULTATO TROVATO",
                                    JOptionPane.OK_CANCEL_OPTION);
                buildCombobox();
            }
        }else{
            //avviso 
            JOptionPane.showMessageDialog(null, "", "NESSUN RISULTATO TROVATO",
                                    JOptionPane.OK_CANCEL_OPTION);
            buildCombobox();
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        buildCombobox();
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        jPanel4.removeAll();
        jPanel4.revalidate();
        jPanel4.repaint();
        jPanel4.add(jPanel3);
        jPanel4.revalidate();
        jPanel4.repaint();
    }//GEN-LAST:event_jButton6MouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        showTeacher();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       jPanel4.removeAll();
        jPanel4.revalidate();
        jPanel4.repaint();
        jPanel4.add(jPanel6);
        jPanel4.revalidate();
        jPanel4.repaint();
        builTeachers();
        showTeacher();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        resetTimetable();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jPanel4.removeAll();
        jPanel4.revalidate();
        jPanel4.repaint();
        jPanel4.add(jPanel7);
        jPanel4.revalidate();
        jPanel4.repaint();
        buildRoomsAndClasses();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        TeacherCreator creator=new TeacherCreator(controller, courses, schoolclasses, Language);
        creator.addWindowListener(new java.awt.event.WindowAdapter() {
                              @Override
                              public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                                   update();
                                }
                              });
        creator.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        creator.setVisible(true);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jList5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList5MouseClicked
        // TODO add your handling code here:
         if(evt.getClickCount()==2){
            int index=jList5.locationToIndex(evt.getPoint());                      
         }
    }//GEN-LAST:event_jList5MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        CourseCreator coursecreator=new CourseCreator(controller,Language);
        coursecreator.addWindowListener(new java.awt.event.WindowAdapter() {
                              @Override
                              public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                                   update();
                                }
                              });
        coursecreator.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        coursecreator.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(courses.isEmpty()){
            CourseEditor courseeditor=new CourseEditor(controller,courses,Language);
            courseeditor.addWindowListener(new java.awt.event.WindowAdapter() {
                                  @Override
                                  public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                                       update();
                                    }
                                  });
            courseeditor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            courseeditor.setVisible(true);
        }else{
            if(Language==1){
                        JOptionPane.showMessageDialog(null,"non ci sono elementi modificabili", "Errore",JOptionPane.ERROR_MESSAGE);
            }else{
                        JOptionPane.showMessageDialog(null,"there is no editable item available", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
            FacultyCreator facultycreator=new FacultyCreator( controller,courses, Language);
            facultycreator.addWindowListener(new java.awt.event.WindowAdapter() {
                              @Override
                              public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                                   update();
                                }
                              });
            facultycreator.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            facultycreator.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(!faculties.isEmpty()){
            FacultyEditor facultyeditor=new FacultyEditor( controller,faculties,courses, Language);
            facultyeditor.addWindowListener(new java.awt.event.WindowAdapter() {
                                  @Override
                                  public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                                       update();
                                    }
                                  });
            facultyeditor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            facultyeditor.setVisible(true);
        }else{
            if(Language==1){
                        JOptionPane.showMessageDialog(null,"non ci sono elementi modificabili", "Errore",JOptionPane.ERROR_MESSAGE);
            }else{
                        JOptionPane.showMessageDialog(null,"there is no editable item available", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        buildList();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox7ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox7ItemStateChanged
      if(jComboBox7.getSelectedIndex()!=-1){
        SchoolClass Class=schoolclasses.get(jComboBox7.getSelectedIndex());
        int indexFaculty=0;
        int idFaculty=Class.getFaculty();
        for(int i=0;i<faculties.size();i++){
            if(idFaculty==faculties.get(i).getId()){
                indexFaculty=i;
                break;
            }
        }
        jLabel37.setText(Integer.toString(Class.getId()));
        jLabel29.setText(Class.getName());
        jLabel30.setText(faculties.get(indexFaculty).getName());
        jLabel31.setText(Integer.toString(Class.getMainClassroom()));
        jLabel32.setText(Integer.toString(Class.getNumberOfStudents()));
        jLabel33.setText(Integer.toString(Class.getYear())+Class.getSection());
      }
    }//GEN-LAST:event_jComboBox7ItemStateChanged

    private void jComboBox8ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox8ItemStateChanged
        if(jComboBox7.getSelectedIndex()!=-1){
            Classroom classroom=classrooms.get(jComboBox8.getSelectedIndex());
            jLabel44.setText(Integer.toString(classroom.getId()));
            jLabel45.setText(classroom.getName());
            jLabel46.setText(Integer.toString(classroom.getMaxCapacity()));
            jLabel47.setText(classroom.getType());
        }
    }//GEN-LAST:event_jComboBox8ItemStateChanged

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if(!schoolclasses.isEmpty()){
        SchoolClassEditor editor=new SchoolClassEditor(controller, faculties, schoolclasses, classrooms, Language);
        editor.addWindowListener(new java.awt.event.WindowAdapter() {
                              @Override
                              public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                                   update();
                                }
                              });
        editor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editor.setVisible(true);
        }else{
            if(Language==1){
                        JOptionPane.showMessageDialog(null,"non ci sono elementi modificabili", "Errore",JOptionPane.ERROR_MESSAGE);
            }else{
                        JOptionPane.showMessageDialog(null,"there is no editable item available", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        SchoolClassCreator creator=new SchoolClassCreator(controller, faculties, Language);
        creator.addWindowListener(new java.awt.event.WindowAdapter() {
                              @Override
                              public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                                   update();
                                }
                              });
        creator.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        creator.setVisible(true);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        ClassroomCreator creator=new ClassroomCreator(controller, Language);
        creator.addWindowListener(new java.awt.event.WindowAdapter() {
                              @Override
                              public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                                   update();
                                }
                              });
        creator.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        creator.setVisible(true);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
      if(!classrooms.isEmpty()){
       ClassroomEditor editor=new ClassroomEditor(controller, classrooms, Language);
       editor.addWindowListener(new java.awt.event.WindowAdapter() {
                              @Override
                              public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                                   update();
                                }
                              });
        editor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editor.setVisible(true);
        }else{
            if(Language==1){
                        JOptionPane.showMessageDialog(null,"non ci sono elementi modificabili", "Errore",JOptionPane.ERROR_MESSAGE);
            }else{
                        JOptionPane.showMessageDialog(null,"there is no editable item available", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        TimetableCreator creator=new TimetableCreator(controller, classrooms, schoolclasses, teachers, courses, Language);
        creator.addWindowListener(new java.awt.event.WindowAdapter() {
                              @Override
                              public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                                   update();
                                }
                              });
        creator.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        creator.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            try {
                TimetableEditor editor=null;
                int index=jComboBox1.getSelectedIndex();
                int id=0;
                Teacher teacher=null;
                Classroom classroom=null;
                SchoolClass schoolclass=null;
                switch(jComboBox2.getSelectedIndex()){
                    case 0:
                        if(resultIds.isEmpty()){
                            id=teachers.get(index).getId();
                        }else{
                            id=resultIds.get(index);
                        }
                        for(int i=0;i<teachers.size();i++){
                            if(teachers.get(i).getId()==id){
                                teacher=teachers.get(i);
                                break;
                            }
                        }
                        selectedWeek=QuerySelect.selectTimetableByTeacher(controller, id);
                        editor=new TimetableEditor(controller, selectedWeek, teacher, courses, Language);
                        break;
                    case 1: 
                        if(resultIds.isEmpty()){
                            id=schoolclasses.get(index).getId();
                        }else{
                            id=resultIds.get(index);
                        }
                        for(int i=0;i<schoolclasses.size();i++){
                            if(schoolclasses.get(i).getId()==id){
                                schoolclass=schoolclasses.get(i);
                                break;
                            }
                        }
                        selectedWeek=QuerySelect.selectTimetableBySchoolClass(controller, id);
                        editor=new TimetableEditor(controller, selectedWeek, schoolclass, resultIds, courses, Language);
                    break;
                    case 2:
                         if(resultIds.isEmpty()){
                            id=classrooms.get(index).getId();
                        }else{
                            id=resultIds.get(index);
                        }
                        for(int i=0;i<classrooms.size();i++){
                            if(classrooms.get(i).getId()==id){
                                classroom=classrooms.get(i);
                                break;
                            }
                        }
                        selectedWeek=QuerySelect.selectTimetableByClassroom(controller, id);
                        editor=new TimetableEditor(controller, selectedWeek, classroom, resultIds, courses, Language);
                    break;
                }
               if(!selectedWeek.getDays().isEmpty()){
                    editor.addWindowListener(new java.awt.event.WindowAdapter() {
                                       @Override
                                       public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                                            update();
                                         }
                                       });
                     editor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                     editor.setVisible(true);
               }else{
                    if(Language==1){
                                JOptionPane.showMessageDialog(null,"l'orario è vuoto", "Errore",JOptionPane.ERROR_MESSAGE);
                    }else{
                                JOptionPane.showMessageDialog(null,"the timetable is empty", "Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         int index=jComboBox1.getSelectedIndex();
         if(index!=-1){
            if(resetTimetable()){
                if(resultIds.isEmpty()){
                    Generator generator=new Generator(controller, Language,schoolclasses.get(index));
                    generator.addWindowListener(new java.awt.event.WindowAdapter() {
                                  @Override
                                  public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                                       update();
                                    }
                                  });
                    generator.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    generator.setVisible(true);             
                }else{
                    for(int i=0;i<schoolclasses.size();i++){
                        if(schoolclasses.get(i).getId()==resultIds.get(jComboBox1.getSelectedIndex())){
                            index=i;
                            break;
                        }
                    }
                    Generator generator=new Generator(controller, Language,schoolclasses.get(index));
                    generator.addWindowListener(new java.awt.event.WindowAdapter() {
                                  @Override
                                  public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                                       update();
                                    }
                                  });
                    generator.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    generator.setVisible(true);
                }
            }
            
            
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if(!teachers.isEmpty()){
        TeacherEditor editor=new TeacherEditor(controller, teachers, courses, schoolclasses, Language);
        editor.addWindowListener(new java.awt.event.WindowAdapter() {
                              @Override
                              public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                                   update();
                                }
                              });
        editor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editor.setVisible(true);
        }else{
            if(Language==1){
                        JOptionPane.showMessageDialog(null,"non ci sono elementi modificabili", "Errore",JOptionPane.ERROR_MESSAGE);
            }else{
                        JOptionPane.showMessageDialog(null,"there is no editable item available", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton12ActionPerformed
    void buildCombobox(){
        if(Building==0){
        resultIds.clear(); 
        jComboBox1.removeAllItems();
        switch(jComboBox2.getSelectedIndex()){
            case 0:if(teachers.size()==0){
                                try {
                                    teachers=QuerySelect.selectTeachers(controller);
                                    for(int i=0;i<teachers.size();i++){
                                        jComboBox1.addItem(teachers.get(i).getName() +" "+ teachers.get(i).getSurname());
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                              }
                              else{
                                    for(int i=0;i<teachers.size();i++){
                                        jComboBox1.addItem(teachers.get(i).getName() +" "+ teachers.get(i).getSurname());
                                    }
                              };
            break;
            case 2:if(classrooms.size()==0){
                                try {
                                    classrooms=QuerySelect.selectClassrooms(controller);
                                    for(int i=0;i<classrooms.size();i++){
                                        jComboBox1.addItem(classrooms.get(i).getName());
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                              }
                              else{
                                        for(int i=0;i<classrooms.size();i++){
                                        jComboBox1.addItem(classrooms.get(i).getName());
                                        }
                              };
            break;
            case 1:if(schoolclasses.size()==0){
                                try {
                                    schoolclasses=QuerySelect.selectSchoolclasses(controller);
                                    for(int i=0;i<schoolclasses.size();i++){
                                        jComboBox1.addItem(schoolclasses.get(i).getName());
                                       }
                                } catch (SQLException ex) {
                                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                              }
                              else{
                                        for(int i=0;i<schoolclasses.size();i++){
                                        jComboBox1.addItem(schoolclasses.get(i).getName());
                                        }
                              };
            break;
        }
        }
        }
    void buildList(){
        DefaultListModel<String> modelCourseList = new DefaultListModel<>();
        DefaultListModel<String> modelFacultyList = new DefaultListModel<>();
        jList1.setModel(modelFacultyList);
        jList2.setModel(modelCourseList);
        for(int i=0;i<faculties.size();i++){
            modelFacultyList.addElement(faculties.get(i).getName());        
        }
        for(int i=0;i<courses.size();i++){
            modelCourseList.addElement(courses.get(i).getName()+ " "+courses.get(i).getType());
        }
    }
    private void showTeacher(){
        int index=jComboBox6.getSelectedIndex();
        if(index!=-1){
        Teacher teacher=null;
        int idToCheck=0;
        if(resultIds.isEmpty()){
            idToCheck=teachers.get(index).getId();
        }else{
            idToCheck=resultIds.get(index);
        }
        ArrayList<Course> subjects=null;
        ArrayList<SchoolClass> classes=null;
        for(int i=0;i<teachers.size();i++){
            if(idToCheck==teachers.get(i).getId()){
                try {
                    teacher=teachers.get(i);
                    subjects=QuerySelect.selectCoursesFromTeacher(controller, teacher.getId());
                    classes=QuerySelect.selectSchoolclassesByTeacher(controller, teacher.getId());
                    DefaultListModel<String> model = new DefaultListModel<>();
                    
                    jList6.setModel(model);
                    for(int x=0;x<subjects.size();x++){
                       model.addElement(subjects.get(x).getName() + " " + subjects.get(x).getType());
                    }
                    try {
                        AdditionalInfo info=QuerySelect.getInfo(controller, teacher.getId());
                        info.setLinks(QuerySelect.getLinks(controller,info.getIdTeacher()));
                        model = new DefaultListModel<>();
                        jList3.setModel(model);
                        for(int x=0;x<classes.size();x++){
                            model.addElement(classes.get(x).getName());
                        }
                        model = new DefaultListModel<>();
                        jList5.setModel(model);
                        
                        for(int x=0;x<info.getLinks().size();x++){
                            model.addElement(info.getLinks().get(i));
                        }
                        
                        if(info.getDescription()!=null){
                            jTextArea3.setText(info.getDescription());
                        }
                    } catch (SQLException | IOException ex) {
                        Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                jLabel20.setText(Integer.toString(teacher.getId()));
                jLabel21.setText(teacher.getName());
                jLabel8.setText(teacher.getSurname());
                jLabel9.setText(teacher.getDateOfBirth().toString());
             break;
            }
        }
        }else{
            if(Language==1){
                    JOptionPane.showMessageDialog(null,"errore, nesssun elemento selezionato", "Errore",JOptionPane.ERROR_MESSAGE);
            }else{
                    JOptionPane.showMessageDialog(null,"error, no item selected ", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void builTeachers(){
        jComboBox6.removeAllItems();
        for(int i=0;i<teachers.size();i++){
                    jComboBox6.addItem(teachers.get(i).getName() + " " +teachers.get(i).getSurname());
        }
    }
    private void buildRoomsAndClasses(){
        jComboBox7.removeAllItems();
        jComboBox8.removeAllItems();
     for(int i=0;i<schoolclasses.size();i++){
         jComboBox7.addItem(schoolclasses.get(i).getName());
     }
     for(int i=0;i<classrooms.size();i++){
         jComboBox8.addItem(classrooms.get(i).getName()+" "+classrooms.get(i).getType()+"(id:"+classrooms.get(i).getId()+")");
     }
    }
    private boolean resetTimetable(){
        int index=jComboBox1.getSelectedIndex();
        int id=0;
        if(resultIds.isEmpty()){
            switch(jComboBox2.getSelectedIndex()){
                case 0:id=teachers.get(index).getId();
                break;
                case 1:id=schoolclasses.get(index).getId();
                break;
                case 2:id=classrooms.get(index).getId();
                break;
            }
        }else{
            id=resultIds.get(index);
        }
        if(Language==1){
            int reply = JOptionPane.showConfirmDialog(null, "sei sicuro di voler eliminare tutta la tabella?", "ATTENZIONE", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                deleteTimetable(jComboBox2.getSelectedIndex(), id);
                return true;
            }else{
                return false;
            }
        }else{
            int reply = JOptionPane.showConfirmDialog(null, "sei sicuro di voler eliminare tutta la tabella?", "ATTENZIONE", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                deleteTimetable(jComboBox2.getSelectedIndex(), id);
                return true;
            }else{
                return false;
            }
        }   
    }
    private void deleteTimetable(int type,int id){
         try {
            switch(type){
                case 0:  QueryDelete.deleteTimetableByTeacher(controller,id);
                break;
                case 1:  QueryDelete.deleteTimetableByClass(controller,id);;
                break;
                case 2:  QueryDelete.deleteTimetableByRoom(controller,id);;
                break;    
            }
         } catch (SQLException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
         }
         update();
    }
    /**
    * The function translate, translates the text of the labels and buttons from english to italian.
    */
    private void translate(){
        jButton1.setText("CERCA");
        jButton2.setText("ORARI");
        jButton4.setText("aulee/classi");
        jButton3.setText("INSEGNANTI");
        jButton6.setText("facoltà e corsi");
        jComboBox2.removeAllItems();
        jComboBox2.addItem("Insegnante");
        jComboBox2.addItem("Classe");
        jComboBox2.addItem("Aula");
        jLabel2.setText("CORSI");
        jLabel11.setText("FACOLTA'");
        jButton10.setText("AGGIUNGI");
        jButton11.setText("MODIFICA");
        jButton8.setText("CREA");
        jButton9.setText("MODIFICA");
        jLabel34.setText("CLASSI");
        jLabel35.setText("AULE");
        jLabel25.setText("NOME");
        jLabel24.setText("FACOLTA'");
        jLabel26.setText("AULA PRINCIPALE");
        jLabel27.setText("NUMERO DI STUDENTI");
        jLabel28.setText("ANNO E SEZIONE");
        jLabel39.setText("NOME");
        jLabel40.setText("MASSIMA CAPACITA'");
        jLabel41.setText("TIPO");
        jButton14.setText("MODIFICA");
        jButton22.setText("AGGIUNGI UNA NUOVA CLASSE");
        jButton15.setText("MODIFICA");
        jButton23.setText("AGGIUNGI UNA NUOVA AULA");
        jLabel14.setText("NOME");
        jLabel15.setText("COGNOME");
        jLabel16.setText("DATA DI NASCITA");
        jLabel19.setText("CORSI");
        jLabel10.setText("CLASSI");
        jLabel18.setText("LINK UTILI");
        jButton21.setText("AGGIUNGI PROFESSORE");
        jButton12.setText("MODIFICA PROFESSORI");
        jButton13.setText("INSERISCI ORA");
    }
    void update(){
        try {
            teachers=QuerySelect.selectTeachers(controller);
            classrooms=QuerySelect.selectClassrooms(controller);
            schoolclasses=QuerySelect.selectSchoolclasses(controller);
            courses=QuerySelect.selectCourses(controller);
            faculties=QuerySelect.selectFaculties(controller);
            for(int i=0;i<faculties.size();i++){
                faculties.get(i).setCourses(QuerySelect.selectCoursesFromFaculty(controller, faculties.get(i).getId()));
            }
            for(int i=0;i<teachers.size();i++){
                    teachers.get(i).setSubjects(QuerySelect.selectCoursesIdsFromTeacher(controller,teachers.get(i).getId()));
                    teachers.get(i).setClasses(QuerySelect.selectSchoolclassesIdsByTeacher(controller,teachers.get(i).getId()));
            }
            buildCombobox();
            buildList();
            builTeachers();
            buildRoomsAndClasses();
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList5;
    private javax.swing.JList<String> jList6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
