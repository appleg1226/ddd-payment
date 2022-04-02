package com.example.payment;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.example.common.event.DomainEvent;
import com.example.common.event.EventPublisher;
import com.example.payment.domain.Payment;
import com.example.payment.domain.PaymentRepository;
import com.example.payment.infra.http.request.PaymentCompleteRequest;
import com.example.purchase.domain.Purchase;
import com.example.purchase.domain.PurchaseRepository;
import com.example.purchase.domain.PurchaseType;
import com.example.purchase.infra.http.request.PurchaseRequest;
import com.example.user.domain.User;
import com.example.user.domain.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PaymentApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // 주석처리하고 코드에서도 해당 mock을 주석처리 할  경우 메시지 전송이 실제로 이루어짐
    private EventPublisher eventPublisher;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PaymentRepository paymentRepository;

    @MockBean
    private PurchaseRepository purchaseRepository;

    private ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        this.mapper = new ObjectMapper();
    }

    @Test
    void paymentCompleteControllerTest() throws Exception {

        String testUserId = "test-user-id";

        PaymentCompleteRequest request = PaymentCompleteRequest.builder()
                                                               .userId(testUserId)
                                                               .amount(BigDecimal.valueOf(1000))
                                                               .payBy("card")
                                                               .pgId("example-pg")
                                                               .build();
        User actualUser = User.newUser(testUserId);

        Payment payment = Payment.of("example-pg", "card", actualUser, ZonedDateTime.now(), ZonedDateTime.now());

        when(userRepository.getByIdOrDefault(anyString())).thenReturn(actualUser);
        when(userRepository.save(any(User.class))).thenReturn("test-user-id");
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);
        doNothing().when(eventPublisher).publish(any(DomainEvent.class));

        mockMvc.perform(post("/payments/complete")
                            .contentType("application/json")
                            .content(mapper.writeValueAsString(request)))
               .andDo(print())
               .andExpect(content().string(payment.getId()));
    }

    @Test
    void purchaseControllerTest() throws Exception {

        String testUserId = "test-user-id";

        PurchaseRequest request = PurchaseRequest.builder()
                                                 .userId("test-user-id")
                                                 .type(PurchaseType.ITEM)
                                                 .amount(BigDecimal.valueOf(1000))
                                                 .build();

        User newUser = User.newUser(testUserId);
        newUser.increaseBalance(BigDecimal.valueOf(10000));
        Optional<User> actualUser = Optional.of(newUser);

        Purchase purchase = Purchase.of(actualUser.get(), request.getType(), request.getAmount(), ZonedDateTime.now(), ZonedDateTime.now());

        when(userRepository.findById(anyString())).thenReturn(actualUser);
        when(userRepository.save(any(User.class))).thenReturn("test-user-id");
        when(purchaseRepository.save(any(Purchase.class))).thenReturn(purchase);
        doNothing().when(eventPublisher).publish(any(DomainEvent.class));

        mockMvc.perform(post("/purchases")
                            .contentType("application/json")
                            .content(mapper.writeValueAsString(request)))
               .andDo(print())
               .andExpect(content().string(purchase.getId()));
    }

}
