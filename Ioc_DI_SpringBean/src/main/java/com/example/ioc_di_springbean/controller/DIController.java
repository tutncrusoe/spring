package com.example.ioc_di_springbean.controller;

import com.example.ioc_di_springbean.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DIController {

    /**
     * Spring Beans = <Built-in beans> Ex: @Component @Controller @Service @Repository
     * + <User-defined beans> Ex: @Bean
     *
     * Spring IoC Container se tao doi tuong tu lop Company (vi co @Component)
     * va` nap vao he thong. Vi vay, DIController co the su dung @Autowired de
     * tiem vao` va` su dung.
     */

    /**
     * @Autowired Dua vao` kieu du lieu cua bien de tim kiem va` lien ket den Spring Bean co kieu phu` hop.
     *
     * DI (Dependence Injection = "Tiem cac doi tuong can thiet") la cach thuc
     * lien ket cac Spring Bean vao` cac bien can thiet cua chuong trinh. Ex: @Autowired
     */
    @Autowired // su dung @Primary
    Company company;

    @Autowired
    @Qualifier("bean2")
    Company company2;

    @RequestMapping("test")
    public String test() {
        return company.getName();
    }
}
