import java.util.HashMap;
import java.util.Map;

public class ChatServer {
    private Map<String, User> users = new HashMap<>();

    public void registerUser(User user) {
        users.put(user.getUsername(), user);
    }

    public void unregisterUser(User user) {
        users.remove(user.getUsername());
    }

    public void sendMessage(User sender, Message message) {
        for (String recipient : message.getRecipients()) {
            if (users.containsKey(recipient)) {
                users.get(recipient).receiveMessage(message);
            }
        }
    }

    public void undoMessage(User sender, MessageMemento memento) {
        if (memento != null) {
            Message toUndo = new Message(sender.getUsername(), null, memento.getContent());
        }
    }
}
