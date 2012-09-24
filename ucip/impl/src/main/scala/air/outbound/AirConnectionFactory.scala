package telcoCx.ucip.spi
package air.outbound

import telcoCx.ucip.api.air.outbound._
import scala.reflect.BeanProperty
import javax.naming.{NamingException , Reference }
import javax.resource.spi.{ ConnectionManager ,  ManagedConnectionFactory }
import javax.resource.ResourceException
/**
 * @author slim ouertani
 */
case class AirConnectionFactory(mcf: ManagedConnectionFactory, cm:ConnectionManager)  extends AirConnectorFactory {
  @BeanProperty var reference:Reference = _ 
  def getAirConnector(airParam : AirParameters) : AirConnector  = 
   cm.allocateConnection(mcf, null).asInstanceOf[AirConnector]
 
}