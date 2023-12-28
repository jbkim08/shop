package com.mysite.shop.service;

import com.mysite.shop.model.Purchase;
import com.mysite.shop.repository.projection.PurchaseItem;

import java.util.List;

public interface PurchaseService {

    Purchase savePurchase(Purchase purchase);

    List<PurchaseItem> findPurchaseItemsOfUser(Long userId);
}
