package com.mysite.shop.repository;

import com.mysite.shop.model.Purchase;
import com.mysite.shop.repository.projection.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    //유저의 구매제품 모두를 가져온다. (제품의 이름,가격,구매시간 리스트)
    @Query("select " +
            "prd.name as name, pur.price as price, pur.purchaseTime as purchaseTime " +
            "from Purchase pur left join Product prd on prd.id = pur.productId " +
            "where pur.userId = :userId" )
    List<PurchaseItem> findAllPurchasesOfUser(@Param("userId") Long userId);
}
