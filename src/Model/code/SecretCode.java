/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 *
 * Name: YOUR NAME
 * Date: 10/4/19
 * Time: 4:47 PM
 *
 * Project: csci205_hw
 * Package: PACKAGE_NAME
 * Class: game.code.SecretCode
 * Description:
 *
 * ****************************************
 */

package Model.code;

import java.util.Random;

/**
 * Our secret code, which is a type of {@link Code}
 */
public class SecretCode extends Code {
    /**
     * Create a new SecretCode instance at random
     */
    public SecretCode(int numPegs) {
        super(numPegs);
        this.generate();
    }

    /**
     * This is really for multiplayer when we receive a secret code from the other
     * player so we can both compete on the same code
     * @param code
     */
    public SecretCode(Code code) {
        super(code.numPegs);
        for (int i = 0; i < numPegs; i++) {
            this.setPegAt(i,code.getPegAt(i));
        }
    }

    /**
     * Generate a new secret code of randomized {@link CodePegEnum} values to be contained
     * in this code
     */
    public void generate() {
        Random rand = new Random();
        for (int i = 0; i < this.numPegs; i++) {
            CodePegEnum peg;
            do {
                peg = CodePegEnum.values()[rand.nextInt(CodePegEnum.values().length)];
            } while (peg == CodePegEnum.NONE);
            this.setPegAt(i, peg);
        }
    }
}
