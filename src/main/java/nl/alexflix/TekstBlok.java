package nl.alexflix;

import java.util.ArrayList;

public class TekstBlok {
    private static final int MAX_LINE_LENGTH = 50;
    private ArrayList<String> lines;
    private String timeString;
    private SRTtimecode tc;
    private String[] dialoog;
    private static int totaalNummer = 0;
    private int uniekNummer;

    public TekstBlok(StringBuilder... lines) {
        this.timeString = lines[0].toString();
        this.tc = new SRTtimecode(this.timeString);
        String regex = "(?<=\\G.{" + MAX_LINE_LENGTH + "})";
        this.dialoog = lines[1].toString().split(regex);
        totaalNummer++;
        this.uniekNummer = totaalNummer;

    }

    private void convertTimeStringToSRT() {

    }

    public void print() {
        System.out.println(uniekNummer);
        System.out.println(tc.getSRTtimecode());
        for (String line : dialoog) {
            System.out.println(line);
        }
        System.out.println();
    }
}
