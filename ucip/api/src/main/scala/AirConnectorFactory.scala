package telcoCx.ucip.api
package air.outbound

import scala.xml.Elem
import java.io.Serializable
import javax.resource.Referenceable 
/**
 * @author slim ouertani
 */
trait AirConnectorFactory extends Referenceable  {
  def getAirConnector(ip:String,port:Int,user:String,pwd:String,agent:String,url:String) : AirConnector  
}