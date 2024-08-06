package com.springlessons.tradersconsumer.repository;

import com.springlessons.tradersconsumer.entity.TraderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraderRepository extends JpaRepository<TraderEntity, String> {
}
