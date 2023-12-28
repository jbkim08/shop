package com.mysite.shop.service;


import com.mysite.shop.model.Purchase;
import com.mysite.shop.repository.PurchaseRepository;
import com.mysite.shop.repository.projection.PurchaseItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Override
    public Purchase savePurchase(Purchase purchase){
        purchase.setPurchaseTime(LocalDateTime.now());
        return purchaseRepository.save(purchase);
    }

    @Override
    public List<PurchaseItem> findPurchaseItemsOfUser(Long userId){
        return purchaseRepository.findAllPurchasesOfUser(userId);
    }
}
