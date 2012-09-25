package telcoCx.ucip.spi
package air.outbound
 import scala.util.control.Exception._
import telcoCx.ucip.api.air.outbound.AirConnector
import javax.resource.spi.{ConnectionRequestInfo , ManagedConnection }
import javax.resource.NotSupportedException
import scala.xml.{Elem,XML}
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.mime.content.StringBody
import org.apache.http.entity.mime.MultipartEntity
import org.apache.http.HttpResponse
import org.apache.http.util.EntityUtils

/**
 * @author slim ouertani
 */
case class AirCx(mc : ManagedConnection,cri :ConnectionRequestInfo)  extends  AirConnector{
  
 def firec(elem : Elem) : Option[Elem] = cri.buildClient.execute(buildPoster(elem))
  
 def fire(elem : Elem) : Option[Elem] = Some(<a></a>)

 private implicit def toElem(hr : HttpResponse): Option[Elem] = {
    catching(classOf[Throwable]).opt( Option(hr).map(_.getEntity()).map(EntityUtils.toString(_)).map(XML.loadString(_)).get)
 }
 
 private implicit def toAirCxRequestInfo(cxRI : ConnectionRequestInfo):AirCxRequestInfo=  cxRI match {
   case cx:AirCxRequestInfo => cx
   case _ => throw new NotSupportedException()
 }
 
 private def buildPoster(elem : Elem) = {
  
    val httppost = new HttpPost(cri.url)
    httppost.addHeader("Content-Type", "text/xml")
    httppost.addHeader("Content-Disposition", "form-data; name=\"fname\"; filename=\"request.xml\"")


    val comment = new StringBody(""+elem)
    val reqEntity = new MultipartEntity()
    reqEntity.addPart("fname", comment)
    httppost.setEntity(reqEntity)

    httppost
 }
 
   
}