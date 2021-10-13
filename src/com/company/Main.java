package com.company;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Эта программа выводит все простые делители числа P");
        int p = getValueFromFile();
        String divisors = getDivisors(p);
        showDivisors(divisors, p);
    }

    public static String getDivisors(int p) {
        int n = p + 1;
        int counter;
        String divisors = "";
        for (int i = 2; i < n; i++) {
            counter = 0;
            if (p % i == 0) {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        counter++;
                    }
                }
                if (counter == 0) {
                    divisors += i + " ";
                }
            }
        }
        return divisors;
    }

    public static int getValueFromFile() {
        int p = 0;
        boolean isCorrect = true;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("E:\\ОАиП\\ЛР2\\Java\\LR2.2\\InputData.txt"));
            p = Integer.parseInt(reader.readLine());
        } catch (FileNotFoundException e) {
            System.err.println("File is not found");
        } catch (IOException e) {
            e.getMessage();
        } catch (NumberFormatException e) {
            isCorrect = false;
            System.err.println("There's not a number in file");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }
        if (p < 1 && isCorrect) {
            System.err.println("There's not a natural number in file");
        }
        if (p == 1) {
            System.out.println("Натуральное число 1 - не имеет простых делителей");
        }
        return p;
    }


    public static void writeValueToFile(String divisors){
        String path = "E:\\ОАиП\\ЛР2\\Java\\LR2.2\\OutputData.txt";
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter( new FileWriter(path));
            writer.write(divisors + " ");
        } catch (IOException e){
             e.getMessage();
        } finally {
            try {
                writer.close();
            } catch (IOException e){
                e.getMessage();
            }
        }
    }

    public static void showDivisors(String divisors, int p){
        System.out.print("Простые делители числа " + p + ": " + divisors);
        writeValueToFile(divisors);
    }
}