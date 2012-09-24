package telcoCx.ucip.spi
package air.outbound

import javax.resource.spi.ManagedConnectionMetaData
import scala.reflect.BeanProperty
/**
 * @author slim ouertani
 */
case class GenericConnectionMetaData(@BeanProperty val eISProductName:String = "UCIP/AIR JCA", 
    @BeanProperty eISProductVersion:String = "1.0" ,
    @BeanProperty maxConnections:Int = 5 ,
    @BeanProperty userName:String = "slim ouertani" )
    extends ManagedConnectionMetaData 