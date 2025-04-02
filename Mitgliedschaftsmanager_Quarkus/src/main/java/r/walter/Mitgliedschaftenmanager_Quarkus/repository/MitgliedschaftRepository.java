package r.walter.Mitgliedschaftenmanager_Quarkus.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import r.walter.Mitgliedschaftenmanager_Quarkus.modul.Mitgliedschaft;

import java.util.List;

@ApplicationScoped
public class MitgliedschaftRepository implements PanacheRepository<Mitgliedschaft> {

    public List<Mitgliedschaft> searchMitgliedschaften(String keyword) {
        String lowerKeyword = "%" + keyword.toLowerCase() + "%";
        return getEntityManager()
                .createQuery("""
                    SELECT m FROM Mitgliedschaft m
                    WHERE lower(m.vorname) LIKE :k
                       OR lower(m.nachname) LIKE :k
                       OR lower(m.email) = :email
                       OR m.telefonnummer = :phone
                       OR lower(m.status) = :status
                    """, Mitgliedschaft.class)
                .setParameter("k", lowerKeyword)
                .setParameter("email", keyword.toLowerCase())
                .setParameter("phone", keyword)
                .setParameter("status", keyword.toLowerCase())
                .getResultList();
    }
}
