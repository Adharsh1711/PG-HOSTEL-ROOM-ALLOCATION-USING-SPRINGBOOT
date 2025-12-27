package com.examly.springapp.service;

import com.examly.springapp.model.Payment;
import com.examly.springapp.repository.PaymentRepo;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepo paymentRepo;

    // ✅ Constructor injection (removes Sonar warning)
    public PaymentServiceImpl(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    @Override
    @Nullable   // ✅ tells Sonar null is expected
    public Payment getPaymentById(Long id) {
        return paymentRepo.findById(id).orElse(null);
    }

    @Override
    @Nullable   // ✅ tells Sonar null is expected
    public Payment updatePayment(Long id, Payment payment) {
        Payment existing = paymentRepo.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }

        existing.setAmount(payment.getAmount());
        existing.setPaymentDate(payment.getPaymentDate());
        existing.setPaymentMethod(payment.getPaymentMethod());
        existing.setBooking(payment.getBooking());

        return paymentRepo.save(existing);
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepo.deleteById(id);
    }
}
