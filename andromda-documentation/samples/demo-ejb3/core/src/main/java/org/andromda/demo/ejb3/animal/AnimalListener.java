// license-header java merge-point
// Generated by EntityListener.vsl in andromda-ejb3-cartridge on 08/06/2014 10:56:20.
// Modify as necessary. If deleted it will be regenerated.
package org.andromda.demo.ejb3.animal;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

/**
 * Callback Listener for Entity POJO EJB Animal
 *
 * @see Animal
 */
public class AnimalListener
{
    /**
     * Default public no-args constructor
     */
    public AnimalListener()
    {
        // empty constructor
    }

    @PrePersist
    public void prePersist(Animal animal)
    {
        // pre persist implementation
    }

    @PostPersist
    public void postPersist(Animal animal)
    {
        // post persist implementation
    }

    @PreRemove
    public void preRemove(Animal animal)
    {
        // pre remove implementation
    }

    @PostRemove
    public void postRemove(Animal animal)
    {
        // post remove implementation
    }

    @PreUpdate
    public void preUpdate(Animal animal) {
        // pre update implementation
    }

    @PostUpdate
    public void postUpdate(Animal animal)
    {
        // post update implementation
    }

    @PostLoad
    public void postLoad(Animal animal)
    {
        // post load implementation
    }
}
