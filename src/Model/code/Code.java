/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 *
 * Name: YOUR NAME
 * Date: 10/4/19
 * Time: 4:41 PM
 *
 * Project: csci205_hw
 * Package: PACKAGE_NAME
 * Class: game.RowOfCodePegs
 * Description:
 *
 * ****************************************
 */
package Model.code;

import java.util.Arrays;

/**
 * This is a general class that represents an arbitrary code. A code consists of
 * a sequence of code pegs. In this implementation, a Code is really an abstraction that
 * can store an array of {@link CodePegHolder}, meaning, once a Code is instantiated, then
 * it can exist forever, with individual entries in the code able to be switched by different
 * {@link CodePegEnum} values.
 *
 * @author brk009
 */
public class Code {
    /** Number of pegs in a code, a static value because ALL codes in a game will have the same number of pegs */
    protected static int numPegs;

    /** The row of code peg holders that individually store {@link CodePegHolder} values */
    protected CodePegHolder[] code;

    /**
     * Create a new Code, initialized with each position storing {@link CodePegEnum#NONE}
     * indicating that the code is created with no pegs in place
     */
    public Code(int numPegs) {
        this.numPegs = numPegs;
        this.code = new CodePegHolder[numPegs];
        for (int i = 0; i < numPegs; i++) {
            code[i] = new CodePegHolder();
        }
    }

    /**
     * Update the code instance from a string of symbols representing pegs. The
     * individual character symbols are represented in each {@link CodePegEnum} enum
     *
     * @param s is the String of symbols
     * @return {@code true} if the string was valid, {@code false} otherwise
     */
    public boolean update(String s) {
        if (!strIsValid(s))
            return false;
        for (int i = 0; i < s.length(); i++) {
            CodePegEnum peg = CodePegEnum.charToCodePeg(s.charAt(i));
            code[i].setPegInHolder(peg);
        }
        return true;
    }

    /** Basic getter to return the {@link CodePegEnum} at a specific location in the code */
    public CodePegEnum getPegAt(int i) { return code[i].getPegInHolder(); }

    /**
     * Setter method to set a new peg at a specific position in the code
     *
     * @param i position in the code to change
     * @param peg new {@link CodePegEnum} to place in its position
     */
    public void setPegAt(int i, CodePegEnum peg) { code[i].setPegInHolder(peg); }

    /**
     * Remove a peg by setting the position {@code i} to be {@link CodePegEnum#NONE}
     *
     * @param i remove the peg at index i and set it to NONE
     */
    public void remove(int i) { code[i].setPegInHolder(CodePegEnum.NONE); }

    /**
     * Remove all pegs from the code, setting all code peg holders to store {@link CodePegEnum#NONE}
     */
    public void removeAll() {
        for (int i = 0; i < this.getCodeSize(); i++) {
            remove(i);
        }
    }

    /**
     * Determine if this code contains the specified peg. If it does, return the index
     * of the first occurrence, or return null
     *
     * @param peg to search this code for
     * @return index of first occurrence, or null if not found
     */
    public Integer contains(CodePegEnum peg) {
        for (int i = 0; i < numPegs; i++) {
            if (code[i].getPegInHolder() == peg)
                return i;
        }
        return null;
    }

    /**
     * @return the length of the code
     */
    public int getCodeSize() { return this.code.length; }

    /**
     * Generate a string representing this code using the unique character symbol
     * for each {@link CodePegEnum}
     *
     * @return the String representing this code
     */
    public String codeToString() {
        String s = "";
        for (CodePegHolder pegHolder : this.code) {
            s += pegHolder.getPegInHolder().toString();
        }
        return s;
    }

    /**
     * @return a new Code instance that is contains the same code as this one
     */
    public Code copyOf() {
        Code newCode = new Code(this.numPegs);
        for (int i = 0; i < this.numPegs; i++) {
            newCode.setPegAt(i,this.getPegAt(i));
        }
        return newCode;
    }

    /**
     * Standard equals method to compare this row of pegs to another one. However,
     * this one is altered a bit to allow the other to be any derived class of this
     * class
     *
     * @param o Object being compared
     * @return true if they represent the same Code, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Code)) return false;
        Code that = (Code) o;
        return codeToString().equals(that.codeToString());
    }

    @Override
    public String toString() {
        return "Code{" +
                "numPegs=" + numPegs +
                ", code=" + Arrays.toString(code) +
                '}';
    }

    /**
     * Helper method to validate an arbitrary string representation of a code
     *
     * @param s is the String to check
     * @return {@code true} if {@code s} is valid, {@code false} otherwise
     */
    public static boolean strIsValid(String s) {
        if (s.length() != Code.numPegs)
            return false;
        for (int i = 0; i < s.length(); i++) {
            CodePegEnum peg = CodePegEnum.charToCodePeg(s.charAt(i));
            if (peg == null)
                return false;
        }
        return true;
    }

}
