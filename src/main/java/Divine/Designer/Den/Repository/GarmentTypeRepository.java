package Divine.Designer.Den.Repository;

import Divine.Designer.Den.Entity.GarmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarmentTypeRepository extends JpaRepository<GarmentType,Long> {
}
