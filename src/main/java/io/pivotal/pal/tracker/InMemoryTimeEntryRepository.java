package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private Map<Long, TimeEntry> db = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        long id = db.size() + 1;
        timeEntry.setId(id);
        db.put(id, timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        return db.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(db.values());
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        db.replace(id, timeEntry);
        timeEntry.setId(id);
        return timeEntry;
    }

    @Override
    public void delete(Long id) {
        db.remove(id);
    }
}
