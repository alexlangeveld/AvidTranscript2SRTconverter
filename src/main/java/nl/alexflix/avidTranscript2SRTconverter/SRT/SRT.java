package nl.alexflix.avidTranscript2SRTconverter.SRT;

import nl.alexflix.avidTranscript2SRTconverter.transcript.Transcript;


public class SRT {
    private final SRTblock[] blocks;
    public SRT(Transcript transcript) {
        this.blocks = new SRTblock[transcript.getLength()];
        for (int i = 0; i < transcript.getLength(); i++) {
            this.blocks[i] = new SRTblock(transcript.getBlock(i));

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < blocks.length; i++) {
            sb.append((i + 1));
            sb.append("\n");
            sb.append(blocks[i]);
        }
        return sb.toString();
    }





}
