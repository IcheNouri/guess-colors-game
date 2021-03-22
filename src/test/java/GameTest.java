import enums.EColor;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void shouldWin() {

        final List<EColor> playedColors = Arrays.asList(EColor.GREEN);
        final List<EColor> expectedColors = Arrays.asList(EColor.GREEN);
        final Game game = new Game(playedColors, expectedColors);

        game.run();
        GameResult gameResult = game.getResult();

        assertTrue(gameResult.won());
    }

    @Test
    public void shouldHaveSameColors() {

        final List<EColor> playedColors = Arrays.asList(EColor.RED, EColor.GREEN);
        final List<EColor> expectedColors = Arrays.asList(EColor.GREEN, EColor.RED);
        final Game game = new Game(playedColors, expectedColors);

        game.run();
        GameResult gameResult = game.getResult();

        assertTrue(gameResult.hasGoodColors());
    }

    @Test
    public void shouldHaveOrderedColors() {

        final List<EColor> playedColors = Arrays.asList(EColor.GREEN, EColor.RED, EColor.WHITE);
        final List<EColor> expectedColors = Arrays.asList(EColor.GREEN, EColor.RED, EColor.WHITE);
        final Game game = new Game(playedColors, expectedColors);

        game.run();
        GameResult gameResult = game.getResult();

        assertTrue(gameResult.hasGoodOrder());
    }

    @Test
    public void shouldCountGoodColors() {

        final List<EColor> playedColors = Arrays.asList(EColor.GREEN, EColor.RED, EColor.RED);
        final List<EColor> expectedColors = Arrays.asList(EColor.GREEN, EColor.RED, EColor.WHITE);
        final Game game = new Game(playedColors, expectedColors);

        game.run();
        GameResult gameResult = game.getResult();

        assertEquals(gameResult.countGoodColors(), 2);
    }

    @Test
    public void shouldCountWellPlacedColors() {

        final List<EColor> playedColors = Arrays.asList(EColor.GREEN, EColor.WHITE, EColor.RED);
        final List<EColor> expectedColors = Arrays.asList(EColor.GREEN, EColor.RED, EColor.WHITE);
        final Game game = new Game(playedColors, expectedColors);

        game.run();
        GameResult gameResult = game.getResult();

        assertEquals(gameResult.countSortedColors(), 1);
    }

    @Test
    public void shouldCountMisplacedColors() {

        final List<EColor> playedColors = Arrays.asList(EColor.GREEN, EColor.RED, EColor.RED, EColor.WHITE);
        final List<EColor> expectedColors = Arrays.asList(EColor.GREEN, EColor.RED, EColor.GREEN, EColor.RED);
        final Game game = new Game(playedColors, expectedColors);

        game.run();
        GameResult gameResult = game.getResult();

        assertEquals(1, gameResult.countMisplacedColors());
    }

}
