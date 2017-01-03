package com.messio.appengine.cdi;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by jpc on 03-01-17.
 */
@XmlRootElement(name = "catalog")
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalog {
    @XmlElementWrapper(name = "current")
    @XmlElement(name = "product")
    private List<Product> currentProducts;
    @XmlElementWrapper(name = "obsolete")
    @XmlElement(name = "product")
    private List<Product> obsoleteProducts;

    public Catalog() {
    }

    public Catalog(List<Product> currentProducts, List<Product> obsoleteProducts) {
        this.currentProducts = currentProducts;
        this.obsoleteProducts = obsoleteProducts;
    }

    public List<Product> getCurrentProducts() {
        return currentProducts;
    }

    public void setCurrentProducts(List<Product> currentProducts) {
        this.currentProducts = currentProducts;
    }

    public List<Product> getObsoleteProducts() {
        return obsoleteProducts;
    }

    public void setObsoleteProducts(List<Product> obsoleteProducts) {
        this.obsoleteProducts = obsoleteProducts;
    }
}
