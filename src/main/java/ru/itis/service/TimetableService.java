package ru.itis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.model.Timetable;
import ru.itis.repository.TimetableRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TimetableService {
    private final TimetableRepository timetableRepository;


    public Timetable getTimetable(UUID id){
        return timetableRepository.findTimetableById(id);
    }

    public List<Timetable> getTimetableList(){
        return timetableRepository.findAll();
    }

    public Timetable updateTimetable(Timetable timetable){
        Timetable timetableRepo = timetableRepository.findTimetableById(timetable.getId());

        timetable.setRoom(timetable.getRoom());

        timetableRepository.save(timetable);
        return timetable;
    }

    public Timetable createTimetable(Timetable timetable){
        timetableRepository.save(timetable);
        return timetable;
    }

    public void deleteTimetable(UUID uuid){
        Timetable timetable = timetableRepository.findTimetableById(uuid);
        timetableRepository.delete(timetable);
    }
}
