public class TradingEngineApp {
    public static void main(String[] args) {
        System.out.println("=== CEP Engine Initialization ===");
        
        // Dynamic Method Overriding & Polymorphic Message Passing
        TradeEvent fixEvent = new FIXOrderEvent("FIX_ADAPTER_01", System.currentTimeMillis(), 1500.00, "ORD_99482");
        TradeEvent reutersEvent = new ReutersQuoteEvent("REUTERS_ADAPTER_02", System.currentTimeMillis(), 1500.00, 1498.50, 1501.25);
        TradeEvent genericEvent = new TradeEvent("GENERIC_GATEWAY", System.currentTimeMillis(), 1000.00);

        // Dispatching events polymorphically
        genericEvent.dispatch();
        fixEvent.dispatch();
        reutersEvent.dispatch();
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
