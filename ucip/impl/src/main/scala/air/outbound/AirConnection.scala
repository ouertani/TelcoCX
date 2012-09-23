package sjca.ucip.spi
package air.outbound

import sjca.ucip.api.air.outbound.AirConnector
import javax.resource.spi.{ConnectionRequestInfo , ManagedConnection }
import scala.xml.Elem


case class AirConnection(mc : ManagedConnection,cri :ConnectionRequestInfo)  extends  AirConnector{
  
 def fire(elem : Elem) : Elem = <a></a> 
}