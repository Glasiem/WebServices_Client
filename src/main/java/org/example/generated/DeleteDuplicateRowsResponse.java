
package org.example.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DeleteDuplicateRowsResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "deleteDuplicateRowsResult"
})
@XmlRootElement(name = "DeleteDuplicateRowsResponse")
public class DeleteDuplicateRowsResponse {

    @XmlElement(name = "DeleteDuplicateRowsResult")
    protected boolean deleteDuplicateRowsResult;

    /**
     * Gets the value of the deleteDuplicateRowsResult property.
     * 
     */
    public boolean isDeleteDuplicateRowsResult() {
        return deleteDuplicateRowsResult;
    }

    /**
     * Sets the value of the deleteDuplicateRowsResult property.
     * 
     */
    public void setDeleteDuplicateRowsResult(boolean value) {
        this.deleteDuplicateRowsResult = value;
    }

}
