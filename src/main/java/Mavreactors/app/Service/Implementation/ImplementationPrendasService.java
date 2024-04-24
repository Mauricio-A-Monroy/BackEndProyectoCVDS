package Mavreactors.app.Service.Implementation;

import Mavreactors.app.Mapper.PrendasMapper;
import Mavreactors.app.Model.Prendas;
import Mavreactors.app.Repository.PrendaRepository;
import Mavreactors.app.Service.PrendasService;
import Mavreactors.app.dto.PrendasDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplementationPrendasService implements PrendasService {
    private final PrendaRepository prendaRepository;

    @Override
    public PrendasDto createPrenda(PrendasDto prendasDto) {
        Prendas prenda = PrendasMapper.mapToPrendas(prendasDto);
        Prendas savedPrenda = prendaRepository.save(prenda);
        return PrendasMapper.mapToPrendasDto(savedPrenda);
    }

    @Override
    public PrendasDto getPrendaById(Long prendasDto) {
        return null;
    }

    @Override
    public List<PrendasDto> getAllPrendas() {
        List<Prendas> prendas = prendaRepository.findAll();
        return prendas.stream().map(prenda -> PrendasMapper.mapToPrendasDto(prenda))
                .collect(Collectors.toList());
    }

    @Override
    public PrendasDto updatePrenda(Long prendasId, PrendasDto updatePrenda) {
        return null;
    }

    @Override
    public void deletePrenda(Long prendasId) {

    }
}
