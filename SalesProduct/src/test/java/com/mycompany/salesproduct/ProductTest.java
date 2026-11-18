/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.salesproduct;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class ProductTest {
    
    public ProductTest() {
    }

    @org.junit.jupiter.api.Test
    public void testSomeMethod() {
    }
    
     // Sample data for testing
    String[] names = {
        "Cozy Nights Monarch",
        "Restonic Barbados",
        "Sealy Phuket"
    };

    int[][] sales = {
        {25, 18, 20},   // Cozy Nights Monarch
        {15, 10, 12},   // Restonic Barbados
        {18, 15, 20}    // Sealy Phuket
    };

    // Unit Test 1
    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(names, sales);
        int result = product.GetTotalProductsSold();
        assertEquals(153, result);
    }

    // Unit Test 2
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(names, sales);
        double result = product.GetAverageProductSold();
        assertEquals(51.0, result, 0.01);   // 153 / 3 = 51
    }
}

