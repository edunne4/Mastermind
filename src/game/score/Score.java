/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 *
 * Name: YOUR NAME
 * Date: 10/4/19
 * Time: 4:59 PM
 *
 * Project: csci205_hw
 * Package: game
 * Class: Score
 * Description:
 *
 * ****************************************
 */

package game.score;

import java.util.Arrays;

/**
 * A complete score, which is a collection of scoring pegs
 *
 * @author brk009
 */
public class Score {
    private ScorePegHolder[] score;
    private int numberOfCodePegs;

    /**
     * Create a Score instance, initialized to NONE pegs.
     *
     * @param numberOfCodePegs the number of code pegs used in the game
     */
    public Score(int numberOfCodePegs) {
        this.numberOfCodePegs = numberOfCodePegs;
        this.score = new ScorePegHolder[numberOfCodePegs];
        for (int i = 0; i < numberOfCodePegs; i++) {
            score[i] = new ScorePegHolder();
        }
        removeAll();
    }

    /**
     * @param i the index position in the score
     * @return the {@link ScorePegEnum} in holder position {@code i} in the score
     */
    public ScorePegEnum getScoringPegAt(int i) { return this.score[i].getPegInHolder();}

    /**
     * Set the {@link ScorePegEnum} to be held in position {@link i}
     * @param i - the position to set the scoring peg
     * @param scorePegEnum - the {@link ScorePegEnum} to set in the score
     */
    public void setScoringPegAt(int i, ScorePegEnum scorePegEnum) {
        this.score[i].setPegInHolder(scorePegEnum);
    }

    /**
     * Empty out the holder by filling all positions with {@link ScorePegEnum#NONE}
     */
    public void removeAll() {
        for (int i = 0; i < numberOfCodePegs; i++) {
            score[i].setPegInHolder(ScorePegEnum.NONE);
        }
    }

    /**
     * @return number of scoring peg holders that are empty
     */
    public int numHoldersEmpty() {
        int count = 0;
        for (int i = 0; i < this.numberOfCodePegs; i++) {
            if (score[i].getPegInHolder() == ScorePegEnum.NONE)
                count++;
        }
        return count;
    }

    /**
     * @return {@code true} if there is an empty place for a scoring peg
     */
    public boolean hasEmpty() {
        return numHoldersEmpty() > 0;
    }

    /**
     * Update the scoring pegs with this a new peg. This will add the peg to the first empty position,
     * otherwise throws an {@link IllegalStateException}
     *
     * This will also ensure that the pegs are maintained in a sorted state
     *
     * @param scorePegEnum is the peg to add to our holder
     * @throws IllegalStateException if the scoring peg was trying to be placed before the holder was
     * properly emptied
     */
    public void addPeg(ScorePegEnum scorePegEnum) {
        if (hasEmpty()) {
            for (int i = 0; i < this.numberOfCodePegs; i++) {
                if (score[i].getPegInHolder() == ScorePegEnum.NONE) {
                    score[i].setPegInHolder(scorePegEnum);
                    sort();
                    return;
                }
            }
        }
        else {
            throw new IllegalStateException("addPeg - No available slot!");
        }
    }

    /**
     * Helper method to keep the scoring pegs in order
     */
    private void sort() {
        Arrays.sort(score, (ScorePegHolder p1, ScorePegHolder p2) -> {
            return Integer.compare(p2.getPegInHolder().ordinal(), p1.getPegInHolder().ordinal());
        });
    }

    /**
     * Does the current score represent a win?
     *
     * @return true if current score is a win, false otherwise
     */
    public boolean isWin() {
        for (ScorePegHolder peg : score) {
            if (peg.getPegInHolder() != ScorePegEnum.RED)
                return false;
        }
        return true;
    }

    /**
     * @return a string representation of this score
     */
    public String scoreToString() {
        String s = "";
        for (int i = 0; i < this.numberOfCodePegs; i++) {
            s += this.score[i].getPegInHolder().toString();
        }
        return s;
    }

    @Override
    public String toString() {
        return "Score{" +
                "score=" + Arrays.toString(score) +
                ", numberOfCodePegs=" + numberOfCodePegs +
                '}';
    }

}
