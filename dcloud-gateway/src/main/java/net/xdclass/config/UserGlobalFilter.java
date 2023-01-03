//package net.xdclass.config;
//
//import com.alibaba.csp.sentinel.util.StringUtil;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.net.InetSocketAddress;
//
///**
// * 小滴课堂,愿景：让技术不再难学
// *
// * @Description
// * @Author 二当家小D，微信：xdclass6
// * @Remark 有问题直接联系我，源码-笔记-技术交流群
// * @Version 1.0
// **/
//@Component
//public class UserGlobalFilter implements GlobalFilter, Ordered {
//
//
//    private static final String UNKNOWN = "unknown";
//    private static final String LOCALHOST = "127.0.0.1";
//    private static final String SEPARATOR = ",";
//
//    private static final String HEADER_X_FORWARDED_FOR = "x-forwarded-for";
//    private static final String HEADER_PROXY_CLIENT_IP = "Proxy-Client-IP";
//    private static final String HEADER_WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
//
//    /**
//     * 获取真实客户端IP
//     *
//     * @param serverHttpRequest
//     * @return
//     */
//    public static String getRealIpAddress(ServerHttpRequest serverHttpRequest) {
//        String ipAddress;
//        try {
//            System.out.println("X-Real-Ip="+serverHttpRequest.getHeaders().getFirst("X-Real-IP"));
//            System.out.println("X-Forwarded-For="+serverHttpRequest.getHeaders().getFirst("X-Forwarded-For"));
//            // 1.根据常见的代理服务器转发的请求ip存放协议，从请求头获取原始请求ip。值类似于203.98.182.163, 203.98.182.163
//            ipAddress = serverHttpRequest.getHeaders().getFirst(HEADER_X_FORWARDED_FOR);
//            if (StringUtil.isEmpty(ipAddress) || UNKNOWN.equalsIgnoreCase(ipAddress)) {
//                ipAddress = serverHttpRequest.getHeaders().getFirst(HEADER_PROXY_CLIENT_IP);
//            }
//            if (StringUtil.isEmpty(ipAddress) || UNKNOWN.equalsIgnoreCase(ipAddress)) {
//                ipAddress = serverHttpRequest.getHeaders().getFirst(HEADER_WL_PROXY_CLIENT_IP);
//            }
//
//
//            // 2.如果没有转发的ip，则取当前通信的请求端的ip
//            if (StringUtil.isEmpty(ipAddress) || UNKNOWN.equalsIgnoreCase(ipAddress)) {
//                InetSocketAddress inetSocketAddress = serverHttpRequest.getRemoteAddress();
//                if (inetSocketAddress != null) {
//                    ipAddress = inetSocketAddress.getAddress().getHostAddress();
//                }
//                // 如果是127.0.0.1，则取本地真实ip
//                if (LOCALHOST.equals(ipAddress)) {
//                    ipAddress = "127.0.0.1";
//                }
//            }
//
//
//            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
//            // "***.***.***.***"
//            if (ipAddress != null) {
//                ipAddress = ipAddress.split(SEPARATOR)[0].trim();
//            }
//        } catch (Exception e) {
//            ipAddress = "";
//        }
//        return ipAddress == null ? "" : ipAddress;
//    }
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        String ip = getRealIpAddress(exchange.getRequest());
//        System.out.println("ip"+ip);
//        ServerHttpRequest request = exchange.getRequest().mutate()
//                .header("x-forwarded-for", new String[]{ip})
//                .build();
//
//        return chain.filter(exchange.mutate().request(request).build());
//    }
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}