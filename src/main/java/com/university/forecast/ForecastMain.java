package com.university.forecast;

public class ForecastMain {

    public static void main(String[] args) {

        double maxValueOfMatrixA = MathUtils.getMaxValueOfMatrix(Data.matrixA);

        double maxValueOfMatrixB = MathUtils.getMaxValueOfMatrix(Data.matrixB);

        double[][][] matrixM = fillMatrixM(maxValueOfMatrixA, maxValueOfMatrixB);

        double[] similarityValues = prepareSimilarityValues(matrixM);

        displayChart(similarityValues);
    }

    private static void displayChart(double[] similarityValues) {
        Charts chart = new Charts("Similarity Index Values Chart", similarityValues);
        chart.pack();
        chart.setVisible(true);
    }

    private static double[] prepareSimilarityValues(double[][][] matrixM) {
        double[] result = new double[Data.STEPS_NUMBER];

        System.out.println("List of similarity values");

        for (int d = 0; d < Data.STEPS_NUMBER; d++) {

            double sumProductValuesOfMatrixMAndP = MathUtils.sumProductOfDifferentMatrixValues(matrixM, Data.matrixP, d);

            double sumSquaredValuesOfMatrixM = MathUtils.sumSqauredMatrixValues(matrixM, d);

            double sumSquaredValuesOfMatrixP = MathUtils.sumSqauredMatrixValues(Data.matrixP);

            result[d] = sumProductValuesOfMatrixMAndP * sumProductValuesOfMatrixMAndP / (sumSquaredValuesOfMatrixM * sumSquaredValuesOfMatrixP);

            System.out.println(result[d]);
        }
        return result;
    }

    private static double[][][] fillMatrixM(double maxValueOfMatrixA, double maxValueOfMatrixB) {
        double[][][] matrixM = new double[Data.STEPS_NUMBER][Data.ROW_NUMBER][Data.COLUMN_NUMBER];
        int distance = 100;

        for (int step = 0; step < Data.STEPS_NUMBER; step++) {
            for (int row = 0; row < Data.ROW_NUMBER; row++) {
                for (int column = 0; column < Data.COLUMN_NUMBER; column++) {
                    double firstEquationPartValue = step / maxValueOfMatrixA * Data.matrixA[row][column];
                    double secondEquationPartValue = (distance - step) / maxValueOfMatrixB * Data.matrixB[row][column];

                    matrixM[step][row][column] = firstEquationPartValue + secondEquationPartValue;
                }
            }
        }
        return matrixM;
    }
}