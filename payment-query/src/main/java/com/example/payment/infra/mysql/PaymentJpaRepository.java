package com.example.payment.infra.mysql;

import com.example.payment.domain.Payment;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PaymentJpaRepository extends CrudRepository<Payment, String> {

    @Query("select p from Payment p where p.userId = :userId")
    List<Payment> findByUserId(@Param("userId") String userId);

}
