package com.example.bookmyshow.dto.entryDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntryDto {
    
    private String name;
    private String mobileNo;
}
