package com.kenzie.groupwork.phonecontacts.model;

public class Contact {

    private Name name;
    private String phoneNumber;
    private String email;

    public Contact(Name name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Name getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private Name name;
        private String phoneNumber;
        private String email;

        public Builder withName(Name contactName) {
            this.name = contactName;
            return this;
        }

        public Builder withPhoneNumber(String number) {
            this.phoneNumber = number;
            return this;
        }

        public Builder withEmail(String address) {
            this.email = address;
            return this;
        }

        public Contact build() {
            return new Contact(name, phoneNumber, email);
        }
    }

}
