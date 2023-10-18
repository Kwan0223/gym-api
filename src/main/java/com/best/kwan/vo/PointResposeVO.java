package com.best.kwan.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PointResposeVO {

    private PageVO pageInfo;
    private List<PointVO> content;
}
