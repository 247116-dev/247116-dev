public class ReutersQuoteEvent extends TradeEvent {
    private double bidPrice;
    private double askPrice;

    public ReutersQuoteEvent(String senderId, long timestamp, double basePrice, double bidPrice, double askPrice) {
        super(senderId, timestamp, basePrice);
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
    }

    @Override
    public void dispatch() {
        double spread = askPrice - bidPrice;
        System.out.printf("[REUTERS QUOTE EVENT] Sender: %s | Timestamp: %d | Bid: $%.2f | Ask: $%.2f | Bid-Ask Spread: $%.2f%n",
                senderId, timestamp, bidPrice, askPrice, spread);
    }
}
// Refactor checkpoint 1 for question1 code formatting

// Refactor checkpoint 2 for question1 code formatting

// Refactor checkpoint 3 for question1 code formatting

// Refactor checkpoint 4 for question1 code formatting

// Refactor checkpoint 5 for question1 code formatting

// Refactor checkpoint 1 for question1 code formatting

// Refactor checkpoint 2 for question1 code formatting
