package com.goit.entity;

import com.goit.exception.TicketConstructorException;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    @ManyToOne
    @JoinColumn(name = "from_planet_id")
    private Planet fromPlanetId;


    @ManyToOne
    @JoinColumn(name = "to_planet_id")
    private Planet toPlanetId;

    public Ticket() {
    }

    public Ticket(Client client, Planet from, Planet destination) {
        if (!(Objects.isNull(client) && Objects.isNull(fromPlanetId) && Objects.isNull(toPlanetId))) {
            this.createdAt = LocalDateTime.now();
            this.client = client;
            this.fromPlanetId = from;
            this.toPlanetId = destination;
        } else
            throw new TicketConstructorException("Field's \"client\", \"fromPlanetId\" and \"toPlanetId\" can't be null");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Planet getFromPlanetId() {
        return fromPlanetId;
    }

    public void setFromPlanetId(Planet fromPlanetId) {
        this.fromPlanetId = fromPlanetId;
    }

    public Planet getToPlanetId() {
        return toPlanetId;
    }

    public void setToPlanetId(Planet toPlanetId) {
        this.toPlanetId = toPlanetId;
    }
}
