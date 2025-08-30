package ada.tech.repository;

import ada.tech.entity.Pet;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class PetRepository implements PanacheRepository<Pet> {
}
