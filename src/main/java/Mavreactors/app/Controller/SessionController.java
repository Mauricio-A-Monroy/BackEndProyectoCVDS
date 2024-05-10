package Mavreactors.app.Controller;

import Mavreactors.app.Model.Session;
import Mavreactors.app.Model.User;
import Mavreactors.app.Repository.SessionRepository;
import Mavreactors.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/session")
public class SessionController {
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UserRepository userRepository; // Asumiendo que tienes un repositorio de usuarios

    @GetMapping("/token")
    public ResponseEntity<String> getTokenForSession(@RequestParam String userEmail) {
        User user = userRepository.findByEmail(userEmail);
        if (user != null) {
            Session session = sessionRepository.findTopByUserOrderByTimestampDesc(user);
            if (session != null) {
                return ResponseEntity.ok(session.getToken().toString());
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
