package Mavreactors.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@SpringBootApplication
public class ProyectoCvdsApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ProyectoCvdsApplication.class, args);
		/*String imagePath = "ruta/a/la/imagen.jpg"; // Cambia esto por la ruta de tu imagen
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		String base64Image = Base64.getEncoder().encodeToString(imageBytes);*/

	}

}
