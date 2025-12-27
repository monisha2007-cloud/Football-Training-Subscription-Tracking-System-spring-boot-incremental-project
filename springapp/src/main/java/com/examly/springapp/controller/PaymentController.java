package com.examly.springapp.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.model.Payment;
@RestController
@RequestMapping("/api/payments")   
public class PaymentController {

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return null;
    }
}