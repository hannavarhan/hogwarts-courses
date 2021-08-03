package com.epam.hogwarts.model.entity;

import java.util.Objects;

public class EmailNotification extends Notification {
    private String text;
    private String subject;
    private String email;

    public EmailNotification(Builder builder) {
        super(builder.notificationId, false, builder.allowableAttempts);
        this.text = builder.text;
        this.subject = builder.subject;
        this.email = builder.email;
    }

    public String getText() {
        return text;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EmailNotification that = (EmailNotification) o;
        return text.equals(that.text) && subject.equals(that.subject) && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), text, subject, email);
    }

    public static class Builder {
        private long notificationId;
        private String text;
        private String subject;
        private String email;
        private int allowableAttempts;

        public Builder setNotificationId(long notificationId) {
            this.notificationId = notificationId;
            return this;
        }

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        public Builder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAllowableAttempts(int allowableAttempts) {
            this.allowableAttempts = allowableAttempts;
            return this;
        }

        public EmailNotification build() {
            return new EmailNotification(this);
        }

    }
}
