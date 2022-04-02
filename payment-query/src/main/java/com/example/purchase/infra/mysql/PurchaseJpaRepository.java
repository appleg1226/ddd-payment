package com.example.purchase.infra.mysql;

import com.example.purchase.domain.Purchase;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PurchaseJpaRepository extends CrudRepository<Purchase, String> {

    @Query("select p from Purchase p where p.userId = :userId")
    List<Purchase> findByUserId(@Param("userId") String userId);
}
