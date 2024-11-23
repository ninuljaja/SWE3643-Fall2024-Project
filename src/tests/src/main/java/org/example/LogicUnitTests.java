package org.example;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LogicUnitTests {

   // Test DescriptiveStatistics functions

    @Test
    @DisplayName("computeMean receives Null Value List - Throw Exception")
    void Calculator_computeMean_ReceiveNullValueList_ThrowException() {
        //preq-UNIT-TEST-4

        // Arrange
        String expectedMessage = "input cannot be null or empty";
        String values = null;
        // Act
        CalculationResult result= DescriptiveStatistics.computeMean(values);

        // Assert

        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));
    }
    @Test
    @DisplayName("computeMean receives Empty Value List - Throw Exception")
    void Calculator_computeMean_ReceiveEmptyValueList_ThrowException() {
        //preq-UNIT-TEST-4

        // Arrange
        String expectedMessage = "input cannot be null or empty";
        String values = "";

        // Act
        CalculationResult result= DescriptiveStatistics.computeMean(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));
    }
    @Test
    @DisplayName("computeMean receives non-numeric value - Throw Exception")
    void Calculator_computeMean_ReceiveNonNumericValue_ThrowException() {
        //preq-UNIT-TEST-4

        // Arrange
        String expectedMessage = "invalid numeric value";
        String values = "1\n123,123\n3";

        // Act
        CalculationResult result= DescriptiveStatistics.computeMean(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));
    }

    @Test
    @DisplayName("computeMean receives valid values - return mean")
    void Calculator_computeMean_ReceiveValidValues_ThrowException() {
        //preq-UNIT-TEST-4

        // Arrange
        String values = "9\n" +
                "6\n" +
                "8\n" +
                "5\n" +
                "7\n";
        double expectedResult = 7;

        // Act
        CalculationResult  result = DescriptiveStatistics.computeMean(values);

        // Assert
        assertTrue(result.getIsSuccess());
        assertEquals(expectedResult, result.getResult(), 0.00000001);
    }

    @Test
    @DisplayName("computeSampleStandardDeviation receives Null Value List - Throw Exception")
    void Calculator_computeSampleStandardDeviation_ReceiveNullValueList_ThrowException() {
        //preq-UNIT-TEST-2

        // Arrange
        String values = null;
        String expectedMessage = "input cannot be null or empty";

        // Act
        CalculationResult result= DescriptiveStatistics.computeSampleStandardDeviation(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));
    }

    @Test
    @DisplayName("computeSampleStandardDeviation receives Empty Value List - Throw Exception")
    void Calculator_computeSampleStandardDeviation_ReceiveEmptyValueList_ThrowException() {
        //preq-UNIT-TEST-2

        // Arrange
        String values = "";
        String expectedMessage = "input cannot be null or empty";
        // Act
        CalculationResult result= DescriptiveStatistics.computeSampleStandardDeviation(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));
    }

    @Test
    @DisplayName("computeSampleStandardDeviation receives one value - Throw Exception")
    void Calculator_computeSampleStandardDeviation_ReceiveOneValue_ThrowException() {
        //preq-UNIT-TEST-2

        // Arrange
        String values = "9";
        String expectedMessage = "invalid input format";
        // Act
        CalculationResult result= DescriptiveStatistics.computeSampleStandardDeviation(values);


        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));
    }

    @Test
    @DisplayName("computeSampleStandardDeviation receives valid values - returns std dev")
    void Calculator_computeSampleStandardDeviation_ReceiveValidValues_ReturnsStdDev() {
        //preq-UNIT-TEST-2

        // Arrange
        String values = "9\n6\n8\n5\n7";
        double expectedResult = 1.5811388300841898;

        // Act
        CalculationResult  result = DescriptiveStatistics.computeSampleStandardDeviation(values);

        // Assert
        assertTrue(result.getIsSuccess());
        assertEquals(expectedResult, result.getResult(), 0.00000001);
    }

    @Test
    @DisplayName("computeSampleStandardDeviation receives all zeros values - returns std dev = 0")
    void Calculator_computeSampleStandardDeviation_ReceiveAllZeros_ReturnsStdDevEquals0() {
        //preq-UNIT-TEST-2

        // Arrange
        String values = "0\n0\n0\n0\n0";
        double expectedResult = 0;

        // Act
        CalculationResult  result = DescriptiveStatistics.computeSampleStandardDeviation(values);

        // Assert
        assertTrue(result.getIsSuccess());
        assertEquals(expectedResult, result.getResult(), 0.00000001);
    }


    @Test
    @DisplayName("computePopulationStandardDeviation receives one value - std dev should be 0")
    void Calculator_computePopulationStandardDeviation_ReceiveOneValue_StdDevShouldBe0() {
        //preq-UNIT-TEST-2

        // Arrange
        String values = "9";
        double expectedResult = 0;
        // Act
        CalculationResult  result = DescriptiveStatistics.computePopulationStandardDeviation(values);
        // Assert
        assertTrue(result.getIsSuccess());
        assertEquals(expectedResult, result.getResult(), 0.00000001);
    }

    @Test
    @DisplayName("computePopulationStandardDeviation receives valid values - returns std dev")
    void Calculator_computePopulationStandardDeviation_ReceiveValidValues_ReturnStdDev() {
        ////preq-UNIT-TEST-2

        // Arrange
        String values = "9\n" +
                "6\n" +
                "\n" +
                "8\n" +
                "5\n" +
                "7";
        double expectedResult = 1.4142135623731;

        // Act
        CalculationResult  result = DescriptiveStatistics.computePopulationStandardDeviation(values);

        // Assert
        assertTrue(result.getIsSuccess());
        assertEquals(expectedResult, result.getResult(), 0.00000001);
    }

    @Test
    @DisplayName("computePopulationStandardDeviation receives Null Value List - Throw Exception")
    void Calculator_computePopulationStandardDeviation_ReceiveNullValueList_ThrowException() {
        //preq-UNIT-TEST-2

        // Arrange
        String values = null;
        String expectedMessage = "input cannot be null or empty";

        // Act
        CalculationResult result= DescriptiveStatistics.computePopulationStandardDeviation(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));
    }

    @Test
    @DisplayName("computePopulationStandardDeviation receives Empty Value List - Throw Exception")
    void Calculator_computePopulationStandardDeviation_ReceiveEmptyValueList_ThrowException() {
        //preq-UNIT-TEST-2

        // Arrange
        String values = "";
        String expectedMessage = "input cannot be null or empty";
        // Act
        CalculationResult result= DescriptiveStatistics.computePopulationStandardDeviation(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));
    }
    @Test
    @DisplayName("computePopulationStandardDeviation receives all zeros values - returns std dev = 0")
    void Calculator_computePopulationStandardDeviation_ReceiveAllZeros_ReturnsStdDevEquals0() {
        //preq-UNIT-TEST-2

        // Arrange
        String values = "0\n0\n0\n0\n0";
        double expectedResult = 0;

        // Act
        CalculationResult  result = DescriptiveStatistics.computePopulationStandardDeviation(values);

        // Assert
        assertTrue(result.getIsSuccess());
        assertEquals(expectedResult, result.getResult(), 0.00000001);
    }


    @Test
    @DisplayName("computeZscore receives Null Value - Throw Exception")
    void Calculator_computeZscore_ReceivesNullValue_ThrowException() {
        //preq-UNIT-TEST-5

        // Arrange
        String values = null;
        String expectedMessage = "input cannot be null or empty";

        // Act
        CalculationResult result= DescriptiveStatistics.computeZscore(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));
    }

    @Test
    @DisplayName("computeZscore receives Empty Value - Throw Exception")
    void Calculator_computeZscore_ReceivesEmptyValue_ThrowException() {
        //preq-UNIT-TEST-5

        // Arrange
        String values = "";
        String expectedMessage = "input cannot be null or empty";

        // Act
        CalculationResult result= DescriptiveStatistics.computeZscore(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));

    }
    @Test
    @DisplayName("computeZscore receives one value - Throw Exception")
    void Calculator_computeZscore_ReceivesOneValue_ThrowException() {
        //preq-UNIT-TEST-5

        // Arrange
        String values = "9";
        String expectedMessage = "exactly 3 numeric values are required";

        // Act
        CalculationResult result= DescriptiveStatistics.computeZscore(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));
    }
    @Test
    @DisplayName("computeZscore receives two values - Throw Exception")
    void Calculator_computeZscore_ReceivesTwoValues_ThrowException() {
        //preq-UNIT-TEST-5

        // Arrange
        String values = "9, 8";
        String expectedMessage = "exactly 3 numeric values are required";

        // Act
        CalculationResult result= DescriptiveStatistics.computeZscore(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));
    }
    @Test
    @DisplayName("computeZscore receives four values - Throw Exception")
    void Calculator_computeZscore_ReceivesFourValues_ThrowException() {
        //preq-UNIT-TEST-5

        // Arrange
        String values = "9, 8, 7, 6";
        String expectedMessage = "exactly 3 numeric values are required";

        // Act
        CalculationResult result= DescriptiveStatistics.computeZscore(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));
    }
    @Test
    @DisplayName("computeZscore receives more than one line of values - Throw Exception")
    void Calculator_computeZscore_ReceivesMoreThanOneLineOfValues_ThrowException() {
        //preq-UNIT-TEST-5

        // Arrange
        String values = "9\n, 8, 7";
        String expectedMessage = "exactly one line of input is required";

        // Act
        CalculationResult result= DescriptiveStatistics.computeZscore(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));
    }
    @Test
    @DisplayName("computeZscore receives three values, standard deviation value is zero - Throw Exception")
    void Calculator_computeZscore_ReceivesValuesStdDevIsZero_ThrowException() {
        //preq-UNIT-TEST-5

        // Arrange
        String values = "9, 8, 0";
        String expectedMessage = "division by zero";

        // Act
        CalculationResult result= DescriptiveStatistics.computeZscore(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));

    }
    @Test
    @DisplayName("computeZscore receives standard deviation = zero, mean = value - Throw Exception")
    void Calculator_computeZscore_ReceivesStdDevIsZeroMeanEqualsValue_ThrowException() {
        //preq-UNIT-TEST-5

        // Arrange
        String values = "9, 9, 0";
        String expectedMessage = "division by zero";

        // Act
        CalculationResult result= DescriptiveStatistics.computeZscore(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));

    }
    @Test
    @DisplayName("computeZscore receives mean = 0 - Returns Z-score = value/stdDev")
    void Calculator_computeZscore_ReceivesMeanIsZero_ReturnZscore () {
        //preq-UNIT-TEST-5

        // Arrange
        String values = "5, 0, 6";
        double expectedResult = 5.0/6.0;

        // Act
        CalculationResult result= DescriptiveStatistics.computeZscore(values);

        // Assert
        assertTrue(result.getIsSuccess());
        assertEquals(expectedResult, result.getResult(), 0.00000000001);

    }
    @Test
    @DisplayName("computeZscore receives valid values - returns Z-score")
    void Calculator_computeZscore_ReceivesValidValues_ReturnsZscore() {
        //preq-UNIT-TEST-5

        // Arrange
        String values = "11.5,7,1.5811388300841898";
        double expectedResult = 2.846049894151541;
        // Act
        CalculationResult result = DescriptiveStatistics.computeZscore(values);

        // Assert
        assertTrue(result.getIsSuccess());
        assertEquals(expectedResult, result.getResult(), 0.00000000001);
    }

    // Testing DescriptiveStatistic Helper methods
    @Test
    @DisplayName("computeMeanHelper receives Null Value List - Throw Exception")
    void Calculator_computeMeanHelper_ReceiveNullValueList_ThrowException() {
        // Arrange
        String expectedMessage = "input cannot be null or empty";
        double[] values = null;
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DescriptiveStatistics.computeMeanHelper(values);
        });
        String actualMessage = exception.getMessage().toLowerCase();
        // Assert

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    @DisplayName("computeMeanHelper receives Empty Value List - Throw Exception")
    void Calculator_computeMeanHelper_ReceiveEmptyValueList_ThrowException() {
        // Arrange
        String expectedMessage = "input cannot be null or empty";
        double[] values = {};
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DescriptiveStatistics.computeMeanHelper(values);
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
        String expectedMessage = "input cannot be null or empty";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DescriptiveStatistics.computeStandardDeviation(values, false);
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
        String expectedMessage = "input cannot be null or empty";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DescriptiveStatistics.computeStandardDeviation(values, false);
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
        String expectedMessage = "input cannot be null or empty";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DescriptiveStatistics.computeSquareOfDifferences(values, 0);
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
        String expectedMessage = "input cannot be null or empty";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DescriptiveStatistics.computeSquareOfDifferences(values, 0);
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

        String expectedMessage = "insufficient values provided";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DescriptiveStatistics.computeVariance(squareOfDifferences, numValues, isPopulation);
        });
        String actualMessage = exception.getMessage().toLowerCase();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Testing LinearRegression methods

    @Test
    @DisplayName("computeLinearRegressionFormula receives valid values - returns liner regression formula in the form y = mx + b")
    void Calculator_computeLinearRegressionFormula_ReceiveValidValues_ReturnsLinearRegressionFormula() {
        //preq-UNIT-TEST-6

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
        CalculationResult result = LinearRegression.computeLinearRegressionFormula(values);
        // Extract m and b from the result
        String[] parts = result.getDescription().replace("y =", "").replace("+","").replaceAll("\\s+", "").split("x");


        double actualM = Double.parseDouble(parts[0].trim());
        double actualB = Double.parseDouble(parts[1].trim());

        // Assert
        assertTrue(result.getIsSuccess());
        assertEquals(expectedM, actualM, tolerance);
        assertEquals(expectedB, actualB, tolerance);
    }

    @Test
    @DisplayName("computeLinearRegressionFormula receives one pair of values - - Throw Exception")
    void Calculator_computeLinearRegressionFormula_ReceiveOnePairOfValues_ThrowException() {
        //preq-UNIT-TEST-6

        // Arrange
        String values = "1.47,52.21";
        String expectedMessage = "at least two x,y pairs are required";

        // Act
        CalculationResult result= LinearRegression.computeLinearRegressionFormula(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));



    }
    @Test
    @DisplayName("computeLinearRegressionFormula receives empty values - Throw Exception")
    void Calculator_computeLinearRegressionFormula_ReceiveEmptyValues_ThrowException() {
        //preq-UNIT-TEST-6

        // Arrange
        String values = "";
        String expectedMessage = "input cannot be null or empty";

        // Act
        CalculationResult result= LinearRegression.computeLinearRegressionFormula(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));


    }
    @Test
    @DisplayName("computeLinearRegressionFormula receives Null values - - Throw Exception")
    void Calculator_computeLinearRegressionFormula_ReceiveNullValues_ThrowException() {
        //preq-UNIT-TEST-6

        // Arrange
        String values = null;
        String expectedMessage = "input cannot be null or empty";

        // Act
        CalculationResult result= LinearRegression.computeLinearRegressionFormula(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));

    }
    @Test
    @DisplayName("computeLinearRegressionFormula receives non-numeric values - - Throw Exception")
    void Calculator_computeLinearRegressionFormula_ReceiveNonNumValues_ThrowException() {
        //preq-UNIT-TEST-6

        // Arrange
        String values = "f," +
                "f,f";
        String expectedMessage = "line should contain exactly two valid numeric values";

        // Act
        CalculationResult result= LinearRegression.computeLinearRegressionFormula(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));

    }
    @Test
    @DisplayName("computeLinearRegressionFormula receives the same X values - Throw Exception")
    void Calculator_computeLinearRegressionFormula_ReceiveSameXValues_ThrowException() {
        //preq-UNIT-TEST-6

        // Arrange
        String values = "1.47,52.21\n" +
                "1.47,53.12\n" +
                "1.47,54.48\n";
        String expectedMessage = "division by zero";
        // Act

        // Act
        CalculationResult result= LinearRegression.computeLinearRegressionFormula(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));

    }
    @Test
    @DisplayName("computeLinearRegressionFormula receives the same X values - Throw Exception")
    void Calculator_computeLinearRegressionFormula_ReceiveAllXYValuesZero_ThrowException() {
        //preq-UNIT-TEST-6

        // Arrange
        String values = "0,0\n" +
                "0,0\n" +
                "0,0\n";
        String expectedMessage = "division by zero";
        // Act

        // Act
        CalculationResult result= LinearRegression.computeLinearRegressionFormula(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));

    }
    @Test
    @DisplayName("computeLinearRegressionFormula receives receives the same Y values - returns liner regression formula y = 0x + y")
    void Calculator_computeLinearRegressionFormula_ReceiveSameYValues_ReturnsLinearRegressionFormula() {
        //preq-UNIT-TEST-6

        // Arrange
        String values = "1.47,52.21\n" +
                "1.5,52.21\n" +
                "1.52,52.21\n" +
                "1.55,52.21\n" +
                "1.57,52.21\n" +
                "1.6,52.21\n" +
                "1.63,52.21\n";
        String expectedResult = "y = 0x + 52.21";
        double expectedM = 0;
        double expectedB = 52.21;
        double tolerance = 1e-10;
        // Act
        CalculationResult result = LinearRegression.computeLinearRegressionFormula(values);
        // Extract m and b from the result
        String[] parts = result.getDescription().replace("y =", "").replace("+","").replaceAll("\\s+", "").split("x");


        double actualM = Double.parseDouble(parts[0].trim());
        double actualB = Double.parseDouble(parts[1].trim());

        // Assert
        assertTrue(result.getIsSuccess());
        assertEquals(expectedM, actualM, tolerance);
        assertEquals(expectedB, actualB, tolerance);
    }
    @Test
    @DisplayName("computeLinearRegressionFormula receives three values in line - Throw Exception")
    void Calculator_computeLinearRegressionFormula_ReceiveThreeValuesInLine_ThrowException() {
        //preq-UNIT-TEST-6

        // Arrange
        String values = "1.47,52.21\n" +
                "1.47,53,12\n" +
                "1.47,54.48\n";
        String expectedMessage = "line should contain exactly two valid numeric values";

        // Act
        CalculationResult result= LinearRegression.computeLinearRegressionFormula(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));

    }
    @Test
    @DisplayName("computeLinearRegressionFormula receives non-numeric value - Throw Exception")
    void Calculator_computeLinearRegressionFormula_ReceiveNonNumericValue_ThrowException() {
        //preq-UNIT-TEST-6

        // Arrange
        String values = "1.47,52.21\n" +
                "1.47,a\n" +
                "1.47,54.48\n";
        String expectedMessage = "invalid numeric value";

        // Act
        CalculationResult result= LinearRegression.computeLinearRegressionFormula(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));

    }

    @Test
    @DisplayName("computePredictedY receives non-numeric value - Throw Exception")
    void Calculator_computePredictedY_ReceiveNonNumericValue_ThrowException() {
        //preq-UNIT-TEST-7

        // Arrange
        String values = "9, a, 5";
        String expectedMessage = "invalid numeric value";

        // Act
        CalculationResult result= LinearRegression.computePredictedY(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));


    }
    @Test
    @DisplayName("computePredictedY receives two lines of values - Throw Exception")
    void Calculator_computePredictedY_ReceiveTwoLinesOfValues_ThrowException() {
        //preq-UNIT-TEST-7

        // Arrange
        String values = "9, 4, 5\n"+
                "5, 6, 2";
        String expectedMessage = "predict y format is \"x,m,b\" on one line separated by commas";

        // Act
        CalculationResult result= LinearRegression.computePredictedY(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));


    }
    @Test
    @DisplayName("computePredictedY receives two values - Throw Exception")
    void Calculator_computePredictedY_ReceivesTwoValues_ThrowException() {
        //preq-UNIT-TEST-7

        // Arrange
        String values = "9, 8";
        String expectedMessage = "exactly 3 numeric values are required";

        // Act
        CalculationResult result= LinearRegression.computePredictedY(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));


    }
    @Test
    @DisplayName("computePredictedY receives four values - Throw Exception")
    void Calculator_computePredictedY_ReceivesFourValues_ThrowException() {
        //preq-UNIT-TEST-7

        // Arrange
        String values = "9, 8, 7, 6";
        String expectedMessage = "exactly 3 numeric values are required";

        // Act
        CalculationResult result= LinearRegression.computePredictedY(values);

        // Assert
        assertFalse(result.getIsSuccess());
        assertTrue(result.getError().toLowerCase().contains(expectedMessage));

    }
    @Test
    @DisplayName("computePredictedY receives valid values - returns predicted Y values")
    void Calculator_computePredictedY_ReceiveValidValues_ReturnsPredictedY() {
        //preq-UNIT-TEST-7

        // Arrange
        String values = "1.535, 61.272186542107434, -39.061955918838656";
        double expectedResult = 54.990850423296244;
        // Act
        CalculationResult result = LinearRegression.computePredictedY(values);

        // Assert
        assertTrue(result.getIsSuccess());
        assertEquals(expectedResult, result.getResult(), 0.00000000001);


    }
}