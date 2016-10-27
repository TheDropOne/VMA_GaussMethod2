package by.thedrop;

import by.thedrop.entity.Matrix;

/**
 * Created by Semen on 27-Oct-16.
 */
public class GaussMethod {
    private double[] variables;

    public void gaussAlgorithm(Matrix matrix) {
        variables = new double[matrix.getMatrixHeight()];
        for (int i = 0; i < matrix.getMatrixHeight(); i++) {
            double coeff = matrix.getElement(i, i);
            matrix = subLines(matrix, divLine(matrix.getLine(i), coeff), i, coeff);
        }
    }

    private Matrix subLines(Matrix matrix, double[] line, int number, double coeff) {
        Matrix temp = new Matrix(matrix);
        for (int j = 0; j < matrix.getMatrixHeight(); j++) {
            if (j != number) {
                for (int i = 0; i < matrix.getMatrixWidth(); i++) {
                    temp.matrixArray[j][i] -= line[i] * coeff;
                }
            }
        }
        return temp;
    }

    private double[] divLine(double[] line, double coeff) {
        for (int i = 0; i < line.length; i++) {
            line[i] /= coeff;
        }
        return line;
    }
}
