package com.koo.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private  Long id;

    private String name;

    // 내장타입인지 확인하기 위한
    // Address에 있으면 굳이 Embedded를 작성 안해도 되지만 가독성을 위한 선택
    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
