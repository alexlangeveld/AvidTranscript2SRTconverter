package nl.alexflix;

import java.util.Scanner;

public class Options {
    private static final int numOfInstances = 0;
    private String inputPath;
    private String outputPath;

    private Options(String[] args) {
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("--input")) {
                    this.inputPath = args[i+1].replaceAll("\"", "");
                } else if (args[i].equals("--output")) {
                    this.outputPath = args[i+1].replaceAll("\"", "");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Iets is mis met je argumenten!");
            this.inputPath = null;
            this.outputPath = null;
        }

        if (this.inputPath == null || this.inputPath.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Plak hier het .txt bestand: ");
            this.inputPath = scanner.nextLine().replaceAll("\"", "");
        }
        if (this.outputPath == null || this.outputPath.isEmpty()) {
            this.outputPath = this.inputPath.replaceAll(".txt", ".srt");
        }
    }

    public static Options init(String... args) {
        if (numOfInstances < 1) {
            return new Options(args);
        }
        else throw new RuntimeException("Object bestaat al!");
    }

    public String getInputPath() {
        return inputPath;
    }

    public String getOutputPath() {
        return outputPath;
    }
}


