// Generated by: hibernate/SpringHibernateDaoImpl.vsl in andromda-spring-cartridge.
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package org.andromda.timetracker.domain;

import org.andromda.timetracker.vo.TaskVO;

/**
 * @see Task
 */
public class TaskDaoImpl
    extends TaskDaoBase
{
    /**
     * {@inheritDoc}
     */
    @Override
    public void toTaskVO(
        Task source,
        TaskVO target)
    {
        // TODO verify behavior of toTaskVO
        super.toTaskVO(source, target);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskVO toTaskVO(final Task entity)
    {
        // TODO verify behavior of toTaskVO
        return super.toTaskVO(entity);
    }

    /**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
    private Task loadTaskFromTaskVO(TaskVO taskVO)
    {
        // TODO implement loadTaskFromTaskVO
        throw new UnsupportedOperationException("org.andromda.timetracker.domain.loadTaskFromTaskVO(TaskVO) not yet implemented.");

        /* A typical implementation looks like this:
        Task task = this.load(taskVO.getId());
        if (task == null)
        {
            task = Task.Factory.newInstance();
        }
        return task;
        */
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task taskVOToEntity(TaskVO taskVO)
    {
        // TODO verify behavior of taskVOToEntity
        Task entity = this.loadTaskFromTaskVO(taskVO);
        this.taskVOToEntity(taskVO, entity, true);
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void taskVOToEntity(
        TaskVO source,
        Task target,
        boolean copyIfNull)
    {
        // TODO verify behavior of taskVOToEntity
        super.taskVOToEntity(source, target, copyIfNull);
    }
}
