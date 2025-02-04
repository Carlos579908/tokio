package seguradora.tokio.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import seguradora.tokio.api.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

}
