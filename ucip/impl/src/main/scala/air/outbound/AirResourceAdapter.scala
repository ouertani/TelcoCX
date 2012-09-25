package telcoCx.ucip.spi
package air.outbound

import javax.resource.ResourceException
import javax.resource.spi._
import javax.resource.spi.endpoint.MessageEndpointFactory
import javax.transaction.xa.XAResource
@Connector(
  reauthenticationSupport = false,
  transactionSupport = TransactionSupport.TransactionSupportLevel.NoTransaction
 )
class AirResourceAdapter() extends ResourceAdapter {
  var bootstrapContext:BootstrapContext =_
  def getXAResources(ass: Array[ActivationSpec]): Array[XAResource] = null
  def endpointDeactivation(mef: MessageEndpointFactory, as: ActivationSpec) {}
  def endpointActivation(mef: MessageEndpointFactory, as: ActivationSpec) {}
  def start(bc: BootstrapContext) {
    this.bootstrapContext = bc;
  }
  def stop() {}
}
