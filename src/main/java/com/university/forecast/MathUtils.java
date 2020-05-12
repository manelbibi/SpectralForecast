package com.university.forecast;

public class MathUtils {

    private MathUtils() {

    }

    public static double getMaxValueOfMatrix(double[][] matrix) {
        double maxValue = matrix[0][0];
        for (int i = 0; i < Data.ROW_NUMBER; i++) {
            for (int j = 0; j < Data.COLUMN_NUMBER; j++) {
                if (matrix[i][j] > maxValue) {
                    maxValue = matrix[i][j];
                }
            }
        }
        return maxValue;
    }

    public static double sumProductOfDifferentMatrixValues(double[][][] tridimensionnelMatrix, double[][] bidimensionnelMatrix, int step) {
        double result = 0;
        for (int i = 0; i < Data.ROW_NUMBER; i++) {
            for (int j = 0; j < Data.COLUMN_NUMBER; j++) {
                result += tridimensionnelMatrix[step][i][j] * bidimensionnelMatrix[i][j];
            }
        }
        return result;
    }

    public static double sumSqauredMatrixValues(double[][][] tridimensionnelMatrix, int step) {
        double result = 0;
        for (int i = 0; i < Data.ROW_NUMBER; i++) {
            for (int j = 0; j < Data.COLUMN_NUMBER; j++) {
                result += tridimensionnelMatrix[step][i][j] * tridimensionnelMatrix[step][i][j];
            }
        }
        return result;
    }

    public static double sumSqauredMatrixValues(double[][] bidimensionnelMatrix) {
        double result = 0;
        for (int i = 0; i < Data.ROW_NUMBER; i++) {
            for (int j = 0; j < Data.COLUMN_NUMBER; j++) {
                result += bidimensionnelMatrix[i][j] * bidimensionnelMatrix[i][j];
            }
        }
        return result;
    }
}