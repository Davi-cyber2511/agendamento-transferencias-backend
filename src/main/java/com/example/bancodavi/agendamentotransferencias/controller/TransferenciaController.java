package com.example.bancodavi.agendamentotransferencias.controller;

import com.example.bancodavi.agendamentotransferencias.model.Transferencia;
import com.example.bancodavi.agendamentotransferencias.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081") // Cominicação com o front
@RequestMapping("/transferencias/agendamentos")
public class TransferenciaController {

    @Autowired
    private TransferenciaService service;

    @PostMapping
    public Transferencia agendarTransferencia(@RequestBody Transferencia transferencia) {
        return service.agendarTransferencia(transferencia);
    }

    @GetMapping
    public List<Transferencia> listarTransferencias() {
        return service.listarTransferencias();
    }
}
