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
  def getAirConnector(ip:String,port:Int,user:String,pwd:String,agent:String) : AirConnector  = {   
   cm.allocateConnection(mcf,  AirCxRequestInfo(ip ,port ,user ,pwd ,agent  )).asInstanceOf[AirConnector]
  }
 
  def apply() :AirConnector = cm.allocateConnection(mcf,  toAirCxRequestInfo).asInstanceOf[AirConnector]
  
  private def toAirCxRequestInfo  = {
    val amcf= mcf.asInstanceOf[AirManagedCxFactory]
    AirCxRequestInfo(amcf.ip ,amcf.port.toInt ,amcf.user ,amcf.pwd ,amcf.agent  )
  }
  
}