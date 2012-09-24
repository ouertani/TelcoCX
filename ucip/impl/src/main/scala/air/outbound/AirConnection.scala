package telcoCx.ucip.spi
package air.outbound

import telcoCx.ucip.api.air.outbound.AirConnector
import javax.resource.spi.{ConnectionRequestInfo , ManagedConnection }
import scala.xml.Elem

/**
 * @author slim ouertani
 */
case class AirConnection(mc : ManagedConnection,cri :ConnectionRequestInfo)  extends  AirConnector{
  
 def fire(elem : Elem) : Elem = <a></a> 
}