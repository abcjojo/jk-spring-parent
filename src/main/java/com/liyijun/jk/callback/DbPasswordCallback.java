package com.liyijun.jk.callback;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.util.DruidPasswordCallback;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import java.util.Properties;
/**
 * 数据库回调密码解密
 * 
 * @author gourd
 *
 */
@Component
@Slf4j
public class DbPasswordCallback extends DruidPasswordCallback {
//    @Override
//    public void setProperties(Properties properties) {
//        super.setProperties(properties);
//        String password = properties.getProperty("password");
//        String publicKey = properties.getProperty("publicKey");
//        if (StringUtils.isNotEmpty(password)) {
//            try {
//                //所以这里的代码是将密码进行解密
//                String sourcePassword = AesHopeUtil.decryt(publicKey, password);
//                setPassword(sourcePassword.toCharArray());
//            } catch (Exception e) {
//                setPassword(password.toCharArray());
//            }
//        }
//    }



    @Override
    public void setProperties(Properties properties){
        super.setProperties(properties);
        //获取application.yml 里面配置的密码和公钥
        String password = (String) properties.get("password");
        String publickey = (String) properties.get("publicKey");
        try {
            String dbpassword = ConfigTools.decrypt(publickey, password);
            setPassword(dbpassword.toCharArray());
        } catch (Exception e) {
            log.error("Druid ConfigTools.decrypt", e);
        }
    }

    /**
     * 生成加密后的密码，放到yml中
     * @param args
     */
//    public static void main(String[] args) {
//        // 生成加密后的密码，放到yml中
//        String password = "gourd123";
//        String pwd = AesHopeUtil.encrypt("GOURD-HXNLYW-201314",password);
//        System.out.println(pwd);
//        String source = AesHopeUtil.decryt("GOURD-HXNLYW-201314",pwd);
//        System.out.println(source);
//    }
}