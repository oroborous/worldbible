package com.javapuppy.springmvc.dao;

import com.javapuppy.hibernate.entity.Npc;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class NpcDAOImpl implements NpcDAO {
    // Inject the Hibernate session factory
    @Autowired
    private SessionFactory sessionFactory;

    // with @Transactional annotation, no need to begin or commit transaction
    @Override
    @Transactional
    public List<Npc> getNpcs() {
        // Get current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        // Create a query
        Query<Npc> query = session.createQuery("from Npc", Npc.class);

        // Get list of NPCs from query
        List<Npc> npcList = query.getResultList();

        // Return results
        return npcList;
    }
}
