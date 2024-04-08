package nl.alexflix;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Options options = Options.init(args);
        File input = new File(options.getInputPath());
        File output = new File(options.getOutputPath());
        ArrayList<String> arrayList = new ArrayList<>();
        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNext()) {
                arrayList.add(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String line : arrayList) {
            System.out.println(line);
        }
    }
}