package com.example.ioc_di_springbean.classes;

import com.example.ioc_di_springbean.interfaces.SpeechRepository;
import org.springframework.stereotype.Component;

@Component
public class VNSpeechRepository implements SpeechRepository {

    @Override
    public void sayGreeting() {
        System.out.println("Hello");
    }
}
