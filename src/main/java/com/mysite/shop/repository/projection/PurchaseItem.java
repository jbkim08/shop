package com.mysite.shop.repository.projection;

import java.time.LocalDateTime;

//Select절에서 조회할 대상을 지정(이름, 가격, 구매시간)을 한꺼번에
public interface PurchaseItem {
    String getName();
    Integer getPrice();
    LocalDateTime getPurchaseTime();
}
