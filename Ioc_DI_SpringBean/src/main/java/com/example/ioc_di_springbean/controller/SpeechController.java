package com.example.ioc_di_springbean.controller;

import com.example.ioc_di_springbean.interfaces.SpeechRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpeechController {

    /**
     * Mac dinh khi khai bao mot bean bang cach cau hinh hoac annotation
     * thi bean se duoc tao ra mot doi tuong duy nhat (singleton)
     * va duoc nap vao` he thong ngay tu dau
     * va phuc vu cho toan ung dung.
     *
     * Spring cung cap mot so annotation cho phep khai bao bean de yeu cau he thong
     * nap va quan ly vong` doi cua chung.
     */
    @Autowired
    SpeechRepository speechRepository;


    @GetMapping("/speech/hello")
    public void hello() {

        /**
         * user sayGreeting() in VNSpeech
         */
        speechRepository.sayGreeting();
    }
}
