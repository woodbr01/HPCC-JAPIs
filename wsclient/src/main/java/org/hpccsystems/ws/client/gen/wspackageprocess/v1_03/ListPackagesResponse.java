/**
 * ListPackagesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.hpccsystems.ws.client.gen.wspackageprocess.v1_03;

public class ListPackagesResponse  implements java.io.Serializable {
    private org.hpccsystems.ws.client.gen.wspackageprocess.v1_03.ArrayOfEspException exceptions;

    private org.hpccsystems.ws.client.gen.wspackageprocess.v1_03.BasePackageStatus status;

    private org.hpccsystems.ws.client.gen.wspackageprocess.v1_03.PackageListMapData[] packageMapList;

    public ListPackagesResponse() {
    }

    public ListPackagesResponse(
           org.hpccsystems.ws.client.gen.wspackageprocess.v1_03.ArrayOfEspException exceptions,
           org.hpccsystems.ws.client.gen.wspackageprocess.v1_03.BasePackageStatus status,
           org.hpccsystems.ws.client.gen.wspackageprocess.v1_03.PackageListMapData[] packageMapList) {
           this.exceptions = exceptions;
           this.status = status;
           this.packageMapList = packageMapList;
    }


    /**
     * Gets the exceptions value for this ListPackagesResponse.
     * 
     * @return exceptions
     */
    public org.hpccsystems.ws.client.gen.wspackageprocess.v1_03.ArrayOfEspException getExceptions() {
        return exceptions;
    }


    /**
     * Sets the exceptions value for this ListPackagesResponse.
     * 
     * @param exceptions
     */
    public void setExceptions(org.hpccsystems.ws.client.gen.wspackageprocess.v1_03.ArrayOfEspException exceptions) {
        this.exceptions = exceptions;
    }


    /**
     * Gets the status value for this ListPackagesResponse.
     * 
     * @return status
     */
    public org.hpccsystems.ws.client.gen.wspackageprocess.v1_03.BasePackageStatus getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ListPackagesResponse.
     * 
     * @param status
     */
    public void setStatus(org.hpccsystems.ws.client.gen.wspackageprocess.v1_03.BasePackageStatus status) {
        this.status = status;
    }


    /**
     * Gets the packageMapList value for this ListPackagesResponse.
     * 
     * @return packageMapList
     */
    public org.hpccsystems.ws.client.gen.wspackageprocess.v1_03.PackageListMapData[] getPackageMapList() {
        return packageMapList;
    }


    /**
     * Sets the packageMapList value for this ListPackagesResponse.
     * 
     * @param packageMapList
     */
    public void setPackageMapList(org.hpccsystems.ws.client.gen.wspackageprocess.v1_03.PackageListMapData[] packageMapList) {
        this.packageMapList = packageMapList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListPackagesResponse)) return false;
        ListPackagesResponse other = (ListPackagesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.exceptions==null && other.getExceptions()==null) || 
             (this.exceptions!=null &&
              this.exceptions.equals(other.getExceptions()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.packageMapList==null && other.getPackageMapList()==null) || 
             (this.packageMapList!=null &&
              java.util.Arrays.equals(this.packageMapList, other.getPackageMapList())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getExceptions() != null) {
            _hashCode += getExceptions().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getPackageMapList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPackageMapList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPackageMapList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListPackagesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:hpccsystems:ws:wspackageprocess", ">ListPackagesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exceptions");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:hpccsystems:ws:wspackageprocess", "Exceptions"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:hpccsystems:ws:wspackageprocess", "ArrayOfEspException"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:hpccsystems:ws:wspackageprocess", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:hpccsystems:ws:wspackageprocess", "BasePackageStatus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("packageMapList");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:hpccsystems:ws:wspackageprocess", "PackageMapList"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:hpccsystems:ws:wspackageprocess", "PackageListMapData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("urn:hpccsystems:ws:wspackageprocess", "PackageListMapData"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
