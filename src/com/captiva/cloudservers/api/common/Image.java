package com.captiva.cloudservers.api.common;

import java.io.Serializable;
import java.util.Date;

/**
 * Image: collection of files used to create or rebuild a server.
 *
 * @author Andres Amaya
 */
public class Image implements Serializable {
    private final Integer id;
    private final String name;
    private final Integer serverId;
    private final String updated;
    private final String created;
    private final Integer progress;
    private final Status status;

    public Image(Integer id, String name, Integer serverId, String updated, String created, Integer progress, Status status) {
        this.id = id;
        this.name = name;
        this.serverId = serverId;
        this.updated = updated;
        this.created = created;
        this.progress = progress;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getServerId() {
        return serverId;
    }

    public String getUpdated() {
        return updated;
    }

    public String getCreated() {
        return created;
    }

    public Integer getProgress() {
        return progress;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Image");
        sb.append("{id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", serverId=").append(serverId);
        sb.append(", updated=").append(updated);
        sb.append(", created=").append(created);
        sb.append(", progress=").append(progress);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }

    public enum Status implements Serializable {
        UNKNOWN, ACTIVE, SAVING, PREPARING, QUEUED, FAILED
    }
}