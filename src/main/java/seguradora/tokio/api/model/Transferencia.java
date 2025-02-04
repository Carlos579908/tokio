package seguradora.tokio.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    public Transferencia(String contaOrigem, String contaDestino, Double valor, LocalDate dataTransferencia) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.dataTransferencia = dataTransferencia;
        this.taxa = calcularTaxa();
    }

    public Double calcularTaxa() {
        long dias = LocalDate.now().until(this.dataTransferencia).getDays();
        if (dias == 0) return 3.00 + (this.valor * 0.025);
        if (dias >= 1 && dias <= 10) return 12.00;
        if (dias >= 11 && dias <= 20) return this.valor * 0.082;
        if (dias >= 21 && dias <= 30) return this.valor * 0.069;
        if (dias >= 31 && dias <= 40) return this.valor * 0.047;
        if (dias >= 41 && dias <= 50) return this.valor * 0.017;
        throw new IllegalArgumentException("Transferência não permitida para mais de 50 dias");
    }

    public Long getId() { return id; }
    public String getContaOrigem() { return contaOrigem; }
    public String getContaDestino() { return contaDestino; }
    public Double getValor() { return valor; }
    public Double getTaxa() { return taxa; }
    public LocalDate getDataTransferencia() { return dataTransferencia; }
    public LocalDate getDataAgendamento() { return dataAgendamento; }
}

