// license-header java merge-point
//
// Generated by SessionBeanImpl.vsl in andromda-ejb3-cartridge on 08/06/2014 10:56:22.
// Modify as necessary. If deleted it will be regenerated.
//
package org.andromda.demo.ejb3.vehicle;

import org.andromda.demo.ejb3.account.Account;
import org.andromda.demo.ejb3.account.AccountException;

/**
 * @see VehicleManagerBase
 *
 * Remember to manually configure the local business interface this bean implements if originally you only
 * defined the remote business interface.  However, this change is automatically reflected in the ejb-jar.xml.
 *
 * Do not specify the javax.ejb.Stateless annotation
 * Instead, the session bean is defined in the ejb-jar.xml descriptor.
 */
// Uncomment to enable webservices for VehicleManagerBean
// @javax.jws.WebService(endpointInterface = "org.andromda.demo.ejb3.vehicle.VehicleManagerWSInterface", serviceName = "VehicleManager")
public class VehicleManagerBean
    extends VehicleManagerBase
    implements VehicleManagerRemote
{
    // --------------- Constructors ---------------

    /**
     * Default constructor extending base class default constructor
     */
    public VehicleManagerBean()
    {
        super();
    }

    // -------- Business Methods Impl --------------

    /**
     * @see VehicleManagerBase#addMotorcycle(Motocycle)
     */
    @Override
    protected void handleAddMotorcycle(Motocycle mc)
        throws Exception
    {
        getMotocycleDao().create(mc);

        // Test session bean injection
        insertAccount();
    }

    private void insertAccount()
    {
        System.out.println("Inserting account...");

        Account account = new Account("test");

        try
        {
            accountManager.addAccount(account);
        }
        catch (AccountException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Insert complete.");
    }

    /**
     * @see VehicleManagerBase#addCar(Car)
     */
    @Override
    protected void handleAddCar(Car car)
        throws Exception
    {
        getCarDao().create(car);
    }

    /**
     * @see VehicleManagerBase#addVehicle(Vehicle)
     */
    @Override
    protected void handleAddVehicle(Vehicle vehicle)
        throws Exception
    {
        getVehicleDao().create(vehicle);
    }

    // -------- Lifecycle Callback Implementation --------------
}
