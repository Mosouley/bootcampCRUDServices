package com.bootcamp.model;

import com.bootcamp.entities.Departement;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author soul
 */
@XmlRootElement(name = "departements")
public class Departements {

    protected Collection<Departement> departements;
    protected List<Link> links;

    @XmlElementRef
    public Collection<Departement> getDepartements() {
        return departements;
    }

    public void setDepartements(Collection<Departement> departements) {
        this.departements = departements;
    }

    @XmlElement(name = "link")
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @XmlTransient
    public URI getNext() {
        if (links == null) {
            return null;
        }
        for (Link link : links) {
            if ("next".equals(link.getRel())) {
                return link.getUri();
            }
        }
        return null;
    }

    @XmlTransient
    public URI getPrevious() {
        if (links == null) {
            return null;
        }
        for (Link link : links) {
            if ("previous".equals(link.getRel())) {
                return link.getUri();
            }
        }
        return null;
    }
}
