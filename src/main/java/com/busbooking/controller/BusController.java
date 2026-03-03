package com.busbooking.controller;
import com.busbooking.dto.ApiResponse;
import com.busbooking.model.Bus;
import com.busbooking.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/buses")
@CrossOrigin(origins = "*")
public class BusController {
    @Autowired private BusService busService;

    @GetMapping
    public ApiResponse<?> getAllBuses() {
        return new ApiResponse<>(true, "Success", busService.getAllBuses());
    }

    @PostMapping
    public ApiResponse<?> addBus(@RequestBody Bus bus) {
        try {
            return new ApiResponse<>(true, "Bus added!", busService.addBus(bus));
        } catch (Exception e) {
            return new ApiResponse<>(false, e.getMessage(), null);
        }
    }

    @DeleteMapping("/{id}")
    public ApiResponse<?> deleteBus(@PathVariable Long id) {
        try {
            busService.deleteBus(id);
            return new ApiResponse<>(true, "Bus deleted!", null);
        } catch (Exception e) {
            return new ApiResponse<>(false, e.getMessage(), null);
        }
    }
}
