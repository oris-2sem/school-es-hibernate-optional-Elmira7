package ru.itis.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import ru.itis.model.Group;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class GroupRepository {

    private final SessionFactory sessionFactory;

    public UUID save(Group group){
        UUID uuid ;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            uuid = (UUID) session.save(group);
            session.getTransaction().commit();
            session.close();
        }
        return uuid;
    }

    public Group findGroupById(UUID id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Group group = session.find(Group.class, id);
            session.getTransaction().commit();
            session.close();
            return group;
        }
    }

    public List<Group> findAll () {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT a FROM Group a", Group.class).getResultList();
        }
    }

    public void delete(Group group) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(group);
            session.getTransaction().commit();
            session.close();
        }
    }

    public void update(Group group) {
        try (Session session = sessionFactory.openSession()) {
            Group groupRepo = findGroupById(group.getId());
            groupRepo.setCourse(group.getCourse());
            session.beginTransaction();
            session.update(group);
            session.getTransaction().commit();
            session.close();
        }
    }

}
