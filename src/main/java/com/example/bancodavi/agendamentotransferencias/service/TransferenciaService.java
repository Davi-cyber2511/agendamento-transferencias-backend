package com.example.bancodavi.agendamentotransferencias.service;

import com.example.bancodavi.agendamentotransferencias.model.Transferencia;
import com.example.bancodavi.agendamentotransferencias.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository repository;

    public Transferencia agendarTransferencia(Transferencia transferencia) {
        transferencia.setDataAgendamento(LocalDate.now());
        transferencia.setTaxa(calcularTaxa(transferencia));
        return repository.save(transferencia);
    }

    public List<Transferencia> listarTransferencias() {
        return repository.findAll();
    }

    private BigDecimal calcularTaxa(Transferencia transferencia) {
        long dias = ChronoUnit.DAYS.between(LocalDate.now(), transferencia.getDataTransferencia());
        BigDecimal valor = transferencia.getValor();

        if (dias == 0) {
            return valor.multiply(new BigDecimal("0.025")).add(new BigDecimal("3.00"));
        } else if (dias >= 1 && dias <= 10) {
            return new BigDecimal("12.00");
        } else if (dias >= 11 && dias <= 20) {
            return valor.multiply(new BigDecimal("0.082"));
        } else if (dias >= 21 && dias <= 30) {
            return valor.multiply(new BigDecimal("0.069"));
        } else if (dias >= 31 && dias <= 40) {
            return valor.multiply(new BigDecimal("0.047"));
        } else if (dias >= 41 && dias <= 50) {
            return valor.multiply(new BigDecimal("0.017"));
        } else {
            throw new IllegalArgumentException("Nenhuma taxa aplicável para esse prazo");
        }
    }
}
