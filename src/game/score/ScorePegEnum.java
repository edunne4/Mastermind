package game.score;

/**
 * Represent a single scoring peg. There are three possible values:
 * NONE - represents NO peg
 * WHITE - a peg used to indicate there is a correct peg in the wrong position
 * RED - a peg used to indicate there is a correct pg in the correct position
 */
public enum ScorePegEnum {
    NONE("-"), WHITE("+"), RED("*");

    /** The individual character to represent each scoring peg */
    private String s;

    private ScorePegEnum(String s) { this.s = s; }

    /**
     * @return the string character used to represent the scoring peg
     */
    @Override
    public String toString() { return this.s; }
}
