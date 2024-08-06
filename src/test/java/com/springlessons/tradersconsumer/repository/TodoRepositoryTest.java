package com.springlessons.tradersconsumer.repository;

import com.springlessons.tradersconsumer.dto.Trader;
import com.springlessons.tradersconsumer.entity.TraderEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
class TraderRepositoryTest {
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:14-alpine");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    TraderRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
        TraderEntity traderEntity = new TraderEntity();
        traderEntity.setId(UUID.randomUUID().toString());
        traderEntity.setName("Trader");
        traderEntity.setPaymentData("pay");
        traderEntity.setDescriptionData("desc");
        repository.save(traderEntity);
    }

    @Test
    void shouldGetPendingTodos() {
        assertThat(repository.findAll()).hasSize(1);
    }
}