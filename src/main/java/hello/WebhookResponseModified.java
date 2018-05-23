package hello;

public class WebhookResponseModified {
    private final String speech;
    private final String displayText;
    private Messages[] messages;

    public Messages[] getMessages() {
        return messages;
    }

    public void setMessages(Messages[] messages) {
        this.messages = messages;
    }

    private final String source = "java-webhook";
    private  String test;

    public WebhookResponseModified(String speech, String displayText) {
        this.speech = speech;
        this.displayText = displayText;
    }

    public String getSpeech() {
        return speech;
    }

    public String getDisplayText() {
        return displayText;
    }

    public String getSource() {
        return source;
    }

    public String getTest() {
        return test;
    }
}
