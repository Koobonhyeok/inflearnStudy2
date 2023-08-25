package com.koo.jpa.domain.item;

import com.koo.jpa.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // SINGLE_TABLE로 설정시 Item을 extends를 한게 한개의 테이블로 생성
@Getter @Setter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private  int stockQuantity;

    /**
     * stock 증가
     */
    public void addStock( int quantity ){
        this.stockQuantity += quantity;
    }

    /**
     * stock 감소
     */
    public void removeStock( int quantity ){
        int restStock = this.stockQuantity - quantity;
        if( restStock < 0 ){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }

}
