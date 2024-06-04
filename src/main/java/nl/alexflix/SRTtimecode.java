package nl.alexflix;

public class SRTtimecode {
    private int inUren;
    private int inMinuten;
    private int inSeconden;
    private int inMiliseconden;
    private int uitUren;
    private int uitMinuten;
    private int uitSeconden;
    private int uitMiliseconden;

    public SRTtimecode(String input) {
        inUren = Integer.parseInt(input.substring(0,2));
        inMinuten = Integer.parseInt(input.substring(3,5));
        inSeconden = Integer.parseInt(input.substring(6,8));
        inMiliseconden = (Integer.parseInt(input.substring(9,11))*40);
        uitUren = Integer.parseInt(input.substring(14,16));
        uitMinuten = Integer.parseInt(input.substring(17,19));
        uitSeconden = Integer.parseInt(input.substring(20,22));
        uitMiliseconden = (Integer.parseInt(input.substring(23,25))*40);
    }

    String getSRTtimecode() {
        StringBuilder rtn = new StringBuilder();
        rtn.append(inUren);
        rtn.append(':');
        rtn.append(inMinuten);
        rtn.append(':');
        rtn.append(inSeconden);
        rtn.append(':');
        rtn.append(String.format("%2d", inMiliseconden));

        rtn.append(" --> ");

        rtn.append(uitUren);
        rtn.append(':');
        rtn.append(uitMinuten);
        rtn.append(':');
        rtn.append(uitSeconden);
        rtn.append(':');
        rtn.append(String.format("%2d", uitMiliseconden));

        return rtn.toString();
    }
}
