package ru.itis.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import ru.itis.model.Group;
import ru.itis.model.Lesson;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class LessonRepository {

    private final SessionFactory sessionFactory;


    public UUID save(Lesson group){
        UUID uuid ;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            uuid = (UUID) session.save(group);
            session.getTransaction().commit();
            session.close();
        }
        return uuid;
    }

    public Lesson findLessonById(UUID id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Lesson group = session.find(Lesson.class, id);
            session.getTransaction().commit();
            session.close();
            return group;
        }
    }

    public List<Lesson> findAll () {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT a FROM Lesson a", Lesson.class).getResultList();
        }
    }

    public void delete(Lesson group) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(group);
            session.getTransaction().commit();
            session.close();
        }
    }

    public void update(Lesson group) {
        try (Session session = sessionFactory.openSession()) {
            Lesson groupRepo = findLessonById(group.getId());
            groupRepo.setName(group.getName());
            session.beginTransaction();
            session.update(group);
            session.getTransaction().commit();
            session.close();
        }
    }
}
