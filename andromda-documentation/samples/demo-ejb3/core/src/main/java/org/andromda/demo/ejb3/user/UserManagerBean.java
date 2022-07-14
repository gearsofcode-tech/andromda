// license-header java merge-point
//
// Generated by SessionBeanImpl.vsl in andromda-ejb3-cartridge on 08/06/2014 10:56:22.
// Modify as necessary. If deleted it will be regenerated.
//
package org.andromda.demo.ejb3.user;

/**
 * @see UserManagerBase
 *
 * Remember to manually configure the local business interface this bean implements if originally you only
 * defined the remote business interface.  However, this change is automatically reflected in the ejb-jar.xml.
 *
 * Do not specify the javax.ejb.Stateless annotation
 * Instead, the session bean is defined in the ejb-jar.xml descriptor.
 */
// Uncomment to enable webservices for UserManagerBean
// @javax.jws.WebService(endpointInterface = "org.andromda.demo.ejb3.user.UserManagerWSInterface", serviceName = "UserManager")
public class UserManagerBean
    extends UserManagerBase
    implements UserManagerRemote
{
    // --------------- Constructors ---------------

    /**
     * Default constructor extending base class default constructor
     */
    public UserManagerBean()
    {
        super();
    }

    // -------- Business Methods Impl --------------

    /**
     * @see UserManagerBase#addUser(User)
     */
    @Override
    protected void handleAddUser(User user)
        throws Exception
    {
        getUserDao().create(user);
    }

    /**
     * @see UserManagerBase#getUser(String)
     */
    @Override
    protected User handleGetUser(String principalId)
        throws Exception
    {
        return getUserDao().load(principalId);
    }

    /**
     * @see UserManagerBase#deleteUser(String)
     */
    @Override
    protected void handleDeleteUser(String principalId)
        throws Exception
    {
        getUserDao().remove(principalId);
    }

    // -------- Lifecycle Callback Implementation --------------
}
