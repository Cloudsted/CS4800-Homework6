import java.time.LocalDateTime;

public class Message {
    private String sender;
    private String[] recipients;
    private LocalDateTime timestamp;
    private String content;

    public Message(String sender, String[] recipients, String content) {
        this.sender = sender;
        this.recipients = recipients;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public String getSender() {
        return sender;
    }

    public String[] getRecipients() {
        return recipients;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "From: " + sender + ", Message: " + content + ", At: " + timestamp;
    }
}
