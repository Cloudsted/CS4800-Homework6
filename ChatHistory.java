import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistory implements IterableByUser {
    private List<Message> messages = new ArrayList<>();

    public void addMessage(Message message) {
        messages.add(message);
    }

    public Message getLastMessage() {
        if (!messages.isEmpty()) {
            return messages.get(messages.size() - 1);
        }
        return null;
    }

    public MessageMemento saveToMemento() {
        Message lastMessage = getLastMessage();
        if (lastMessage != null) {
            return new MessageMemento(lastMessage.getContent(), lastMessage.getTimestamp());
        }
        return null;
    }

    public void restoreFromMemento(MessageMemento memento) {
        if (memento != null) {
            Message lastMessage = getLastMessage();
            if (lastMessage != null && lastMessage.getTimestamp().equals(memento.getTimestamp())) {
                messages.remove(lastMessage);
            }
        }
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return new searchMessagesByUser(userToSearchWith, messages);
    }
}
