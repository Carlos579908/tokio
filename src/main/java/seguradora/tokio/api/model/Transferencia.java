package seguradora.tokio.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "transferencias")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contaOrigem;
    private String contaDestino;
    private Double valor;
    private Double taxa;
    private LocalDate dataTransferencia;
    private LocalDate dataAgendamento = LocalDate.now();


    public Transferencia(String contaOrigem, String contaDestino, double valor, LocalDate dataTransferencia) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.dataTransferencia = dataTransferencia;
        this.dataAgendamento = LocalDate.now();
        this.taxa = calcularTaxa(valor, dataAgendamento, dataTransferencia);
    }

    private double calcularTaxa(double valor, LocalDate dataAgendamento, LocalDate dataTransferencia) {
        long dias = ChronoUnit.DAYS.between(dataAgendamento, dataTransferencia);

        if (dias == 0) {
            return valor * 0.03 + 3.00; // Transferência no mesmo dia
        } else if (dias <= 10) {
            return valor * 0.08; // Entre 1 e 10 dias
        } else if (dias <= 20) {
            return valor * 0.06; // Entre 11 e 20 dias
        } else if (dias <= 30) {
            return valor * 0.04; // Entre 21 e 30 dias
        } else {
            return valor * 0.02; // Acima de 30 dias
        }
    }

    @Override
    public String toString() {
        return "Transferência agendada: " +
                "Origem: " + contaOrigem + ", Destino: " + contaDestino + ", Valor: R$ " + valor +
                ", Taxa: R$ " + taxa + ", Data de Transferência: " + dataTransferencia +
                ", Data de Agendamento: " + dataAgendamento;
    }
}
