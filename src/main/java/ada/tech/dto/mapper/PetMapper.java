package ada.tech.dto.mapper;


import ada.tech.dto.PetDTO;
import ada.tech.entity.Pet;

public class PetMapper {
    public static PetDTO toDTO(Pet pet) {
        return PetDTO.builder()
                .id(pet.getId())
                .nome(pet.getNome())
                .especie(pet.getEspecie())
                .raca(pet.getRaca())
                .idade(pet.getIdade())
                .peso(pet.getPeso())
                .dono(pet.getDono())
                .build();
    }

    public static Pet toEntity(PetDTO petDTO) {
        return Pet.builder()
                .id(petDTO.getId())
                .nome(petDTO.getNome())
                .especie(petDTO.getEspecie())
                .raca(petDTO.getRaca())
                .idade(petDTO.getIdade())
                .peso(petDTO.getPeso())
                .dono(petDTO.getDono())
                .build();
    }
}
