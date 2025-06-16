package sistema.reaproveitamento.alimentos.project.service;

import sistema.reaproveitamento.alimentos.project.model.Ong;
import sistema.reaproveitamento.alimentos.project.model.dto.OngDTO;

import java.util.List;

public interface OngService {
    void create(OngDTO ongDTO);
    List<Ong> getAll();
    Ong getById(Integer id);
    void update(Integer id, OngDTO ongDTO);
    void delete(Integer id);
    void deleteAll();
}
