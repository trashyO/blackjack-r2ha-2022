package com.r2ha.blackjack;

import com.r2ha.blackjack.Card;
import com.r2ha.blackjack.ConsoleCard;
import com.r2ha.blackjack.Rank;
import com.r2ha.blackjack.Suit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fusesource.jansi.Ansi.ansi;

public class CardDisplayTest {
    private static final Suit DUMMY_SUIT = Suit.HEARTS;
    private static final Rank DUMMY_RANK = Rank.TEN;

    @Test
    public void withDisplayTenAsString() throws Exception {
        Card card = new Card(DUMMY_SUIT, DUMMY_RANK);

        assertThat(ConsoleCard.display(card))
                .isEqualTo("[31m┌─────────┐[1B[11D│10       │[1B[11D│         │[1B[11D│    ♥    │[1B[11D│         │[1B[11D│       10│[1B[11D└─────────┘");
    }

    @Test
    public void withDisplayNonTenAsString() throws Exception {
        Card card = new Card(DUMMY_SUIT, Rank.SEVEN);

        assertThat(ConsoleCard.display(card))
                .isEqualTo("[31m┌─────────┐[1B[11D│7        │[1B[11D│         │[1B[11D│    ♥    │[1B[11D│         │[1B[11D│        7│[1B[11D└─────────┘");
    }


    @Test
    public void suitOfClubsAndSpadesIsDisplayedInBlack() throws Exception {
        // given a card with Hearts or Diamonds
        Card clubsCard = new Card(Suit.CLUBS, DUMMY_RANK);
        Card spadesCard = new Card(Suit.SPADES, DUMMY_RANK);

        // when we ask for its display representation
        String ansiBlackString = ansi().fgBlack().toString();

        // then we expect a red color ansi sequence
        assertThat(ConsoleCard.display(clubsCard))
                .contains(ansiBlackString);
        assertThat(ConsoleCard.display(spadesCard))
                .contains(ansiBlackString);
    }

}
