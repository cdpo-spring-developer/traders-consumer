package com.springlessons.tradersconsumer.service.database;

import com.springlessons.tradersconsumer.dto.Trader;
import com.springlessons.tradersconsumer.entity.TraderEntity;
import com.springlessons.tradersconsumer.repository.TraderRepository;
import org.springframework.stereotype.Service;

@Service
public class TraderService {
    private final TraderRepository traderRepository;

    public TraderService(TraderRepository traderRepository) {
        this.traderRepository = traderRepository;
    }

    public void saveTrader(Trader trader) {
        TraderEntity traderEntity = new TraderEntity();
        traderEntity.setId(trader.id());
        traderEntity.setName(trader.name());
        traderEntity.setDescriptionData(trader.descriptionData());
        traderEntity.setPaymentData(trader.paymentData());
        traderRepository.save(traderEntity);
    }
}
