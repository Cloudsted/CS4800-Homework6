import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ChatServer server = new ChatServer();

        User alice = new User("Alice", server);
        User bob = new User("Bob", server);
        User charlie = new User("Charlie", server);

        server.registerUser(alice);
        server.registerUser(bob);
        server.registerUser(charlie);

        alice.sendMessage(new String[] {"Bob", "Charlie"}, "Hello everyone!");
        bob.sendMessage(new String[] {"Alice"}, "Hello Alice!");
        charlie.sendMessage(new String[] {"Alice"}, "Hey Alice, how are you?");

        alice.undoLastMessage();

        Iterator<Message> it = alice.iterator(bob);
        while (it.hasNext()) {
            Message message = it.next();
            System.out.println("Iterated message: " + message);
        }
    }
}
