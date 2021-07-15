package com.epam.hogwarts.entity;

import java.util.Arrays;

public class User extends AbstractEntity {

    //todo: can we describe fields as final to guarantee immutability??
    private final String login;
    private final String password;
    private final UserRole role;
    private final String rating;
    private final String name;
    private final String surname;
    private final String email;
    private final byte[] avatar;
    private final String about;
    private double ratingDouble;

    private User(Builder builder) {
        super(builder.userId);
        this.login = builder.login;
        this.password = builder.password;
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

    public String getPassword() {
        return password;
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

    public byte[] getAvatar() {
        return avatar;
    }

    public String getAbout() {
        return about;
    }

    public double getRatingDouble() {
        return ratingDouble;
    }

    public void setRatingDouble(double ratingDouble) {
        this.ratingDouble = ratingDouble;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return login.equals(user.login)
                && password == user.password
                && role == user.role
                && rating.equals(user.rating)
                && name.equals(user.name)
                && surname.equals(user.surname);
    }

    @Override
    public int hashCode() {
        int result = (int) getEntityId();
        result += 31 * result + login.hashCode();
        result += 31 * result + password.hashCode();
        result += 31 * result + role.hashCode();
        result += 31 * result + rating.hashCode();
        result += 31 * result + name.hashCode();
        result += 31 * result + surname.hashCode();
        return result;
    }

    public static class Builder {
        private long userId;
        private String login;
        private String password;
        private UserRole role;
        private String rating;
        private String name;
        private String surname;
        private String email;
        private byte[] avatar;
        private String about;

        public Builder setUserId(Long userId) { //todo do we need to build userId?? (it should be created by sql)
            this.userId = userId;
            return this;
        }

        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
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

        public Builder setAvatar(byte[] avatar) {
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
