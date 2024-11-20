package co.purrfecthaven.nico.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.purrfecthaven.nico.dto.PaymentsDTO;
import co.purrfecthaven.nico.model.Payments;
import co.purrfecthaven.nico.service.PaymentsService;

/**
 * PaymentsController
 */
@RestController
@RequestMapping("/api/payments")
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

    public PaymentsController(PaymentsService paymentsService){
        this.paymentsService = paymentsService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Payments>> getPayments() {
        try {
            ArrayList<Payments> listPayments = this.paymentsService.getPayments();
            return ResponseEntity.ok(listPayments);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }


    @PostMapping
    public ResponseEntity<?> savePayments(@RequestBody PaymentsDTO paymentsDTO){
        try {
            Payments createdPayments = this.paymentsService.createPayment(paymentsDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPayments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acceso no autorizado");
        }
    }



}
