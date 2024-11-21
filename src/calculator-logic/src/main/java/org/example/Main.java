package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {


//        double[] sampleValues = {9, 6, 8, 5, 7};
//        double sampleStdDev = computeSampleStandardDeviation(sampleValues);
//        System.out.println("Sample StdDev = " + sampleStdDev);
//
//
//        double[] populationValues = {9, 2, 5, 4, 12, 7, 8, 11, 9, 3, 7, 4, 12, 5, 4, 10, 9, 6, 9, 4};
//        double popStdDev = computePopulationStandardDeviation(populationValues);
//        System.out.println("Population StdDev = " + popStdDev);
//        double mean = computeMean(sampleValues);
//        System.out.println("Mean average = " + mean);
//        double zScore = computeZscore(11.5, mean, sampleStdDev);
//        System.out.println("zScore = " + zScore);
//        double[][] pairs = {
//                {1.47,52.21},
//                {1.5,53.12},
//                {1.52,54.48},
//                {1.55,55.84},
//                {1.57,57.2},
//                {1.6, 58.57},
//                {1.63, 59.93},
//                {1.65, 61.29},
//                {1.68, 63.11},
//                {1.7, 64.47},
//                {1.73, 66.28},
//                {1.75, 68.1},
//                {1.78, 69.92},
//                {1.8, 72.19},
//                {1.83,74.46}};
//        String linearRegression = computeLinearRegressionFormula(pairs);
//        System.out.println("linear regression: " + linearRegression);
//        double prediction = computePredictedYvalue(1.535,61.272186542107434, -39.061955918838656);
//        System.out.println("prediction: " + prediction);

    }

    static double computeMean(double[] values) throws IllegalArgumentException {
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
    static double computeVariance(double squareOfDifferences, double numValues, boolean isPopulation) throws IllegalArgumentException {
        if(!isPopulation) {
            numValues--;
        }
        if(numValues < 1) {
            throw new IllegalArgumentException("numValues is too low (sample must be >= 1, population must be >= 2)");
        }
        return squareOfDifferences / numValues;
    }


    static double computeStandardDeviation(double[] values, boolean isPopulation) throws IllegalArgumentException {
        if (values == null || values.length == 0){
            throw new IllegalArgumentException("values parameter cannot be null or empty");
        }

        double mean = computeMean(values);
        double squareOfDifferences = computeSquareOfDifferences(values, mean);
        double variance = computeVariance(squareOfDifferences, values.length, isPopulation);
        return Math.sqrt(variance);
    }



    static double computeSampleStandardDeviation(String input) throws IllegalArgumentException {
        //preq-LOGIC-3
        double[] values = parseValues(input, 1); // at least one value
        return computeStandardDeviation(values, false);
    }


    static double computePopulationStandardDeviation(String input) throws IllegalArgumentException {
        //preq-LOGIC-4
        double[] values = parseValues(input, 2); // at least two values
        return computeStandardDeviation(values, true);
    }

    static double computeZscore(String input) throws IllegalArgumentException {
        //preq-LOGIC-6
        double[] parameters = parseParameters(input, 3); // three parameters
        double value = parameters[0];
        double mean = parameters[1];
        double stdDev = parameters[2];
        double numerator = value - mean;
        if(Double.isInfinite(numerator/stdDev)){
            throw new IllegalArgumentException("Division by zero");
        }
        return numerator / stdDev;
    }
    static String computeLinearRegressionFormula(String input) throws IllegalArgumentException {
        //preq-LOGIC-7
        String[] lines = input.split("\n");
        ArrayList<Double> xValues = new ArrayList<>();
        ArrayList<Double> yValues = new ArrayList<>();

        for (String line : lines) {
            String trimmed = line.trim();
            if (!trimmed.isEmpty()) {
                String[] parts = trimmed.split(",");
                if (parts.length != 2) {
                    throw new IllegalArgumentException("\"Any line should contain exactly two valid numeric values");
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

        double xMean = computeMean(xValues.stream().mapToDouble(Double::doubleValue).toArray());
        double yMean = computeMean(yValues.stream().mapToDouble(Double::doubleValue).toArray());

        double numerator = 0.0;
        double denominator = 0.0;

        for (int i = 0; i < xValues.size(); i++) {
            double xDifference = xValues.get(i) - xMean;
            double yDifference = yValues.get(i) - yMean;
            numerator += xDifference * yDifference;
            denominator += yDifference * xDifference;
        }


        if(Double.isInfinite(numerator/denominator)){
            throw new IllegalArgumentException("Division by zero");
        }

        double m = numerator / denominator; // slope
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

    private static double[] parseValues(String input, int minValues) throws IllegalArgumentException {
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

    private static double[] parseParameters(String input, int numParams) throws IllegalArgumentException {
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
            throw new IllegalArgumentException("Invalid numeric value in input");
        }
    }





}