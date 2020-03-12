package models;

import java.util.Date;

public class Todo implements Comparable{
    String description;
    Date creation;
    boolean isDone;

    public Todo(String description, Date creation, boolean isDone) {
        this.description = description;
        this.creation = creation;
        this.isDone = isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreation() {
        return creation;
    }

    public boolean isDone() {
        return isDone;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
