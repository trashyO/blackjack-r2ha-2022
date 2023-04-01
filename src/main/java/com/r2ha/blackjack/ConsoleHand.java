package com.r2ha.blackjack;

import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class ConsoleHand {
    public static Card dealerFaceUpCard(Hand hand) {
        return hand.cards().get(0);
    }

    public static String cardAsString(Hand hand) {
        return hand.cards().stream()
                   .map(ConsoleCard::display)
                   .collect(Collectors.joining(
                            ansi().cursorUp(6).cursorRight(1).toString()));
    }

    public static String displayValue(Hand hand) {
        return String.valueOf(hand.value());
    }
}
