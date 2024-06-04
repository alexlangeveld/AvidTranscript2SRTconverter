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
        ArrayList<StringBuilder> arrayList = new ArrayList<>();
        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNext()) {
                arrayList.add(new StringBuilder(scanner.nextLine()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<TekstBlok> tekstBlokken = naarTekstBlokken(arrayList);
        for (TekstBlok blok : tekstBlokken) {
            blok.print();
        }

    }

    static ArrayList<TekstBlok> naarTekstBlokken(ArrayList<StringBuilder> transcript) {
        ArrayList<TekstBlok> arrayList = new ArrayList<>();
        if (transcript.get(0).toString().startsWith("Project: ")) {
            transcript.remove(0);
        }
        if (transcript.get(0).toString().startsWith("Clip Name: ")) {
            transcript.remove(0);
            if (transcript.get(0).toString().isEmpty()) transcript.remove(0);
        }
        for (int i = 0; i < transcript.size(); i++) {
            String string = transcript.get(i).toString();
            if (string.length() == 25 && string.charAt(12) == '-') {
                arrayList.add(new TekstBlok(transcript.get(i), transcript.get(i+1)));
            }
        }
        return arrayList;
    }
}