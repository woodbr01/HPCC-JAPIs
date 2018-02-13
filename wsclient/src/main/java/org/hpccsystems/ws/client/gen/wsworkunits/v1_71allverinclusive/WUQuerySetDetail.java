/**
 * WUQuerySetDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive;

public class WUQuerySetDetail  implements java.io.Serializable {
    private java.lang.String querySetName;

    private org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.QuerySetQuery[] queries;

    private org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.QuerySetAlias[] aliases;

    public WUQuerySetDetail() {
    }

    public WUQuerySetDetail(
           java.lang.String querySetName,
           org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.QuerySetQuery[] queries,
           org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.QuerySetAlias[] aliases) {
           this.querySetName = querySetName;
           this.queries = queries;
           this.aliases = aliases;
    }


    /**
     * Gets the querySetName value for this WUQuerySetDetail.
     * 
     * @return querySetName
     */
    public java.lang.String getQuerySetName() {
        return querySetName;
    }


    /**
     * Sets the querySetName value for this WUQuerySetDetail.
     * 
     * @param querySetName
     */
    public void setQuerySetName(java.lang.String querySetName) {
        this.querySetName = querySetName;
    }


    /**
     * Gets the queries value for this WUQuerySetDetail.
     * 
     * @return queries
     */
    public org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.QuerySetQuery[] getQueries() {
        return queries;
    }


    /**
     * Sets the queries value for this WUQuerySetDetail.
     * 
     * @param queries
     */
    public void setQueries(org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.QuerySetQuery[] queries) {
        this.queries = queries;
    }


    /**
     * Gets the aliases value for this WUQuerySetDetail.
     * 
     * @return aliases
     */
    public org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.QuerySetAlias[] getAliases() {
        return aliases;
    }


    /**
     * Sets the aliases value for this WUQuerySetDetail.
     * 
     * @param aliases
     */
    public void setAliases(org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.QuerySetAlias[] aliases) {
        this.aliases = aliases;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WUQuerySetDetail)) return false;
        WUQuerySetDetail other = (WUQuerySetDetail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.querySetName==null && other.getQuerySetName()==null) || 
             (this.querySetName!=null &&
              this.querySetName.equals(other.getQuerySetName()))) &&
            ((this.queries==null && other.getQueries()==null) || 
             (this.queries!=null &&
              java.util.Arrays.equals(this.queries, other.getQueries()))) &&
            ((this.aliases==null && other.getAliases()==null) || 
             (this.aliases!=null &&
              java.util.Arrays.equals(this.aliases, other.getAliases())));
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
        if (getQuerySetName() != null) {
            _hashCode += getQuerySetName().hashCode();
        }
        if (getQueries() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getQueries());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getQueries(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAliases() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAliases());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAliases(), i);
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
        new org.apache.axis.description.TypeDesc(WUQuerySetDetail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:hpccsystems:ws:wsworkunits", "WUQuerySetDetail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("querySetName");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:hpccsystems:ws:wsworkunits", "QuerySetName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queries");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:hpccsystems:ws:wsworkunits", "Queries"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:hpccsystems:ws:wsworkunits", "QuerySetQuery"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("urn:hpccsystems:ws:wsworkunits", "QuerySetQuery"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aliases");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:hpccsystems:ws:wsworkunits", "Aliases"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:hpccsystems:ws:wsworkunits", "QuerySetAlias"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("urn:hpccsystems:ws:wsworkunits", "QuerySetAlias"));
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
