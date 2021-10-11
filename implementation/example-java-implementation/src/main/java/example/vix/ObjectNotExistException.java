package example.vix;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.SERVER, faultStringOrReason = "Object not exist")
public class ObjectNotExistException extends Exception {

    public ObjectNotExistException() {
    }
}
