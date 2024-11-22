package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {


    static double computeMeanHelper(double[] values) throws IllegalArgumentException {
        //preq-LOGIC-5
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("values parameter cannot be null or empty");
        }
        double sumAccumulator = 0;
        for (double value : values) {
            sumAccumulator += value;
        }

        return (double) sumAccumulator / values.length;
    }
    static double computeMean(String input) throws IllegalArgumentException {
        //preq-LOGIC-5
        double[] values = parseValues(input, 1); // At least one value
        return computeMeanHelper(values);
    }


    static double computeSquareOfDifferences(double[] values, double mean) throws IllegalArgumentException {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("values parameter cannot be null or empty");
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
            throw new IllegalArgumentException("Insufficient number of values provided");
        }
        return squareOfDifferences / numValues;
    }


    static double computeStandardDeviation(double[] values, boolean isPopulation) throws IllegalArgumentException {
        if (values == null || values.length == 0){
            throw new IllegalArgumentException("values parameter cannot be null or empty");
        }

        double mean = computeMeanHelper(values);
        double squareOfDifferences = computeSquareOfDifferences(values, mean);
        double variance = computeVariance(squareOfDifferences, values.length, isPopulation);
        return Math.sqrt(variance);
    }



    static double computeSampleStandardDeviation(String input) throws IllegalArgumentException {
        //preq-LOGIC-3
        double[] values = parseValues(input, 2); // at least one value
        return computeStandardDeviation(values, false);
    }


    static double computePopulationStandardDeviation(String input) throws IllegalArgumentException {
        //preq-LOGIC-4
        double[] values = parseValues(input, 1); // at least two values
        return computeStandardDeviation(values, true);
    }

    static double computeZscore(String input) throws IllegalArgumentException {
        //preq-LOGIC-6
        double[] parameters = parseParameters(input, 3); // three parameters
        double value = parameters[0];
        double mean = parameters[1];
        double stdDev = parameters[2];
        double numerator = value - mean;
        double zScore = numerator / stdDev;
        if(Double.isInfinite(zScore) || Double.isNaN(zScore)) {
            throw new IllegalArgumentException("Division by zero");
        }
        return numerator / stdDev;
    }
    static String computeLinearRegressionFormula(String input) throws IllegalArgumentException {
        //preq-LOGIC-7
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Values parameter cannot be null or empty");
        }
        String[] lines = input.split("\n");
        ArrayList<Double> xValues = new ArrayList<>();
        ArrayList<Double> yValues = new ArrayList<>();

        for (String line : lines) {
            String trimmed = line.trim();
            if (!trimmed.isEmpty()) {
                String[] parts = trimmed.split(",");
                if (parts.length != 2) {
                    throw new IllegalArgumentException("Line should contain exactly two valid numeric values");
                }
                try {
                    xValues.add(Double.parseDouble(parts[0].trim()));
                    yValues.add(Double.parseDouble(parts[1].trim()));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid numeric value in line: " + trimmed);
                }
            }
        }

        if (xValues.size() < 2) {
            throw new IllegalArgumentException("At least two X,Y pairs are required");
        }

        double xMean = computeMeanHelper(xValues.stream().mapToDouble(Double::doubleValue).toArray());
        double yMean = computeMeanHelper(yValues.stream().mapToDouble(Double::doubleValue).toArray());
        double numerator = 0.0;
        double denominator = 0.0;

        for (int i = 0; i < xValues.size(); i++) {
            double xDifference = xValues.get(i) - xMean;
            double yDifference = yValues.get(i) - yMean;
            numerator += xDifference * yDifference;
            denominator += xDifference * xDifference;
        }
        double m = numerator / denominator; // slope
        if(Double.isNaN(m)){
            throw new IllegalArgumentException("Division by zero");
        }


        double b = yMean - (m * xMean); //intercept


        return "y = " + m + "x + " + b;


    }

    static double computePredictedY(String input) throws IllegalArgumentException {
        double[] parameters = parseParameters(input, 3); // three parameters
        double x = parameters[0];
        double slope = parameters[1];
        double intercept = parameters[2];
        return x*slope + intercept;
    }

    static private double[] parseValues(String input, int minValues) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Values parameter cannot be null or empty");
        }
        String[] lines = input.split("\n");
        ArrayList<Double> values = new ArrayList<>();
        for (String line : lines) {
            String trimmed = line.trim();
            if (!trimmed.isEmpty()) {
                try {
                    values.add(Double.parseDouble(trimmed));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid numeric value: " + trimmed);
                }
            }
        }
        if (values.size() < minValues) {
            throw new IllegalArgumentException("Insufficient numeric values provided");
        }
        return values.stream().mapToDouble(Double::doubleValue).toArray();
    }

    static private double[] parseParameters(String input, int numParams) throws IllegalArgumentException {

        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Values parameter cannot be null or empty");
        }
        String[] lines = input.split("\n");
        if (lines.length != 1) {
            throw new IllegalArgumentException("Exactly one line of input is required");
        }
        String[] parts = lines[0].split(",");
        if (parts.length != numParams) {
            throw new IllegalArgumentException("Exactly " + numParams + " numeric values are required");
        }
        try {
            return Arrays.stream(parts).map(String::trim).mapToDouble(Double::parseDouble).toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid value in input");
        }
    }





}