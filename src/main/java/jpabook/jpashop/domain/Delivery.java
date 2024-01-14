package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.order.Order;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)    //읽기 전용 -> 거울
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)    //기본은 ORDINAL인데, 이는 숫자로 지정하는 것 -> String 으로 해줘야 다른게 추가될 때 오류가 발생X
    private DeliveryStatus status; //배송 상태 [READY, COMP]
}
