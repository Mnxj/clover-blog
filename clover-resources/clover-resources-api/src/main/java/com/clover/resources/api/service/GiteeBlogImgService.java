package com.clover.resources.api.service;

import com.clover.common.util.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @InterfaceName: GiteeBlogImg
 * @Description:
 * @Author: Clover
 * @Date: 2021.04.18
 * Version: 1.0
 */
public interface GiteeBlogImgService {
    Result<Map<String, Object>> saveImg(String trueFileName,String file) throws Exception;
    Result<Map<String, Object>> refreshPage();
}
