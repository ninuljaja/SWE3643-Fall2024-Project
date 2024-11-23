package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class LinearRegression {



    static CalculationResult computeLinearRegressionFormula(String input) throws IllegalArgumentException {
        //preq-LOGIC-7
        try {
            DescriptiveStatistics.validateInput(input);
            String[] lines = input.split("\n");

            ArrayList<Double> xValues = new ArrayList<>();
            ArrayList<Double> yValues = new ArrayList<>();

            for (String line : lines) {
                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    String[] parts = trimmed.split(",");
                    validateXYpair(parts);
                    DescriptiveStatistics.validateNumericInput(parts[0]);
                    DescriptiveStatistics.validateNumericInput(parts[1]);
                    xValues.add(Double.parseDouble(parts[0].trim()));
                    yValues.add(Double.parseDouble(parts[1].trim()));

                }
            }

            validateNumberOfXYpairs(xValues, yValues);

            double xMean = DescriptiveStatistics.computeMeanHelper(xValues.stream().mapToDouble(Double::doubleValue).toArray());
            double yMean = DescriptiveStatistics.computeMeanHelper(yValues.stream().mapToDouble(Double::doubleValue).toArray());
            double numerator = 0.0;
            double denominator = 0.0;

            for (int i = 0; i < xValues.size(); i++) {
                double xDifference = xValues.get(i) - xMean;
                double yDifference = yValues.get(i) - yMean;
                numerator += xDifference * yDifference;
                denominator += xDifference * xDifference;
            }
            double m = numerator / denominator; // slope

            validateDivision(m);

            double b = yMean - (m * xMean); //intercept


            String formula = "y = " + m + "x + " + b;
            return new CalculationResult(true, formula, m, "");
        }catch (IllegalArgumentException e){
            return new CalculationResult(false, e.getMessage(), 0, e.getMessage());
        }

    }

    static CalculationResult computePredictedY(String input) throws IllegalArgumentException {
        try {
            DescriptiveStatistics.validateInput(input);
            double[] parameters = parseParameters(input, 3); // three parameters
            double x = parameters[0];
            double slope = parameters[1];
            double intercept = parameters[2];
            double predictedY = x * slope + intercept;
            return new CalculationResult(true, "Single Linear Regression Prediction", predictedY, "");
        } catch (IllegalArgumentException e){
            return new CalculationResult(false, e.getMessage(), 0, e.getMessage());
        }
    }



    // Validation methods

    static double[] parseParameters(String input, int numParams) {
        String[] lines = input.split("\n");
        validateNumberOfLines(lines);
        String[] parts = lines[0].split(",");
        validateNumberOfParameters(parts, numParams);
        for (String part : parts) {
            validateNumericInput(part.trim());  // Validate each parameter
        }
        return Arrays.stream(parts).map(String::trim).mapToDouble(Double::parseDouble).toArray();
    }
    private static void validateNumberOfLines(String[] lines) {
        if (lines.length != 1) {
            throw new IllegalArgumentException("Predict Y format is \"x,m,b\" on one line separated by commas");
        }
    }
    private static void validateNumberOfParameters(String[] parts, int numParams) {
        if (parts.length != numParams) {
            throw new IllegalArgumentException("Exactly " + numParams + " numeric values are required");
        }
    }


    private static void validateNumberOfXYpairs(ArrayList<Double> xValues, ArrayList<Double> yValues) throws IllegalArgumentException {
        if (xValues.size() < 2) {
            throw new IllegalArgumentException("At least two X,Y pairs are required");
        }
    }
    private static void validateDivision(double slope) throws IllegalArgumentException {
        if (Double.isNaN(slope)) {
            throw new IllegalArgumentException("Division by zero");
        }
    }
    static void validateNumericInput(String input) {
        try {
            Double.parseDouble(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numeric value: " + input);
        }
    }
    static void validateXYpair(String[] parts){
        if (parts.length != 2) {
            throw new IllegalArgumentException("Line should contain exactly two valid numeric values");
        }
    }

}