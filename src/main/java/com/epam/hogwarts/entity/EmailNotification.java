package com.epam.hogwarts.entity;

import java.util.Objects;

public class EmailNotification extends Notification {
    private long userId;
    private String text;
    private String subject;
    private String email;
    private String token;
    private String locale;

    public EmailNotification(Builder builder) {
        super(builder.notificationId, false, builder.allowableAttempts);
        this.userId = builder.userId;
        this.text = builder.text;
        this.subject = builder.subject;
        this.email = builder.email;
        this.token = builder.token;
        this.locale = builder.locale;
    }

    public long getUserId() {
        return userId;
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

    public String getToken() {
        return token;
    }

    public String getLocale() {
        return locale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EmailNotification that = (EmailNotification) o;
        return text.equals(that.text) && subject.equals(that.subject) && email.equals(that.email) && token.equals(that.token) && locale.equals(that.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), text, subject, email, token, locale);
    }

    public static class Builder {
        private long notificationId;
        private long userId;
        private String text;
        private String subject;
        private String email;
        private String token;
        private String locale;
        private int allowableAttempts;

        public Builder setNotificationId(long notificationId) {
            this.notificationId = notificationId;
            return this;
        }

        public Builder setUserId(long userId) {
            this.userId = userId;
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

        public Builder setToken(String token) {
            this.token = token;
            return this;
        }

        public Builder setLocale(String locale) {
            this.locale = locale;
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
