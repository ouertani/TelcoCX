package telcoCx.ucip.spi
package air.outbound

import javax.resource.ResourceException
import javax.resource.spi.{ ActivationSpec, BootstrapContext, Connector, ResourceAdapter, ResourceAdapterInternalException, TransactionSupport }
import javax.resource.spi.endpoint.MessageEndpointFactory;
import javax.transaction.xa.XAResource
@Connector(reauthenticationSupport = false,
  transactionSupport = TransactionSupport.TransactionSupportLevel.NoTransaction,
  description = Array("JCA 4 UCIP API"),
  displayName = Array("JCA4UCIP"),
  vendorName = "TelcoCx",
  eisType = "UCIP",
  version = "1.0")
class AirResourceAdapter extends ResourceAdapter {
  def getXAResources(ass: Array[ActivationSpec]): Array[XAResource] = null
  def endpointDeactivation(mef: MessageEndpointFactory, as: ActivationSpec) {}
  def endpointActivation(mef: MessageEndpointFactory, as: ActivationSpec) {}
  def start(bc: BootstrapContext) {}
  def stop() {}
}
