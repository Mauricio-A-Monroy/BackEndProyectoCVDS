package Mavreactors.app.Mapper;

import Mavreactors.app.Model.Prendas;
import Mavreactors.app.dto.PrendasDto;

public class PrendasMapper {
    public static PrendasDto mapToPrendasDto (Prendas prendas) {
        return new PrendasDto(
                prendas.getPrendaId(),
                prendas.getFoto(),
                prendas.getSePlancha(),
                prendas.getUltimoLavado(),
                prendas.getTipo(),
                prendas.getUltimoUso()
        );
    }

    public static Prendas mapToPrendas(PrendasDto prendasDtoDto){
        return new Prendas(
                prendasDtoDto.getPrendaId(),
                prendasDtoDto.getFoto(),
                prendasDtoDto.getSePlancha(),
                prendasDtoDto.getUltimoLavado(),
                prendasDtoDto.getTipo(),
                prendasDtoDto.getUltimoUso()
        );
    }
}
