/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productapp;

/**
 *
 * @author Student
 */
import javax.swing.*;
import java.awt.event.*;
import java.io.*;


public class ProductApp extends JFrame implements ActionListener {
     JFrame Frame;
     JTextField txtCustomer;
     JComboBox<String> cmbProduct;
     JTextField txtPrice;
     JButton btnProcess;
          
    public ProductApp(){
        Frame = new JFrame("Product App");
        Frame.setSize(450,300);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setLayout(null);
        Frame.setLocationRelativeTo(null);
        
        
        JMenuBar menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(this);
        fileMenu.add(exitItem);
        
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        processItem.addActionListener(this);
        clearItem.addActionListener(this);
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);
        
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        Frame.setJMenuBar(menuBar);
       
        
        JLabel lblCustomer = new JLabel("Customer Name: ");
        lblCustomer.setBounds(40, 30, 120, 25);
        Frame.add(lblCustomer);
        
        txtCustomer =new JTextField();
        txtCustomer.setBounds(170, 30, 220, 25);
        Frame.add(txtCustomer);
        
        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(40, 70, 120, 25);
        Frame.add(lblProduct);

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
        cmbProduct = new JComboBox<>(products);
        cmbProduct.setBounds(170, 70, 220, 25);
        Frame.add(cmbProduct);

        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(40, 110, 120, 25);
        Frame.add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(170, 110, 220, 25);
        Frame.add(txtPrice);

        btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(140, 160, 160, 35);
        btnProcess.addActionListener(this);
        Frame.add(btnProcess);

        Frame.setVisible(true);
    }

    // ========== ACTION LISTENER ==========
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Exit menu item
        if (command.equals("Exit")) {
            System.exit(0);
        }
        // Clear menu item
        else if (command.equals("Clear")) {
            txtCustomer.setText("");
            txtPrice.setText("");
            cmbProduct.setSelectedIndex(0);
        }
        // Process button or Process menu item
        else if (command.equals("PROCESS") || command.equals("Process")) {
            processSale();
        }
    }

    // ========== PROCESS SALE LOGIC ==========
    private void processSale() {
        String customer = txtCustomer.getText();
        String product = (String) cmbProduct.getSelectedItem();
        String priceText = txtPrice.getText();

        if (customer.equals("") || priceText.equals("")) {
            JOptionPane.showMessageDialog(Frame, "Please fill in all fields");
            return;
        }

        double price = Double.parseDouble(priceText);

        // Use the ProductCalculations class (Q.2.5)
        ProductCalc calc = new ProductCalc(price);

        double vat = calc.GetVat();
        double commission = calc.GetCommission();
        double total = calc.GetTotal();

        // Show message
        String message = "Customer Name: " + customer + "\n"
                       + "Product: " + product + "\n"
                       + "VAT: R " + vat + "\n"
                       + "COMMISSION: R " + commission + "\n"
                       + "TOTAL: R " + total;

        JOptionPane.showMessageDialog(Frame, message);

        // Save to data.txt
        try {
            FileWriter writer = new FileWriter("data.txt", true);
            writer.write("DATA LOG\n");
            writer.write("********************************\n");
            writer.write("Customer Name: " + customer + "\n");
            writer.write("Product: " + product + "\n");
            writer.write("VAT: R " + vat + "\n");
            writer.write("COMMISSION: R " + commission + "\n");
            writer.write("TOTAL: R " + total + "\n");
            writer.write("********************************\n\n");
            writer.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(Frame, "Error saving to file");
        }
    }

    public static void main(String[] args) {
        new ProductApp();
    }
        
 }
 
 // by the help of grok AI tool
    