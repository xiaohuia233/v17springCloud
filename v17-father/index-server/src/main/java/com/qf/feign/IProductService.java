package com.qf.feign;

import com.qf.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "PRODUCT-SERVICE", fallback = IProductService.ProduductServiceFallback.class)
public interface IProductService {
    @GetMapping("product/list")
    public List<Product> list();

    @Component
    @Slf4j
    static class ProduductServiceFallback implements IProductService{
        @Override
        public List<Product> list() {
            log.info("调用product-service出现问题，进入熔断的处理方案...");
            List<Product> list = new ArrayList<>();
            return list;
        }
    }
}
