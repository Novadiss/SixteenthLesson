import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player alfa = new Player(1, "Max", 125);
    Player beta = new Player(2, "Forest", 100);
    Player gamma = new Player(3, "Bull", 140);
    Player delta = new Player(4, "Shark", 110);
    Player epsilon = new Player(5, "Snake", 100);

    @Test
    public void shouldWhenFirstPlayerWin() {
        Game game = new Game();

        game.register(alfa);
        game.register(beta);
        game.register(gamma);
        game.register(delta);
        game.register(epsilon);

        int actual = game.round("Max", "Forest");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWhenSecondPlayerWin() {
        Game game = new Game();

        game.register(alfa);
        game.register(beta);
        game.register(gamma);
        game.register(delta);
        game.register(epsilon);

        int actual = game.round("Shark", "Bull");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWhenPlayersEqual() {
        Game game = new Game();

        game.register(alfa);
        game.register(beta);
        game.register(gamma);
        game.register(delta);
        game.register(epsilon);

        int actual = game.round("Forest", "Snake");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWhenFirstPlayerNotRegistered() {
        Game game = new Game();

        game.register(alfa);
        game.register(beta);
        game.register(gamma);
        game.register(delta);
        game.register(epsilon);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Merlin", "Max"));

    }

    @Test
    public void shouldWhenSecondPlayerNotRegistered() {
        Game game = new Game();

        game.register(alfa);
        game.register(beta);
        game.register(gamma);
        game.register(delta);
        game.register(epsilon);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Bull", "Grek"));

    }
}
