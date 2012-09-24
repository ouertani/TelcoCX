package telcoCx.ucip.api
package air.outbound

import scala.xml.Elem
import java.io.Serializable
import javax.resource.Referenceable 
/**
 * @author slim ouertani
 */
trait AirConnector {
   def fire(elem : Elem) : Elem
}
/**
 * @author slim ouertani
 */
trait AirConnectorFactory extends Serializable with Referenceable{
  def getAirConnector(ip:String,port:Int=10010,user:String,pwd:String,agent:String,url:String) : AirConnector  
}
