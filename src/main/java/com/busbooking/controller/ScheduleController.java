package com.busbooking.controller;
import com.busbooking.dto.ApiResponse;
import com.busbooking.model.Schedule;
import com.busbooking.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/schedules")
@CrossOrigin(origins = "*")
public class ScheduleController {
    @Autowired private ScheduleService scheduleService;

    @GetMapping("/search")
    public ApiResponse<?> search(@RequestParam String source, @RequestParam String destination, @RequestParam(defaultValue = "1") int seats) {
        try {
            return new ApiResponse<>(true, "Success", scheduleService.searchSchedules(source, destination, seats));
        } catch (Exception e) {
            return new ApiResponse<>(false, e.getMessage(), null);
        }
    }

    @GetMapping
    public ApiResponse<?> getAllSchedules() {
        return new ApiResponse<>(true, "Success", scheduleService.getAllSchedules());
    }

    @PostMapping
    public ApiResponse<?> createSchedule(@RequestBody Schedule schedule) {
        try {
            return new ApiResponse<>(true, "Schedule created!", scheduleService.createSchedule(schedule));
        } catch (Exception e) {
            return new ApiResponse<>(false, e.getMessage(), null);
        }
    }
}
