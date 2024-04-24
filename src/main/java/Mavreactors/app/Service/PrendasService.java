package Mavreactors.app.Service;

import Mavreactors.app.dto.PrendasDto;

import java.util.List;

public interface PrendasService {
    PrendasDto createPrenda(PrendasDto prendasDto);
    PrendasDto getPrendaById(Long prendasDto);
    List<PrendasDto> getAllPrendas();

    PrendasDto updatePrenda(Long prendasId, PrendasDto updatePrenda);

    void deletePrenda(Long prendasId);
}
