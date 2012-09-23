package sjca.ucip.api
package air.outbound

import scala.xml.Elem
import java.io.Serializable
import javax.resource.Referenceable 
trait AirConnector {
   def fire(elem : Elem) : Elem
}
trait AirConnectorFactory extends Serializable with Referenceable{
  def getAirConnector(airParam : AirParameters) : AirConnector  
}
case class AirParameters(ip:String,port:Int,user:String,pwd:String,agent:String,url:String)