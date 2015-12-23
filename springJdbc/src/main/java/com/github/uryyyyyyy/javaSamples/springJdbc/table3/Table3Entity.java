package com.github.uryyyyyyy.javaSamples.springJdbc.table3;

import java.sql.Array;

public class Table3Entity {
    private String name;
    private Array keys;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Array getKeys() {
        return keys;
    }

    public void setKeys(Array keys) {
        this.keys = keys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Table3Entity that = (Table3Entity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return keys != null ? keys.equals(that.keys) : that.keys == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (keys != null ? keys.hashCode() : 0);
        return result;
    }

    public Table3Entity(){}

    public Table3Entity(String name, Array keys) {
        this.name = name;
        this.keys = keys;
    }
}
