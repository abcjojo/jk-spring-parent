package com.liyijun.jk.tools;

import com.alibaba.druid.filter.config.ConfigTools;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.util.text.BasicTextEncryptor;

@Slf4j
public class DatabasePwdEncrypt {

    /**
     *  privateKey:MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAuFI7klRpnU8IJpj//oNCEvG+BHtoyWpZWuIbmGidc94J7Ja9iR5TcZqU8gyDB/oeqrYrVdZll08/vwgPn7IQlwIDAQABAkBFcV3WRI1B4gutFwmjZupW3tL7N0+EStf9YKCK7CceBo53MEwLZxEERBH3/xxAcbhWBKxBBZsPM5UOzxm6eQRZAiEA5qQQ38BWM3m8FyZDIwC/kbQvKZI56LgO34Sf+e5xdrUCIQDMlmPjMxh5RAMMC98QDY23QeSzd41O1uionVEtCRgNmwIgRw+Fo2q/JFz9dqRzSvWQEHRTk5tZ/Dm5W2ShZX/xtYECIBGybJ+JmvNaa70OBdSYp4qTm5nenI2WT3fOa+guYjNDAiEAqu2zkrnxA7kY7BmMiTXqlHiq134v/BxLf97PP7LkxXU=
     * publicKey:MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALhSO5JUaZ1PCCaY//6DQhLxvgR7aMlqWVriG5honXPeCeyWvYkeU3GalPIMgwf6Hqq2K1XWZZdPP78ID5+yEJcCAwEAAQ==
     * password:cWj/UYotLXprLUlxgdGubmy0mtOJFR/wfqzd31/sLZIJ2hdKeZzD0e5Q3Q/57zSiRAqlrpBjlyI14XkYqSdLIw==
     *
     */
    public static void main(String[] args) {
        String password = "root";
        String[] arguments = new String[]{password};
        try {
            ConfigTools.main(arguments);
        } catch (Exception e) {
            log.info("生成密文失败，异常信息:{}", e);
        }


    }


//    public static void main(String[] args) throws Exception {
//        // jasypt
//        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
//        textEncryptor.setPassword("ENCRYPT-LYJ-0808");
//        // 加密
//        String password = textEncryptor.encrypt("root");
//        System.out.println("^0^===password:"+ password);
//        // 解密
//        String originPwd = textEncryptor.decrypt("XYbvI39zNBhxudNcl/Njzg==");
//        System.out.println("^0^===originPwd:"+ originPwd);
//    }
}
