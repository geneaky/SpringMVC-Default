package hello.springmvc.basic.requestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MappingController {

  @RequestMapping(value = {"/hello-basic","hello-go"}, method = RequestMethod.GET)
  public String helloBasic() {
    log.info("helloBasic");
    return "ok";
  }

  @GetMapping("mapping-get-v2")
  public String mappingGetV2() {
    log.info("mapping-get-v2");
    return "ok";
  }

  /**
   * PathVariable 사용
   * 변수명이 같으면 생략 가능
   *
   * @PathVariable("userId") String userId -> @PathVariable userId
   * /mapping/userA
   */
  @GetMapping("/mapping/{userId}")
  public String mappingPath(@PathVariable String userId) {
    log.info("mappingPath userId = {}", userId);
    return "ok";
  }

  /**
   * PathVariable 다중 사용
   */
  @GetMapping("/mapping/users/{userId}/orders/{orderId}")
  public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
    log.info("mappingPath userId={} , orderId={}");
    return "ok";
  }

  /**
   * 파라밑러로 추가 매핑
   *  params="mode',
   *  params = "!mode"
   *  params = "mode=debug"
   *  params = "mode!=debug" ( ! = )
   *  params = {"mode=debug", "data=good}
   * @return
   */
  @GetMapping(value = "/mapping-param", params = "mode=debug")
  public String mappingParam() {
    log.info("mappingParam");
    return "ok";
  }

  /**
   * 특정 헤더로 추가 매핑
   * headers="mode",
   * headers="!mode",
   * headers="mode=debug"
   * headers="mode!=-debug" (! = )
   */
  @GetMapping(value="/mapping-header", headers = "mode=debug")
  public String mappingHeader() {
    log.info("mappingHeader");
    return "ok";
  }

  /**
   * Content-Tpye 헤더 기반 추가 매핑 Media Type
   * consumes="application/json"
   * consumes="!application/json"
   * consumes="application/*
   * cnosumes = "\/"
   * MediaType.APPLICATION_JSON_VALUE
   */
  @PostMapping(value = "/mapping-consume", consumes = "application/json")
  public String mappingConsumes() {
    log.info("mappingConsumes");
    return "ok";
  }

  /**
   * Accept 헤더 기반 Media Type
   * poduces = "text/html"
   * produces = "!text/html"
   * produces = "text/*"
   * produces = "*\/*"
   */
  @PostMapping(value = "/mapping-produce", produces = "text/html")
  public String mappingProduces() {
    log.info("mappingProduces");
    return "ok";
  }
}
