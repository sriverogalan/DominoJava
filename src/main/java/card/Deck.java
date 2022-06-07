package card;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Deck {
    private List<Card> cards = new ArrayList<>();
    public Deck() {
        int counter = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (j >= counter){
                    cards.add(new Card(i, j));
                }
            }
            counter++;
        }
        Collections.shuffle(cards);
    }



}
