package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.model.Timetable;
import ru.itis.service.TimetableService;

import java.util.List;
import java.util.UUID;

@RequestMapping("/timetable")
@RestController
@RequiredArgsConstructor
public class TimetableController {
    private final TimetableService timetableService;


    @GetMapping("/{uuid}")
    public Timetable getTimetable(@PathVariable UUID uuid){
        return timetableService.getTimetable(uuid);
    }

    @GetMapping("/list")
    public List<Timetable> getTimetableList(){
        return timetableService.getTimetableList();
    }

    @PutMapping
    public Timetable updateTimetable(@RequestBody Timetable timetable){
        return timetableService.updateTimetable(timetable);
    }

    @PostMapping
    public Timetable createTimetable(@RequestBody Timetable timetable){
        return timetableService.createTimetable(timetable);
    }

    @DeleteMapping
    public void deleteTimetable(UUID uuid){
        timetableService.deleteTimetable(uuid);
    }
}
