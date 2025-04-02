package r.walter.Mitgliedschaftenmanager_Quarkus.modul;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.ws.rs.FormParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mitgliedschaft extends PanacheEntityBase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@FormParam("id")
	private int id;
	@FormParam("vorname")
	private String vorname;
	@FormParam("nachname")
	private String nachname;
	@FormParam("email")
	private String email;
	@FormParam("telefonnummer")
	private String telefonnummer;
	@FormParam("eintrittsdatum")
	private LocalDate eintrittsdatum;
	@FormParam("austrittsdatum")
	private LocalDate austrittsdatum;
	@FormParam("status")
	private String status;
}