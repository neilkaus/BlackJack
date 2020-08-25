/**
* GUI based Manager for an ArrayList of employees
*
* date     20200814
* @author neil
* @version 1.0
* @see    Assignment 2.6
*/

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class JPanelTest {

    private ImageIcon[] cardlist = new ImageIcon[52];
    
    class Employee {
        public String FirstName, LastName, StartDate;
        public int IdNum;
        public double AnnualSalary;

        public Employee(int _IdNum, String _FirstName, String _LastName, double _AnnualSalary, String _StartDate) {
            IdNum = _IdNum;
            FirstName = _FirstName;
            LastName = _LastName;
            AnnualSalary = _AnnualSalary;
            StartDate = _StartDate;
        }
    }

    //declare the ArrayList that the program manages 
    private ArrayList<Employee> arrayEmployees = new ArrayList<Employee>();
    
    //declare GUI variables
    private JLabel lblTitle, lblFirstName, lblLastName, lblAnnualSalary, lblStartDate, lblIdNum, lblRemove1, lblRemove2;
    private JTextField txtFirstName, txtLastName, txtAnnualSalary, txtStartDate, txtIdNum, txtWeek4;
    private JButton btnAdd, btnRemove, btnList;
    private JTextArea areaOutput;
    private JScrollPane scrollOutput;
    private JPanel pnlCards;
    ImageIcon b = new ImageIcon("O.jpg");
 
    /**
     * Add the GUI components to the pane src:https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/GridBagLayoutDemoProject/src/layout/GridBagLayoutDemo.java
     * @param pane 
     */
    public void addComponentsToPane(Container pane) { 
        //set pane layout to GridBag
        pane.setLayout(new GridBagLayout());

        lblRemove1 = new JLabel("Enter an ID# and press Remove to");
        GridBagConstraints lblRemove1Constraints = new GridBagConstraints();
        lblRemove1Constraints.fill = GridBagConstraints.HORIZONTAL;
        lblRemove1Constraints.gridx = 2;
        lblRemove1Constraints.gridy = 1;
        pane.add(lblRemove1, lblRemove1Constraints);
        
        lblRemove2 = new JLabel("delete an Employee's Records.");
        GridBagConstraints lblRemove2Constraints = new GridBagConstraints();
        lblRemove2Constraints.fill = GridBagConstraints.HORIZONTAL;
        lblRemove2Constraints.gridx = 2;
        lblRemove2Constraints.gridy = 2;
        pane.add(lblRemove2, lblRemove2Constraints);
        
        //Make title label and set font size to 24
        lblTitle = new JLabel("Employee Records");
        lblTitle.setFont(new Font("Tahoma", 0, 24));
        //set to fill horizontal space and take top center position
        GridBagConstraints lblTitleConstraints = new GridBagConstraints();
        lblTitleConstraints.fill = GridBagConstraints.HORIZONTAL;
        lblTitleConstraints.gridx = 1;
        lblTitleConstraints.gridy = 0;
        pane.add(lblTitle, lblTitleConstraints);
        
        //Create FirstName label
        lblFirstName = new JLabel("First Name:");
        //set to fill horizontal space and position to second row first column 
        GridBagConstraints lblFirstNameConstraints = new GridBagConstraints();
        lblFirstNameConstraints.insets = new Insets(0,0,0,20);
        lblFirstNameConstraints.fill = GridBagConstraints.HORIZONTAL;
        lblFirstNameConstraints.gridx = 0;
        lblFirstNameConstraints.gridy = 2;
        pane.add(lblFirstName, lblFirstNameConstraints);
        
        //Create FirstName textfield
        txtFirstName = new JTextField();
        GridBagConstraints txtFirstNameConstraints = new GridBagConstraints();
        txtFirstNameConstraints.insets = new Insets(0,10,0,0);
        txtFirstNameConstraints.gridx = 1;
        txtFirstNameConstraints.gridy = 2;
        txtFirstNameConstraints.fill = GridBagConstraints.HORIZONTAL;
        pane.add(txtFirstName, txtFirstNameConstraints);
         
        //Create LastName label
        lblLastName = new JLabel("Last Name:");
        //set to fill horizontal space and position to second row first column 
        GridBagConstraints lblLastNameConstraints = new GridBagConstraints();
        lblLastNameConstraints.insets = new Insets(0,0,0,20);
        lblLastNameConstraints.fill = GridBagConstraints.HORIZONTAL;
        lblLastNameConstraints.gridx = 0;
        lblLastNameConstraints.gridy = 3;
        pane.add(lblLastName, lblLastNameConstraints);
        
        //Create LastName textfield
        txtLastName = new JTextField();
        GridBagConstraints txtLastNameConstraints = new GridBagConstraints();
        txtLastNameConstraints.insets = new Insets(0,10,0,0);
        txtLastNameConstraints.gridx = 1;
        txtLastNameConstraints.gridy = 3;
        txtLastNameConstraints.fill = GridBagConstraints.HORIZONTAL;
        pane.add(txtLastName, txtLastNameConstraints);
         
        //Create IdNum label
        lblIdNum = new JLabel("ID #");
        //set to fill horizontal space and position to second row first column 
        GridBagConstraints lblIdNumConstraints = new GridBagConstraints();
        lblIdNumConstraints.insets = new Insets(0,0,0,20);
        lblIdNumConstraints.fill = GridBagConstraints.HORIZONTAL;
        lblIdNumConstraints.gridx = 0;
        lblIdNumConstraints.gridy = 1;
        pane.add(lblIdNum, lblIdNumConstraints);
        
        //Create IdNum textfield
        txtIdNum = new JTextField();
        GridBagConstraints txtIdNumConstraints = new GridBagConstraints();
        txtIdNumConstraints.insets = new Insets(0,10,0,0);
        txtIdNumConstraints.gridx = 1;
        txtIdNumConstraints.gridy = 1;
        txtIdNumConstraints.fill = GridBagConstraints.HORIZONTAL;
        pane.add(txtIdNum, txtIdNumConstraints);
         
        //Create AnnualSalary label
        lblAnnualSalary = new JLabel("Annual Salary:");
        //set to fill horizontal space and position to second row first column 
        GridBagConstraints lblAnnualSalaryConstraints = new GridBagConstraints();
        lblAnnualSalaryConstraints.insets = new Insets(0,0,0,20);
        lblAnnualSalaryConstraints.fill = GridBagConstraints.HORIZONTAL;
        lblAnnualSalaryConstraints.gridx = 0;
        lblAnnualSalaryConstraints.gridy = 4;
        pane.add(lblAnnualSalary, lblAnnualSalaryConstraints);
        
        //Create AnnualSalary textfield
        txtAnnualSalary = new JTextField();
        GridBagConstraints txtAnnualSalaryConstraints = new GridBagConstraints();
        txtAnnualSalaryConstraints.insets = new Insets(0,10,0,0);
        txtAnnualSalaryConstraints.gridx = 1;
        txtAnnualSalaryConstraints.gridy = 4;
        txtAnnualSalaryConstraints.fill = GridBagConstraints.HORIZONTAL;
        pane.add(txtAnnualSalary, txtAnnualSalaryConstraints);
           
        //Create StartDate label
        lblStartDate = new JLabel("Start Date:");
        //set to fill horizontal space and position to second row first column 
        GridBagConstraints lblStartDateConstraints = new GridBagConstraints();
        lblStartDateConstraints.insets = new Insets(0,0,0,20);
        lblStartDateConstraints.fill = GridBagConstraints.HORIZONTAL;
        lblStartDateConstraints.gridx = 0;
        lblStartDateConstraints.gridy = 5;
        pane.add(lblStartDate, lblStartDateConstraints);
        
        //Create StartDate textfield
        txtStartDate = new JTextField();
        GridBagConstraints txtStartDateConstraints = new GridBagConstraints();
        txtStartDateConstraints.insets = new Insets(0,10,0,0);
        txtStartDateConstraints.gridx = 1;
        txtStartDateConstraints.gridy = 5;
        txtStartDateConstraints.fill = GridBagConstraints.HORIZONTAL;
        pane.add(txtStartDate, txtStartDateConstraints);
               
        //Create Add button
        btnAdd = new JButton("Add");
        //add action listener to Add button
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        //set position and fill
        GridBagConstraints btnAddConstraints = new GridBagConstraints();
        btnAddConstraints.fill = GridBagConstraints.HORIZONTAL;
        btnAddConstraints.gridx = 2;
        btnAddConstraints.gridy = 3;
        btnAddConstraints.insets = new Insets(1,10,1,10);
        pane.add(btnAdd, btnAddConstraints);

        //create output text area
        areaOutput = new JTextArea();
        areaOutput.setEditable(false);
        scrollOutput = new JScrollPane(areaOutput);
        // set contraints to give position and fill
        GridBagConstraints scrollOutputConstraints = new GridBagConstraints();
        scrollOutputConstraints.fill = GridBagConstraints.HORIZONTAL;
        scrollOutputConstraints.ipady = 150;      
        scrollOutputConstraints.ipadx = 70;
        scrollOutputConstraints.gridwidth = 3;
        scrollOutputConstraints.gridx = 0;
        scrollOutputConstraints.gridy = 6;
        scrollOutputConstraints.insets = new Insets(5,10,10,10);
        //pane.add(scrollOutput, scrollOutputConstraints);
        
        //Create List button
        btnList = new JButton("List");
        //add action listener to List button
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });
        //set position and fill
        GridBagConstraints btnListConstraints = new GridBagConstraints();
        btnListConstraints.fill = GridBagConstraints.HORIZONTAL;
        btnListConstraints.gridx = 2;
        btnListConstraints.gridy = 5;
        btnListConstraints.insets = new Insets(1,10,1,10);
        pane.add(btnList, btnListConstraints);

        //Create Remove button
        btnRemove = new JButton("Remove");
        //add action listener to Remove button
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        //set position and fill
        GridBagConstraints btnRemoveConstraints = new GridBagConstraints();
        btnRemoveConstraints.fill = GridBagConstraints.HORIZONTAL;
        btnRemoveConstraints.gridx = 2;
        btnRemoveConstraints.gridy = 4;
        btnRemoveConstraints.insets = new Insets(1,10,1,10);
        pane.add(btnRemove, btnRemoveConstraints);

        pnlCards = new JPanel();
        pnlCards.setSize(400,100);
        pnlCards.setLayout(new FlowLayout());
        GridBagConstraints pnlCardsConstraints = new GridBagConstraints();
        pnlCardsConstraints.insets = new Insets(5,10,5,10);
        pnlCardsConstraints.gridwidth = 3;
        pnlCardsConstraints.gridx = 0;
        pnlCardsConstraints.ipadx = 400;
        pnlCardsConstraints.ipady = 100;
        pnlCardsConstraints.gridy = 6;
        pnlCardsConstraints.fill = GridBagConstraints.HORIZONTAL;
        pane.add(pnlCards, pnlCardsConstraints);

    }
 
    /**
     * Create the GUI and show it. 
     */
    public void createAndShowGUI() {
        //Create and set up the window.
        cardlist[0] = new ImageIcon("O.jpg");
        JFrame frame = new JFrame("Employee Records");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        addComponentsToPane(frame.getContentPane());
 
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * method to handle when Add button is pressed and give user output
     * @param evt 
     */
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt){
        try {
            int intIdNum = Integer.parseInt(txtIdNum.getText());
            String strFirstName = txtFirstName.getText();
            String strLastName = txtLastName.getText();
            double dblAnnualSalary = Double.parseDouble(txtAnnualSalary.getText());
            String strStartDate =txtStartDate.getText();

            if( dblAnnualSalary < 0 || intIdNum < 0  ) {

            } else {
                Employee employeeToAdd = new Employee(intIdNum, strFirstName, strLastName, dblAnnualSalary, strStartDate);

                //loop so we update an employee already in the system
                boolean found = false;
                for(Employee employeeToCheck:arrayEmployees) {
                    if( employeeToAdd.IdNum == employeeToCheck.IdNum ) {
                        arrayEmployees.set(arrayEmployees.indexOf(employeeToCheck), employeeToAdd);
                        found = true;
                        break;
                    }                    
                }

                if(found) {
                } else {
                    arrayEmployees.add(employeeToAdd);
                }
            }
        } catch(Exception e) {
        }
        areaOutput.setText("");
    }
 
    /**
     * method to handle when List button is pressed and give user output
     * @param evt 
     */
    private void btnListActionPerformed(java.awt.event.ActionEvent evt){
        JLabel test = new JLabel("");
        test.setIcon(cardlist[0]);
        pnlCards.add(test);
        pnlCards.validate();
        pnlCards.repaint();
    }
 
    /**
     * method to handle when Remove button is pressed and give user output
     * @param evt 
     */
    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt){
        pnlCards.removeAll();
        pnlCards.validate();
        pnlCards.repaint();
    }


}
