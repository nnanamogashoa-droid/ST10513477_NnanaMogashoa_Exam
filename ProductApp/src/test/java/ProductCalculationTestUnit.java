/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */


import org.junit.Test;
import static org.junit.Assert.*;

public class ProductCalculationTestUnit {

    // Unit Test 1
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        // Arrange
        ProductCalc calc = new ProductCalc(3500);

        // Act
        double result = calc.GetVat();

        // Assert
        assertEquals(525.0, result, 0.01);
    }

    // Unit Test 2
    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        // Arrange
        ProductCalc calc = new ProductCalc(3500);

        // Act
        double result = calc.GetTotal();

        // Assert
        assertEquals(4200.0, result, 0.01);
    }
}