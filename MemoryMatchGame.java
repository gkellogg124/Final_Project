import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

// Class for creating and managing the Memory Match Game
public class MemoryMatchGame {

    // GridPane to arrange cards in a grid
    private GridPane gridPane;

    // List to hold all card buttons
    private List<Button> cards = new ArrayList<>();

    // To keep track of the currently selected card
    private Button selectedCard = null;

    // Counter for the number of matches made
    private int matchCount = 0;

    // Method to create and return the game content pane
    public Pane createContent() {
        // Initializing the GridPane
        gridPane = new GridPane();

        // Setting up the cards
        initializeCards();

        // Returning the gridPane with all cards
        return gridPane;
    }

    // Method to initialize and shuffle cards
    private void initializeCards() {
        // List to store card values
        List<String> cardValues = new ArrayList<>();

        // Adding pairs of numbers to the list for matching
        for (int i = 1; i <= 18; i++) {
            cardValues.add(String.valueOf(i));
            cardValues.add(String.valueOf(i)); // Duplicate for matching
        }

        // Shuffling the card values
        Collections.shuffle(cardValues);

        // Creating and adding cards to the gridPane
        for (int i = 0; i < 36; i++) {
            Button card = createCard(cardValues.get(i));
            cards.add(card);
            gridPane.add(card, i % 6, i / 6); // Arranging cards in 4x4 grid
        }
    }

    // Method to create a card button
    private Button createCard(String value) {
        // Creating a new button for the card
        Button card = new Button();
        card.setPrefSize(100, 100); // Setting preferred size

        // Setting action on card selection
        card.setOnAction(e -> handleCardSelection(card, value));
        return card;
    }

    // Method to handle card selection logic
    private void handleCardSelection(Button card, String value) {
        // Check if no card is currently selected
        if (selectedCard == null) {
            selectedCard = card;
            card.setText(value); // Show card value
        } else {
            // Handle case where selected card is not the current card
            if (!card.equals(selectedCard)) {
                // Check if the card values match
                if (value.equals(selectedCard.getText())) {
                    card.setText(value);
                    card.setDisable(true);
                    selectedCard.setDisable(true);
                    matchCount++; // Increment match count

                    // Check if all pairs are matched
                    if (matchCount == 8) {
                        System.out.println("Congratulations! You won!");
                    }
                } else {
                    // Case when card values do not match
                    card.setText(value);
                    Button previousCard = selectedCard;
                    selectedCard = null;

                    // Delay flipping back the unmatched cards
                    new Thread(() -> {
                        try {
                            Thread.sleep(500); // Wait for 500 milliseconds
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }

                        // Flipping back the cards
                        previousCard.setText("");
                        try {
                            card.setText("");
                        } catch (Exception ex) {
                            // Handle exception (if any)
                        }
                    }).start();
                }
            }
        }
    }
}
