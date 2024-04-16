import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class searchMessagesByUser implements Iterator<Message> {
    private Iterator<Message> iterator;
    private User userToSearchWith;
    private Message nextMessage;
    private boolean hasNextCalled = false;

    public searchMessagesByUser(User userToSearchWith, List<Message> messages) {
        this.userToSearchWith = userToSearchWith;
        this.iterator = messages.iterator();
    }

    @Override
    public boolean hasNext() {
        if (hasNextCalled) {
            return nextMessage != null;
        }
        hasNextCalled = true;
        while (iterator.hasNext()) {
            Message current = iterator.next();
            if (current.getSender().equals(userToSearchWith.getUsername()) || 
            		recipientsContainsUsername(current.getRecipients(), userToSearchWith.getUsername())) {
                nextMessage = current;
                return true;
            }
        }
        nextMessage = null;
        return false;
    }

    @Override
    public Message next() {
        if (!hasNextCalled || nextMessage == null) {
            throw new NoSuchElementException();
        }
        hasNextCalled = false;
        return nextMessage;
    }
    
    private boolean recipientsContainsUsername(String[] recipients, String username) {
    	for(String recipientUsername : recipients) {
    		if(recipientUsername.equals(username)) {
    			return true;
    		}
    	}
    	
    	return false;
    }
}
