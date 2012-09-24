package telcoCx.ucip.spi
package air.outbound
import javax.resource.spi.ConnectionRequestInfo
/**
 * @author slim ouertani
 */
case class AirCxRequestInfo(
  ip: String,
  port: Int = 10010,
  user: String,
  pwd: String,
  agent: String,
  url: String)
  extends ConnectionRequestInfo  