package ru.itis.repository;


import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.itis.model.Timetable;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class TimetableRepository {
    private final SessionFactory sessionFactory;


    public UUID save(Timetable group){
        UUID uuid ;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            uuid = (UUID) session.save(group);
            session.getTransaction().commit();
            session.close();
        }
        return uuid;
    }

    public Timetable findTimetableById(UUID id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Timetable group = session.find(Timetable.class, id);
            session.getTransaction().commit();
            session.close();
            return group;
        }
    }

    public List<Timetable> findAll () {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT a FROM Timetable a", Timetable.class).getResultList();
        }
    }

    public void delete(Timetable group) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(group);
            session.getTransaction().commit();
            session.close();
        }
    }

    public void update(Timetable group) {
        try (Session session = sessionFactory.openSession()) {
            Timetable groupRepo = findTimetableById(group.getId());
            groupRepo.setRoom(group.getRoom());
            session.beginTransaction();
            session.update(group);
            session.getTransaction().commit();
            session.close();
        }
    }
}
