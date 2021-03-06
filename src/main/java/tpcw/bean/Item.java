/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tpcw.bean;

import java.io.*;

/**
 * Item definition.
 *
 * Code generated by Apache Ignite Schema Import utility: 10/09/2016.
 */
public class Item implements Serializable {
    /** */
    private static final long serialVersionUID = 0L;

    /** Value for iId. */
    private int iId;

    /** Value for iTitle. */
    private String iTitle;

    /** Value for iAId. */
    private Integer iAId;

    /** Value for iPubDate. */
    private java.sql.Date iPubDate;

    /** Value for iPublisher. */
    private String iPublisher;

    /** Value for iSubject. */
    private String iSubject;

    /** Value for iDesc. */
    private String iDesc;

    /** Value for iRelated1. */
    private Integer iRelated1;

    /** Value for iRelated2. */
    private Integer iRelated2;

    /** Value for iRelated3. */
    private Integer iRelated3;

    /** Value for iRelated4. */
    private Integer iRelated4;

    /** Value for iRelated5. */
    private Integer iRelated5;

    /** Value for iThumbnail. */
    private String iThumbnail;

    /** Value for iImage. */
    private String iImage;

    /** Value for iSrp. */
    private Double iSrp;

    /** Value for iCost. */
    private Double iCost;

    /** Value for iAvail. */
    private java.sql.Date iAvail;

    /** Value for iStock. */
    private Integer iStock;

    /** Value for iIsbn. */
    private String iIsbn;

    /** Value for iPage. */
    private Integer iPage;

    /** Value for iBacking. */
    private String iBacking;

    /** Value for iDimensions. */
    private String iDimensions;

    /**
     * Empty constructor.
     */
    public Item() {
        // No-op.
    }

    /**
     * Full constructor.
     */
    public Item(
        int iId,
        String iTitle,
        Integer iAId,
        java.sql.Date iPubDate,
        String iPublisher,
        String iSubject,
        String iDesc,
        Integer iRelated1,
        Integer iRelated2,
        Integer iRelated3,
        Integer iRelated4,
        Integer iRelated5,
        String iThumbnail,
        String iImage,
        Double iSrp,
        Double iCost,
        java.sql.Date iAvail,
        Integer iStock,
        String iIsbn,
        Integer iPage,
        String iBacking,
        String iDimensions
    ) {
        this.iId = iId;
        this.iTitle = iTitle;
        this.iAId = iAId;
        this.iPubDate = iPubDate;
        this.iPublisher = iPublisher;
        this.iSubject = iSubject;
        this.iDesc = iDesc;
        this.iRelated1 = iRelated1;
        this.iRelated2 = iRelated2;
        this.iRelated3 = iRelated3;
        this.iRelated4 = iRelated4;
        this.iRelated5 = iRelated5;
        this.iThumbnail = iThumbnail;
        this.iImage = iImage;
        this.iSrp = iSrp;
        this.iCost = iCost;
        this.iAvail = iAvail;
        this.iStock = iStock;
        this.iIsbn = iIsbn;
        this.iPage = iPage;
        this.iBacking = iBacking;
        this.iDimensions = iDimensions;
    }

    /**
     * Gets iId.
     *
     * @return Value for iId.
     */
    public int getIId() {
        return iId;
    }

    /**
     * Sets iId.
     *
     * @param iId New value for iId.
     */
    public void setIId(int iId) {
        this.iId = iId;
    }

    /**
     * Gets iTitle.
     *
     * @return Value for iTitle.
     */
    public String getITitle() {
        return iTitle;
    }

    /**
     * Sets iTitle.
     *
     * @param iTitle New value for iTitle.
     */
    public void setITitle(String iTitle) {
        this.iTitle = iTitle;
    }

    /**
     * Gets iAId.
     *
     * @return Value for iAId.
     */
    public Integer getIAId() {
        return iAId;
    }

    /**
     * Sets iAId.
     *
     * @param iAId New value for iAId.
     */
    public void setIAId(Integer iAId) {
        this.iAId = iAId;
    }

    /**
     * Gets iPubDate.
     *
     * @return Value for iPubDate.
     */
    public java.sql.Date getIPubDate() {
        return iPubDate;
    }

    /**
     * Sets iPubDate.
     *
     * @param iPubDate New value for iPubDate.
     */
    public void setIPubDate(java.sql.Date iPubDate) {
        this.iPubDate = iPubDate;
    }

    /**
     * Gets iPublisher.
     *
     * @return Value for iPublisher.
     */
    public String getIPublisher() {
        return iPublisher;
    }

    /**
     * Sets iPublisher.
     *
     * @param iPublisher New value for iPublisher.
     */
    public void setIPublisher(String iPublisher) {
        this.iPublisher = iPublisher;
    }

    /**
     * Gets iSubject.
     *
     * @return Value for iSubject.
     */
    public String getISubject() {
        return iSubject;
    }

    /**
     * Sets iSubject.
     *
     * @param iSubject New value for iSubject.
     */
    public void setISubject(String iSubject) {
        this.iSubject = iSubject;
    }

    /**
     * Gets iDesc.
     *
     * @return Value for iDesc.
     */
    public String getIDesc() {
        return iDesc;
    }

    /**
     * Sets iDesc.
     *
     * @param iDesc New value for iDesc.
     */
    public void setIDesc(String iDesc) {
        this.iDesc = iDesc;
    }

    /**
     * Gets iRelated1.
     *
     * @return Value for iRelated1.
     */
    public Integer getIRelated1() {
        return iRelated1;
    }

    /**
     * Sets iRelated1.
     *
     * @param iRelated1 New value for iRelated1.
     */
    public void setIRelated1(Integer iRelated1) {
        this.iRelated1 = iRelated1;
    }

    /**
     * Gets iRelated2.
     *
     * @return Value for iRelated2.
     */
    public Integer getIRelated2() {
        return iRelated2;
    }

    /**
     * Sets iRelated2.
     *
     * @param iRelated2 New value for iRelated2.
     */
    public void setIRelated2(Integer iRelated2) {
        this.iRelated2 = iRelated2;
    }

    /**
     * Gets iRelated3.
     *
     * @return Value for iRelated3.
     */
    public Integer getIRelated3() {
        return iRelated3;
    }

    /**
     * Sets iRelated3.
     *
     * @param iRelated3 New value for iRelated3.
     */
    public void setIRelated3(Integer iRelated3) {
        this.iRelated3 = iRelated3;
    }

    /**
     * Gets iRelated4.
     *
     * @return Value for iRelated4.
     */
    public Integer getIRelated4() {
        return iRelated4;
    }

    /**
     * Sets iRelated4.
     *
     * @param iRelated4 New value for iRelated4.
     */
    public void setIRelated4(Integer iRelated4) {
        this.iRelated4 = iRelated4;
    }

    /**
     * Gets iRelated5.
     *
     * @return Value for iRelated5.
     */
    public Integer getIRelated5() {
        return iRelated5;
    }

    /**
     * Sets iRelated5.
     *
     * @param iRelated5 New value for iRelated5.
     */
    public void setIRelated5(Integer iRelated5) {
        this.iRelated5 = iRelated5;
    }

    /**
     * Gets iThumbnail.
     *
     * @return Value for iThumbnail.
     */
    public String getIThumbnail() {
        return iThumbnail;
    }

    /**
     * Sets iThumbnail.
     *
     * @param iThumbnail New value for iThumbnail.
     */
    public void setIThumbnail(String iThumbnail) {
        this.iThumbnail = iThumbnail;
    }

    /**
     * Gets iImage.
     *
     * @return Value for iImage.
     */
    public String getIImage() {
        return iImage;
    }

    /**
     * Sets iImage.
     *
     * @param iImage New value for iImage.
     */
    public void setIImage(String iImage) {
        this.iImage = iImage;
    }

    /**
     * Gets iSrp.
     *
     * @return Value for iSrp.
     */
    public Double getISrp() {
        return iSrp;
    }

    /**
     * Sets iSrp.
     *
     * @param iSrp New value for iSrp.
     */
    public void setISrp(Double iSrp) {
        this.iSrp = iSrp;
    }

    /**
     * Gets iCost.
     *
     * @return Value for iCost.
     */
    public Double getICost() {
        return iCost;
    }

    /**
     * Sets iCost.
     *
     * @param iCost New value for iCost.
     */
    public void setICost(Double iCost) {
        this.iCost = iCost;
    }

    /**
     * Gets iAvail.
     *
     * @return Value for iAvail.
     */
    public java.sql.Date getIAvail() {
        return iAvail;
    }

    /**
     * Sets iAvail.
     *
     * @param iAvail New value for iAvail.
     */
    public void setIAvail(java.sql.Date iAvail) {
        this.iAvail = iAvail;
    }

    /**
     * Gets iStock.
     *
     * @return Value for iStock.
     */
    public Integer getIStock() {
        return iStock;
    }

    /**
     * Sets iStock.
     *
     * @param iStock New value for iStock.
     */
    public void setIStock(Integer iStock) {
        this.iStock = iStock;
    }

    /**
     * Gets iIsbn.
     *
     * @return Value for iIsbn.
     */
    public String getIIsbn() {
        return iIsbn;
    }

    /**
     * Sets iIsbn.
     *
     * @param iIsbn New value for iIsbn.
     */
    public void setIIsbn(String iIsbn) {
        this.iIsbn = iIsbn;
    }

    /**
     * Gets iPage.
     *
     * @return Value for iPage.
     */
    public Integer getIPage() {
        return iPage;
    }

    /**
     * Sets iPage.
     *
     * @param iPage New value for iPage.
     */
    public void setIPage(Integer iPage) {
        this.iPage = iPage;
    }

    /**
     * Gets iBacking.
     *
     * @return Value for iBacking.
     */
    public String getIBacking() {
        return iBacking;
    }

    /**
     * Sets iBacking.
     *
     * @param iBacking New value for iBacking.
     */
    public void setIBacking(String iBacking) {
        this.iBacking = iBacking;
    }

    /**
     * Gets iDimensions.
     *
     * @return Value for iDimensions.
     */
    public String getIDimensions() {
        return iDimensions;
    }

    /**
     * Sets iDimensions.
     *
     * @param iDimensions New value for iDimensions.
     */
    public void setIDimensions(String iDimensions) {
        this.iDimensions = iDimensions;
    }

    /** {@inheritDoc} */
    @Override public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Item))
            return false;

        Item that = (Item)o;

        if (iId != that.iId)
            return false;

        if (iTitle != null ? !iTitle.equals(that.iTitle) : that.iTitle != null)
            return false;

        if (iAId != null ? !iAId.equals(that.iAId) : that.iAId != null)
            return false;

        if (iPubDate != null ? !iPubDate.equals(that.iPubDate) : that.iPubDate != null)
            return false;

        if (iPublisher != null ? !iPublisher.equals(that.iPublisher) : that.iPublisher != null)
            return false;

        if (iSubject != null ? !iSubject.equals(that.iSubject) : that.iSubject != null)
            return false;

        if (iDesc != null ? !iDesc.equals(that.iDesc) : that.iDesc != null)
            return false;

        if (iRelated1 != null ? !iRelated1.equals(that.iRelated1) : that.iRelated1 != null)
            return false;

        if (iRelated2 != null ? !iRelated2.equals(that.iRelated2) : that.iRelated2 != null)
            return false;

        if (iRelated3 != null ? !iRelated3.equals(that.iRelated3) : that.iRelated3 != null)
            return false;

        if (iRelated4 != null ? !iRelated4.equals(that.iRelated4) : that.iRelated4 != null)
            return false;

        if (iRelated5 != null ? !iRelated5.equals(that.iRelated5) : that.iRelated5 != null)
            return false;

        if (iThumbnail != null ? !iThumbnail.equals(that.iThumbnail) : that.iThumbnail != null)
            return false;

        if (iImage != null ? !iImage.equals(that.iImage) : that.iImage != null)
            return false;

        if (iSrp != null ? !iSrp.equals(that.iSrp) : that.iSrp != null)
            return false;

        if (iCost != null ? !iCost.equals(that.iCost) : that.iCost != null)
            return false;

        if (iAvail != null ? !iAvail.equals(that.iAvail) : that.iAvail != null)
            return false;

        if (iStock != null ? !iStock.equals(that.iStock) : that.iStock != null)
            return false;

        if (iIsbn != null ? !iIsbn.equals(that.iIsbn) : that.iIsbn != null)
            return false;

        if (iPage != null ? !iPage.equals(that.iPage) : that.iPage != null)
            return false;

        if (iBacking != null ? !iBacking.equals(that.iBacking) : that.iBacking != null)
            return false;

        if (iDimensions != null ? !iDimensions.equals(that.iDimensions) : that.iDimensions != null)
            return false;

        return true;
    }

    /** {@inheritDoc} */
    @Override public int hashCode() {
        int res = iId;

        res = 31 * res + (iTitle != null ? iTitle.hashCode() : 0);

        res = 31 * res + (iAId != null ? iAId.hashCode() : 0);

        res = 31 * res + (iPubDate != null ? iPubDate.hashCode() : 0);

        res = 31 * res + (iPublisher != null ? iPublisher.hashCode() : 0);

        res = 31 * res + (iSubject != null ? iSubject.hashCode() : 0);

        res = 31 * res + (iDesc != null ? iDesc.hashCode() : 0);

        res = 31 * res + (iRelated1 != null ? iRelated1.hashCode() : 0);

        res = 31 * res + (iRelated2 != null ? iRelated2.hashCode() : 0);

        res = 31 * res + (iRelated3 != null ? iRelated3.hashCode() : 0);

        res = 31 * res + (iRelated4 != null ? iRelated4.hashCode() : 0);

        res = 31 * res + (iRelated5 != null ? iRelated5.hashCode() : 0);

        res = 31 * res + (iThumbnail != null ? iThumbnail.hashCode() : 0);

        res = 31 * res + (iImage != null ? iImage.hashCode() : 0);

        res = 31 * res + (iSrp != null ? iSrp.hashCode() : 0);

        res = 31 * res + (iCost != null ? iCost.hashCode() : 0);

        res = 31 * res + (iAvail != null ? iAvail.hashCode() : 0);

        res = 31 * res + (iStock != null ? iStock.hashCode() : 0);

        res = 31 * res + (iIsbn != null ? iIsbn.hashCode() : 0);

        res = 31 * res + (iPage != null ? iPage.hashCode() : 0);

        res = 31 * res + (iBacking != null ? iBacking.hashCode() : 0);

        res = 31 * res + (iDimensions != null ? iDimensions.hashCode() : 0);

        return res;
    }

    /** {@inheritDoc} */
    @Override public String toString() {
        return "Item [iId=" + iId +
            ", iTitle=" + iTitle +
            ", iAId=" + iAId +
            ", iPubDate=" + iPubDate +
            ", iPublisher=" + iPublisher +
            ", iSubject=" + iSubject +
            ", iDesc=" + iDesc +
            ", iRelated1=" + iRelated1 +
            ", iRelated2=" + iRelated2 +
            ", iRelated3=" + iRelated3 +
            ", iRelated4=" + iRelated4 +
            ", iRelated5=" + iRelated5 +
            ", iThumbnail=" + iThumbnail +
            ", iImage=" + iImage +
            ", iSrp=" + iSrp +
            ", iCost=" + iCost +
            ", iAvail=" + iAvail +
            ", iStock=" + iStock +
            ", iIsbn=" + iIsbn +
            ", iPage=" + iPage +
            ", iBacking=" + iBacking +
            ", iDimensions=" + iDimensions +
            "]";
    }
}

