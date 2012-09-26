package telcoCx.ucip.spi
package air.outbound

import scala.reflect.BeanProperty
import java.io.PrintWriter
import java.util.{Set => JSet}
import scala.collection.JavaConversions._
import javax.resource.ResourceException 
import javax.resource.spi._
import javax.security.auth.Subject 
import telcoCx.ucip.api.air.outbound._
/**
 * @author slim ouertani
 */
@ConnectionDefinition(connectionFactory = classOf[AirConnectorFactory],
   connectionFactoryImpl = classOf[AirCxFactory],
   connection = classOf[AirConnector],
   connectionImpl = classOf[AirCx])
case class AirManagedCxFactory() extends ManagedConnectionFactory   {
 @BeanProperty var logWriter:PrintWriter = new PrintWriter(System.out)
 var ip :String= _
 var port : String = _
 var user : String= _
 var pwd : String= _
 var agent : String= _
 def createConnectionFactory(cxManager: ConnectionManager)=    AirCxFactory(this, cxManager)
 def createConnectionFactory() = AirCxFactory(this, null)
 def createManagedConnection( subject:Subject,  cxRequestInfo:ConnectionRequestInfo)= AirManagedCx(logWriter, this, cxRequestInfo)
 def matchManagedConnections( connectionSet:JSet[_],  subject:Subject,  cxRequestInfo:ConnectionRequestInfo):ManagedConnection = {
   
   def check(gmc : AirManagedCx):Boolean = 
   { 
     val cri = gmc.connectionRequestInfo 
     cri == null ||cri == cxRequestInfo
   }
   connectionSet
   .filter(_.isInstanceOf[AirManagedCx])
   .map(_.asInstanceOf[AirManagedCx])
   .filter( check ).headOption.getOrElse(throw new ResourceException("Cannot find connection for info!")  )
 }
 @ConfigProperty( supportsDynamicUpdates = true, description = Array("AIR IP"))
 def setIp(ip:String) {this.ip =ip}
 @ConfigProperty(defaultValue = "10010", supportsDynamicUpdates = true, description = Array("AIR PORT"))
 def setPort(port : String) {this.port =port} 
 @ConfigProperty( supportsDynamicUpdates = true )
 def setUser(user:String) {this.user =user} 
 @ConfigProperty( supportsDynamicUpdates = true )
 def setPwd(pwd: String) {this.pwd =pwd}
 @ConfigProperty( supportsDynamicUpdates = true )
 def setAgent(agent : String){this.agent=agent}
}