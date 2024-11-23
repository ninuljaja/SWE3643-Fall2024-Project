package org.example;

public class CalculationResult {
    private double result = 0.0;
    private boolean isSuccess;
    private String description;
    private String error;

    public CalculationResult(boolean success, String description, double result, String error) {
        this.result = result;
        this.isSuccess = success;
        this.description = description;
        this.error = error;
    }
    public double getResult() {
        return result;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }


    public String getDescription() {
        return description;
    }


    public String getError() {
        return error;
    }

}
