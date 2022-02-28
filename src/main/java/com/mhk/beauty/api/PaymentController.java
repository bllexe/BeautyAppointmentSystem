package com.mhk.beauty.api;

import com.mhk.beauty.entity.Payment;
import com.mhk.beauty.service.ClientService;
import com.mhk.beauty.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentController {

  private final ClientService clientService;
  private final PaymentService paymentService;


  public PaymentController(ClientService clientService, PaymentService paymentService) {
    this.clientService = clientService;
    this.paymentService = paymentService;
  }


  @PostMapping("/save/{treatmentId}")
  public ResponseEntity<Payment> savePayment(@PathVariable Long treatmentId, @RequestBody Payment payment) {
    return ResponseEntity.ok(paymentService.save(treatmentId, payment));
  }

}
