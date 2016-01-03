package com.github.uryyyyyyy.javaSamples.ebeans;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * Customer entity bean.
 */
@Entity
@Table(name="eg_customer")
public class Customer extends Model {

    public Customer(String name, String comments) {
        this.name = name;
        this.comments = comments;
    }

    /**
     * Convenience Finder for 'active record' style.  Finder is public static class in com.avaje.ebean.Model
     */
    public static final Find<Long,Customer> find = new Find<Long,Customer>(){};

    @Id
    Long id;

    @Version
    Long version;

    @CreatedTimestamp
    Timestamp whenCreated;

    @UpdatedTimestamp
    Timestamp whenUpdated;

    @Column(length=100)
    String name;

    @Column(length=1000)
    String comments;

}