package com.javainuse.controller;

import com.javainuse.model.Employee;
import com.javainuse.model.Product;
import com.javainuse.service.EmployeeService;
import com.javainuse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/add/product", method = RequestMethod.GET)
    public Product addProduct(@RequestParam("name") String name, @RequestParam("code") String code) {
        return productService.createProduct(name, code);
    }

    @RequestMapping(value = "/remove/product", method = RequestMethod.GET)
    public String removeProduct( @RequestParam("code") String code) {
        productService.deleteProduct(code);
        return "Employee removed";
    }

}
