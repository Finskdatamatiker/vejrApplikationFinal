package com.example.vejret.models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

/**
 * Med denne annotation behøver jeg ikke at skrive id til hver entity hver for sig.
 * Bruger den alligevel ikke, fordi jeg kom til at have en broken path i dependencies,
 * som jeg ikke lige kunne rette. Vil ikke risikere, at det hele crasher.
 */
@MappedSuperclass
public class BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    public BaseEntity(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
