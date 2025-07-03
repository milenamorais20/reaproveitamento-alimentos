package sistema.reaproveitamento.alimentos.project.service;

import sistema.reaproveitamento.alimentos.project.model.Retirada;
import sistema.reaproveitamento.alimentos.project.model.dto.RetiradaDTO;

import java.util.List;

public interface RetiradaService {
    void createRetirada(RetiradaDTO retirada);
    Retirada getRetirada(int id);
    List<String> getAllRetiradas();
    String deleteRetirada(int id);
}