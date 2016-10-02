package com.exercise.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
abstract class BaseEntity implements Serializable {
    public long getId() {
        return Id;
    }

    @Id @GeneratedValue
    private long Id;

    private String uuid = UUID.randomUUID().toString();

    @Override
    public boolean equals(Object o) {
       return this==o || o instanceof BaseEntity
               && Objects.equals(uuid,((BaseEntity)o).uuid);

    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
