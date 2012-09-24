package telcoCx.ucip.spi
package air.outbound
import java.io.PrintWriter
import javax.resource.spi.{ ConnectionEventListener, ConnectionRequestInfo, LocalTransaction, ManagedConnection, ManagedConnectionFactory, ManagedConnectionMetaData }
import javax.transaction.xa.XAResource
import javax.security.auth.Subject
import scala.reflect.BeanProperty
/**
 * @author slim ouertani
 */
case class GenericManagedCx(
  @BeanProperty var logWriter: PrintWriter,
  @BeanProperty var mcf: ManagedConnectionFactory,
  @BeanProperty var connectionRequestInfo: ConnectionRequestInfo 
  ) extends ManagedConnection {

  
  @BeanProperty var metaData: ManagedConnectionMetaData = GenericCxMetaData()
  @BeanProperty var localTransaction: LocalTransaction = _
  @BeanProperty val xAResource: XAResource = null
  
  var cx: AirCx = _
  
  var listeners: List[ConnectionEventListener] = List()
  def removeConnectionEventListener(cxEL: ConnectionEventListener) { listeners -= cxEL }
  def addConnectionEventListener(cxEL: ConnectionEventListener) { listeners = cxEL :: listeners }
  def cleanup() {}
  def destroy() {}
  def associateConnection(connection: AnyRef) { cx = connection.asInstanceOf[AirCx] }
  def getConnection(subject: Subject, cxRequestInfo: ConnectionRequestInfo) = {cx = AirCx(this, cxRequestInfo) ; cx }

}