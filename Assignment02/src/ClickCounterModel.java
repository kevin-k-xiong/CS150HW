/**
 * Model for counting individual A/B/C clicks and the overall total.
 */
public class ClickCounterModel {

    private int aCount;
    private int bCount;
    private int cCount;
    private static int totalCount;

    /**
     * Increments the A click counter and total click counter.
     *
     * @return updated A click count
     */
    public int incrementA() {
        aCount++;
        totalCount++;
        return aCount;
    }

    /**
     * Increments the B click counter and total click counter.
     *
     * @return updated B click count
     */
    public int incrementB() {
        bCount++;
        totalCount++;
        return bCount;
    }

    /**
     * Increments the C click counter and total click counter.
     *
     * @return updated C click count
     */
    public int incrementC() {
        cCount++;
        totalCount++;
        return cCount;
    }

    /**
     * Returns the current A click count.
     *
     * @return A click count
     */
    public int getACount() {
        return aCount;
    }

    /**
     * Returns the current B click count.
     *
     * @return B click count
     */
    public int getBCount() {
        return bCount;
    }

    /**
     * Returns the current C click count.
     *
     * @return C click count
     */
    public int getCCount() {
        return cCount;
    }

    /**
     * Returns the total number of clicks across all buttons.
     *
     * @return total click count
     */
    public static int getTotalCount() {
        return totalCount;
    }
}
