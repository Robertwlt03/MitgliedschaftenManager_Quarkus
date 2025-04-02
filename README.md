# Mitgliedschaften-Manager - Quarkus Version

Dieses Repository enthält die Quarkus-Variante einer Webanwendung zur Verwaltung von Mitgliedschaften. Die Anwendung ist Teil eines Vergleichs zwischen Quarkus und Spring Boot und fokussiert sich auf moderne Entwicklungsprozesse und schnelle Feedback-Zyklen.

---

## ✨ Features

- Mitgliederverwaltung (Erstellen, Anzeigen, Bearbeiten, Löschen)
- Suchfunktion für Mitglieder
- Hot-Reload durch Quarkus Dev-Mode
- Moderne Template-Engine: Qute
- PostgreSQL-Datenbank via Docker
- RESTful API & schlanke Architektur mit Panache ORM

---

## 🛠️ Technologien

- Java 17
- Quarkus
- Qute
- Maven
- PostgreSQL (Docker)
- Lombok
- HTML, CSS, Vanilla JavaScript

---

## 🚀 Quickstart

### 1️⃣ PostgreSQL-Datenbank starten (Docker)

```bash
docker run --name MitgliedschaftenManager -e POSTGRES_PASSWORD=app -p 5432:5432 -d postgres
```

---

## 2️⃣ Spring Boot Anwendung starten

- Projekt importieren:

    `File -> Import -> Maven -> Existing Maven Project`

- Anwendung starten über:

    ```bash
    mvn quarkus:dev
    ```

- Öffne die Anwendung unter:

    [http://localhost:8080/mitgliedschaften](http://localhost:8080/mitgliedschaften)

---

## 💡 Hinweise

- Die Datenbank-Tabellen werden automatisch beim Start erzeugt.
- Suchfunktion über Name, E-Mail, Telefonnummer und Status.
- Fokus auf Stabilität und klare Projektstruktur.

---

## 🟣 Hintergrund

Diese Anwendung wurde erstellt, um die Eigenschaften und den Workflow von **Quarkus** praxisnah zu analysieren. Sie eignet sich als Grundlage für kleine bis mittelgroße Projekte im klassischen Java-Enterprise-Umfeld.
