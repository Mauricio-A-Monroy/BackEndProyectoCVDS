package Mavreactors.app.Controller;

import Mavreactors.app.Service.PrendasService;
import Mavreactors.app.dto.PrendasDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/prendas")
public class PrendasController {

    private final PrendasService prendasService;

    @PostMapping
    public ResponseEntity<PrendasDto> createPrenda(@RequestParam("imagen") MultipartFile file,
                                                  @RequestBody PrendasDto prendasDto) {
        try {
            // Verificar si se ha seleccionado un archivo
            if (!file.isEmpty()) {
                // Convertir la imagen a una cadena Base64
                String base64Image = Base64.getEncoder().encodeToString(file.getBytes());
                // Asignar la imagen codificada a la DTO de prendas
                prendasDto.setFoto(base64Image);
            }

            // Crear la prenda utilizando el servicio
            PrendasDto savePrenda = prendasService.createPrenda(prendasDto);
            return new ResponseEntity<>(savePrenda, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<List<PrendasDto>> getAllPrendas(){
        List<PrendasDto> prendas = prendasService.getAllPrendas();
        return ResponseEntity.ok(prendas);
    }

}
