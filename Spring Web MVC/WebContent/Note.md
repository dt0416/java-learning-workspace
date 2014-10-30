可看到所有範例:http://localhost:8080/Spring_Web_MVC/
01. 透過maven取得spring-webmvc 3.2.9.RELEASE的lib及相依lib，並放至在/WEB-INF/lib
02. 在web.xml增加dispatcherServlet
03. 新增mvc-config.xml(需與02步驟增加的名稱一致)

# BeanNameUrlHandlerMapping
01. 新增A01_FirstController.java
02. 新增/WEB-INF/jsp/A01_firstMvc.jsp
03. 在mvc-config.xml裡新增<bean name="/firstMvc" class="ln.controller.FirstController"></bean>
04. 在mvc-config.xml裡新增
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsp/"></property>
        <property name="suffix" value=".jsp"></property>
    </bean>

# DefaultAnnotationHandlerMapping
01. 在/WEB-INF/web.xml新增
    <context:component-scan base-package="ln.controller"></context:component-scan>
    <mvc:annotation-driven></mvc:annotation-driven>
02. 在ln.controller.A02_AnnotationHandlerMapping，透過Annotation來做url相關設定
03. 新增/WEB-INF/jsp/A02_AnnotationHandlerMapping.jsp

# SimpleUser
01. 新增jstl-1.2.jar
    validator相關:classmate-1.0.0.jar、hibernate-validator-5.1.1.Final.jar、jboss-logging-3.1.3.GA.jar、validation-api-1.1.0.Final.jar
02. 新增ln.model.User
03. 新增ln.controller.A05_SimpleUser
04. 新增/WEB-INF/jsp/user/*.jsp

# Upload
01. 新增commons-fileupload-1.3.1.jar、commons-io-2.2.jar
02. 在mvc-config.xml新增
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
       <property name="maxUploadSize" value="100000" />
    </bean>
03. 新增/upload.html、/WEB-INF/jsp/uploadSuccess.jsp
04. 新增ln.controller.A08_FileUpload

# JSON
01. 新增jackson-core-asl-1.9.13.jar、jackson-mapper-asl-1.9.13.jar
02. 新增ln.controller.A09_JSON

# SiteMesh
01. 新增sitemesh-2.4.2.jar
02. 在web.xml裡新增
  <filter>
    <filter-name>sitemesh</filter-name>
    <filter-class>com.opensymphony.sitemesh.webapp.SiteMeshFilter</filter-class>
  </filter>
  <filter-mapping>
    <filter-name>sitemesh</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
03. 新增/WEB-INF/decorators.xml，並設定要套用sitemesh的url pattern
04. 新增/decorators/basic-theme.jsp