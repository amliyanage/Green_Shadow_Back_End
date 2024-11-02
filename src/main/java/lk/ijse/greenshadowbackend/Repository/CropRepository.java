package lk.ijse.greenshadowbackend.Repository;

import lk.ijse.greenshadowbackend.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepository extends JpaRepository<Crop, Integer> {
}
