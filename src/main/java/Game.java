import enums.EColor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private final List<EColor> playedColors;
    private final List<EColor> expectedColors;
    private GameResult gameResult;
    private Map<EColor, Integer> colorsMap;

    public Game(List<EColor> playedColors, List<EColor> expectedColors) {
        this.playedColors = playedColors;
        this.expectedColors = expectedColors;
    }

    public void run() {
        gameResult = new GameResult(expectedColors.size());
        setColorsMap();
        checkGoodColors();
    }

    private void setColorsMap() {
        colorsMap = new HashMap<>();

        for (EColor expectedColor : expectedColors) {
            Integer value = colorsMap.get(expectedColor) != null ? colorsMap.get(expectedColor) : 0;
            colorsMap.put(expectedColor, ++value);
        }
    }

    private void checkGoodColors() {

        for (int i = 0; i < playedColors.size(); i++) {

            final EColor color = playedColors.get(i);
            final Integer colorCount = colorsMap.get(color);

            if (colorCount == null) {
                continue;
            }

            if (playedColors.get(i) == expectedColors.get(i)) {
                gameResult.incrementSortedColorCount();

            } else if (colorCount > 0) {
                gameResult.incrementMisplacedColors();
            }

            colorsMap.put(color, colorCount - 1);
        }
    }

    public GameResult getResult() {
        return gameResult;
    }
}
