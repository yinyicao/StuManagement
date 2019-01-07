package cn.cqut.yyc.utility;

import cn.cqut.yyc.vo.DataInfoVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * @ClassName StringUtil
 * @Description 字符串处理工具类
 * @Author yinyicao
 * @DateTime 2019/1/4 18:56
 * @Blog http://www.cnblogs.com/hyyq/
 */
public class StringUtil {
    private static final String END_OR_START_EQUEL = "\"";

    /**
     * 根据传入的object对象，转换成对应的Json字符串
     * @param object
     * @return json字符串
     * @throws JsonProcessingException
     */
    public static String getJsonString(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString;
        jsonString = mapper.writeValueAsString(object);
        return jsonString;
    }


    /**
     * 根据json字符串转Java对象
     * @param request
     * @return
     * @throws IOException
     * @throws UnsupportedEncodingException
     */
    public static DataInfoVo receivePost(HttpServletRequest request) throws IOException, UnsupportedEncodingException {

        // 读取请求内容
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        //删除多条数据时json字符串为："{\"msg\": \"deleteData\", \"data\": [{\"studentId\": 12314}]}"
        //需要转为{"msg": "deleteData", "data": [{"studentId": 12314}]}才能被jackson转为对象。
        String str = sb.toString();
        if (str.startsWith(END_OR_START_EQUEL)) {
            str = str.substring(1);
        }
        if (str.endsWith(END_OR_START_EQUEL)) {
            str = str.substring(0, str.length() - 1);
        }
        str = str.replaceAll("\\\\", "");

        ObjectMapper mapper = new ObjectMapper();
        DataInfoVo studentInfoVo = mapper.readValue(str, DataInfoVo.class);
        return studentInfoVo;
    }

}
