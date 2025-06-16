package sistema.reaproveitamento.alimentos.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.reaproveitamento.alimentos.project.model.Ong;
import sistema.reaproveitamento.alimentos.project.model.dto.OngDTO;
import sistema.reaproveitamento.alimentos.project.repository.OngRepository;
import sistema.reaproveitamento.alimentos.project.service.OngService;

import java.util.List;
import java.util.Optional;

@Service
public class OngServiceImpl implements OngService {
    @Autowired
    private OngRepository repository;

    @Override
    public void create(OngDTO ongDTO) {
        Ong ong = new Ong();

        ong.setNome(ongDTO.getNome());
        ong.setEmail(ongDTO.getEmail());

        repository.save(ong);
    }

    @Override
    public List<Ong> getAll() {
        return repository.findAll();
    }

    @Override
    public Ong getById(Integer id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Ong inexistente no banco de dados. Por favor, insira um id válido."));
    }

    @Override
    public void update(Integer id, OngDTO ongDTO) {
        Optional<Ong> ong = repository.findById(id);
        if (ong.isPresent()){
            Ong ongUpdate = new Ong();
            ongUpdate.setNome(ongDTO.getNome());
            ongUpdate.setEmail(ongUpdate.getEmail());
            repository.save(ongUpdate);
        }else {
            throw new RuntimeException("Ong inexistente no banco de dados. Por favor, insira um id válido.");
        }
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
