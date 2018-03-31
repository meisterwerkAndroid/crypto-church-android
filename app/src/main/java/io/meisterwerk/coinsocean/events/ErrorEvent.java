package io.meisterwerk.coinsocean.events;

/**
 * Created by xdev on 05.02.18.
 */

public class ErrorEvent {

    private String message;

    public ErrorEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
