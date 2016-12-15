package by.thedrop;

import by.thedrop.entity.Matrix;

/**
 * Created by Semen on 27-Oct-16.
 */
public class GaussMethod {
    private static double[] variables;

    public static void gaussAlgorithm(Matrix matrix) {
        Matrix matrix1 = new Matrix(matrix);
        Matrix inverseMatrix = new Matrix(inversion(matrix1.getSubArray(),matrix.getMatrixHeight()));
        double[] line = new double[matrix.getMatrixWidth()];
        for (int i = 0; i < matrix.getMatrixHeight(); i++) {
            double coeff = matrix.getElement(i, i);
            matrix = subLines(matrix, divLine(matrix.getLine(i), coeff), i, coeff);
        }
        matrix.print();
        System.out.println("Определитель : ");
        System.out.println(getDeterminator(matrix));
        System.out.println("Корни : ");
        variables = new double[matrix.getMatrixHeight()];
        variables = getSolutions(matrix);
        for (int i = 0; i < variables.length; i++) {
            System.out.println(String.format("%-3s", variables[i]));
        }
        System.out.println("Обратная матрица : ");
        inverseMatrix.print();
    }

    private static Matrix subLines(Matrix matrix, double[] line, int number, double coeff) {
        Matrix temp = new Matrix(matrix);
        for (int j = number + 1; j < matrix.getMatrixHeight(); j++) {
            double tempCoeff = temp.matrixArray[j][number];
            for (int i = 0; i < matrix.getMatrixWidth(); i++) {
                temp.matrixArray[j][i] -= line[i] * tempCoeff;
            }
        }
        //BigDecimal a = BigDecimal.
        return temp;
    }

    private static double getDeterminator(Matrix matrix) {
        double temp = 1;
        for (int i = 0; i < matrix.getMatrixHeight(); i++) {
            temp = temp * matrix.getElement(i, i);
        }
        return temp;
    }

    private static double[] getSolutions(Matrix matrix) {
        double[] variables = new double[matrix.getMatrixHeight()];
        for (int i = 0; i < variables.length; i++) {
            double temp = matrix.getElement(matrix.getMatrixHeight() - i - 1, matrix.getMatrixWidth() - 1);
            for (int j = 0; j < i; j++) {
                double a = matrix.getElement(matrix.getMatrixHeight() - i - 1, matrix.getMatrixWidth() - 2 - j);
                double b = variables[i - j - 1];
                temp -= matrix.getElement(matrix.getMatrixHeight() - i - 1, matrix.getMatrixWidth() - 2 - j) * variables[j];
            }
            variables[i] = temp / matrix.getElement(matrix.getMatrixHeight() - i - 1, matrix.getMatrixWidth() - i - 2);
        }
        return variables;
    }

    private static double[] divLine(double[] line, double coeff) {
        for (int i = 0; i < line.length; i++) {
            line[i] /= coeff;
        }
        return line;
    }

    /*private static double[][] reverseMatrix(Matrix matrix) {

    }
    */

    private static double[][] inversion(double[][] matrixArray, int size) {
        double temp;
        double[][] tempMatrix = new double[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                tempMatrix[i][j] = 0.0;
                if (i == j)
                    tempMatrix[i][j] = 1.0;
            }
        for (int k = 0; k < size; k++) {
            temp = matrixArray[k][k];

            for (int j = 0; j < size; j++) {
                matrixArray[k][j] /= temp;
                tempMatrix[k][j] /= temp;
            }
            for (int i = k + 1; i < size; i++) {
                temp = matrixArray[i][k];

                for (int j = 0; j < size; j++) {
                    matrixArray[i][j] -= matrixArray[k][j] * temp;
                    tempMatrix[i][j] -= tempMatrix[k][j] * temp;
                }
            }
        }
        for (int k = size - 1; k > 0; k--) {
            for (int i = k - 1; i >= 0; i--) {
                temp = matrixArray[i][k];

                for (int j = 0; j < size; j++) {
                    matrixArray[i][j] -= matrixArray[k][j] * temp;
                    tempMatrix[i][j] -= tempMatrix[k][j] * temp;
                }
            }
        }
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                matrixArray[i][j] = tempMatrix[i][j];
        return tempMatrix;
    }
}
