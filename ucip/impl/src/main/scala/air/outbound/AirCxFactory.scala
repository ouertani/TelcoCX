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
case class AirCxFactory(mcf: ManagedConnectionFactory, cm:ConnectionManager)  extends AirConnectorFactory {
  @BeanProperty var reference:Reference = _ 
  def getAirConnector(ip:String,port:Int=10010,user:String,pwd:String,agent:String,url:String) : AirConnector  = 
   // val ri =  AirCxRequestInfo(ip ,port ,user ,pwd ,agent ,url )
   cm.allocateConnection(mcf,  AirCxRequestInfo(ip ,port ,user ,pwd ,agent ,url )).asInstanceOf[AirConnector]
 
}