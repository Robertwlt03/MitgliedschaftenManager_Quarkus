package r.walter.Mitgliedschaftenmanager_Quarkus.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import r.walter.Mitgliedschaftenmanager_Quarkus.modul.Mitgliedschaft;
import r.walter.Mitgliedschaftenmanager_Quarkus.repository.MitgliedschaftRepository;

import java.time.LocalDate;
import java.util.List;

@Transactional
@ApplicationScoped
public class MitgliedschaftService {

    @Inject
    MitgliedschaftRepository repository;

    public List<Mitgliedschaft> findAll() {
        return repository.listAll();
    }

    public Mitgliedschaft findById(int id) {
        return repository.findById((long) id);
    }

    public Mitgliedschaft setMitgliedschaft() {
        return Mitgliedschaft.builder()
                .eintrittsdatum(LocalDate.now())
                .build();
    }

    public void save(Mitgliedschaft mitglied) {
        repository.persist(mitglied);
    }

    public void update (Mitgliedschaft mitglied) {
        Mitgliedschaft existing = repository.findById(((long) mitglied.getId()));

        existing.setVorname(mitglied.getVorname());
        existing.setNachname(mitglied.getNachname());
        existing.setEmail(mitglied.getEmail());
        existing.setTelefonnummer(mitglied.getTelefonnummer());
        existing.setEintrittsdatum(mitglied.getEintrittsdatum());
        existing.setAustrittsdatum(mitglied.getAustrittsdatum());
        existing.setStatus(mitglied.getStatus());
    }


    public void delete(int id) {
        repository.deleteById((long) id);
    }

    public List<Mitgliedschaft> search(String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return repository.searchMitgliedschaften(keyword);
        }

        return repository.listAll();
    }
}
