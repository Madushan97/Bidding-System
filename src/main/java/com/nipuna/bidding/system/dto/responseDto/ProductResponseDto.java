package com.nipuna.bidding.system.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponseDto {
    private Integer id;
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;
}
