package com.clover.resources.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: VisitorCount
 * @Description:
 * @Author: Clover
 * @Date: 2021.04.18
 * Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorCount {
    private String id;
    private String vCount;
    private String uCount;
}
