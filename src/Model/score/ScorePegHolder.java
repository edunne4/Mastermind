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
 * Class: ScorePegHolder
 * Description:
 *
 * ****************************************
 */

package Model.score;

/**
 * A placeholder to store a scoring peg {@link ScorePegEnum}
 */
public class ScorePegHolder {
    /** Current {@link Model.score.ScorePegEnum being stored */
    private ScorePegEnum value;

    /**
     * Initialize a new scoring peg holder, initialized with {@link ScorePegEnum#NONE}
     */
    public ScorePegHolder() {
        this.value = ScorePegEnum.NONE;
    }

    /**
     * @return the current peg being stored in the peg holder
     */
    public ScorePegEnum getPegInHolder() {
        return value;
    }

    /**
     * Set a new {@link ScorePegEnum} in the holder}
     * @param value is the new {@link ScorePegEnum} being stored
     */
    public void setPegInHolder(ScorePegEnum value) {
        this.value = value;
    }

}
