/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Keresnt
 */

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class StudentInfo extends javax.swing.JFrame {

    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    /**
     * Creates new form Update
     */
    public StudentInfo() {
        initComponents();
        
        setLocationRelativeTo(null);
        establishConnection(); //Connect to database
        LoadStudentData();
        addActionListener();
    }
    
    private void addActionListener(){
        EXITBTN.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){
        EXITBTNActionPerformed(evt);
    }
        });
    }
   
//Establish connection to database
    private void establishConnection(){
        try{
            //Database connection (replace with your actual credentials)
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance", "root", "nemuimors");
           if (conn != null){
            stmt = conn.createStatement();
        }else{
                JOptionPane.showMessageDialog(null, "Error updating data: ", "", JOptionPane.ERROR_MESSAGE);
                }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Database connection error: " + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void LoadStudentData(){
        try{
            //Load data into table
            DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
            DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
            model1.setRowCount(0); //clear existing rows
            model2.setRowCount(0);
            
            String query = "SELECT * FROM students";
            
            rs = stmt.executeQuery(query);
            while (rs.next()){
                //Table 1: ID, First Name, Last Name, Date of Birth
                model1.addRow(new Object[]{
                
                    rs.getString("student_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("date_of_birth")
                });
                
                //Table 2
                model2.addRow(new Object[]{
                    
                    rs.getString("address"),
                    rs.getString("email"),
                    rs.getString("guardian_name"),
                    rs.getString("phone_number")
                });
            }
        }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        FNametxt = new javax.swing.JTextField();
        FrstNameLbL = new javax.swing.JLabel();
        LastNametxt = new javax.swing.JTextField();
        FrstNameLbL1 = new javax.swing.JLabel();
        BdayLbL = new javax.swing.JLabel();
        IDtxtField = new javax.swing.JTextField();
        IDlbL = new javax.swing.JLabel();
        GuardiantxtField = new javax.swing.JTextField();
        AddLbL = new javax.swing.JLabel();
        AddtxtField = new javax.swing.JTextField();
        EmailLbL = new javax.swing.JLabel();
        EmailtxtField = new javax.swing.JTextField();
        GuardianLbL = new javax.swing.JLabel();
        GuardianLbL1 = new javax.swing.JLabel();
        DoBtxtField = new javax.swing.JTextField();
        ConNotxtField = new javax.swing.JTextField();
        UpdateBTN = new javax.swing.JButton();
        SaveBTN = new javax.swing.JButton();
        EXITBTN = new javax.swing.JButton();
        DeleteBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "First Name", "Last Name", "Date of  Birth"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Address", "Email", "Guardian", "Contact Number"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        FNametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FNametxtActionPerformed(evt);
            }
        });

        FrstNameLbL.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        FrstNameLbL.setForeground(new java.awt.Color(255, 255, 255));
        FrstNameLbL.setText("First Name:");

        LastNametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNametxtActionPerformed(evt);
            }
        });

        FrstNameLbL1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        FrstNameLbL1.setForeground(new java.awt.Color(255, 255, 255));
        FrstNameLbL1.setText("First name:");

        BdayLbL.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        BdayLbL.setForeground(new java.awt.Color(255, 255, 255));
        BdayLbL.setText("Date Of Birth:");

        IDtxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDtxtFieldActionPerformed(evt);
            }
        });

        IDlbL.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        IDlbL.setForeground(new java.awt.Color(255, 255, 255));
        IDlbL.setText("ID:");

        AddLbL.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        AddLbL.setForeground(new java.awt.Color(255, 255, 255));
        AddLbL.setText("Address:");

        EmailLbL.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        EmailLbL.setForeground(new java.awt.Color(255, 255, 255));
        EmailLbL.setText("Email:");

        EmailtxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailtxtFieldActionPerformed(evt);
            }
        });

        GuardianLbL.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        GuardianLbL.setForeground(new java.awt.Color(255, 255, 255));
        GuardianLbL.setText("Guardian:");

        GuardianLbL1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        GuardianLbL1.setForeground(new java.awt.Color(255, 255, 255));
        GuardianLbL1.setText("Contact No.:");

        DoBtxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoBtxtFieldActionPerformed(evt);
            }
        });

        UpdateBTN.setBackground(new java.awt.Color(204, 204, 204));
        UpdateBTN.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        UpdateBTN.setForeground(new java.awt.Color(0, 51, 255));
        UpdateBTN.setText("Update");
        UpdateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBTNActionPerformed(evt);
            }
        });

        SaveBTN.setBackground(new java.awt.Color(204, 204, 204));
        SaveBTN.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        SaveBTN.setForeground(new java.awt.Color(51, 51, 255));
        SaveBTN.setText("Save");
        SaveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBTNActionPerformed(evt);
            }
        });

        EXITBTN.setBackground(new java.awt.Color(204, 204, 204));
        EXITBTN.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        EXITBTN.setForeground(new java.awt.Color(51, 51, 255));
        EXITBTN.setText("Exit");
        EXITBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXITBTNActionPerformed(evt);
            }
        });

        DeleteBTN.setBackground(new java.awt.Color(204, 204, 204));
        DeleteBTN.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        DeleteBTN.setForeground(new java.awt.Color(0, 51, 255));
        DeleteBTN.setText("Delete");
        DeleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(FrstNameLbL, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BdayLbL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(FrstNameLbL1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(IDlbL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LastNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DoBtxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IDtxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(DeleteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(UpdateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GuardianLbL1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailLbL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GuardianLbL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddLbL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GuardiantxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ConNotxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailtxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddtxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(SaveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(EXITBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FrstNameLbL)
                            .addComponent(AddtxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddLbL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LastNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FrstNameLbL1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmailtxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailLbL))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IDtxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GuardiantxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDlbL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DoBtxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BdayLbL)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GuardianLbL)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ConNotxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GuardianLbL1))))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EXITBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LastNametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNametxtActionPerformed

    private void EmailtxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailtxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailtxtFieldActionPerformed

    private void DoBtxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoBtxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DoBtxtFieldActionPerformed

    private void FNametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FNametxtActionPerformed

    private void IDtxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDtxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDtxtFieldActionPerformed
 //Fetch data from text fields and update the database
    private void UpdateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBTNActionPerformed
        if(conn != null){
        try{
           String query = "UPDATE students SET first_name=?, last_name=?, date_of_birth=?, address=?, email=?, guardian_name=?, phone_number=? WHERE student_id=?";
           pstmt = conn.prepareStatement(query);
     
           pstmt.setString(1, FNametxt.getText());
           pstmt.setString(2, LastNametxt.getText());
           pstmt.setString(3, DoBtxtField.getText());
           pstmt.setString(4, AddtxtField.getText());
           pstmt.setString(5, EmailtxtField.getText());
           pstmt.setString(6, GuardiantxtField.getText());
           pstmt.setString(7, ConNotxtField.getText());
           pstmt.setString(8, IDtxtField.getText());
           int rowsAffected = pstmt.executeUpdate();
           if (rowsAffected > 0){
               JOptionPane.showMessageDialog(null, "Student info updated successfully.");
               LoadStudentData();
           }
        }catch (Exception e){
             JOptionPane.showMessageDialog(null, "Error updating data: " + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
        }else{
                JOptionPane.showMessageDialog(null, "Error updating data: ", "", JOptionPane.ERROR_MESSAGE);
                }
    }//GEN-LAST:event_UpdateBTNActionPerformed
//Close current window and return to main window
    private void EXITBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXITBTNActionPerformed
        new SAS().setVisible(true);
        this.dispose(); //Close current window
    }//GEN-LAST:event_EXITBTNActionPerformed
//insert new student data to database
    private void SaveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBTNActionPerformed
        try{
            String query = "INSERT INTO students (first_name, last_name, date_of_birth, address, email, guardian_name, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
              pstmt = conn.prepareStatement(query);
                pstmt.setString(1, FNametxt.getText());
           pstmt.setString(2, LastNametxt.getText());
           pstmt.setString(3, DoBtxtField.getText());
           pstmt.setString(4, AddtxtField.getText());
           pstmt.setString(5, EmailtxtField.getText());
           pstmt.setString(6, GuardiantxtField.getText());
           pstmt.setString(7, ConNotxtField.getText());
           
           
           int rowsInserted = pstmt.executeUpdate();
           if (rowsInserted > 0){
               JOptionPane.showMessageDialog(null, "Student info saved successfully.");
               LoadStudentData();
           }
        }catch (Exception e){
             JOptionPane.showMessageDialog(null, "Error saving data: " + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_SaveBTNActionPerformed

    private void DeleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBTNActionPerformed
       if (conn != null) {
        try {
            // Get the student ID from the text field
            String studentId = IDtxtField.getText();
            
            // Confirm deletion
            int confirm = JOptionPane.showConfirmDialog(null, 
                "Are you sure you want to delete the student with ID " + studentId + "?", 
                "Confirm Deletion", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                // Prepare the DELETE SQL statement
                String query = "DELETE FROM students WHERE student_id = ?";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, studentId);
                
                // Execute the delete operation
                int rowsAffected = pstmt.executeUpdate();
                
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Student deleted successfully.");
                    LoadStudentData(); // Refresh the table data
                } else {
                    JOptionPane.showMessageDialog(null, "No student found with ID " + studentId, 
                        "Deletion Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error deleting data: " + e.getMessage(), 
                "", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Error deleting data: No database connection.", 
            "", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_DeleteBTNActionPerformed

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
            java.util.logging.Logger.getLogger(StudentInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddLbL;
    private javax.swing.JTextField AddtxtField;
    private javax.swing.JLabel BdayLbL;
    private javax.swing.JTextField ConNotxtField;
    private javax.swing.JButton DeleteBTN;
    private javax.swing.JTextField DoBtxtField;
    private javax.swing.JButton EXITBTN;
    private javax.swing.JLabel EmailLbL;
    private javax.swing.JTextField EmailtxtField;
    private javax.swing.JTextField FNametxt;
    private javax.swing.JLabel FrstNameLbL;
    private javax.swing.JLabel FrstNameLbL1;
    private javax.swing.JLabel GuardianLbL;
    private javax.swing.JLabel GuardianLbL1;
    private javax.swing.JTextField GuardiantxtField;
    private javax.swing.JLabel IDlbL;
    private javax.swing.JTextField IDtxtField;
    private javax.swing.JTextField LastNametxt;
    private javax.swing.JButton SaveBTN;
    private javax.swing.JButton UpdateBTN;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
