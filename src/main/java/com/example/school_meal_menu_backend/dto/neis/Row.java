package com.example.school_meal_menu_backend.dto.neis;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Row {
    private String ATPT_OFCDC_SC_CODE;
    private String ATPT_OFCDC_SC_NM;
    private String SD_SCHUL_CODE;
    private String SCHUL_NM;
    private String MMEAL_SC_CODE;
    private String MMEAL_SC_NM;
    private String MLSV_YMD;
    private double MLSV_FGR;
    private String DDISH_NM;
    private String ORPLC_INFO;
    private String CAL_INFO;
    private String NTR_INFO;
    private String MLSV_FROM_YMD;
    private String MLSV_TO_YMD;
    private String LOAD_DTM;
}
