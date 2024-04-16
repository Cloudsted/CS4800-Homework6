import java.util.Iterator;

public class User implements IterableByUser {
    private String username;
    private ChatServer server;
    private ChatHistory history;

    public User(String username, ChatServer server) {
        this.username = username;
        this.server = server;
        this.history = new ChatHistory();
    }

    public void sendMessage(String[] recipients, String content) {
        Message message = new Message(this.username, recipients, content);
        server.sendMessage(this, message);
        history.addMessage(message);
    }

    public void receiveMessage(Message message) {
        System.out.println("Received by " + this.username + ": " + message);
    }

    public void undoLastMessage() {
        MessageMemento memento = history.saveToMemento();
        server.undoMessage(this, memento);
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return history.iterator(userToSearchWith);
    }

	public String getUsername() {
		return username;
	}

	public ChatServer getServer() {
		return server;
	}

	public ChatHistory getHistory() {
		return history;
	}
}
