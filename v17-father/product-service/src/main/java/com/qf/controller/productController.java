package com.qf.controller;

import com.qf.entity.Product;
import com.qf.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
@Slf4j
public class productController {
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    public IProductService productService;

    @GetMapping("list")
    public List<Product> list(){
        log.info(serverPort);
        return productService.list();
    }
}
