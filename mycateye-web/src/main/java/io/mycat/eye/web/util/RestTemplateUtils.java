package io.mycat.eye.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

import static java.util.Collections.singletonList;

@Component
public class RestTemplateUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateUtils.class);

    private static final String STRING_EMPTY = "";

    @Autowired
    protected RestTemplate restTemplate;

    public String get(String url, Map<String, String> headers, Map<String, ?> params) {
        if (StringUtils.isEmpty(url)) {
            return STRING_EMPTY;
        }

        try {
            setHeaders(headers);
            if (params != null && !params.isEmpty()) {
                return restTemplate.getForObject(url, String.class, params);
            }
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            LOGGER.error("调用远程Restful接口失败，调用方式：GET，接口地址：" + url + "，接口参数：" + params + ",Header参数：" + headers, e);
        } finally {
            restTemplate.setInterceptors(null);
        }
        return STRING_EMPTY;
    }

    private void setHeaders(Map<String, String> headers) {
        if (headers != null && !headers.isEmpty()) {
            ClientHttpRequestInterceptor acceptHeaderPdf = new AcceptHeaderHttpRequestInterceptor(headers);
            restTemplate.setInterceptors(singletonList(acceptHeaderPdf));
        }
    }

    public String get(String url) {
        return get(url, null, null);
    }

    public String getWithOneParam(String url, String key, String value) {
        return get(url, null, MiscUtil.mapOf(key, value));
    }

    public String getWithTwoParam(String url, String key, String value, String key2, String value2) {

        return get(url, null, MiscUtil.mapOf(key, value, key2, value2));
    }

    public String get(String url, Map<String, ?> params) {
        return get(url, null, params);
    }

    public String getAndHeaders(String url, Map<String, String> headers) {
        return get(url, headers, null);
    }

    public String post(String url, Map<String, String> headers, Map<String, String> params) {
        if (StringUtils.isEmpty(url)) {
            return STRING_EMPTY;
        }

        try {
            setHeaders(headers);
            HttpEntity<Map<String, String>> entity = new HttpEntity<>(params);
            return restTemplate.postForObject(url, entity, String.class);
        } catch (Exception e) {
            LOGGER.error("调用远程Restful接口失败，调用方式：POST，接口地址：" + url + "，接口参数：" + params + ",Header参数：" + headers, e);
        } finally {
            restTemplate.setInterceptors(null);
        }
        return STRING_EMPTY;
    }

    public String postBodyWithOneUriParams(String url, String uriParmaKey, String uriParamValue, String body) {
        return postBodyWithUriParams(url, null, MiscUtil.mapOf(uriParmaKey, uriParamValue), body);
    }

    public String postBodyWithTwoUriParams(String url, String uriParmaKey, String uriParamValue, String uriParmaKey2, String uriParamValue2, String body) {
        return postBodyWithUriParams(url, null, MiscUtil.mapOf(uriParmaKey, uriParamValue, uriParmaKey2, uriParamValue2), body);
    }

    public String postBodyWithUriParams(String url, Map<String, String> uriParams, String body) {
        return postBodyWithUriParams(url, null, uriParams, body);
    }

    public String postBodyWithUriParams(String url, Map<String, String> headers, Map<String, String> uriParams, String body) {
        if (StringUtils.isEmpty(url)) {
            return STRING_EMPTY;
        }

        try {
            setHeaders(headers);
            return restTemplate.postForObject(url, body, String.class, uriParams);
        } catch (Exception e) {
            LOGGER.error("调用远程Restful接口失败，调用方式：POST，接口地址：" + url + "，uri参数：" + uriParams + ",Header参数：" + headers + ",Body参数：", e);
        } finally {
            restTemplate.setInterceptors(null);
        }
        return STRING_EMPTY;
    }

    public String post(String url) {
        return post(url, null, null);
    }

    public String post(String url, Map<String, String> params) {
        return post(url, null, params);
    }

    public String postAndHeaders(String url, Map<String, String> headers) {
        return get(url, headers, null);
    }

    static class AcceptHeaderHttpRequestInterceptor implements ClientHttpRequestInterceptor {
        private final Map<String, String> headerValues;

        public AcceptHeaderHttpRequestInterceptor(Map<String, String> headerValues) {
            this.headerValues = headerValues;
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
                throws IOException {

            HttpRequestWrapper requestWrapper = new HttpRequestWrapper(request);

            HttpHeaders headers = requestWrapper.getHeaders();

            for (Map.Entry<String, String> entry : headerValues.entrySet()) {
                headers.set(entry.getKey(), entry.getValue());
            }

            return execution.execute(requestWrapper, body);
        }
    }
}
