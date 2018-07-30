package com.asad.myfirstjob;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class SoapClass {

    public int SignUp(String name, String uname, String email, String mobileno, String password) {
        String SOAP_ACTION = "http://apps.visualsolutions.work/SignUp";
        String METHOD_NAME = "SignUp";
        String NAMESPACE = "http://apps.visualsolutions.work/";
        String URL = "http://androidwebservice.somee.com/WebService.asmx?WSDL";

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        PropertyInfo pi = new PropertyInfo();
        pi.setName("Name");
        pi.setValue(name);
        pi.setType(String.class);
        request.addProperty(pi);

        pi = new PropertyInfo();
        pi.setName("Username");
        pi.setValue(uname);
        pi.setType(String.class);
        request.addProperty(pi);

        pi = new PropertyInfo();
        pi.setName("EmailAddress");
        pi.setValue(email);
        pi.setType(String.class);
        request.addProperty(pi);

        pi = new PropertyInfo();
        pi.setName("MobileNo");
        pi.setValue(mobileno);
        pi.setType(String.class);
        request.addProperty(pi);

        pi = new PropertyInfo();
        pi.setName("Password");
        pi.setValue(password);
        pi.setType(String.class);
        request.addProperty(pi);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        SoapObject response;
        int result;

        HttpTransportSE httptransport = new HttpTransportSE(URL);
        httptransport.debug = true;

        try {

            httptransport.call(SOAP_ACTION, envelope);
            //response = (SoapObject) envelope.getResponse();
            response = (SoapObject) envelope.bodyIn;
            //response = httptransport.responseDump;
            //response = (SoapPrimitive) envelope.getResponse();

            result = Integer.parseInt(response.getProperty(0).toString());

            //result = response;

            //result = response.toString();
        } catch (Exception e) {
            result = 4;
        }
        return result;
    }

    public String Login(String email, String password) {
        String SOAP_ACTION = "http://apps.visualsolutions.work/getLoginDetail";
        String METHOD_NAME = "getLoginDetail";
        String NAMESPACE = "http://apps.visualsolutions.work/";
        String URL = "http://androidwebservice.somee.com/WebService.asmx?WSDL";

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        PropertyInfo pi = new PropertyInfo();
        pi.setName("UserId");
        pi.setValue(email);
        pi.setType(String.class);
        request.addProperty(pi);

        pi = new PropertyInfo();
        pi.setName("Password");
        pi.setValue(password);
        pi.setType(String.class);
        request.addProperty(pi);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        SoapObject response;
        String result;

        HttpTransportSE httptransport = new HttpTransportSE(URL);
        httptransport.debug = true;

        try {

            httptransport.call(SOAP_ACTION, envelope);
            //response = (SoapObject) envelope.getResponse();
            response = (SoapObject) (SoapObject) envelope.bodyIn;
            //response = httptransport.responseDump;
            //response = (SoapPrimitive) envelope.getResponse();

            result = (response.getProperty(0).toString());

            //result = response;

            //result = response.toString();
        } catch (Exception e) {
            result = "Error";
        }
        return result;
    }
}
