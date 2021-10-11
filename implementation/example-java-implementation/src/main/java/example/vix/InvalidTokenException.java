package example.vix;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.SERVER, faultStringOrReason = "Invalid token")
public class InvalidTokenException extends Exception {

    public InvalidTokenException() {
    }
}
