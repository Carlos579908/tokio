package seguradora.tokio.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seguradora.tokio.api.model.Transferencia;
import seguradora.tokio.api.repository.TransferenciaRepository;

import java.util.List;

@Service
public class TransferenciaService {
    @Autowired
    private TransferenciaRepository repository;


    public Transferencia agendarTransferencia(Transferencia transferencia) {
        return repository.save(transferencia);
    }

    public List<Transferencia> listarTransferencias() {
        return repository.findAll();
    }
}
