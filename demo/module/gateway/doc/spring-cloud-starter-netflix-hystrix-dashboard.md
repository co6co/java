[主页](../reademe.md)
1. 启动类增加 添加@EnableHystrixDashboard 开启Dashboard。
注意：在2.x之前的版本中，会自动注入该Servlet的，但是在2.x之后的版本，没有自动注册该Servlet
2. 2.x 后半部手动的注册该Servlet到容器
```java
    @Bean
    public ServletRegistrationBean registrationBean() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
```