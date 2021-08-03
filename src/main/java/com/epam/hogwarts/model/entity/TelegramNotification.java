package com.epam.hogwarts.model.entity;

import com.vdurmont.emoji.EmojiParser;

import java.util.Objects;

public class TelegramNotification extends Notification {
    private String name;
    private String author;
    private int complexity;
    private String description;

    private TelegramNotification(Builder builder) {
        super(builder.notificationId, false, builder.allowableAttempts);
        this.name = builder.name;
        this.author = builder.author;
        this.complexity = builder.complexity;
        this.description = builder.description;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getComplexity() {
        return complexity;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        String smileEmoji = EmojiParser.parseToUnicode(":fire: ");
        final StringBuilder sb = new StringBuilder(smileEmoji);
        sb.append(author);
        sb.append(" создал курс ").append(name);
        sb.append(" со сложностью ").append(complexity).append("\n");
        sb.append(description == null ? "" : description);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TelegramNotification that = (TelegramNotification) o;
        return complexity == that.complexity && name.equals(that.name) && author.equals(that.author) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, author, complexity, description);
    }

    public static class Builder {
        private long notificationId;
        private String name;
        private String author;
        private int complexity;
        private String description;
        private int allowableAttempts;

        public Builder setNotificationId(long notificationId) {
            this.notificationId = notificationId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder setComplexity(int complexity) {
            this.complexity = complexity;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setAllowableAttempts(int allowableAttempts) {
            this.allowableAttempts = allowableAttempts;
            return this;
        }

        public TelegramNotification build() {
            return new TelegramNotification(this);
        }
    }
}
