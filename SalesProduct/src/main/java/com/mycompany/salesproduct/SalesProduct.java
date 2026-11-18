/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.salesproduct;

/**
 *
 * @author Student
 */
import java.util.Scanner;
public class SalesProduct {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Product names
        String[] productName={"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        
        // Sales Data
        int [][] sale = new int[3][3];
        
        
        //Input form user
        for(int i =0; i < productName.length; i++){
            for(int m = 0; m < 3; m++){
                System.out.print("Enter number of sales for month" + (m+1) + "For" + productName[i] + "mattress: ");
                sale[i][m] = input.nextInt();
            }
            System.out.println();
        }
        // Create Product object
        Product product = new Product(productName,sale);

        // Create PrintProduct object and print the report
        PrintProduct printer = new PrintProduct(product);
        printer.printFullReport();

        input.close();
    }
}
