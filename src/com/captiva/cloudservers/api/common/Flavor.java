package com.captiva.cloudservers.api.common;

import java.io.Serializable;

/**
 * Hardware configuration.
 * @author Andres Amaya
 */
public class Flavor implements Serializable {
    private final int id;
    private final String name;
    private final Integer ram;
    private final Integer disk;
    
    public Flavor(int id, String name){
    	this.id = id;
    	this.name = name;
    	this.ram = null;
    	this.disk = null;
    }
    
    public Flavor(int id, String name, Integer ram, Integer disk) {
        this.id = id;
        this.name = name;
        this.ram = ram;
        this.disk = disk;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getRam() {
        return ram;
    }

    public Integer getDisk() {
        return disk;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Flavor");
        sb.append("{id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", ram=").append(ram);
        sb.append(", disk=").append(disk);
        sb.append('}');
        return sb.toString();
    }
}