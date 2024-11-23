package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class DescriptiveStatistics {


    static CalculationResult computeMean(String input) throws IllegalArgumentException {
        //preq-LOGIC-5

        try {
            validateInput(input);  // Check if input is empty
            double[] values = parseValues(input, 1); // At least one value
            double mean = computeMeanHelper(values);
            return new CalculationResult(true, "Mean", mean, "");
        } catch (IllegalArgumentException e) {
            return new CalculationResult(false, e.getMessage(), 0, e.getMessage());
        }
    }


    static CalculationResult computeSampleStandardDeviation(String input) throws IllegalArgumentException {
        //preq-LOGIC-3
        try {
            validateInput(input); // check if input is empty
            double[] values = parseValues(input, 2); // at least two values
            double stdDev =  computeStandardDeviation(values, false);
            return new CalculationResult(true, "Sample Standard Deviation", stdDev, "");
        } catch (IllegalArgumentException e) {
            return new CalculationResult(false, e.getMessage(), 0, e.getMessage());
        }
    }


    static CalculationResult computePopulationStandardDeviation(String input) throws IllegalArgumentException {
        //preq-LOGIC-4
        try{
            validateInput(input);
            double[] values = parseValues(input, 1);
            double stdDev =  computeStandardDeviation(values, true);
            return new CalculationResult(true, "Population Standard Deviation", stdDev, "");
        } catch (IllegalArgumentException e) {
            return new CalculationResult(false, e.getMessage(), 0, e.getMessage());
        }
    }
    static CalculationResult computeZscore(String input) throws IllegalArgumentException {
        //preq-LOGIC-6
        try {
            validateInput(input);
            double[] parameters = parseParameters(input, 3); // three parameters
            double value = parameters[0];
            double mean = parameters[1];
            double stdDev = parameters[2];
            double numerator = value - mean;
            double zScore = numerator / stdDev;
            validateDivision(zScore);

            return new CalculationResult(true, "Z-Score", zScore, "");
        }catch (IllegalArgumentException e) {
            return new CalculationResult(false, e.getMessage(), 0, e.getMessage());
        }
    }

    // Helper methods
    static double computeMeanHelper(double[] values) throws IllegalArgumentException {

        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        double sumAccumulator = 0;
        for (double value : values) {
            sumAccumulator += value;
        }

        return sumAccumulator / values.length;
    }

    static double computeSquareOfDifferences(double[] values, double mean) throws IllegalArgumentException {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        double squareAccumulator = 0;
        for (double value : values) {
            double difference = value - mean;
            double squareOfDifference = difference * difference;
            squareAccumulator += squareOfDifference;
        }
        return squareAccumulator;
    }
    static double computeVariance(double squareOfDifferences, int numValues, boolean isPopulation) throws IllegalArgumentException {
        if(!isPopulation) {
            numValues--;
        }
        if(numValues < 1) {
            throw new IllegalArgumentException("Insufficient values provided");
        }
        return squareOfDifferences / numValues;
    }


    static double computeStandardDeviation(double[] values, boolean isPopulation) throws IllegalArgumentException {
        if (values == null || values.length == 0){
            throw new IllegalArgumentException("input cannot be null or empty");
        }

        double mean = computeMeanHelper(values);
        double squareOfDifferences = computeSquareOfDifferences(values, mean);
        double variance = computeVariance(squareOfDifferences, values.length, isPopulation);
        return Math.sqrt(variance);
    }

    // Validation methods
    static void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
    }
    private static void validateNumberOfValues(String[] lines, int minValues) {
        if (lines.length < minValues) {
            throw new IllegalArgumentException("Invalid input format. Expected at least " + minValues + " values, one value per line");
        }
    }

    static void validateNumericInput(String input) {
        try {
            Double.parseDouble(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numeric value");
        }
    }

    private static void validateDivision(double result){
        if (Double.isInfinite(result) || Double.isNaN(result)) {
            throw new IllegalArgumentException("Division by zero");
        }
    }
    static double[] parseValues(String input, int minValue) {

        String[] lines = input.split("\n");
        validateNumberOfValues(lines, minValue);
        ArrayList<Double> values = new ArrayList<>();
        for (String line : lines) {
            String trimmed = line.trim();
            if (!trimmed.isEmpty()) {
                validateNumericInput(trimmed); // Validate numeric values
                values.add(Double.parseDouble(trimmed));
            }
        }
        return values.stream().mapToDouble(Double::doubleValue).toArray();
    }
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
            throw new IllegalArgumentException("Exactly one line of input is required");
        }
    }
    private static void validateNumberOfParameters(String[] parts, int numParams) {
        if (parts.length != numParams) {
            throw new IllegalArgumentException("Invalid input format. Exactly " + numParams + " numeric values are required");
        }
    }



}
