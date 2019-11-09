/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 *
 * Name: YOUR NAME
 * Date: 10/4/19
 * Time: 4:53 PM
 *
 * Project: csci205_hw
 * Package: game.code
 * Class: CodePegEnnum
 * ****************************************
 */

package Model.code;

import javafx.scene.paint.Color;

/**
 * This enum represents all possible code pegs that could be played in the game. It
 * also includes a NONE value, to allow the {@link CodePegHolder} to have an empty place
 * holder for a peg
 *
 * @author brk009
 */
public enum CodePegEnum {
    NONE("-", Color.BLACK),
    RED("1", Color.RED),
    GREEN("2", Color.GREEN),
    YELLOW("3", Color.YELLOW),
    BLUE("4", Color.BLUE),
    CYAN("5", Color.CYAN),
    ORANGE("6", Color.ORANGE);

    private String symbol;
    /** The color associated with this code peg */
    private Color color;

    /** Constructor to initialize symbol and color associated */
    private CodePegEnum(String symbol, Color color) {
        this.symbol = symbol;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    /**
     * A slick way of quickly getting the string representation for each of
     * our code pegs
     *
     * @return the string representing this peg
     */
    @Override
    public String toString() { return this.symbol; }

    /**
     * Helper method to return a CodePeg enum from the string used
     * to represent the enum, assuming it's valid
     *
     * @param symbol The string representing one CodePeg
     * @return a CodePeg enum constant, or <code>null</code> if the string does not
     * represent a valid enum
     */
    public static CodePegEnum strToCodePeg(String symbol) {
        for(CodePegEnum codePegEnum : CodePegEnum.values()) {
            if (codePegEnum.symbol.equals(symbol))
                return codePegEnum;
        }
        return null;
    }

    /**
     * Helper method to return a {@link CodePegEnum} from a single character
     *
     * @param ch The character representing a single {@link CodePegEnum}
     * @return a {@link CodePegEnum} constant, or {@code null} if the string does not
     * represent a valid enum
     */
    public static CodePegEnum charToCodePeg(char ch) {
        return strToCodePeg("" + ch);
    }

}
