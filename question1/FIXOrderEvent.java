public class FIXOrderEvent extends TradeEvent {
    private String clOrdId;

    public FIXOrderEvent(String senderId, long timestamp, double basePrice, String clOrdId) {
        super(senderId, timestamp, basePrice);
        this.clOrdId = clOrdId;
    }

    @Override
    public void dispatch() {
        double fee = basePrice * 0.0015; // 0.15% transaction fee
        double totalPrice = basePrice + fee;
        System.out.printf("[FIX ORDER EVENT] Client Order ID: %s | Sender: %s | Base Price: $%.2f | Transaction Fee (0.15%%): $%.2f | Total Executed: $%.2f%n",
                clOrdId, senderId, basePrice, fee, totalPrice);
    }
}
// Refactor checkpoint 1 for question1 code formatting

// Refactor checkpoint 2 for question1 code formatting

// Refactor checkpoint 3 for question1 code formatting

// Refactor checkpoint 4 for question1 code formatting

// Refactor checkpoint 5 for question1 code formatting

// Refactor checkpoint 1 for question1 code formatting

// Refactor checkpoint 2 for question1 code formatting

// Refactor checkpoint 3 for question1 code formatting

// Refactor checkpoint 4 for question1 code formatting

// Refactor checkpoint 5 for question1 code formatting

// Refactor checkpoint 1 for question1 code formatting

// Refactor checkpoint 2 for question1 code formatting

// Refactor checkpoint 3 for question1 code formatting
