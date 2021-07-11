package com.epam.hogwarts.entity;

import java.sql.Blob;

public class User extends AbstractEntity {

    //todo: we don't need setters if we use builder, aren't we??
    //todo: can we describe fields as final to guarantee immutability??
    private final String login;
    private final UserRole role;
    private final String rating;
    private final String name;
    private final String surname;
    private final String email;
    private final Blob avatar;
    private final String about;

    private User(Builder builder) {
        super(builder.userId);
        this.login = builder.login;
        this.role = builder.role;
        this.rating = builder.rating;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
        this.avatar = builder.avatar;
        this.about = builder.about;
    }

    public String getLogin() {
        return login;
    }

    public UserRole getRole() {
        return role;
    }

    public String getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public String getAbout() {
        return about;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return rating.equals(user.rating) &&
                login.equals(user.login) &&
                role == user.role &&
                name.equals(user.name) &&
                surname.equals(user.surname) &&
                email.equals(user.email) &&
                avatar.equals(user.avatar) && about.equals(user.about);
    }

    @Override
    public int hashCode() {
        int result = login == null ? 0 : login.hashCode();
        result += 31 * result + role.hashCode();
        result += 31 * result + role.hashCode();
        result += 31 * result + rating.hashCode();
        result += 31 * result + name.hashCode();
        result += 31 * result + surname.hashCode();
        result += 31 * result + email.hashCode();
        result += 31 * result + avatar.hashCode();
        result += 31 * result + about.hashCode();
        return result;
    }

    public static class Builder {
        private long userId;
        private String login;
        private UserRole role;
        private String rating;
        private String name;
        private String surname;
        private String email;
        private Blob avatar;
        private String about;

        public Builder setUserId(Long userId) { //todo do we need to build userId?? (it should be created by sql)
            this.userId = userId;
            return this;
        }

        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder setRole(UserRole role) {
            this.role = role;
            return this;
        }

        public Builder setRating(String rating) {
            this.rating = rating;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAvatar(Blob avatar) {
            this.avatar = avatar;
            return this;
        }

        public Builder setAbout(String about) {
            this.about = about;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
