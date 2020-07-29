package com.fleet.consumer;

import com.fleet.common.entity.user.User;
import com.fleet.common.enums.TokenExpiresIn;
import com.fleet.common.exception.BaseException;
import com.fleet.common.service.user.UserService;
import com.fleet.common.util.UUIDUtil;
import com.fleet.common.util.cache.RedisUtil;
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
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    private Long userId;

    private String accessToken;

    private String refreshToken;

    @Before
    public void before() {
        initToken();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void after() {
    }

    public void post(String url) {
        try {
            builder = MockMvcRequestBuilders.post(url).header("accessToken", this.accessToken);
            String result = getMockHttpServletResponse(builder).getContentAsString();
            result(result);
        } catch (Exception e) {
            throw new BaseException("test fail：" + e);
        }
    }

    public void post(String url, Map<String, String[]> params) {
        try {
            builder = MockMvcRequestBuilders.post(url).header("accessToken", this.accessToken);
            if (params != null && params.size() > 0) {
                for (String key : params.keySet()) {
                    builder.param(key, params.get(key));
                }
            }
            String result = getMockHttpServletResponse(builder).getContentAsString();
            result(result);
        } catch (Exception e) {
            throw new BaseException("test fail：" + e);
        }
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

    public void get(String url) {
        try {
            builder = MockMvcRequestBuilders.get(url).header("accessToken", this.accessToken);
            String result = getMockHttpServletResponse(builder).getContentAsString();
            result(result);
        } catch (Exception e) {
            throw new BaseException("test fail：" + e);
        }
    }

    public void get(String url, Map<String, String[]> params) {
        try {
            builder = MockMvcRequestBuilders.get(url).header("accessToken", this.accessToken);
            if (params != null && params.size() > 0) {
                for (String key : params.keySet()) {
                    builder.param(key, params.get(key));
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
            throw new BaseException("test fail：测试用户名不存在");
        }

        Long userId = user.getId();
        String refreshToken = (String) redisUtil.get("user:refreshToken:" + userId);
        String accessToken;
        if (StringUtils.isNotEmpty(refreshToken)) {
            accessToken = (String) redisUtil.get("refreshToken:accessToken:" + refreshToken);
            if (StringUtils.isEmpty(accessToken)) {
                redisUtil.delete("refreshToken:accessToken:" + refreshToken);

                accessToken = UUIDUtil.getUUID();
                redisUtil.setEx("refreshToken:accessToken:" + refreshToken, accessToken, TokenExpiresIn.ACCESS_EXPIRES_IN.getSec(), TimeUnit.SECONDS);
                redisUtil.setEx("accessToken:user:" + accessToken, userId, TokenExpiresIn.ACCESS_EXPIRES_IN.getSec(), TimeUnit.SECONDS);
            }
        } else {
            redisUtil.delete("user:refreshToken:" + userId);

            refreshToken = UUIDUtil.getUUID();
            accessToken = UUIDUtil.getUUID();
            redisUtil.setEx("user:refreshToken:" + userId, refreshToken, TokenExpiresIn.REFRESH_EXPIRES_IN.getSec(), TimeUnit.SECONDS);
            redisUtil.setEx("refreshToken:user:" + refreshToken, userId, TokenExpiresIn.REFRESH_EXPIRES_IN.getSec(), TimeUnit.SECONDS);
            redisUtil.setEx("refreshToken:accessToken:" + refreshToken, accessToken, TokenExpiresIn.ACCESS_EXPIRES_IN.getSec(), TimeUnit.SECONDS);
            redisUtil.setEx("accessToken:user:" + accessToken, userId, TokenExpiresIn.ACCESS_EXPIRES_IN.getSec(), TimeUnit.SECONDS);
        }

        this.userId = userId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
