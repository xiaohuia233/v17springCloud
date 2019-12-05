package com.qf.service.impl;

import com.qf.entity.Product;
import com.qf.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Override
    public List<Product> list() {
        List<Product> list = new ArrayList<Product>();
        list.add(new Product(1L,"坚持", 99999L));
        list.add(new Product(2L, "加油", 999999999L));
        return list;
    }
}
