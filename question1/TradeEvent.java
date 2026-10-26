public class TradeEvent {
    protected String senderId;
    protected long timestamp;
    protected double basePrice;

    public TradeEvent(String senderId, long timestamp, double basePrice) {
        this.senderId = senderId;
        this.timestamp = timestamp;
        this.basePrice = basePrice;
    }

    public void dispatch() {
        System.out.println("[GENERIC EVENT] Sender: " + senderId + " | Timestamp: " + timestamp + " | Base Price: $" + basePrice);
    }
}
// Refactor checkpoint 1 for question1 code formatting

// Refactor checkpoint 2 for question1 code formatting

// Refactor checkpoint 3 for question1 code formatting

// Refactor checkpoint 4 for question1 code formatting
