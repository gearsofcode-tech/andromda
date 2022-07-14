// license-header java merge-point
//
// Generated by SessionBeanImpl.vsl in andromda-ejb3-cartridge on 08/06/2014 10:56:22.
// Modify as necessary. If deleted it will be regenerated.
//
package org.andromda.demo.ejb3.ticket;

/**
 * @see TicketManagerBase
 *
 * Remember to manually configure the local business interface this bean implements if originally you only
 * defined the remote business interface.  However, this change is automatically reflected in the ejb-jar.xml.
 *
 * Do not specify the javax.ejb.Stateless annotation
 * Instead, the session bean is defined in the ejb-jar.xml descriptor.
 */
// Uncomment to enable webservices for TicketManagerBean
// @javax.jws.WebService(endpointInterface = "org.andromda.demo.ejb3.ticket.TicketManagerWSInterface", serviceName = "TicketManager")
public class TicketManagerBean
    extends TicketManagerBase
    implements TicketManagerRemote
{
    // --------------- Constructors ---------------

    /**
     * Default constructor extending base class default constructor
     */
    public TicketManagerBean()
    {
        super();
    }

    // -------- Business Methods Impl --------------

    /**
     * @see TicketManagerBase#addEmailTicket(EmailTicket)
     */
    @Override
    protected void handleAddEmailTicket(EmailTicket ticket)
        throws Exception
    {
        getEmailTicketDao().create(ticket);
    }

    /**
     * @see TicketManagerBase#addPaperTicket(PaperTicket)
     */
    @Override
    protected void handleAddPaperTicket(PaperTicket ticket)
        throws Exception
    {
        getPaperTicketDao().create(ticket);
    }

    // -------- Lifecycle Callback Implementation --------------
}
