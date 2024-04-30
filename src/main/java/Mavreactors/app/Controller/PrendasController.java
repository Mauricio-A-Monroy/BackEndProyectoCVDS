package Mavreactors.app.Controller;

import Mavreactors.app.Model.Prendas;
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
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/customer")
public class PrendasController {

    private final PrendasService prendasService;

    @PostMapping("/prenda")
    public ResponseEntity<PrendasDto> createPrenda(@RequestBody PrendasDto prendasDto){
        PrendasDto savePrenda = prendasService.createPrenda(prendasDto);
        return new ResponseEntity<>(savePrenda, HttpStatus.CREATED);
    }

    @GetMapping("/prenda")
    public ResponseEntity<List<PrendasDto>> getAllPrendas(){
        List<PrendasDto> prendas = prendasService.getAllPrendas();
        return ResponseEntity.ok(prendas);
    }

    @GetMapping("/prenda/{id}")
    public ResponseEntity<PrendasDto> getPrendaById(@PathVariable("id") long prendaId) {
        PrendasDto prendasDto = prendasService.getPrendaById(prendaId);
        return ResponseEntity.ok(prendasDto);

    }

    @PutMapping("/prenda/{id}")
    public ResponseEntity<PrendasDto> udaptePrenda(@PathVariable("id") Long prendaId,
                                                      @RequestBody PrendasDto udaptedPrenda){
        PrendasDto prendasDto = prendasService.updatePrenda(prendaId, udaptedPrenda);
        return ResponseEntity.ok(prendasDto);
    }

    @DeleteMapping("/prenda/{id}")
    public ResponseEntity<String>  deletePrenda(@PathVariable("id") Long prendaId){
        prendasService.deletePrenda(prendaId);
        return ResponseEntity.ok("Employee deleted successfully.! ");
    }

}
