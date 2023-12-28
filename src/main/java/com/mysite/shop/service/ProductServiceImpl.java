package com.mysite.shop.service;

import com.mysite.shop.model.Product;
import com.mysite.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements  ProductService{

    private final ProductRepository productRepository;

    //제품을 저장하기
    @Override
    public Product saveProduct(Product product){
        product.setCreateTime(LocalDateTime.now());
        return productRepository.save(product);
    }

    //제품을 삭제하기
    @Override
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    //모든 제품 리스트
    @Override
    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

}
