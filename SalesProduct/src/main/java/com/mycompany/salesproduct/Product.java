/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salesproduct;

/**
 *
 * @author Student
 */
public class Product implements IProduct {
    private String[] productName;
    private int[][] sale;
    
    
    //Constuctors
    public Product(String[] productName, int[][] sale) {
        this.productName = productName;
        this.sale = sale;
    }

    // Calculate total products sold
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < sale.length; i++) {
            for (int j = 0; j < sale[i].length; j++) {
                total = total + sale[i][j];
            }
        }
        return total;
    }

    // Calculate average products sold per product
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        return (double) total / productName.length;
    }

    // Find the most popular product
    public String GetMostPopularProduct() {
        int highestTotal = 0;
        String mostPopular = "";

        for (int i = 0; i < productName.length; i++) {
            int productTotal = 0;

            for (int j = 0; j < sale[i].length; j++) {
                productTotal = productTotal + sale[i][j];
            }

            if (productTotal > highestTotal) {
                highestTotal = productTotal;
                mostPopular = productName[i] + "(" + productTotal + ")";
            }
        }
        return mostPopular;
    }
}
