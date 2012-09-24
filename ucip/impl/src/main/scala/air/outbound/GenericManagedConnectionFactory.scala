package telcoCx.ucip.spi
package air.outbound

import scala.reflect.BeanProperty
import java.io.PrintWriter
import java.util.{Set => JSet}
import scala.collection.JavaConversions._
import javax.resource.ResourceException;
import javax.resource.spi.{ConnectionManager , ConnectionRequestInfo , ManagedConnection ,ManagedConnectionFactory }
import javax.security.auth.Subject;
/**
 * @author slim ouertani
 */
case class GenericManagedConnectionFactory(@BeanProperty var logWriter:PrintWriter) extends ManagedConnectionFactory  {
 def this()  {this (new PrintWriter(System.out))}
 def createConnectionFactory(cxManager: ConnectionManager)=   new AirConnectionFactory(this, cxManager)
 def createConnectionFactory() = new AirConnectionFactory(this, null)
 def createManagedConnection( subject:Subject,  cxRequestInfo:ConnectionRequestInfo)=new GenericManagedConnection(logWriter, this, cxRequestInfo)
 def matchManagedConnections( connectionSet:JSet[_],  subject:Subject,  cxRequestInfo:ConnectionRequestInfo):ManagedConnection = {
   
   def check(gmc : GenericManagedConnection):Boolean = 
   { 
     val cri = gmc.connectionRequestInfo 
     cri == null ||cri == cxRequestInfo
   }
   connectionSet
   .filter(_.isInstanceOf[GenericManagedConnection])
   .map(_.asInstanceOf[GenericManagedConnection])
   .filter( check ).headOption.getOrElse(throw new ResourceException("Cannot find connection for info!")  )
 }
}