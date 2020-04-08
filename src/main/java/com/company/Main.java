package com.company;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Main {




    public static void main(String[] args) throws IOException {

        JsonParser parser = new JsonParser();
        parser.convertToJson();

        Analizer analizer = new Analizer();

        double[] P1Relative = new double[analizer.getArray2D().length];  // Revenue
        double[] P2Relative = new double[analizer.getArray2D().length];  // paidusers
        double[] P3Relative = new double[analizer.getArray2D().length];  // mau
        double[] P4Relative = new double[analizer.getArray2D().length];  // urr
        double[] P5Relative = new double[analizer.getArray2D().length];  // test

        for (Companies a : parser.getCompaniesList()) {
            for (Companies b : parser.getCompaniesList()) {
                for (Companies c : parser.getCompaniesList()) {
                    if (a.getId() == 1 && b.getId() == 2 && c.getId() == 3) {

                        analizer.AnalizeWithGivenParameters(a.getRevenue(), b.getRevenue(), c.getRevenue(), P1Relative);
                        analizer.AnalizeWithGivenParameters(a.getPaidusers(), b.getPaidusers(), c.getPaidusers(), P2Relative);
                        analizer.AnalizeWithGivenParameters(a.getMau(), b.getMau(), c.getMau(), P3Relative);
                        analizer.AnalizeWithGivenParameters(a.getUrr(), b.getUrr(), c.getUrr(), P4Relative);
                        analizer.AnalizeWithGivenParameters(a.getTest(), b.getTest(), c.getTest(), P5Relative);

                    }
                }
            }
        }

        for (int b = 0; b< P1Relative.length; b++) {
            System.out.print(P1Relative[b]);
            System.out.print(" ");
        }
        System.out.println();
        for (int b = 0; b< P2Relative.length; b++) {
            System.out.print(P2Relative[b]);
            System.out.print(" ");
        }
        System.out.println();
        for (int b = 0; b< P3Relative.length; b++) {
            System.out.print(P3Relative[b]);
            System.out.print(" ");
        }
        System.out.println();
        for (int b = 0; b< P4Relative.length; b++) {
            System.out.print(P4Relative[b]);
            System.out.print(" ");
        }
        System.out.println();
        for (int b = 0; b< P5Relative.length; b++) {
            System.out.print(P5Relative[b]);
            System.out.print(" ");
        }
        System.out.println();


    }


}









