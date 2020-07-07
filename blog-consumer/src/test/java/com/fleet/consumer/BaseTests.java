package com.fleet.consumer;

import com.fleet.common.entity.user.User;
import com.fleet.common.enums.TokenExpiresIn;
import com.fleet.common.exception.BaseException;
import com.fleet.common.service.user.UserService;
import com.fleet.common.util.UUIDUtil;
import com.fleet.common.util.cache.RedisUtil;
import com.fleet.common.util.token.entity.Token;
import com.fleet.common.util.token.entity.UserToken;
import com.fleet.consumer.config.TestConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTests {

    @Resource
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private MockHttpServletRequestBuilder builder;

    @Resource
    private TestConfig testConfig;

    @Reference
    private UserService userService;

    @Resource
    private RedisUtil redisUtil;

    private Integer id;

    private String accessToken;

    private String refreshToken;

    @Before
    public void before() {
        initToken();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void after() {
        deleteToken();
    }

    public void post(String url, String json) {
        try {
            builder = MockMvcRequestBuilders.post(url).header("accessToken", this.accessToken).contentType(MediaType.APPLICATION_JSON).content(json);
            String result = getMockHttpServletResponse(builder).getContentAsString();
            result(result);
        } catch (Exception e) {
            throw new BaseException("test fail：" + e);
        }
    }

    public void post(String url, Map<String, String> param) {
        try {
            builder = MockMvcRequestBuilders.post(url).header("accessToken", this.accessToken);
            if (param != null && param.size() > 0) {
                for (String key : param.keySet()) {
                    builder.param(key, param.get(key));
                }
            }
            String result = getMockHttpServletResponse(builder).getContentAsString();
            result(result);
        } catch (Exception e) {
            throw new BaseException("test fail：" + e);
        }
    }

    public void get(String url) {
        try {
            builder = MockMvcRequestBuilders.get(url).header("accessToken", this.accessToken);
            String result = getMockHttpServletResponse(builder).getContentAsString();
            result(result);
        } catch (Exception e) {
            throw new BaseException("test fail：" + e);
        }
    }

    public void get(String url, Map<String, String> param) {
        List<String> paramList = new ArrayList<>();
        if (param != null && param.size() != 0) {
            for (String key : param.keySet()) {
                paramList.add(key + "=" + param.get(key));
            }
        }
        try {
            String paramString = paramList.size() != 0 ? "?" + StringUtils.join(paramList, "&") : "";
            builder = MockMvcRequestBuilders.get(url + paramString).header("accessToken", this.accessToken);
            if (param != null && param.size() > 0) {
                for (String key : param.keySet()) {
                    builder.param(key, param.get(key));
                }
            }
            String result = getMockHttpServletResponse(builder).getContentAsString();
            result(result);
        } catch (Exception e) {
            throw new BaseException("test fail：" + e);
        }
    }

    public MockHttpServletResponse getMockHttpServletResponse(MockHttpServletRequestBuilder builder) throws Exception {
        Assert.notNull(builder, "builder is required");
        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(builder).andReturn().getResponse();
        mockHttpServletResponse.setCharacterEncoding("UTF-8");
        return mockHttpServletResponse;
    }

    public void result(String result) {
        System.err.println("-------------------RESULT->>BEGIN-------------------");
        System.err.println();
        System.err.println(result);
        System.err.println();
        System.err.println("-------------------RESULT->>END-------------------");
    }

    public void initToken() {
        User user = new User();
        user.setName(testConfig.getName());
        user = userService.get(user);
        if (user == null) {
            throw new BaseException("test fail：测试账户不存在");
        }

        Integer id = user.getId();

        Long issuedAt = System.currentTimeMillis();
        String accessToken = UUIDUtil.getUUID();
        String refreshToken = UUIDUtil.getUUID();

//        // 设置用户 accessToken 信息
//        Token userAccessToken = new Token();
//        userAccessToken.setId(id);
//        userAccessToken.setToken(accessToken);
//        userAccessToken.setIssuedAt(issuedAt);
//        userAccessToken.setExpiresIn(TokenExpiresIn.EXPIRES_IN.getMsec());
//        redisUtil.set("token:access:" + accessToken, userAccessToken);
//
//        // 设置用户 refreshToken 信息
//        Token userRefreshToken = new Token();
//        userRefreshToken.setId(id);
//        userRefreshToken.setToken(refreshToken);
//        userRefreshToken.setIssuedAt(issuedAt);
//        userRefreshToken.setExpiresIn(TokenExpiresIn.REFRESH_EXPIRES_IN.getMsec());
//        redisUtil.set("token:refresh:" + refreshToken, userRefreshToken);

        // 设置用户 token 关联信息
        UserToken userToken = new UserToken();
        userToken.setAccessToken(accessToken);
        userToken.setRefreshToken(refreshToken);
        redisUtil.set("token:user:" + id + ":refresh:" + refreshToken + ":access:" + accessToken, userToken);

        this.id = id;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public void deleteToken() {
        redisUtil.delete("token:access:" + this.accessToken);
        redisUtil.delete("token:refresh:" + this.refreshToken);
        redisUtil.delete("token:user:" + this.id + ":refresh:" + this.refreshToken + ":access:" + this.accessToken);
    }
}
