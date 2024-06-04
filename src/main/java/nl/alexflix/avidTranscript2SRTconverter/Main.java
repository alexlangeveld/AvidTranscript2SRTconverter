package nl.alexflix.avidTranscript2SRTconverter;

import nl.alexflix.avidTranscript2SRTconverter.SRT.SRT;
import nl.alexflix.avidTranscript2SRTconverter.transcript.Transcript;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        // Add input files
        Scanner sc = new Scanner(System.in);
        System.out.print("Path to input files: ");
        File inputFolder = new File(sc.nextLine());
        List<File> inputFiles = getInputFiles(inputFolder);
        System.out.println(inputFiles);

        // create transcript objects
        Transcript[] transcripts = new Transcript[inputFiles.size()];
        for (int i = 0; i < transcripts.length; i++) {
            transcripts[i] = new Transcript(inputFiles.get(i));
            System.out.println(transcripts[i]);
        }

        //create SRT objects
        SRT[] srt = new SRT[transcripts.length];

        for (int i = 0; i < srt.length; i++) {
            srt[i] = new SRT(transcripts[i]);
            System.out.println(srt[i]);
        }

        //Write output file
        File[] outputFiles = new File[srt.length];
        for (int i = 0; i < outputFiles.length; i++) {
            File currentInputFile = inputFiles.get(i);
            String output = currentInputFile.getParentFile() + File.separator + currentInputFile.getName().replace("txt", "srt");
            outputFiles[i] = new File(output);
            try {
                FileWriter writer = new FileWriter(outputFiles[i], false);
                writer.write(srt[i].toString());
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }



    public static ArrayList<File> getInputFiles(File inputFolder) {
        ArrayList<File> inputFiles = new ArrayList<>();
        File[] children = inputFolder.listFiles();
        assert children != null;
        for (File child : children) {
            if (child.isDirectory()) {
                inputFiles.addAll(getInputFiles(child));
            } else {
                if (child.getName().endsWith(".txt")) {
                    inputFiles.add(child);
                }
            }
        }
        return inputFiles;
    }
}
