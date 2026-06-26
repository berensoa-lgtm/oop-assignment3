package level;
import level.EventListener;

import java.util.List;

public class EventManager {

    private List<EventListener> listeners = new ArrayList<>();

    public void addListener(EventListener l) {
        listeners.add(l);
    }

    public void publish(String msg) {
        for (EventListener l : listeners)
            l.onEvent(msg);
    }
}