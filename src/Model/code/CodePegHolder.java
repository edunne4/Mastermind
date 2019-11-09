/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 *
 * Name: YOUR NAME
 * Date: 10/18/19
 * Time: 12:14 PM
 *
 * Project: csci205_hw
 * Package: game
 * Class: CodePegHolder
 * Description:
 *
 * ****************************************
 */

package Model.code;

/**
 * This represents a single placeholder to hold a {@link CodePegEnum}
 *
 * @author brk009
 */
public class CodePegHolder {

    /** Stores one {@link Model.code.CodePegEnum} constant */
    private CodePegEnum value;

    /**
     * Initialize the holder to be {@link CodePegEnum#NONE}
     */
    public CodePegHolder() {
        this.value = CodePegEnum.NONE;
    }

    /**
     * @return the {@link Model.code.CodePegEnum} currently in the holder
     */
    public CodePegEnum getPegInHolder() {
        return value;
    }

    /**
     * Place a new peg in the holder
     *
     * @param value is the new {@link Model.code.CodePegEnum to be stored in the holder
     */
    public void setPegInHolder(CodePegEnum value) {
        this.value = value;
    }
}
