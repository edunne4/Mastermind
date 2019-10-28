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

package game.code;

/**
 * This enum represents all possible code pegs that could be played in the game. It
 * also includes a NONE value, to allow the {@link CodePegHolder} to have an empty place
 * holder for a peg
 *
 * @author brk009
 */
public enum CodePegEnum {
    NONE("-"),
    RED("1"),
    GREEN("2"),
    YELLOW("3"),
    BLUE("4"),
    CYAN("5"),
    ORANGE("6");

    private String symbol;

    private CodePegEnum(String symbol) {
        this.symbol = symbol;
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
