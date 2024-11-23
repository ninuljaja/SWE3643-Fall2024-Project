package org.example;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class WebController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("calculationResult", new CalculationResult(true, "Enter values below, then select an operation", 0.0, ""));
        return "index"; // Serve the index page
    }


    @GetMapping("/mean")
    @ResponseBody
    public CalculationResult  computeMean(@RequestParam String values) {
        CalculationResult result = DescriptiveStatistics.computeMean(values);

        return result; // return the same index.html, result will be updated
    }


    @GetMapping("/sample-std-dev")
    @ResponseBody
    public CalculationResult computeSampleStandardDeviation(@RequestParam String values, Model model) {
        CalculationResult result = DescriptiveStatistics.computeSampleStandardDeviation(values);
        return result;
    }


    @GetMapping("/population-std-dev")
    @ResponseBody
    public CalculationResult computePopulationStandardDeviation(@RequestParam String values, Model model) {
        CalculationResult result = DescriptiveStatistics.computePopulationStandardDeviation(values);
        return result;
    }

    @GetMapping("/z-score")
    @ResponseBody
    public CalculationResult computeZscore(@RequestParam String values, Model model) {
        CalculationResult result = DescriptiveStatistics.computeZscore(values);

        return result;
    }

    @GetMapping("/linear-regression")
    @ResponseBody
    public CalculationResult computeLinearRegression(@RequestParam String values, Model model) {
        CalculationResult result = LinearRegression.computeLinearRegressionFormula(values);
        return result;
    }

    @GetMapping("/predict-y")
    @ResponseBody
    public CalculationResult computePredictedY(@RequestParam String values, Model model) {
        CalculationResult result = LinearRegression.computePredictedY(values);

        return result;
    }
}
