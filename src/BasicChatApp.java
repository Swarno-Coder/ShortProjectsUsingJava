import java.util.ArrayList;
import java.util.Scanner;

class ChatMessage {
    private String sender;
    private String message;

    public ChatMessage(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    @Override
    public String toString() {
        return sender + ": " + message;
    }
}

public class BasicChatApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ChatMessage> chatLog = new ArrayList<>();

        System.out.println("Welcome to the Basic Chat Application!");

        while (true) {
            System.out.print("Enter your name (or 'quit' to exit): ");
            String sender = scanner.nextLine();

            if (sender.equalsIgnoreCase("quit")) {
                break;
            }

            System.out.println("Start chatting. Type 'exit' to end the chat.");

            while (true) {
                System.out.print(sender + ": ");
                String message = scanner.nextLine();

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                ChatMessage chatMessage = new ChatMessage(sender, message);
                chatLog.add(chatMessage);
            }
        }

        System.out.println("\nChat Log:");
        for (ChatMessage message : chatLog) {
            System.out.println(message);
        }

        scanner.close();
    }
}
