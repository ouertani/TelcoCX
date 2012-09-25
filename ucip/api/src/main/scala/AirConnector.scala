package telcoCx.ucip.api
package air.outbound

import scala.xml.Elem
import java.io.Serializable
import javax.resource.Referenceable 
/**
 * @author slim ouertani
 */
trait AirConnector {
   def fire(elem : Elem) : Option[Elem]
}