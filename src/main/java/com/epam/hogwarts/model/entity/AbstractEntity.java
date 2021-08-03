package com.epam.hogwarts.model.entity;

public abstract class AbstractEntity {

    private long entityId;

    public AbstractEntity(long entityId) {
        this.entityId = entityId;
    }

    public long getEntityId() {
        return entityId;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return entityId == that.entityId;
    }

    @Override
    public int hashCode() {
        int result = (int) (entityId ^ (entityId >>> 32));
        return result;
    }
}
