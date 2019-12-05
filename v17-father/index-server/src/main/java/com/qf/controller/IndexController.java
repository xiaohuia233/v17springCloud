package com.qf.controller;

import com.qf.entity.Product;
import com.qf.feign.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.print.attribute.standard.PrinterURI;
import java.util.List;

@RestController
@RequestMapping("index")
@Slf4j
public class IndexController {

    @Value("${server.port}")
    private String serverPort;

    private String product_server_url = "http://PRODUCT-SERVICE/product/list";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IProductService productService;

    @RequestMapping("show")
    @ResponseBody
    public List<Product> show(){
        log.info(serverPort);
//        List<Product> list = restTemplate.getForObject(product_server_url, List.class);
        List<Product> list = productService.list();
        return list;
    }
}
