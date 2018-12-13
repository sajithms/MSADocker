package com.zcare.api.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Authority {

    @Id
    @NotNull
    @Size(min = 0, max = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
    	boolean resullt =true;
        if (this != o) resullt= false;
        if (o == null || getClass() != o.getClass()) resullt= false;

        Authority authority = (Authority) o;

        if (authority != null && !name.equals(authority.name)) resullt= false;

        return resullt;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Authority{" +
                "name='" + name + '\'' +
                '}';
    }

}
