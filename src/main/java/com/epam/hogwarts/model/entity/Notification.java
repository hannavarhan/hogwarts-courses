package com.epam.hogwarts.model.entity;

import java.util.Objects;

public abstract class Notification {

    private long notificationId;
    private boolean isSend;
    private int allowableAttempts = 5;

    public Notification(long notificationId, boolean isSend, int allowableAttempts) {
        this.notificationId = notificationId;
        this.isSend = isSend;
        this.allowableAttempts = allowableAttempts;
    }

    public long getNotificationId() {
        return notificationId;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }

    public int getAllowableAttempts() {
        return allowableAttempts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return notificationId == that.notificationId && isSend == that.isSend && allowableAttempts == that.allowableAttempts;
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationId, isSend, allowableAttempts);
    }
}
