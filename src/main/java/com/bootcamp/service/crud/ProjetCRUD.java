
package com.bootcamp.service.crud;

import static com.bootcamp.AppConstants.PERSISTENCE_UNIT;
import com.bootcamp.constants.AppConstants;
import com.bootcamp.entities.Projet;
import com.bootcamp.jpa.ProjetRepository;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author edwigegédéon
 */
public class ProjetCRUD implements AppConstants
{
    public static void create(Projet projet) throws SQLException{
        ProjetRepository pr = new ProjetRepository(PERSISTENCE_UNIT);
        pr.create(projet);
    }
    
    public static void update(Projet projet) throws SQLException{
        ProjetRepository pr = new ProjetRepository(PERSISTENCE_UNIT);
        pr.update(projet);
    }
    
    public static void delete(Projet projet) throws SQLException{
        ProjetRepository pr = new ProjetRepository(PERSISTENCE_UNIT);
        pr.delete(projet);
    }
    
    public static List<Projet> findAll() throws SQLException{
        ProjetRepository pr = new ProjetRepository(PERSISTENCE_UNIT);
        List<Projet> liste =pr.findAll();
        return liste;
    }
    
    public static List<Projet> findByProperty(String propertyName, Object value) throws SQLException{
        ProjetRepository pr = new ProjetRepository(PERSISTENCE_UNIT);
        List<Projet> projets = pr.findByProperty(propertyName, value);
        
        return projets;
    }
}
