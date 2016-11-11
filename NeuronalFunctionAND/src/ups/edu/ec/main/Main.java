/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.main;

/**
 *
 * @author Jorge Mendoza & Gabriela Zambrano Neural Network Simulation: AND.
 */
public class Main {

    static double oscillation;
    static double[] arrayUnits = new double[2];
    String outputEval = "";
    static int[][] valuesTableAND = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

    public static void main(String[] args) {
        init();
        double h = 0;
        double g = 0;
        System.out.println("X" + "\t" + "Y" + "\t" + "h()" + "\t" + "g(z)");
        System.out.println("-----------------------------------------------");
        for (int[] value : valuesTableAND) {
            h = functionZeta(value[0], value[1]);
            //g = (int) Math.round(functionSigmoid(h)); // 0 or 1
            g = functionSigmoid(h);
            System.out.println(value[0] + "\t" + value[1] + "\t" + h + "\t" + g);
        }
    }

    public static void init() {
        oscillation = -30;
        arrayUnits[0] = 20;
        arrayUnits[1] = 20;
    }

    public static double functionZeta(int x, int y) {
        double result = 0;
        double productoPunto = 0;
        productoPunto = arrayUnits[0] * x + arrayUnits[1] * y;
        result = oscillation + productoPunto;
        return result;
    }

    public static double functionSigmoid(double z) {
        double result = 0;
        try {
            result = 1 / (1 + (Math.exp(-z)));
        } catch (Exception e) {
            System.err.println("Error:" + e.getMessage());
        }
        return result;
    }
}
