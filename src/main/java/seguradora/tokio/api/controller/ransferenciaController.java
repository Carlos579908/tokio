package seguradora.tokio.api.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seguradora.tokio.api.model.Transferencia;
import seguradora.tokio.api.service.TransferenciaService;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
class TransferenciaController {

    @Autowired
    private TransferenciaService service;

    @PostMapping
    @Transactional
    public Transferencia agendar(@RequestBody Transferencia transferencia) {
        return service.agendarTransferencia(transferencia);
    }

    @GetMapping
    public List<Transferencia> listar() {
        return service.listarTransferencias();
    }
}
