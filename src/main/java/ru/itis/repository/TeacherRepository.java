package ru.itis.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.itis.model.Teacher;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class TeacherRepository {

    private final SessionFactory sessionFactory;

}
