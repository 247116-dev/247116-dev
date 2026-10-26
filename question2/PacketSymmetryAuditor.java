import java.util.Scanner;

public class PacketSymmetryAuditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Raw Network Packet Payload: ");
        String payload = scanner.nextLine();
        
        int length = payload.length();
        TransactionStack stack = new TransactionStack(length);
        RequestQueue queue = new RequestQueue(length);

        // Ingest characters into stack and queue concurrently
        for (int i = 0; i < length; i++) {
            char c = payload.charAt(i);
            stack.push(c);
            queue.enqueue(c);
        }

        boolean isSymmetric = true;

        // Verify bi-directional payload symmetry
        while (!stack.isEmpty() && !queue.isEmpty()) {
            char fromStack = stack.pop();
            char fromQueue = queue.dequeue();
            if (fromStack != fromQueue) {
                isSymmetric = false;
                break;
            }
        }

        System.out.println("\n=== AUDIT TERMINAL LOG ===");
        System.out.println("Ingested Payload: " + payload);
        if (isSymmetric) {
            System.out.println("Status: [VERIFIED] Packet exhibits bi-directional symmetry (Valid Palindrome Signature).");
        } else {
            System.out.println("Status: [REJECTED] Packet fails bi-directional symmetry check.");
        }
        scanner.close();
    }
}

// Refactor checkpoint 1 for question2 code formatting
