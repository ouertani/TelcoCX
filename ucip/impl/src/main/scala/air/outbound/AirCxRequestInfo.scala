package telcoCx.ucip.spi
package air.outbound
import javax.resource.spi.ConnectionRequestInfo
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.auth.AuthScope
import org.apache.http.params.CoreProtocolPNames
import org.apache.http.auth.UsernamePasswordCredentials
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
  extends ConnectionRequestInfo {

  def buildClient = {
    val httpclient = new DefaultHttpClient();

    httpclient.getCredentialsProvider().setCredentials(
      new AuthScope(ip, port),
      new UsernamePasswordCredentials(user, pwd))

    httpclient.getParams().setParameter(CoreProtocolPNames.USER_AGENT,  agent)
    httpclient
  }
}