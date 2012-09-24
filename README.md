TelcoCX
=======
Telecommunication connectors

An JCA implementation for some telecommunications nodes such as IN, BSCS, HLR...

IN-AIR
======

An OutBound JCA connector based on ucip connector. 

TelcoCx for ucip can be injected as sample server resource like  

    @Resource(name="AIR")
    telcoCx.ucip.api.air.outbound.AirConnectorFactory airConnectorFactory;


