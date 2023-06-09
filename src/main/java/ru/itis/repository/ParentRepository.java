package ru.itis.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class ParentRepository {

    private final SessionFactory sessionFactory;

}
