package io.payment.payment.PaymentController;

import io.payment.payment.PaymentException.PayNotFoundException;
import io.payment.payment.PaymentModel.Pay;
import io.payment.payment.PaymentRepository.PayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("http://localhost:3000")
public class PayController {
    @Autowired
    private PayRepository payRepository;

    @PostMapping("/payments")
    Pay newPay(@RequestBody Pay newPay){return payRepository.save(newPay);}
    @GetMapping("/allpayments")
    List<Pay> getAllPays(){return payRepository.findAll();}
    @GetMapping("/payments/{id}")
    Pay getPayById(@PathVariable UUID id){
        return payRepository.findById(id)
                .orElseThrow(()->new PayNotFoundException(id));
    }
    @PutMapping("/payments/{id}")
    Pay updatePay(@RequestBody Pay newPay,@PathVariable UUID id){
        return payRepository.findById(id)
                .map(pay ->{
                    pay.setUserid(newPay.getUserid());
                    pay.setAmount(newPay.getAmount());
                    pay.setPaycoin(newPay.getPaycoin());
                    return payRepository.save(pay);
                }).orElseThrow(()-> new PayNotFoundException(id));
    }
    @DeleteMapping("/payments/{id}")
    void deletePay(@PathVariable UUID id){
        payRepository.deleteById(id);
    }



}
