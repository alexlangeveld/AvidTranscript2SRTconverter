package nl.alexflix.avidTranscript2SRTconverter.SRT;

import nl.alexflix.avidTranscript2SRTconverter.transcript.TranscriptBlock;

public class SRTblock {
    private final int framerate = 25;
    private final String[] content;
    private final int inHours;
    private final int inMinutes;
    private final int inSeconds;
    private final int inMillis;
    private final int outHours;
    private final int outMinutes;
    private final int outSeconds;
    private final int outMillis;
    public SRTblock(TranscriptBlock block){
        this.content = block.getContent();

        this.inHours = block.getInHours();
        this.inMinutes = block.getInMinutes();
        this.inSeconds = block.getInSeconds();
        this.inMillis = (int) ((block.getInFrames() / (double) framerate * 1000));

        this.outHours = block.getOutHours();
        this.outMinutes = block.getOutMinutes();
        this.outSeconds = block.getOutSeconds();
        this.outMillis = (int) ((block.getOutFrames() / (double) framerate * 1000));


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", this.inHours))
                .append(":")
                .append(String.format("%02d", this.inMinutes))
                .append(":")
                .append(String.format("%02d", this.inSeconds))
                .append(",")
                .append(String.format("%03d", this.inMillis));

        sb.append(" --> ");

        sb.append(String.format("%02d", this.outHours))
                .append(":")
                .append(String.format("%02d", this.outMinutes))
                .append(":")
                .append(String.format("%02d", this.outSeconds))
                .append(",")
                .append(String.format("%03d", this.outMillis))
                .append("\n");

        for (String line : content) {
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
    }
}
