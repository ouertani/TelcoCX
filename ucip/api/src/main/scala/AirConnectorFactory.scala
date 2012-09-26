package telcoCx.ucip.api
package air.outbound

import scala.xml.Elem
import java.io.Serializable
import javax.resource.Referenceable 
/**
 * @author slim ouertani
 */
trait AirConnectorFactory extends Referenceable with Function0[AirConnector] {
  def getAirConnector(
      ip :String,
      port:Int,
      user:String,
      pwd:String,
      agent:String) : AirConnector  
     
      
}