package com.fisadyukovasecondattempt.SafeSpaceForYou.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UpdatePostDto {

    @NotNull
    @Min(0)
    private Long id;

    @NotNull
    @Size(min = 10)
    private String title;

    @NotNull
    @Size(min = 10)
    private String mainText;

}
