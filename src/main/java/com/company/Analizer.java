package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Analizer {

    private double[][] array2D;

    public Analizer()  {
        JsonParser parser = new JsonParser();
        try{
            parser.convertToJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(null == array2D){
            array2D = new double[parser.getCompaniesList().size()][parser.getCompaniesList().size()];
        }
    }

    public void AnalizeWithGivenParameters(int a, int b, int c, double[] PnRelative){
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D.length; j++) {
                if (i == j) {
                    array2D[i][j] = 1;
                } else {
                    if (a > b || a > c || b > c) {
                        array2D[i][j] = 1.5;
                        array2D[j][i] = 0.5;
                    }
                    if (a < b || a < c || b < c) {
                        array2D[i][j] = 0.5;
                        array2D[j][i] = 1.5;
                    }
                    if (a == b || a == c || c == b) {
                        array2D[i][j] = 1;
                    }

                    double[] P = new double[array2D.length];
                    double[] result = new double[array2D.length];
                    double total;
                    for (int m = 0; m < array2D.length; m++) {
                        total = 0;
                        for (int n = 0; n < array2D.length; n++)
                            total += array2D[m][n];
                        result[m] = total;
                    }
                    int x = 0, y = 0, z = 0;
                    P[z] = array2D[x][y] * result[0] + array2D[x][y + 1] * result[1] + array2D[x][y + 2] * result[2];
                    z++;
                    P[z] = array2D[x + 1][y] * result[0] + array2D[x + 1][y + 1] * result[1] + array2D[x + 1][y + 2] * result[2];
                    z++;
                    P[z] = array2D[x + 2][y] * result[0] + array2D[x + 2][y + 1] * result[1] + array2D[x + 2][y + 2] * result[2];

                    double s = 0;
                    for (int q = 0; q < P.length; q++) {
                        s = s + P[q];
                    }
                    for (int u = 0; u < P.length; u++) {
                        PnRelative[u] = P[u] / s;
                    }
                }
            }
        }
    }

    public double[][] getArray2D() {
        return array2D;
    }

}
