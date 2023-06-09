package org.nng.swdoc.library.mangement;

import org.nng.swdoc.library.domain.Rent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentObservable {
    public enum Event {
        BOOK_RENTED,
        BOOK_RETURNED
    }

    Map<Event, List<RentObserver>> observers = new HashMap<>();

    public RentObservable() {
        for (Event event : Event.values()) {
            observers.put(event, new ArrayList<>());
        }
    }

    public void addRentEventListener(Event event, RentObserver observer) {
        observers.get(event).add(observer);
    }

    public boolean notifyRentEventChange(Context ctx, Event event, Rent rent) {
        boolean result = true;
        for (RentObserver observer : observers.get(event)) {
            result &= observer.onRentEventChange(ctx, rent);
        }
        return result;
    }
}
