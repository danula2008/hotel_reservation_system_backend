package edu.icet.pms.dao;

import edu.icet.pms.entity.DopReservationEntity;
import edu.icet.pms.util.composite_keys.DopReservationPK;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface DopReservationDao extends JpaRepository<DopReservationEntity, DopReservationPK> {
    List<DopReservationEntity> findByReservationId(String id);
    List<DopReservationEntity> findByDopId(String dopId);
    List<DopReservationEntity> findByDate(LocalDate date);
}
