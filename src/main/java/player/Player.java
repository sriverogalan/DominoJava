package player;
import card.Card;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Player {
    private int id;
    private String name;
    private String color;
    @Getter public List<Card> hand = new ArrayList<>();
    private int points = 0;
    @Getter public boolean isBOT;

    public Player(String name, String color, boolean isBOT) {
        this.name = name;
        this.color = color;
        this.isBOT = isBOT;
    }

    public void addCard(Card card) {
        hand.add(card);
    }
    public void removeCard(Card card) {
        hand.remove(card);
    }
    public boolean isEmptyHand() {
        return hand.isEmpty();
    }
    public void displayHand() {
        int counter = 1;
        for (Card card : hand) {
            System.out.print(counter++ + ". " + card.toString()+ " ");
        }
    }
}