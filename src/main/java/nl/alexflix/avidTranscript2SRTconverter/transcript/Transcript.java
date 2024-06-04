package nl.alexflix.avidTranscript2SRTconverter.transcript;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Transcript {
    private final TranscriptBlock[] blocks;

    private String project;
    private String clipName;


    public Transcript(File inputFile) {
        try {
            Scanner scanner = new Scanner(new FileReader(inputFile));
            ArrayList<String> content = new ArrayList<>();
            ArrayList<TranscriptBlock> blocks = new ArrayList<>();
            while (scanner.hasNextLine()) {
                content.add(scanner.nextLine());
            }
            String[] rawContent = content.toArray(new String[0]);

            for (int i = 0; i < rawContent.length; i++) {
                String currentLine = rawContent[i];
                String pattern = "^\\d{2}:\\d{2}:\\d{2}:\\d{2} - \\d{2}:\\d{2}:\\d{2}:\\d{2}$";
                if (currentLine.matches(pattern)) {
                    blocks.add(new TranscriptBlock(currentLine.substring(0, 11), currentLine.substring(14, 25), rawContent[i+1]));
                }
                else if (currentLine.startsWith("Project: ")) {
                    project = currentLine.replace("Project: ", "");
                }
                else if (currentLine.startsWith("Clip Name: ")) {
                    clipName = currentLine.replace("Clip Name: ", "");
                }

            }
            this.blocks =  blocks.toArray(new TranscriptBlock[0]);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int getLength() {
        return blocks.length;
    }

    public TranscriptBlock getBlock(int i) {
        return blocks[i];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Project: ");
        sb.append(project);
        sb.append("\n");
        sb.append("Clip Name: ");
        sb.append(clipName);
        sb.append("\n\n");
        for (TranscriptBlock block : blocks) {
            sb.append(block.toString());

        }
        return sb.toString();
    }
}
