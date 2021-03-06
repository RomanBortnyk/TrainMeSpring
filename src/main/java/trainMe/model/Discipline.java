package trainMe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by romab on 9/24/16.
 */
@javax.persistence.Entity
@Table(name = "discipline")
public class Discipline implements Entity {

    private int id;
    private String name;
    @JsonIgnore
    private byte[] icon;

    public Discipline (){

    }

    public Discipline(String name, byte[] icon) {
        this.name = name;
        this.icon = icon;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "icon")
    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    @Override
    public boolean equals(Object discipline) {


        return discipline instanceof Discipline &&
                this.getName().equals( ((Discipline)discipline).getName()) &&
                this.getId() == ((Discipline) discipline).getId();


    }
}
