package com.project.dao;

import com.project.model.Projekt;
import com.project.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {

//    EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();

    @Override
    public List<Projekt> get() {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        List<Projekt> projekty = entityManager.createNativeQuery("SELECT * FROM projekt ORDER BY nazwa", Projekt.class).getResultList();
        return projekty;
    }

    @Override
    public Projekt get(int id) {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        Projekt projekt = entityManager.find(Projekt.class, id);
        return projekt;
    }

    @Override
    public boolean save(Projekt projekt) {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(projekt);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean delete(int id) {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        Projekt projekt = entityManager.find(Projekt.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(projekt);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean update(Projekt projekt) {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        Projekt projekt1 = entityManager.find(Projekt.class,projekt.getProjektId());

        entityManager.getTransaction().begin();
        projekt1.setNazwa(projekt.getNazwa());
        projekt1.setOpis(projekt.getOpis());
        projekt1.setDataCzasModyfikacji(LocalDateTime.now());
        entityManager.getTransaction().commit();
        return true;
    }
}
