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
    public ResponseEntity<PrendasDto> createPrenda(@RequestBody PrendasDto prendasDto){
        PrendasDto savePrenda = prendasService.createPrenda(prendasDto);
        return new ResponseEntity<>(savePrenda, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PrendasDto>> getAllPrendas(){
        List<PrendasDto> prendas = prendasService.getAllPrendas();
        return ResponseEntity.ok(prendas);
    }

    @PostMapping("/subir-prenda")
    public String subirPrenda(@RequestParam("imagen") MultipartFile file,
                              @RequestParam(value = "sePlancha", required = false) boolean sePlancha) {
        // Verificar si se ha seleccionado un archivo
        if (!file.isEmpty()) {
            try {
                // Convertir la imagen a una cadena Base64
                String base64Image = Base64.getEncoder().encodeToString(file.getBytes());

                // Aquí puedes guardar base64Image en la base de datos o en algún otro almacenamiento
                // También puedes manejar otros datos de la prenda como 'sePlancha' y guardarlos en la base de datos

                return "redirect:/exito"; // Redirigir a una página de éxito después de la carga
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/error"; // Redirigir a una página de error si la carga falla
    }
}
