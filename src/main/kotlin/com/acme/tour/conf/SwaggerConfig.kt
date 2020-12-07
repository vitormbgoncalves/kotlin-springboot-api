package com.acme.tour.conf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
open class SwaggerConfig {

  @Bean
  open fun lojaAPI() =
    Docket(DocumentationType.SWAGGER_2)
      .select()
      .apis(RequestHandlerSelectors.basePackage("com.acme.tour"))
      .paths(PathSelectors.any())
      .build()
      .apiInfo(metaData())


  private fun metaData() =
    ApiInfoBuilder()
      .title("API DA LOJA ACME")
      .description("API QUE POSSUI TODOS OS METODOS DA LOJA")
      .version("1.0.0")
      .build()

}