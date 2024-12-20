package edu.icet.pms.service.impl;

import edu.icet.pms.dao.HallReservationDao;
import edu.icet.pms.model.HallReservation;
import edu.icet.pms.entity.HallReservationEntity;
import edu.icet.pms.service.HallReservationService;
import edu.icet.pms.util.composite_keys.HallReservationPK;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HallReservationServiceImpl implements HallReservationService {

    private final ModelMapper mapper;
    private final HallReservationDao repository;

    @Override
    public void addHallReservation(HallReservation hallReservation) {
        repository.save(mapper.map(hallReservation, HallReservationEntity.class));
    }

    @Override
    public void deleteHallReservation(HallReservationPK hallReservationPK) {
        repository.deleteById(hallReservationPK);
    }

    @Override
    public List<HallReservation> getAllHallReservations() {
        return repository.findAll().stream().map(hallReservationEntity -> mapper.map(hallReservationEntity, HallReservation.class)).toList();
    }

    @Override
    public HallReservation getHallReservationByReservationId(String id) {
        return mapper.map(repository.findByReservationId(id), HallReservation.class);
    }

    @Override
    public List<HallReservation> getHallReservationByHallId(String hallId) {
        return repository.findByHallId(hallId).stream().map(hallReservationEntity -> mapper.map(hallReservationEntity, HallReservation.class)).toList();
    }
}
