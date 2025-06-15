interface EventHandler {
    void handleEvent();
}

public class EventSystem {

    void registerEvent() {
        class LocalEventHandler implements EventHandler {
            public void handleEvent() {
                System.out.println("Event handled by local inner class");
            }
        }

        EventHandler localHandler = new LocalEventHandler();
        localHandler.handleEvent();
    }

    public static void main(String[] args) {
        EventSystem eventSystem = new EventSystem();
        eventSystem.registerEvent();

        EventHandler anonymousHandler = new EventHandler() {
            public void handleEvent() {
                System.out.println("Event handled by anonymous inner class");
            }
        };
        anonymousHandler.handleEvent();
    }
}

