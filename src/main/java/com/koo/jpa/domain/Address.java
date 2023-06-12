package com.koo.jpa.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable // Member의 가독성을 위한 선택?
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {
    }
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
