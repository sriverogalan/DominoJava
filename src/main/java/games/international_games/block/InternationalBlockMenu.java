package games.international_games.block;

import card.Card;
import games.DominoMenu;
import player.Player;
import player.PlayerManager;
import utils.Colors;
import utils.Text;

public class InternationalBlockMenu extends DominoMenu {
    private static final InternationalBlockGame game = new InternationalBlockGame();
    private static boolean isFirstPutBoard = true;
    public static void start() {
        Text.separator();
        Text.startInternationalBlockGame();
        PlayerManager.addPlayer(new Player(scanner.next(), Colors.getRandomColor()));
        choosePlayersMode();
        game.start();
    }
    public static void chooseWhatYouWantToDo(Player player) {
        Text.separator();
        game.printBoard();
        player.displayHand();
        Text.chooseWhatYouWantToDoInternationalBlockGame(player);
        switch (scanner.nextInt()) {
            case 1 -> playCard(player);
            case 2 -> Text.step(player);
            default -> {
                Text.wrongInput();
                chooseWhatYouWantToDo(player);
            }
        }
    }
    public static void playCard(Player player) {
        Card card = chooseCard(player);
        if (isFirstPutBoard){
            game.firstPutBoard(player, card);
            isFirstPutBoard = false;
        } else {
            Text.chooseLeftOrRight(card);
            switch (scanner.nextInt()) {
                case 1 -> game.putCardLeft(player, card);
                case 2 -> game.putCardRight(player, card);
                default -> {
                    Text.wrongInput();
                    chooseWhatYouWantToDo(player);
                }
            }
        }
    }
}
