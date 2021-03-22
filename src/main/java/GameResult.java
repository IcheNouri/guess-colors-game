public class GameResult {

    private int sortedColorsCount;
    private int misplacedColorsCount;
    private final int expectedSize;

    public GameResult(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    public boolean won() {
        return hasGoodColors() && hasGoodOrder();
    }

    public boolean hasGoodColors() {
        return sortedColorsCount + misplacedColorsCount == expectedSize;
    }

    public boolean hasGoodOrder() {
        return sortedColorsCount == expectedSize;
    }

    public int countGoodColors() {
        return sortedColorsCount + misplacedColorsCount;
    }

    public int countSortedColors() {
        return sortedColorsCount;
    }

    public int countMisplacedColors() {
        return misplacedColorsCount;
    }

    public void incrementSortedColorCount() {
        sortedColorsCount++;
    }

    public void incrementMisplacedColors() {
        misplacedColorsCount++;
    }
}
