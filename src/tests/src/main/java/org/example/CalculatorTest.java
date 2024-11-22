package org.example;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    @DisplayName("computeMean receives Null Value List - Throw Exception")
    void Calculator_computeMean_ReceiveNullValueList_ThrowException() {
        // Arrange
        String expectedMessage = "values parameter cannot be null or empty";
        String values = null;
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeMean(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();
        // Assert

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    @DisplayName("computeMean receives Empty Value List - Throw Exception")
    void Calculator_computeMean_ReceiveEmptyValueList_ThrowException() {
        // Arrange
        String expectedMessage = "values parameter cannot be null or empty";
        String values = "";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeMean(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    @DisplayName("computeMean receives non-numeric value - Throw Exception")
    void Calculator_computeMean_ReceiveNonNumericValue_ThrowException() {
        // Arrange
        String expectedMessage = "invalid numeric value";
        String values = "1\n123,123\n3";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeMean(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();
        // Assert

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("computeMean receives valid values - return mean")
    void Calculator_computeMean_ReceiveValidValues_ThrowException() {
        // Arrange
        String values = "9\n" +
                "6\n" +
                "8\n" +
                "5\n" +
                "7\n";
        double expectedResult = 7;

        // Act
        double result = Calculator.computeMean(values);

        // Assert
        assertEquals(expectedResult, result, 0.00000001);
    }
    @Test
    @DisplayName("computeMeanHelper receives Null Value List - Throw Exception")
    void Calculator_computeMeanHelper_ReceiveNullValueList_ThrowException() {
        // Arrange
        String expectedMessage = "values parameter cannot be null or empty";
        double[] values = null;
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeMeanHelper(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();
        // Assert

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    @DisplayName("computeMeanHelper receives Empty Value List - Throw Exception")
    void Calculator_computeMeanHelper_ReceiveEmptyValueList_ThrowException() {
        // Arrange
        String expectedMessage = "values parameter cannot be null or empty";
        double[] values = {};
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeMeanHelper(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("computeSquareOfDifferences receives Null Value List - Throw Exception")
    void Calculator_computeSquareOfDifferences_ReceiveNullValueList_ThrowException() {
        // Arrange
        double[] values = null;
        String expectedMessage = "values parameter cannot be null or empty";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeSquareOfDifferences(values, 0);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    @DisplayName("ComputeSquareOfDifferences receives Empty Value List - Throw Exception")
    void Calculator_computeSquareOfDifferences_ReceiveEmptyValueList_ThrowException() {
        // Arrange
        double[] values = {};
        String expectedMessage = "values parameter cannot be null or empty";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeSquareOfDifferences(values, 0);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("computeVariance receives NumValues = 1, isPopulation = false - Throw Exception")
    void Calculator_computeVariance_ReceiveNumValuesOneIsPopulationFalse_ThrowException() {
        // Arrange
        double squareOfDifferences = 0;
        int numValues = 1;
        boolean isPopulation = false;

        String expectedMessage = "insufficient number of values provided";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeVariance(squareOfDifferences, numValues, isPopulation);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("computeStandardDeviation receives Null Value List - Throw Exception")
    void Calculator_computeStandardDeviation_ReceiveNullValueList_ThrowException() {
        // Arrange
        double[] values = null;
        String expectedMessage = "values parameter cannot be null or empty";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeStandardDeviation(values, false);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("computeStandardDeviation receives Empty Value List - Throw Exception")
    void Calculator_computeStandardDeviation_ReceiveEmptyValueList_ThrowException() {
        // Arrange
        double[] values = {};
        String expectedMessage = "values parameter cannot be null or empty";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeStandardDeviation(values, false);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    @DisplayName("computeSampleStandardDeviation receives one value - Throw Exception")
    void Calculator_computeSampleStandardDeviation_ReceiveOneValue_ThrowException() {
        // Arrange
        String values = "9";
        String expectedMessage = "insufficient numeric values provided";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeSampleStandardDeviation(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    @DisplayName("computeSampleStandardDeviation receives valid values - returns std dev")
    void Calculator_computeSampleStandardDeviation_ReceiveValidValues_ThrowException() {
        // Arrange
        String values = "9\n6\n8\n5\n7";
        double expectedResult = 1.5811388300841898;

        // Act
        double result = Calculator.computeSampleStandardDeviation(values);

        // Assert
        assertEquals(expectedResult, result, 0.00000001);
    }


    @Test
    @DisplayName("computePopulationStandardDeviation receives one value - std dev should be 0")
    void Calculator_computePopulationStandardDeviation_ReceiveOneValue_ThrowException() {
        // Arrange
        String values = "9";
        // Act
        double result = Calculator.computePopulationStandardDeviation(values);

        // Assert
        assertEquals(0.0, result);
    }

    @Test
    @DisplayName("computePopulationStandardDeviation receives valid values - returns std dev")
    void Calculator_computePopulationStandardDeviation_ReceiveValidValues_ThrowException() {
        // Arrange
        String values = "9\n" +
                "6\n" +
                "\n" +
                "8\n" +
                "5\n" +
                "7";
        double expectedResult = 1.4142135623731;

        // Act
        double result = Calculator.computePopulationStandardDeviation(values);

        // Assert
        assertEquals(expectedResult, result, 0.00000001);
    }
    @Test
    @DisplayName("computeZscore receives Null Value - Throw Exception")
    void Calculator_computeZscore_ReceivesNullValue_ThrowException() {
        // Arrange
        String values = null;
        String expectedMessage = "values parameter cannot be null or empty";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeZscore(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("computeZscore receives Empty Value - Throw Exception")
    void Calculator_computeZscore_ReceivesEmptyValue_ThrowException() {
        // Arrange
        String values = "";
        String expectedMessage = "values parameter cannot be null or empty";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeZscore(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    @DisplayName("computeZscore receives one value - Throw Exception")
    void Calculator_computeZscore_ReceivesOneValue_ThrowException() {
        // Arrange
        String values = "9";
        String expectedMessage = "exactly 3 numeric values are required";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeZscore(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    @DisplayName("computeZscore receives two values - Throw Exception")
    void Calculator_computeZscore_ReceivesTwoValues_ThrowException() {
        // Arrange
        String values = "9, 8";
        String expectedMessage = "exactly 3 numeric values are required";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeZscore(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    @DisplayName("computeZscore receives four values - Throw Exception")
    void Calculator_computeZscore_ReceivesFourValues_ThrowException() {
        // Arrange
        String values = "9, 8, 7, 6";
        String expectedMessage = "exactly 3 numeric values are required";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeZscore(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    @DisplayName("computeZscore receives more than one line of values - Throw Exception")
    void Calculator_computeZscore_ReceivesMoreThanOneLineOfValues_ThrowException() {
        // Arrange
        String values = "9\n, 8, 7";
        String expectedMessage = "exactly one line of input is required";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeZscore(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    @DisplayName("computeZscore receives three values, standard deviation value is zero - Throw Exception")
    void Calculator_computeZscore_ReceivesValuesStdDevIsZero_ThrowException() {
        // Arrange
        String values = "9, 8, 0";
        String expectedMessage = "division by zero";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeZscore(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));

    }
    @Test
    @DisplayName("computeZscore receives standard deviation = zero, mean = value - Throw Exception")
    void Calculator_computeZscore_ReceivesStdDevIsZeroMeanEqualsValue_ThrowException() {
        // Arrange
        String values = "9, 9, 0";
        String expectedMessage = "division by zero";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeZscore(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));

    }
    @Test
    @DisplayName("computeZscore receives valid values - returns Z-score")
    void Calculator_computeZscore_ReceivesValidValues_ReturnsZscore() {
        // Arrange
        String values = "11.5,7,1.5811388300841898";
        double expectedResult = 2.846049894151541;
        // Act
        double result = Calculator.computeZscore(values);

        // Assert
        assertEquals(expectedResult, result, 0.00000000001);
    }

    @Test
    @DisplayName("computeLinearRegressionFormula receives valid values - returns liner regression formula in the form y = mx + b")
    void Calculator_computeLinearRegressionFormula_ReceiveValidValues_ReturnsLinearRegressionFormula() {
        // Arrange
        String values = "1.47,52.21\n" +
                "\n" +
                "1.5,53.12\n" +
                "\n" +
                "1.52,54.48\n" +
                "\n" +
                "1.55,55.84\n" +
                "\n" +
                "1.57,57.2\n" +
                "\n" +
                "1.6,58.57\n" +
                "\n" +
                "1.63,59.93\n" +
                "\n" +
                "1.65,61.29\n" +
                "\n" +
                "1.68,63.11\n" +
                "\n" +
                "1.7,64.47\n" +
                "\n" +
                "1.73,66.28\n" +
                "\n" +
                "1.75,68.1\n" +
                "\n" +
                "1.78,69.92\n" +
                "\n" +
                "1.8,72.19\n" +
                "\n" +
                "1.83,74.46,\n";
        String expectedResult = "y = 61.272186542107434x + -39.061955918838656";
        double expectedM = 61.272186542107434;
        double expectedB = -39.061955918838656;
        double tolerance = 1e-10;
        // Act
        String result = Calculator.computeLinearRegressionFormula(values);
        // Extract m and b from the result
        String[] parts = result.replace("y =", "").replace("+","").replaceAll("\\s+", "").split("x");


        double actualM = Double.parseDouble(parts[0].trim());
        double actualB = Double.parseDouble(parts[1].trim());

        // Assert
        assertEquals(expectedM, actualM, tolerance);
        assertEquals(expectedB, actualB, tolerance);
    }

    @Test
    @DisplayName("computeLinearRegressionFormula receives one pair of values - - Throw Exception")
    void Calculator_computeLinearRegressionFormula_ReceiveOnePairOfValues_ThrowException() {
        // Arrange
        String values = "1.47,52.21";
        String expectedMessage = "at least two x,y pairs are required";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeLinearRegressionFormula(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));


    }
    @Test
    @DisplayName("computeLinearRegressionFormula receives empty values - - Throw Exception")
    void Calculator_computeLinearRegressionFormula_ReceiveEmptyValues_ThrowException() {
        // Arrange
        String values = "";
        String expectedMessage = "values parameter cannot be null or empty";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeLinearRegressionFormula(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));


    }
    @Test
    @DisplayName("computeLinearRegressionFormula receives Null values - - Throw Exception")
    void Calculator_computeLinearRegressionFormula_ReceiveNullValues_ThrowException() {
        // Arrange
        String values = null;
        String expectedMessage = "values parameter cannot be null or empty";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeLinearRegressionFormula(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));


    }
    @Test
    @DisplayName("computeLinearRegressionFormula receives non-numer values - - Throw Exception")
    void Calculator_computeLinearRegressionFormula_ReceiveNonNumValues_ThrowException() {
        // Arrange
        String values = "f," +
                "f,f";
        String expectedMessage = "line should contain exactly two valid numeric values";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeLinearRegressionFormula(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));


    }
    @Test
    @DisplayName("computeLinearRegressionFormula receives the same values - - Throw Exception")
    void Calculator_computeLinearRegressionFormula_ReceiveSameValues_ThrowException() {
        // Arrange
        String values = "1.47,52.21\n" +
                "1.47,53.12\n" +
                "1.47,54.48\n";
        String expectedMessage = "division by zero";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeLinearRegressionFormula(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));


    }
    @Test
    @DisplayName("computeLinearRegressionFormula receives non-numeric value - - Throw Exception")
    void Calculator_computeLinearRegressionFormula_ReceiveNonNumericValue_ThrowException() {
        // Arrange
        String values = "1.47,52.21\n" +
                "1.47,53,12\n" +
                "1.47,54.48\n";
        String expectedMessage = "line should contain exactly two valid numeric values";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeLinearRegressionFormula(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));


    }
    @Test
    @DisplayName("computeLinearRegressionFormula receives three values in line - Throw Exception")
    void Calculator_computeLinearRegressionFormula_ReceiveThreeValuesInLine_ThrowException() {
        // Arrange
        String values = "1.47,52.21\n" +
                "1.47,a\n" +
                "1.47,54.48\n";
        String expectedMessage = "invalid numeric value in line";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computeLinearRegressionFormula(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));


    }

    @Test
    @DisplayName("computePredictedY receives non-numeric value - Throw Exception")
    void Calculator_computePredictedY_ReceiveNonNumericValue_ThrowException() {
        // Arrange
        String values = "9, a, 5";
        String expectedMessage = "invalid value in input";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computePredictedY(values);
        });

        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));


    }
    @Test
    @DisplayName("computePredictedY receives two lines of values - Throw Exception")
    void Calculator_computePredictedY_ReceiveTwoLinesOfValues_ThrowException() {
        // Arrange
        String values = "9, 4, 5\n"+
                "5, 6, 2";
        String expectedMessage = "exactly one line of input is required";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computePredictedY(values);
        });

        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));


    }
    @Test
    @DisplayName("computePredictedY receives two values - Throw Exception")
    void Calculator_computePredictedY_ReceivesTwoValues_ThrowException() {
        // Arrange
        String values = "9, 8";
        String expectedMessage = "exactly 3 numeric values are required";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computePredictedY(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));


    }
    @Test
    @DisplayName("computePredictedY receives four values - Throw Exception")
    void Calculator_computePredictedY_ReceivesFourValues_ThrowException() {
        // Arrange
        String values = "9, 8, 7, 6";
        String expectedMessage = "exactly 3 numeric values are required";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.computePredictedY(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    @DisplayName("computePredictedY receives valid values - returns predicted Y valus")
    void Calculator_computePredictedY_ReceiveValidValues_ReturnsPredictedY() {
        // Arrange
        String values = "1.535, 61.272186542107434, -39.061955918838656";
        double expectedResult = 54.990850423296244;
        // Act
        double result = Calculator.computePredictedY(values);

        // Assert
        assertEquals(expectedResult, result, 0.00000000001);


    }
}