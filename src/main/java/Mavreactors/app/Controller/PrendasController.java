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
@RequestMapping("/api/prendas")
public class PrendasController {

    private final PrendasService prendasService;

    @PostMapping("/subir-prenda")
    public ResponseEntity<PrendasDto> createPrenda(@RequestBody PrendasDto prendasDto){
        PrendasDto savePrenda = prendasService.createPrenda(prendasDto);
        return new ResponseEntity<>(savePrenda, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<PrendasDto>> getAllPrendas(){
        List<PrendasDto> prendas = prendasService.getAllPrendas();
        return ResponseEntity.ok(prendas);
    }

}
