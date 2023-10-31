package com.kenzie.groupwork.phonecontacts.model;

public class Name {

    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("{firstName: %s, lastName: %s}", this.firstName, this.lastName);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private String firstName;
        private String lastName;

        public Builder withFirstName(String first) {
            this.firstName = first;
            return this;
        }

        public Builder withLastName(String last) {
            this.lastName = last;
            return this;
        }

        public Name build() {
            return new Name(firstName, lastName);
        }
    }
}
