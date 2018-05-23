package hello;

public class Messages
{

    private String speech;
    private int type;
    private Movies payload;

    public Movies getPayload() {
        return payload;
    }

    public void setPayload(Movies payload) {
        this.payload = payload;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }
}