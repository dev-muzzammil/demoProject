package com.example.sample.Controller;

import com.example.sample.DTO.OrderRegisterDTO;
import com.example.sample.DTO.OrderResponseDTO;
import com.example.sample.Entity.User;
import com.example.sample.Exception.ErrorResponse;
import com.example.sample.Exception.ResourceNotFoundException;
import com.example.sample.Repo.UserRepo;
import com.example.sample.Service.OrderService;
import com.example.sample.Validation.Admin;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Tag(name = "Order APIs")
public class OrderController {

    private final OrderService orderService;
    private final UserRepo userRepo;


    @Operation(
            summary = "Create a new order"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = "New order created successfully"),
            @ApiResponse(responseCode = "500" , description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    @PostMapping
    public ResponseEntity<OrderResponseDTO> addOrder(@Valid @RequestBody OrderRegisterDTO orderRegisterDTO) {
        User user = userRepo.findById(orderRegisterDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + orderRegisterDTO.getUserId()));
        OrderResponseDTO responseDTO = orderService.addOrder(orderRegisterDTO , user);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get order by id",
            description = "Fetch order by id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Order fetch successfully"),
            @ApiResponse(responseCode = "404" , description = "Order not found"),
            @ApiResponse(responseCode = "500" , description = "Internal server error",
                content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class)
                )
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @Admin
    @Operation(
            summary = "Get all order"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Orders fetch successfully"),
            @ApiResponse(responseCode = "500" , description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class))
                    )
            )
    })
    @GetMapping
    public ResponseEntity<Page<OrderResponseDTO>> getAllOrders(@ParameterObject Pageable pageable) {
        return ResponseEntity.ok(orderService.getAllOrders(pageable));
    }


    @Operation(
            summary = "Update Order",
            description = "Update order by id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Order update successfully"),
            @ApiResponse(responseCode = "404" , description = "Order not found"),
            @ApiResponse(responseCode = "500" , description = "Internal server error",
                    content = @Content(mediaType = "applicatin/json",
                        schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    @PatchMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> updateOrder(@PathVariable Long id, @Valid @RequestBody OrderRegisterDTO registerDTO) {
        return ResponseEntity.ok(orderService.updateOrder(id , registerDTO));
    }

    @Admin
    @Operation(
            summary = "Delete order",
            description = "Delete order by id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204" , description = "Order deleted successfully"),
            @ApiResponse(responseCode = "404" , description = "Order not found",
                content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class)
                )
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
