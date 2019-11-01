package game.score;

import javafx.scene.paint.Color;

/**
 * Represent a single scoring peg. There are three possible values:
 * NONE - represents NO peg
 * WHITE - a peg used to indicate there is a correct peg in the wrong position
 * RED - a peg used to indicate there is a correct pg in the correct position
 */
public enum ScorePegEnum {
    NONE("-", Color.BLACK), WHITE("+", Color.WHITE), RED("*", Color.RED);

    /** The individual character to represent each scoring peg */
    private String s;

    private Color color;

    private ScorePegEnum(String s, Color color) { this.s = s; this.color = color; }

    public Color getColor() {
        return color;
    }

    /**
     * @return the string character used to represent the scoring peg
     */
    @Override
    public String toString() { return this.s; }
}
