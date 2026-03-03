package com.busbooking.controller;
import com.busbooking.dto.ApiResponse;
import com.busbooking.dto.BookingRequest;
import com.busbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {
    @Autowired private BookingService bookingService;

    @PostMapping
    public ApiResponse<?> bookTicket(@RequestBody BookingRequest request) {
        try {
            var booking = bookingService.bookTicket(request);
            return new ApiResponse<>(true, "Ticket booked successfully! Booking ID: " + booking.getBookingId(), booking);
        } catch (Exception e) {
            return new ApiResponse<>(false, e.getMessage(), null);
        }
    }

    @PutMapping("/{id}/cancel")
    public ApiResponse<?> cancelBooking(@PathVariable Long id) {
        try {
            return new ApiResponse<>(true, "Booking cancelled!", bookingService.cancelBooking(id));
        } catch (Exception e) {
            return new ApiResponse<>(false, e.getMessage(), null);
        }
    }

    @GetMapping("/user/{userId}")
    public ApiResponse<?> getUserBookings(@PathVariable Long userId) {
        return new ApiResponse<>(true, "Success", bookingService.getUserBookings(userId));
    }

    @GetMapping
    public ApiResponse<?> getAllBookings() {
        return new ApiResponse<>(true, "Success", bookingService.getAllBookings());
    }

    @GetMapping("/{id}")
    public ApiResponse<?> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id)
            .map(b -> new ApiResponse<>(true, "Success", (Object)b))
            .orElse(new ApiResponse<>(false, "Booking not found", null));
    }
}
