package ada.tech.services;

import ada.tech.dto.PetDTO;
import ada.tech.dto.mapper.PetMapper;
import ada.tech.entity.Pet;
import ada.tech.exception.PetNaoEncontradoException;
import ada.tech.repository.PetRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PetService {
    @Inject
    PetRepository petRepository;

    public List<PetDTO> listaPet() {
        return petRepository.listAll().stream()
                .map(PetMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PetDTO criaPet(PetDTO petDTO) {
        Pet pet = PetMapper.toEntity(petDTO);
        petRepository.persist(pet);
        return PetMapper.toDTO(pet);
    }

    public PetDTO buscaPetPorID(Long id) {
        Pet pet = petRepository.findById(id);
        if (pet == null) {
            throw new PetNaoEncontradoException("Pet não encontrado");
        }
        return PetMapper.toDTO(pet);
    }

    public PetDTO updatePet(Long id, PetDTO petDTO) {
        Pet updatedPet = PetMapper.toEntity(petDTO);
        Pet petToUpdate = petRepository.findById(id);
        if (petToUpdate == null) {
            throw new PetNaoEncontradoException("Pet não encontrado");
        }
        petToUpdate.setNome(updatedPet.getNome());
        petToUpdate.setEspecie(updatedPet.getEspecie());
        petToUpdate.setRaca(updatedPet.getRaca());
        petToUpdate.setIdade(updatedPet.getIdade());
        petToUpdate.setPeso(updatedPet.getPeso());
        petToUpdate.setDono(updatedPet.getDono());

        return PetMapper.toDTO(petToUpdate);
    }

    public PetDTO patchPet(Long id, PetDTO petDTO) {
        Pet updatedPet = PetMapper.toEntity(petDTO);
        Pet petToPatch = petRepository.findById(id);
        if (petToPatch == null) {
            throw new PetNaoEncontradoException("Pet não encontrado");
        }
        if (updatedPet.getNome() != null) petToPatch.setNome(updatedPet.getNome());
        if (updatedPet.getEspecie() != null) petToPatch.setEspecie(updatedPet.getEspecie());
        if (updatedPet.getRaca() != null) petToPatch.setRaca(updatedPet.getRaca());
        if (updatedPet.getIdade() != null) petToPatch.setIdade(updatedPet.getIdade());
        if (updatedPet.getPeso() != null) petToPatch.setPeso(updatedPet.getPeso());
        if (updatedPet.getDono() != null) petToPatch.setDono(updatedPet.getDono());

        return PetMapper.toDTO(petToPatch);
    }
}
