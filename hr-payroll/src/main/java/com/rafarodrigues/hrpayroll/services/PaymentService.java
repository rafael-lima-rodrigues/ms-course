package com.rafarodrigues.hrpayroll.services;

import com.rafarodrigues.hrpayroll.entities.Payment;
import com.rafarodrigues.hrpayroll.entities.Worker;
import com.rafarodrigues.hrpayroll.feignClient.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {
        Worker worker = workerFeignClient.findbyId(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
