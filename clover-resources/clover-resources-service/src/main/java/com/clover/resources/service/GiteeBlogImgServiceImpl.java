package com.clover.resources.service;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.clover.common.util.EncryptUtil;
import com.clover.common.util.RandomUuidUtil;
import com.clover.common.util.Result;
import com.clover.common.util.ResultUtil;
import com.clover.resources.api.dto.GiteeImgBedConstant;
import com.clover.resources.api.service.GiteeBlogImgService;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: GiteeBlogImgService
 * @Description:
 * @Author: Clover
 * @Date: 2021.04.18
 * Version: 1.0
 */
@Service
public class GiteeBlogImgServiceImpl implements GiteeBlogImgService {
    @Transactional
    public Result<Map<String, Object>> saveImg(String trueFileName,String paramImgFile) throws Exception {
        Result<Map<String, Object>> result = ResultUtil.success("请求成功");
        Map<String, Object> resultMap = new HashMap<>();

        assert trueFileName != null;
        String suffix = trueFileName.substring(trueFileName.lastIndexOf("."));

        String fileName = System.currentTimeMillis() + "_" + RandomUuidUtil.getUUID() + suffix;
        //转存到gitee
        Map<String, Object> paramMap = getStringObjectMap(paramImgFile);
        String targetDir = GiteeImgBedConstant.IMG_FILE_DEST_PATH + fileName;
        String requestUrl = String.format(GiteeImgBedConstant.CREATE_REPOS_URL, GiteeImgBedConstant.OWNER,
                GiteeImgBedConstant.REPO_NAME, targetDir);
        String resultJson = HttpUtil.post(requestUrl, paramMap);
        JSONObject jsonObject = JSONUtil.parseObj(resultJson);
        if (jsonObject.getObj("commit") != null) {
            String resultImgUrl = GiteeImgBedConstant.GITPAGE_REQUEST_URL + targetDir;
            String resultImgHttpsUrl = GiteeImgBedConstant.GITEE_PAGES_URL + targetDir;
            resultMap.put("resultImgUrl", resultImgUrl);
            resultMap.put("resultImgHttpsUrl", resultImgHttpsUrl);
            result.setCode(200);
        } else {
            result.setCode(400);
        }
        result.setResult(resultMap);

        return result;
    }



    @Override
    public Result<Map<String, Object>> refreshPage() {
        return getMapResult();
    }

    public Result<Map<String, Object>> getMapResult() {
        Result<Map<String, Object>> result = ResultUtil.success("请求成功");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("access_token", GiteeImgBedConstant.ACCESS_TOKEN);

        String requestUrl = String.format(GiteeImgBedConstant.BUILD_PAGE_URL,
                GiteeImgBedConstant.OWNER, GiteeImgBedConstant.REPO_NAME);

        System.out.println(requestUrl);

        Map<String, Object> resultMap = new HashMap<>();
        String resultJson = HttpUtil.post(requestUrl, paramMap);

        JSONObject jsonObject = JSONUtil.parseObj(resultJson);
        if (jsonObject.getStr("status") != null) {
            String notice = jsonObject.getStr("notice");
            if (notice != null) {
                if ("Deployed frequently".equalsIgnoreCase(notice)) {
                    resultMap.put("message", "部署频繁");
                    result.setCode(404);
                } else {
                    resultMap.put("message", "其他错误");
                }
                result.setCode(404);

            }
        } else {
            result.setCode(200);
        }
        System.out.println(resultJson);
        return result;
    }
    // ===================================================method=====================================
    private Map<String, Object> getStringObjectMap(String paramImgFile) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("access_token", GiteeImgBedConstant.ACCESS_TOKEN);
        paramMap.put("message", GiteeImgBedConstant.CREATE_REPOS_MESSAGE);
        paramMap.put("content", paramImgFile);
        return paramMap;
    }
}
