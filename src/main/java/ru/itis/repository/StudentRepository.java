package ru.itis.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StudentRepository {

    private final SessionFactory sessionFactory;


}
