package hello;

public class Messages
{

    private String speech;
    private int type;
    private Movies payLoad;

    public Movies getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(Movies payLoad) {
        this.payLoad = payLoad;
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