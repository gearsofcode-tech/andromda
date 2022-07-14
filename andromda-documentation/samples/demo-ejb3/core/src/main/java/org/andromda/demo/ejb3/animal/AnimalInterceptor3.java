// license-header java merge-point
// Generated by Interceptor.vsl in andromda-ejb3-cartridge on 08/06/2014 10:56:25.
package org.andromda.demo.ejb3.animal;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Interceptor class AnimalInterceptor3
 */
public class AnimalInterceptor3
{
    /**
     * Default interceptor execution method
     *
     * @param ctx the invocation context
     * @return
     */
    @AroundInvoke
    public Object execute(InvocationContext ctx)
        throws Exception
    {
        System.out.println("interceptor 3");

        try
        {
            return ctx.proceed();
        }
        catch (Exception e)
        {
            throw e;
        }
    }
}
