package nl.alexflix.avidTranscript2SRTconverter.transcript;

import java.util.ArrayList;
import java.util.Collections;

public class TranscriptBlock {
    private final String TCin;
    private final String TCout;
    private final String[] content;
    private final int maxLineWith = 40;

    private final int inHours;
    private final int inMinutes;
    private final int inSeconds;
    private final int inFrames;
    private final int outHours;
    private final int outMinutes;
    private final int outSeconds;
    private final int outFrames;
    public TranscriptBlock(String TCin, String TCout, String content) {
        this.TCin = TCin;
        this.TCout = TCout;

        this.content = generateContent(content);
        String[] parts = TCin.split(":");
        this.inHours = Integer.parseInt(parts[0]);
        this.inMinutes = Integer.parseInt(parts[1]);
        this.inSeconds = Integer.parseInt(parts[2]);
        this.inFrames = Integer.parseInt(parts[3]);
        
        parts = TCout.split(":");
        this.outHours = Integer.parseInt(parts[0]);
        this.outMinutes = Integer.parseInt(parts[1]);
        this.outSeconds = Integer.parseInt(parts[2]);
        this.outFrames = Integer.parseInt(parts[3]);

    }

    private String[] generateContent(String content) {

        ArrayList<String> rtn = new ArrayList<>();

            int spaceIndex = content.indexOf(" ", maxLineWith);
            if (spaceIndex > 0) {
                rtn.add(content.substring(0, spaceIndex));
                Collections.addAll(rtn, generateContent(content.substring(spaceIndex).trim()));
            } else rtn.add(content + "\n");


        return rtn.toArray(new String[0]);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append(this.TCin)
                .append(" - ")
                .append(this.TCout)
                .append("\n");
        for (String line : content) {
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();

    }


    public String[] getContent() {
        return content;
    }

    public int getInHours() {
        return inHours;
    }

    public int getInMinutes() {
        return inMinutes;
    }

    public int getInSeconds() {
        return inSeconds;
    }

    public int getInFrames() {
        return inFrames;
    }

    public int getOutHours() {
        return outHours;
    }

    public int getOutMinutes() {
        return outMinutes;
    }

    public int getOutSeconds() {
        return outSeconds;
    }

    public int getOutFrames() {
        return outFrames;
    }
}
